package com.example.davidstone.record_store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidstone on 7/28/16.
 */
public class ItemsSQLiteOpenHelper extends SQLiteOpenHelper {

    //THE DATABASE SETUP IS IN HERE, THERE ARE A COUPLE EXTRA METHODS HERE THAT I"M KEEPING BECAUSE I MIGHT USE THEM LATER

    public ItemsSQLiteOpenHelper(Context context) {
        super(context, "db", null, 5);
    }

    private static final String TAG = ItemsSQLiteOpenHelper.class.getCanonicalName();


    private static ItemsSQLiteOpenHelper INSTANCE;

    public static synchronized ItemsSQLiteOpenHelper getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new ItemsSQLiteOpenHelper(context.getApplicationContext());
        return INSTANCE;
    }


    public static final String[] INVENTORY_COLUMNS = {InventoryItem.COLUMN_ID,
            String.valueOf(InventoryItem.COLUMN_ICON),
            InventoryItem.COLUMN_BAND_NAME, InventoryItem.COLUMN_ALBUM_TITLE,
            InventoryItem.COLUMN_GENRE, InventoryItem.COLUMN_FORMAT,
            InventoryItem.COLUMN_PRICE.toString()};

    public static final String[] CART_COLUMNS = {Cart.COL_ID,
            Cart.COLUMN_BAND_NAME, Cart.COLUMN_ALBUM_TITLE,
            Cart.COLUMN_FORMAT, Cart.COLUMN_PRICE.toString()};

    public boolean checkIfTableExists (){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(InventoryItem.TABLE_NAME, null, null, null, null, null, null);
        boolean result = cursor.moveToFirst();
        cursor.close();

        return result;
    }

    public boolean checkIfCartExists (){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(Cart.TABLE_NAME, null, null, null, null, null, null);
        boolean result = cursor.moveToFirst();
        cursor.close();

        return result;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_BASIC_INVENTORY);
        db.execSQL(SQL_CREATE_ENTRIES_CART);

//        insertRowItem()


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES_BASIC_INVENTORY);
        db.execSQL(SQL_DELETE_ENTRIES_CART);
        onCreate(db);
    }

    public static abstract class InventoryItem implements BaseColumns {
        public static final String TABLE_NAME = "inventoryItem";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_ICON = "albumIcon";
        public static final String COLUMN_BAND_NAME = "bandName";
        public static final String COLUMN_ALBUM_TITLE = "albumTitle";
        public static final String COLUMN_GENRE = "genre";
        public static final String COLUMN_FORMAT = "format";
        public static final String COLUMN_PRICE = "price";
    }

    public static abstract class Cart implements BaseColumns {
        public static final String TABLE_NAME = "cart";
        public static final String COL_ID = "_id";
        public static final String COLUMN_BAND_NAME = "bandName";
        public static final String COLUMN_ALBUM_TITLE = "albumTitle";
        public static final String COLUMN_FORMAT = "format";
        public static final String COLUMN_PRICE = "price";
    }

    private static final String SQL_CREATE_ENTRIES_BASIC_INVENTORY = "CREATE TABLE " +
            InventoryItem.TABLE_NAME + " (" +
            InventoryItem._ID + " INTEGER PRIMARY KEY," +
            InventoryItem.COLUMN_ICON + " INTEGER," +
            InventoryItem.COLUMN_BAND_NAME + " TEXT," +
            InventoryItem.COLUMN_ALBUM_TITLE + " TEXT," +
            InventoryItem.COLUMN_FORMAT + " TEXT," +
            InventoryItem.COLUMN_GENRE + " TEXT," +
            InventoryItem.COLUMN_PRICE + " REAL)" ;

    private static final String SQL_DELETE_ENTRIES_BASIC_INVENTORY = "DROP TABLE IF EXISTS " +
            InventoryItem.TABLE_NAME;

    private static final String SQL_CREATE_ENTRIES_CART = "CREATE TABLE " +
            Cart.TABLE_NAME + " (" +
            Cart._ID + " INTEGER PRIMARY KEY," +
            Cart.COLUMN_BAND_NAME + " TEXT," +
            Cart.COLUMN_ALBUM_TITLE + " TEXT," +
            Cart.COLUMN_FORMAT + " TEXT," +
            Cart.COLUMN_PRICE + " REAL)";

    private static final String SQL_DELETE_ENTRIES_CART = "DROP TABLE IF EXISTS " +
            Cart.TABLE_NAME;

    public long insertRowItem(CustomObjectMain customObjectMain) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(String.valueOf(InventoryItem.COLUMN_ICON), customObjectMain.getmAlbumIcon());
        values.put(InventoryItem.COLUMN_BAND_NAME, customObjectMain.getmBandName());
        values.put(InventoryItem.COLUMN_ALBUM_TITLE, customObjectMain.getmAlbumTitle());
        values.put(InventoryItem.COLUMN_GENRE, customObjectMain.getmGenre());
        values.put(InventoryItem.COLUMN_FORMAT, customObjectMain.getmFormat());
        values.put(String.valueOf(InventoryItem.COLUMN_PRICE), customObjectMain.getmPrice());

       // db.insertOrThrow(InventoryItem.TABLE_NAME, null, values);

        long returnItemId = db.insert(InventoryItem.TABLE_NAME, null, values);
        db.close();
        return returnItemId;
    }

    public long insertRowCart(CartCustomObject cartCustomObject) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Cart.COLUMN_BAND_NAME, cartCustomObject.getmBandName());
        values.put(Cart.COLUMN_ALBUM_TITLE, cartCustomObject.getmAlbumTitle());
        values.put(Cart.COLUMN_FORMAT, cartCustomObject.getmFormat());
        values.put(String.valueOf(Cart.COLUMN_PRICE), cartCustomObject.getmPrice());

      //  db.insertOrThrow(Cart.TABLE_NAME, null, values);

        long returnCartId = db.insert(Cart.TABLE_NAME, null, values);
        db.close();
        return returnCartId;
    }


    // PASS THESE PARAMETERS INTO itemList to do the case switch selection stuff (String extraSelection, String[] newArg)
    public ArrayList<CustomObjectMain> itemList () {
        ArrayList<CustomObjectMain> inventoryItemList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(InventoryItem.TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            //should probably do this with setters...
            while (!cursor.isAfterLast()) {
                try {
                    inventoryItemList.add(processItem(cursor));
                } catch (Exception e) {
                    Log.e("DBHELPER", "getShopItems: ", e);
                }
                cursor.moveToNext();
            }
        }
        cursor.close();
        return inventoryItemList;
    }

    private CustomObjectMain processItem (Cursor cursor) throws Exception {


        int mainObjectID = cursor.getInt(cursor.getColumnIndex(String.valueOf(InventoryItem.COLUMN_ID)));
        int icon = cursor.getInt(cursor.getColumnIndex(String.valueOf(InventoryItem.COLUMN_ICON)));
        String band = cursor.getString(cursor.getColumnIndex(InventoryItem.COLUMN_BAND_NAME));
        String album = cursor.getString(cursor.getColumnIndex(InventoryItem.COLUMN_ALBUM_TITLE));
        String genre = cursor.getString(cursor.getColumnIndex(InventoryItem.COLUMN_GENRE));
        String format = cursor.getString(cursor.getColumnIndex(InventoryItem.COLUMN_FORMAT));
        Double price = cursor.getDouble(cursor.getColumnIndex(String.valueOf(InventoryItem.COLUMN_PRICE)));


        return new CustomObjectMain(mainObjectID, icon, band, album, genre,
                format, price);
    }

    public ArrayList<CartCustomObject> cartList () {
        ArrayList<CartCustomObject> inventoryCartList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor2 = db.query(Cart.TABLE_NAME, null, null, null, null, null, null);

        if (cursor2.moveToFirst()) {

            while (!cursor2.isAfterLast()) {
                try {
                    inventoryCartList.add(processCart(cursor2));
                } catch (Exception e) {
                    Log.e("DBHELPER", "getShopItems: ", e);
                }

                cursor2.moveToNext();
            }
        }

        cursor2.close();
        return inventoryCartList;
    }

    private CartCustomObject processCart (Cursor cursor) throws Exception {


        int cartObjectID = cursor.getInt(cursor.getColumnIndex(String.valueOf(Cart.COL_ID)));
        String band = cursor.getString(cursor.getColumnIndex(Cart.COLUMN_BAND_NAME));
        String album = cursor.getString(cursor.getColumnIndex(Cart.COLUMN_ALBUM_TITLE));
        String format = cursor.getString(cursor.getColumnIndex(Cart.COLUMN_FORMAT));
        Double price = cursor.getDouble(cursor.getColumnIndex(String.valueOf(Cart.COLUMN_PRICE)));


        return new CartCustomObject(cartObjectID, band, album, format, price);
    }

    public Cursor getInventoryList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(InventoryItem.TABLE_NAME, // a. table
                INVENTORY_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor getInventoryItem(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(InventoryItem.TABLE_NAME, // a. table
                INVENTORY_COLUMNS, // b. column names
                InventoryItem.COLUMN_ID + " = ?", // c. selections
                new String[]{String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }


    public ArrayList<CustomObjectMain> searchInventoryList(String query){

        ArrayList<CustomObjectMain> searchList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String selection =  InventoryItem.COLUMN_BAND_NAME + " like ? ";
        String[] selectionArgs = {"%" + query + "%"};

       Cursor cursor = db.query(InventoryItem.TABLE_NAME, // a. table
               INVENTORY_COLUMNS, // b. column names
               selection, // c. selections
               selectionArgs, // d. selections args
               //new String[]{query}, // d. selections args
               null, // e. group by
               null, // f. having
               null, // g. order by
               null); // h. limit

       if (cursor.moveToFirst()) {
           while (!cursor.isAfterLast()) {
               try {
                   searchList.add(processItem(cursor));
               } catch (Exception e) {
                   Log.e("DBHELPER", "getShopItems: ", e);
               }
               cursor.moveToNext();
           }
       }

        cursor.close();
        return searchList;
    }
}


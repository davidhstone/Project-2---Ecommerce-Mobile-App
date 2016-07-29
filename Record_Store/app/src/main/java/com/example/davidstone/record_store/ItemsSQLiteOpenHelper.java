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

    public ItemsSQLiteOpenHelper(Context context) {
        super(context, "db", null, 4);
    }

 //   private static final String TAG = ItemsSQLiteOpenHelper.class.getCanonicalName();

 //   private static final int DATABASE_VERSION = 1;
 //   public static final String DATABASE_NAME = "INVENTORY_DB";
 //   public static final String BASIC_INVENTORY_TABLE_NAME = "BASIC_INVENTORY";
 //   public static final String AVAILABLE_FORMATS_TABLE_NAME = "AVAILABLE_FORMATS";

 //   public static final String INVENTORY_COL_ID = "_id";
 //   public static final String INVENTORY_COL_BAND_NAME = "BAND_NAME";
 //   public static final String INVENTORY_COL_ALBUM_TITLE = "ALBUM_TITLE";
 //   public static final String INVENTORY_COL_GENRE = "GENRE";
//
 //   public static final String FORMAT_COL_ID = "_id";
 //   public static final String FORMAT_COL_BAND_NAME = "BAND_NAME";
 //   public static final String FORMAT_COL_ALBUM_TITLE = "ALBUM_TITLE";
 //   public static final String FORMAT_COL_FORMAT = "FORMAT";
 //   public static final String FORMAT_COL_PRICE = "PRICE";




    private static ItemsSQLiteOpenHelper INSTANCE;

    public static synchronized ItemsSQLiteOpenHelper getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new ItemsSQLiteOpenHelper(context.getApplicationContext());
        return INSTANCE;
    }

    //BELOW IS A TEST TO SEE IF I CAN GET THe DETAIL VIEW WORKING
    public static final String[] INVENTORY_COLUMNS = {InventoryItem.COLUMN_ID,
            String.valueOf(InventoryItem.COLUMN_ICON),
            InventoryItem.COLUMN_BAND_NAME, InventoryItem.COLUMN_ALBUM_TITLE,
            InventoryItem.COLUMN_GENRE, InventoryItem.COLUMN_FORMAT,
            InventoryItem.COLUMN_PRICE.toString()};

  // public static final String[] CART_COLUMNS = {CART.COL_ID,
  //         CART.COLUMN_BAND_NAME, CART.COLUMN_ALBUM_TITLE,
  //         CART.COLUMN_FORMAT, CART.COLUMN_PRICE};

    public boolean checkIfTableExists (){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(InventoryItem.TABLE_NAME, null, null, null, null, null, null);
        boolean result = cursor.moveToFirst();
        cursor.close();

        return result;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_BASIC_INVENTORY);
     //   db.execSQL(SQL_CREATE_ENTRIES_AVAILABLE_FORMAT);

//        insertRowItem()


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES_BASIC_INVENTORY);
     //   db.execSQL(SQL_DELETE_ENTRIES_AVAILABLE_FORMAT);
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

   // public static abstract class AvailableFormat implements BaseColumns {
   //     public static final String TABLE_NAME = "availableFormat";
   //     public static final String COL_ID = "_id";
   //     public static final String COLUMN_BAND_NAME = "bandName";
   //     public static final String COLUMN_ALBUM_TITLE = "albumTitle";
   //     public static final String COLUMN_FORMAT = "format";
   //     public static final String COLUMN_PRICE = "price";
   // }

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

  //  private static final String SQL_CREATE_ENTRIES_AVAILABLE_FORMAT = "CREATE TABLE " +
  //          AvailableFormat.TABLE_NAME + " (" +
  //          AvailableFormat._ID + " INTEGER PRIMARY KEY," +
  //          AvailableFormat.COLUMN_BAND_NAME + " TEXT," +
  //          AvailableFormat.COLUMN_ALBUM_TITLE + " TEXT," +
  //          AvailableFormat.COLUMN_FORMAT + " TEXT," +
  //          AvailableFormat.COLUMN_PRICE + " DOUBLE)";

  //  private static final String SQL_DELETE_ENTRIES_AVAILABLE_FORMAT = "DROP TABLE IF EXISTS " +
  //          AvailableFormat.TABLE_NAME;

    public long insertRowItem(CustomObjectMain customObjectMain) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(String.valueOf(InventoryItem.COLUMN_ICON), customObjectMain.getmAlbumIcon());
        values.put(InventoryItem.COLUMN_BAND_NAME, customObjectMain.getmBandName());
        values.put(InventoryItem.COLUMN_ALBUM_TITLE, customObjectMain.getmAlbumTitle());
        values.put(InventoryItem.COLUMN_GENRE, customObjectMain.getmGenre());
        values.put(InventoryItem.COLUMN_FORMAT, customObjectMain.getmFormat());
        values.put(String.valueOf(InventoryItem.COLUMN_PRICE), customObjectMain.getmPrice());

        db.insertOrThrow(InventoryItem.TABLE_NAME, null, values);

        long returnItemId = db.insert(InventoryItem.TABLE_NAME, null, values);
        db.close();
        return returnItemId;
    }

 // public long insertRowFormat(FormatContainsPrice availableFormat) {
 //     SQLiteDatabase db = getWritableDatabase();
 //     ContentValues values = new ContentValues();
 //     values.put(AvailableFormat.COLUMN_BAND_NAME, availableFormat.getBandName());
 //     values.put(AvailableFormat.COLUMN_ALBUM_TITLE, availableFormat.getAlbumTitle());
 //     values.put(AvailableFormat.COLUMN_FORMAT, availableFormat.getFormat());
 //     values.put(AvailableFormat.COLUMN_PRICE, availableFormat.getPrice());

 //     db.insertOrThrow(AvailableFormat.TABLE_NAME, null, values);

 //     long returnFormatId = db.insert(AvailableFormat.TABLE_NAME, null, values);
 //     db.close();
 //     return returnFormatId;
 // }

 //  public Cursor getInventoryList(){

 //      ArrayList<CustomObjectMain> itemsList = new ArrayList<>();

 //      itemsList.add(new CustomObjectMain(R.color.colorAccent,
 //              "AC/DC", "PowerAge"));

 //      SQLiteDatabase db = getWritableDatabase();

 //      Cursor cursor = db.query(InventoryItem.TABLE_NAME, // a. table
 //              INVENTORY_COLUMNS, // b. column names
 //              null, // c. selections
 //              null, // d. selections args
 //              null, // e. group by
 //              null, // f. having
 //              null, // g. order by
 //              null); // h. limit

 //          public ArrayList<CustomObjectMain> itemList (String extraSelection, String[] newArg){
 //          ArrayList<CustomObjectMain> itemList = new ArrayList<>();
 //          SQLiteDatabase db = getReadableDatabase();

 //          Cursor cursor = db.query(InventoryItem.TABLE_NAME, null, extraSelection, newArg, null, null, null);

 //          if (cursor.moveToFirst()) {
 //              //should probably do this with setters...
 //              while (!cursor.isAfterLast()) {
 //                  try {
 //                      itemList.add(insertRowItem(cursor));
 //                  } catch (Exception e) {
 //                      Log.e("DBHELPER", "getShopItems: ", e);
 //                  }

 //                  cursor.moveToNext();
 //              }
 //          }

 //          cursor.close();
 //          return itemList;

 //          SQLiteDatabase db = this.getReadableDatabase();
 //      }
 //  }
    // PASS THESE PARAMETERS INTO itemList to do the case switch selcetion stuff (String extraSelection, String[] newArg)
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

    // DON'T NEED THIS  -----> UNTIL I NEED THE SWITCH STATEMENT FOR FORMAT  ---->  CustomObjectMain albumItem;
        int mainObjectID = cursor.getInt(cursor.getColumnIndex(String.valueOf(InventoryItem.COLUMN_ID)));
        int icon = cursor.getInt(cursor.getColumnIndex(String.valueOf(InventoryItem.COLUMN_ICON)));
        String band = cursor.getString(cursor.getColumnIndex(InventoryItem.COLUMN_BAND_NAME));
        String album = cursor.getString(cursor.getColumnIndex(InventoryItem.COLUMN_ALBUM_TITLE));
        String genre = cursor.getString(cursor.getColumnIndex(InventoryItem.COLUMN_GENRE));
        String format = cursor.getString(cursor.getColumnIndex(InventoryItem.COLUMN_FORMAT));
        Double price = cursor.getDouble(cursor.getColumnIndex(String.valueOf(InventoryItem.COLUMN_PRICE)));

     //   TURNS OUT I DON'T THINK I NEED A SWITCH STATEMENT UNTIL I DEVELOP A NEW CUSTOM OBJECT FOR EACH FORMAT
     //   CustomObjectMain. format;
     //   switch(format) {
     //       case vinyl:
     //           format = CustomObjectMain.Format.Vinyl;
     //           break;
     //   }

        return new CustomObjectMain(mainObjectID, icon, band, album, genre,
                format, price);
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

   // public Cursor getFormatItem(){
//
   //     SQLiteDatabase db = this.getReadableDatabase();
//
   //     Cursor cursor = db.query(AvailableFormat.TABLE_NAME, // a. table
   //             FORMAT_COLUMNS, // b. column names
   //             null, // c. selections
   //             null, // d. selections args
   //             null, // e. group by
   //             null, // f. having
   //             null, // g. order by
   //             null); // h. limit
//
   //     return cursor;
   // }

    public Cursor searchInventoryList(String query){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(InventoryItem.TABLE_NAME, // a. table
                INVENTORY_COLUMNS, // b. column names
                InventoryItem.COLUMN_ALBUM_TITLE + " LIKE ?", // c. selections
                new String[]{"%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

}

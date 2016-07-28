package com.example.davidstone.record_store;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidstone on 7/28/16.
 */
public class ItemsSQLiteOpenHelper extends SQLiteOpenHelper {

    public ItemsSQLiteOpenHelper(Context context) {
        super(context, "db", null, 1);
    }

 //  private static final String TAG = ItemsSQLiteOpenHelper.class.getCanonicalName();

 //  private static final int DATABASE_VERSION = 1;
 //  public static final String DATABASE_NAME = "INVENTORY_DB";
 //  public static final String BASIC_INENTORY_TABLE_NAME = "BASIC_INVENTORY";
 //  public static final String AVAILABLE_FORMATS_TABLE_NAME = "AVAILABLE_FORMATS";

    private static ItemsSQLiteOpenHelper INSTANCE;

    public static synchronized ItemsSQLiteOpenHelper getInstace(Context context) {
        if (INSTANCE == null)
            INSTANCE = new ItemsSQLiteOpenHelper(context.getApplicationContext());
        return INSTANCE;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_BASIC_INVENTORY);
        db.execSQL(SQL_CREATE_ENTRIES_AVAILABLE_FORMAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES_BASIC_INVENTORY);
        db.execSQL(SQL_DELETE_ENTRIES_AVAILABLE_FORMAT);
        onCreate(db);
    }

    public static abstract class InventoryItem implements BaseColumns {
        public static final String TABLE_NAME = "inventoryItem";
        public static final String COLUMN_BAND_NAME = "bandName";
        public static final String COLUMN_ALBUM_TITLE = "albumTitle";
        public static final String COLUMN_GENRE = "genre";
    }

    public static abstract class AvailableFormat implements BaseColumns {
        public static final String TABLE_NAME = "availableFormat";
        public static final String COLUMN_BAND_NAME = "bandName";
        public static final String COLUMN_ALBUM_TITLE = "albumTitle";
        public static final String COLUMN_FORMAT = "format";
        public static final String COLUMN_PRICE = "price";
    }

    private static final String SQL_CREATE_ENTRIES_BASIC_INVENTORY = "CREATE TABLE " +
            InventoryItem.TABLE_NAME + " (" +
            InventoryItem._ID + " INTEGER PRIMARY KEY," +
            InventoryItem.COLUMN_BAND_NAME + " TEXT," +
            InventoryItem.COLUMN_ALBUM_TITLE + " TEXT," +
            InventoryItem.COLUMN_GENRE + " TEXT,";

    private static final String SQL_DELETE_ENTRIES_BASIC_INVENTORY = "DROP TABLE IF EXISTS " +
            InventoryItem.TABLE_NAME;

    private static final String SQL_CREATE_ENTRIES_AVAILABLE_FORMAT = "CREATE TABLE " +
            AvailableFormat.TABLE_NAME + " (" +
            AvailableFormat._ID + " INTEGER PRIMARY KEY," +
            AvailableFormat.COLUMN_BAND_NAME + " TEXT," +
            AvailableFormat.COLUMN_ALBUM_TITLE + " TEXT," +
            AvailableFormat.COLUMN_FORMAT + " TEXT," +
            AvailableFormat.COLUMN_PRICE + " DOUBLE,";

    private static final String SQL_DELETE_ENTRIES_AVAILABLE_FORMAT = "DROP TABLE IF EXISTS " +
            AvailableFormat.TABLE_NAME;

    public void insertRow(Item inventoryItem) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryItem.COLUMN_BAND_NAME, inventoryItem.getBandName());
        values.put(InventoryItem.COLUMN_ALBUM_TITLE, inventoryItem.getAlbumTitle());
        values.put(InventoryItem.COLUMN_GENRE, inventoryItem.getGenre());

        db.insertOrThrow(InventoryItem.TABLE_NAME, null, values);
    }

    public void insertRowFormat(FormatContainsPrice availableFormat) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AvailableFormat.COLUMN_BAND_NAME, availableFormat.getBandName());
        values.put(AvailableFormat.COLUMN_ALBUM_TITLE, availableFormat.getAlbumTitle());
        values.put(AvailableFormat.COLUMN_FORMAT, availableFormat.getFormat());
        values.put(AvailableFormat.COLUMN_PRICE, availableFormat.getPrice());

        db.insertOrThrow(InventoryItem.TABLE_NAME, null, values);
    }
}

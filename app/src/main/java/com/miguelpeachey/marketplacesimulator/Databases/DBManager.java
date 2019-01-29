package com.miguelpeachey.marketplacesimulator.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.miguelpeachey.marketplacesimulator.Helpers.ItemsDatabaseHelper;

public class DBManager {

    private ItemsDatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new ItemsDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String item, String price) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(ItemsDatabaseHelper.ITEM, item);
        contentValue.put(ItemsDatabaseHelper.PRICE, price);
        database.insert(ItemsDatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { ItemsDatabaseHelper._ID, ItemsDatabaseHelper.ITEM, ItemsDatabaseHelper.PRICE };
        Cursor cursor = database.query(ItemsDatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemsDatabaseHelper.ITEM, name);
        contentValues.put(ItemsDatabaseHelper.PRICE, desc);
        int i = database.update(ItemsDatabaseHelper.TABLE_NAME, contentValues, ItemsDatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(ItemsDatabaseHelper.TABLE_NAME, ItemsDatabaseHelper._ID + "=" + _id, null);
    }

}

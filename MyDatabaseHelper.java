package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    static final String database_name = "Session.db";
    static final String table_name = "Student";
    static final String col_1 = "ID";
    static final String col_2 = "Name";
    static final String col_3 = "Level";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + table_name + " (ID text primary key, Name text, Level int) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("Drop Table if exists "+ table_name);
    onCreate(db);
    }

    public long insertRecord(String id, String name, int level){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col_1, id);
        values.put(col_2, name);
        values.put(col_3, level);
        return database.insert(table_name, null, values);
    }

    public Cursor getAll()
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from " + table_name, null);
        return  cursor;
    }
}

package com.son.danghaison_dh9c2.entities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="ql_tacpham.db";
    public static final String TABLE_NAME="TacPham";
    private Context context;

    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE IF NOT EXISTS " +TABLE_NAME+
                "(maTP integer primary key , "+
                "tenTP text , "+
                "nxb text , "+
                "soxb text, "+
                "soluong text, "+
                "dongia text )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}

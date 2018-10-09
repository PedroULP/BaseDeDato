package com.example.pedro.github.Adapters;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ProyectoAdapter {

    private static final String NAME = "Proyecto";
    private SQLiteDatabase sqlDB;

    public ProyectoAdapter(SQLiteDatabase sqlDB) {
        this.sqlDB = sqlDB;
    }
}

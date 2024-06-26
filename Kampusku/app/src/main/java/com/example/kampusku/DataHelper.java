package com.example.kampusku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE biodata (no INTEGER PRIMARY KEY, nama TEXT, tgl TEXT, jk TEXT, alamat TEXT);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

        sql = "INSERT INTO biodata (no, nama, tgl, jk, alamat) VALUES ('0', 'Jalaludin', '1996-07-11', 'Lakilaki', 'Rangkasbitung');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, but in this simple example, we are not handling upgrades
        db.execSQL("DROP TABLE IF EXISTS biodata");

        // Recreate table
        onCreate(db);
    }
}

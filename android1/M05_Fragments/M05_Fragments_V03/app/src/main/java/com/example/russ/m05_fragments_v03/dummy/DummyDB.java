package com.example.russ.m05_fragments_v03.dummy;

import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Locale;

public class DummyDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TEST_DB.db";
    private SQLiteDatabase db;
    public DummyDB(Context context) {
        super(context, "DB_Name", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        this.db.execSQL("CREATE TABLE 'DATA' " +
                "( `ID` INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                " `Character_Name` TEXT," +
                " `Field1` TEXT," +
                " `Field2` TEXT, " +
                "`Field3` TEXT, " +
                "`Field4` TEXT )");

        this.db.execSQL("CREATE TABLE sqlite_sequence(name,seq)");

    }

    public void InsertIntoData(String CharName, String Field1, String Field2, String Field3, String Field4){
        String sql = (String.format(Locale.CANADA, "insert into 'DATA' (Character_Name, Field1, Field2, Field3, Field4) values ('%s','%s','%s','%s','%s');", CharName, Field1, Field2, Field3, Field4));
    }
    public String QueryDBKnownID(int id){
        String sql = (String.format(Locale.CANADA,"select * from DATA where id=%d;", id));
        Cursor c = this.db.rawQuery(sql, null); //TODO: Continue to fix this

        CharArrayBuffer b = new CharArrayBuffer(1000);
        for(int i = 0; i<=5; i++) {
            c.copyStringToBuffer(i, b);
        }
        String s = b.data.toString();
        Log.w("Database", s);
        return "";
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL("DROP TABLE IF EXISTS 'DATA' ");
        onCreate(db);
    }
}


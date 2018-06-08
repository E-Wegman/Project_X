package com.example.alex_.hrcommunity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class database extends SQLiteOpenHelper {

    private static final String TAG = "Database";

    private static final String Table_Name = "Agenda";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "date";

    public database(Context context) {
        super(context, Table_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT ,"+ COL3 + "TEXT)";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);
        contentValues.put(COL3, item);

        Log.d(TAG, "addData: Adding " + item + " to " + Table_Name);

        long result = db.insert(Table_Name, null, contentValues);

        if (result == -1){
            return false;
        }else{
            return true;
        }
    }


}

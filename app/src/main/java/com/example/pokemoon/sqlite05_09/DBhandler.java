package com.example.pokemoon.sqlite05_09;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DBhandler  extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NICETRY";//name of the database
    private static final String TABLE_NAME = "URUN";//name for the table

    private static final String ID = "id";
    private static final String URUNADI = "urunadi";
    private static final String FIYAT = "fiyat";
    private static final String ADET = "adet";

    public DBhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                URUNADI + " TEXT NOT NULL," +
                FIYAT + " INTEGER NOT NULL," +
                ADET + " INTEGER NOT NULL)");
    }

    //Executes once a database change is occurred

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //method to add row to table
    void addUrun(UrunBilgiClass u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(URUNADI, u.getUrunadi());

        values.put(FIYAT, u.getFiyat());

        values.put(ADET, u.getAdet());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<UrunBilgiClass> getAll() {

        List<UrunBilgiClass> contactList = new ArrayList<UrunBilgiClass>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME; //retrieve data from the database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                UrunBilgiClass m = new UrunBilgiClass();
                m.setKey(cursor.getInt(0));
                m.setUrunadi(cursor.getString(1));
                m.setFiyat(cursor.getInt(2));
                m.setAdet(cursor.getInt(3));
                contactList.add(m);

            } while (cursor.moveToNext());
        }

        return contactList;
    }
    public UrunBilgiClass getProduct(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = " + String.valueOf(id),null);

        try {
            if (data != null)
                while (data.moveToFirst())
                    return new UrunBilgiClass(data.getInt(0), data.getString(1), data.getInt(2), data.getInt(3));
        }finally {
            data.close();
        }
        return null;
    }

    public void delete(int key)
    {    //code to delete a row from the table
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = '" + key + "'", new String[]{});
        db.close();
    }

    public void edit(UrunBilgiClass u, int key) {     //code to edit the contents

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(URUNADI, u.getUrunadi());
        values.put(FIYAT, u.getFiyat());
        values.put(ADET, u.getAdet());

        // updating row
        db.update(TABLE_NAME, values, ID + " = '" + key + "'", new String[]{});
    }


}

package com.example.nata.contacts_homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.example.nata.contacts_homework.DBHelper.TABLE_NAME;

/**
 * Created by Nata on 25.03.2018.
 */

public class ContactsHelper {

    SQLiteDatabase db;

    public ContactsHelper(Context context) {
        DBHelper dbHelper=new DBHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    long insert(String name, String phone) {

        ContentValues cv = new ContentValues();

        cv.put(DBHelper.COLUMN_NAME, name);
        cv.put(DBHelper.COLUMN_PHONE, phone);

        return db.insert(TABLE_NAME, null, cv);
    }

    long update(long id, String name, String phone){

        ContentValues cv = new ContentValues();

        cv.put(DBHelper.COLUMN_NAME, name);
        cv.put(DBHelper.COLUMN_PHONE, phone);

        return db.update(TABLE_NAME, cv, "_id = ?",new String[]{Long.toString(id)});

    }

    ArrayList<Contact> getAll() {

        Cursor mCursor = db.query(TABLE_NAME, null, null, null, null, null,null, null);
        ArrayList<Contact> arr = new ArrayList<>();

        mCursor.moveToFirst();

        if (!mCursor.isAfterLast()) {

            do {
                long id = mCursor.getLong(DBHelper.NUM_COLUMN_ID);
                String name = mCursor.getString(DBHelper.NUM_COLUMN_NAME);
                String phone = mCursor.getString(DBHelper.NUM_COLUMN_PHONE);

                arr.add(new Contact(id, name, phone));

            } while (mCursor.moveToNext());
        }
        db.close();

        return arr;
    }
}

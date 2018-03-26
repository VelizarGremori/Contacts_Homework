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

        ContentValues cv = new ContentValues();// хранилище с принципом ключ-значени

        cv.put(DBHelper.COLUMN_NAME, name);
        cv.put(DBHelper.COLUMN_PHONE, phone);

        return db.insert(TABLE_NAME, null, cv);// метод insert возвращает id, помещенного объекта в таблицу.
        // указали имя таблицы и хранилище данных
    }

    ArrayList<Contact> getAll() {

        Cursor mCursor = db.query(TABLE_NAME, null, null, null, null, null,null, null);
        ArrayList<Contact> arr = new ArrayList<>();

        mCursor.moveToFirst();

        if (!mCursor.isAfterLast()) {

            //делай пока записи есть в таблице
            do {
                long id = mCursor.getLong(DBHelper.NUM_COLUMN_ID);
                String name = mCursor.getString(DBHelper.NUM_COLUMN_NAME);
                String phone = mCursor.getString(DBHelper.NUM_COLUMN_PHONE);

                // получем значения соотвествующих полей и формируем объект, добавив его в коллекцию.
                arr.add(new Contact(id, name, phone));

            } while (mCursor.moveToNext());
        }
        db.close(); // закрыли транзакцию

        return arr; // вернули коллекцию
    }
}

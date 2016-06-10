package com.example.ravi.broadcast.BroaccastReceiver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ravi on 5/30/2016.
 */
public class Datadaseclass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    private HashMap hashMap;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table contacts" +
                        "(id integer primary key,name text,phone text,email text,street text,place text)"
        );
    }
    Datadaseclass(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists contacts");
    }

    public boolean insertcontact(Integer id,String name,String phone,String email,String street,String place)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("street",street);
        contentValues.put("place",place);
        db.insert("contacts", null, contentValues);
        return true;
    }
    public Integer deletecontact(Integer id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("contacts","id=?",new String[]{Integer.toString(id)});
    }
    public Cursor getdata(int id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from contacts where id id=" + id + "", null);
        return  cursor;
    }
    public Integer numbofrows()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        int numberofrows=(int) DatabaseUtils.queryNumEntries(db,CONTACTS_TABLE_NAME);
        return numberofrows;
    }

    public ArrayList<String> getallcontacts()
    {
        ArrayList<String> arrayAdapter=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from contacts",null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false)
        {
            arrayAdapter.add(cursor.getString(cursor.getColumnIndex(CONTACTS_TABLE_NAME)));
            cursor.moveToLast();
        }
        return arrayAdapter;
    }

}

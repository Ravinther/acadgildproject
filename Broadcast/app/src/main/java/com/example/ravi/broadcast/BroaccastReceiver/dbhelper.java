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
 * Created by Ravi on 5/26/2016.
 */
public class dbhelper extends SQLiteOpenHelper {
    public static final String dbname="sample1.db";
    public static final String db_Table_name="contacts";
    public static final String db_name="name";
    public static final String dbname_id="id";
    public static final String dbname_email="email";
    public static final String dbname_street="street";
    public static final String dbname_phone="phone";
    public static final String dbname_place="place";
    private HashMap hp;
    public dbhelper(Context context)
    {
        super(context,dbname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table contacts"
                + "(id integer primary key,name text,email text,street text,phone text,place text)"
        );
    }
    public boolean insertmethod(String name,String email,String street,String phone,String place)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("street",street);
        contentValues.put("phone",phone);
        contentValues.put("place", place);
        db.insert("contacts", null, contentValues);
        return true;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if Exists contacts");
    }
    public Cursor numofele(Integer id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from contacts where id=" + id + "", null);
        return  cursor;
    }
    public Integer noofrows()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        int num=(int) DatabaseUtils.queryNumEntries(db,db_Table_name);
        return num;
    }
    public boolean updatemethod(Integer id,String name,String email,String street,String phone,String place)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("street",street);
        contentValues.put("phone",phone);
        contentValues.put("place", place);
        db.update("contacts",contentValues,"id=?",new String[]{Integer.toString(id)});
        return true;
    }
    public  Integer deletemethod(Integer id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
       return db.delete("contacts","id=?",new String[] {Integer.toString(id)} );
    }
    public ArrayList<String> getallcontacts()
    {
        ArrayList<String> arrayList=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from contacts",null);
        cursor.moveToFirst();
        while ((cursor.isAfterLast()==false))
        {
            arrayList.add(cursor.getString(cursor.getColumnIndex(db_name)));
            cursor.moveToNext();
        }
        return arrayList;
    }
}

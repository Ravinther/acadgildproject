package com.example.ux.myfirstapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SimpleTimeZone;

/**
 * Created by Ravi on 6/2/2016.
 */
public class Databasecreation extends SQLiteOpenHelper {
    public static final String db_Table_creation="dbcreation.db";
    public static final String db_Table_name="tbllogin";
    public static final String db_id="id";
    public static final String db_name="name";
    public static final String db_password="password";
    public static final String db_phone="phone";
    public static final String db_email="email";
    private HashMap hashMap;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("" +
                "create table tbllogin"+
                        "(id integer primary key autoincrement not null," +
                        "name text null,password text null,phone text null,email text null);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbllogin");

    }
    public Databasecreation(Context context)
    {
        super(context, db_Table_name, null, 1);
    }
    public boolean insertmethod(String name,String password,String phone,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);;
        contentValues.put("password",password);
        contentValues.put("phone",phone);
        contentValues.put("email", email);
        db.insert("tbllogin", null, contentValues);
        return true;
    }
    public Cursor getdetails(Integer id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from tbllogin where id="+id+"",null);
        return cursor;
    }
    public int getnumofrows()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        int num=(int) DatabaseUtils.queryNumEntries(db,db_Table_name);
        return num;
    }
    public boolean updatemethod(Integer id,String name,String password,String phone,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);;
        contentValues.put("password",password);
        contentValues.put("phone",phone);
        contentValues.put("email", email);
        db.update("tbllogin",contentValues,"id=?",new String[]{Integer.toString(id)});
        return true;
    }
    public Integer deletemethod(Integer id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("tbllogin","id=?",new String[]{Integer.toString(id)});
    }
    public ArrayList<String> getallcontacts()
    {
        ArrayList<String> arrayList=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from tbllogin",null);
        cursor.moveToFirst();
        while ((cursor.isAfterLast()==false))
        {
            arrayList.add(cursor.getString(cursor.getColumnIndex(db_name)));
            cursor.moveToFirst();
        }
    return arrayList;
    }
}

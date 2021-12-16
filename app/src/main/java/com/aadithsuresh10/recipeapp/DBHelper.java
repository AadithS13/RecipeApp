package com.aadithsuresh10.recipeapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";


    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT,email TEXT, mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");

    }
    public Boolean insertData(String username, String password, String email , String mobile){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor ViewUser(String username, String password)
    {
        SQLiteDatabase MYDB = this.getWritableDatabase();
        Cursor cursor = MYDB.rawQuery("Select * from users where username = ? and password = ? ",new String[] {username,password});
        return cursor;


    }

    public Boolean sendOTP(String mobile)
    {
        SQLiteDatabase MYDB = this.getWritableDatabase();
        Cursor cursor = MYDB.rawQuery("Select * from users where mobile = ? ",new String[] {mobile});
        if(cursor.getCount()>0)
            return true;

        else
            return false;

    }

    public Boolean changePassword(String username,String mobile,String password)
    {
        SQLiteDatabase MYDB = this.getWritableDatabase();
        Cursor cursor = MYDB.rawQuery("Update users set password = ?, username = ? where mobile = ?",new String[] {password,username,mobile});
        if(cursor.getCount()>0)
            return true;

        else
            return false;
    }

}

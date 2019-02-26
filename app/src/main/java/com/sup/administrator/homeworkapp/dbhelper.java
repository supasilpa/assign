package com.sup.administrator.homeworkapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2/12/2019.
 */
public class dbhelper extends SQLiteOpenHelper {
    public static final String dbname="stud.db";
    public static final String tablename="stud";
    public static final String col1="id";
    public static final String col2="name";
    public static final String col3="department";
    public static final String col4="rollno";
    public static final String col5="email";
    public static final String col6="mobileno";
    public static final String col7="username";
    public static final String col8="password";


    public static final String tablenamee="assign";
    public static final String col11="id";
    public static final String col12="sem";
    public static final String col13="subname";
    public static final String col14="duedate";
    public static final String col15="tutor";
    public static final String col16="topic";
    public static final String col17="message";






    public dbhelper(Context context) {
        super(context, dbname, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+tablename+"("+col1+ " integer primary key autoincrement, " +col2+ " text, " +col3+ " text, " +col4+ " text, " +col5+ " text, " +col6+ " text," +col7+ " text, "+col8+ " text )";
        sqLiteDatabase.execSQL(query);

        String query1="create table "+tablenamee+"("+col11+ " integer primary key autoincrement, " +col12+ " text, " +col13+ " text, " +col14+ " text, " +col15+ " text, " +col16+ " text," +col17+ " text )";
        sqLiteDatabase.execSQL(query1);





    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="drop table if exists "+tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

        String query1="drop table if exists "+tablenamee;
        sqLiteDatabase.execSQL(query1);
        onCreate(sqLiteDatabase);
    }
    //insert
    public boolean insert(String name,String  department,String rollno,String email,String mobileno,String username,String password)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,name);
        cv.put(col3,department);
        cv.put(col4,rollno);
        cv.put(col5,email);
        cv.put(col6,mobileno);
        cv.put(col7,username);
        cv.put(col8,password);
         long status=sqLiteDatabase.insert(tablename,null,cv);
          if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    //insert2
    public boolean insertassign(String semester,String  subname,String duedate,String tutor,String topic,String message)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,semester);
        cv.put(col3,subname);
        cv.put(col4,duedate);
        cv.put(col5,tutor);
        cv.put(col6,topic);
        cv.put(col7,message);

        long status=sqLiteDatabase.insert(tablename,null,cv);
        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    //search
    public Cursor search(String name){
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cur=sq.rawQuery("SELECT * FROM "+tablenamee+" WHERE "+col13+"='"+name+"'",null);
        return cur;
    }
}

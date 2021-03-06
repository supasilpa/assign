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



    public static final String table="mark";
    public static final String col21="id";
    public static final String col22="studname";
    public static final String col23="subname";
    public static final String col24="rollno";
    public static final String col25="sem";
    public static final String col26="mark";



    public dbhelper(Context context) {
        super(context, dbname, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+tablename+"("+col1+ " integer primary key autoincrement, " +col2+ " text, " +col3+ " text, " +col4+ " text, " +col5+ " text, " +col6+ " text," +col7+ " text, "+col8+ " text )";
        sqLiteDatabase.execSQL(query);

        String query1="create table "+tablenamee+"("+col11+ " integer primary key autoincrement, " +col12+ " text, " +col13+ " text, " +col14+ " text, " +col15+ " text, " +col16+ " text," +col17+ " text )";
        sqLiteDatabase.execSQL(query1);


        String query2="create table "+table+"("+col21+ " integer primary key autoincrement, " +col22+ " text, " +col23+ " text, " +col24+ " text, " +col25+ " text, " +col26+ " text )";
        sqLiteDatabase.execSQL(query2);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="drop table if exists "+tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

        String query1="drop table if exists "+tablenamee;
        sqLiteDatabase.execSQL(query1);
        onCreate(sqLiteDatabase);


        String query2="drop table if exists "+table;
        sqLiteDatabase.execSQL(query2);
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
        cv.put(col12,semester);
        cv.put(col13,subname);
        cv.put(col14,duedate);
        cv.put(col15,tutor);
        cv.put(col16,topic);
        cv.put(col17,message);

        long status=sqLiteDatabase.insert(tablenamee,null,cv);
        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    //insertmark
    public boolean insertmark(String name,String  subject,String rollno,String sem,String mark)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col22,name);
        cv.put(col23,subject);
        cv.put(col24,rollno);
        cv.put(col25,sem);
        cv.put(col26,mark);


        long status=sqLiteDatabase.insert(table,null,cv);
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
    //searchmark
    public Cursor searchmark(String rollno){
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cur=sq.rawQuery("SELECT * FROM "+table+" WHERE "+col24+"='"+rollno+"'",null);
        return cur;
    }
//    update
    public boolean update(String id,String semester,String duedate,String tutor,String topic,String message)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col12,semester);
        cv.put(col14,duedate);
        cv.put(col15,tutor);
        cv.put(col16,topic);
        cv.put(col17,message);
        long status=sq.update(tablenamee,cv,col11 + "=" +id,null);
        if (status==-1)
        {
            return false;

        }
    else
        {
            return  true;

        }
    }

    //profile srch
    public Cursor searchid(String id)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cur=sq.rawQuery("SELECT * FROM "+tablename+ " WHERE "+col1+ "="+id,null);
        return cur;
    }


    //profile update
    public boolean updatedata(String id,String name,String  department,String rollno,String email,String mobileno,String username,String password){
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,name);
        cv.put(col3,department);
        cv.put(col4,rollno);
        cv.put(col5,email);
        cv.put(col6,mobileno);
        cv.put(col7,username);
        cv.put(col8,password);


        long status=sq.update(tablename,cv,col1 + "=" +id,null);
        if(status==-1)
        {
            return false;

        }
        else
        {
            return true;
        }

    }

public boolean delete (String id)
{
    SQLiteDatabase sq=this.getWritableDatabase();
    long status=sq.delete(tablenamee,col11 + "=" +id,null);
    if(status==-1)
    {
        return false;
    }
    else
    {
        return true;
    }
}
    public Cursor getvalues(String username)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cur=sq.rawQuery("SELECT * FROM "+tablename+ " WHERE "+col7+ "='"+username+"'", null);
        return cur;
    }
}

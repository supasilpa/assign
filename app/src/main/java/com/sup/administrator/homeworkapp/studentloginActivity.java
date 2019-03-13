package com.sup.administrator.homeworkapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class studentloginActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1;
    String checkusername,s1,s2,dbname,dbpass,id;
    dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);

        SharedPreferences a=getSharedPreferences("login",MODE_PRIVATE);
        checkusername=a.getString("username",null);
        if(checkusername!=null)
        {
            Intent i =new Intent(getApplicationContext(),studhome.class);
            startActivity(i);
        }

        db=new dbhelper(this);
        db.getWritableDatabase();


        ed1=(EditText)findViewById(R.id.studuname);
        ed2=(EditText)findViewById(R.id.studpass);
        b1=(Button)findViewById(R.id.studlogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                Cursor cur=db.getvalues(s1);
                if(cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid username",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while(cur.moveToNext())
                    {
                        dbpass=cur.getString(7);
                        dbname=cur.getString(6);
                        id=cur.getString(0);
                        if(dbpass.equals(s2))
                        {
                            SharedPreferences.Editor ed=getSharedPreferences("login",MODE_PRIVATE).edit();
                            ed.putString("name",dbname);
                            ed.putString("id",id);

                            ed.apply();
                            Intent y=new Intent(getApplicationContext(),studhome.class);
                            startActivity(y);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Invalid username and password",Toast.LENGTH_LONG).show();

                        }
                    }
                }

            }
        });
    }
}

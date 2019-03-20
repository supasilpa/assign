package com.sup.administrator.homeworkapp;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class profileedit extends AppCompatActivity {
     Button b;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Spinner sp;
    String getid,s1,s2,s3,s4,s5,s6,s7,ss2;
    dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileedit);
        ed1=(EditText)findViewById(R.id.pname);
        ed2=(EditText)findViewById(R.id.prno);
        ed3=(EditText)findViewById(R.id.pemail);
        ed4=(EditText)findViewById(R.id.pmob);
        ed5=(EditText)findViewById(R.id.pusername);
        ed6=(EditText)findViewById(R.id.ppass);
        b=(Button)findViewById(R.id.psubmit);
       // sp=(Spinner)findViewById(R.id.pdep);

        //ss2=sp.getSelectedItem().toString();

        db=new dbhelper(this);
        db.getWritableDatabase();

        SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
        final String dbid=pref.getString("id",null);



        Cursor cur=db.searchid(dbid) ;
        if(cur.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"no data",Toast.LENGTH_LONG).show();
        }
        else {
            while(cur.moveToNext())
            {
                getid=cur.getString(0);

                s1=cur.getString(1);
               // s2=cur.getString(2);
                s3=cur.getString(3);
                s4=cur.getString(4);
                s5=cur.getString(5);
                s6=cur.getString(6);
                s7=cur.getString(7);
                ed1.setText(s1);

                ed2.setText(s3);
                ed3.setText(s4);
                ed4.setText(s5);
                ed5.setText(s6);
                ed6.setText(s7);


            }
        }

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        s1=ed1.getText().toString();
//        s2=e2.getText().toString();
        s3=ed2.getText().toString();
        s4=ed3.getText().toString();
        s5=ed4.getText().toString();
        s6=ed5.getText().toString();
        s7=ed6.getText().toString();
        boolean result=db.updatedata(dbid,s1,s2,s3,s4,s5,s6,s7);
        if(result==true)
        {
            Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
        }

    }
});
    }
}

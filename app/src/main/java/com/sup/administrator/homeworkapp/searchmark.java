package com.sup.administrator.homeworkapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class searchmark extends AppCompatActivity {
    Button b1;
    EditText ed1,ed2,ed3,ed4;
    String s1,s2,s3,s4;
TextView t1,t2,t3;
    dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchmark);
        b1=(Button)findViewById(R.id.marksearch);
        t1=(TextView) findViewById(R.id.t1);
        t2=(TextView) findViewById(R.id.t2);
        t3=(TextView) findViewById(R.id.t3);
        ed1=(EditText)findViewById(R.id.srollno);
        ed2=(EditText)findViewById(R.id.sstudname);
        ed3=(EditText)findViewById(R.id.ssubject);
        ed4=(EditText)findViewById(R.id.smark);
        db=new dbhelper(this);
        db.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
//                s1=ed1.getText().toString();
                Cursor cur=db.searchmark(s1);
                if (cur.getCount() == 0) {
                    Toast.makeText(getApplicationContext(),"no data",Toast.LENGTH_LONG).show();
                }
                else {
                    while (cur.moveToNext()) {

                        s2 = cur.getString(1);
                        s3 = cur.getString(2);
//                        s4 = cur.getString(4);


                        t1.setVisibility(View.VISIBLE);
                        ed2.setVisibility(View.VISIBLE);
                        ed2.setText(s2);
                        t2.setVisibility(View.VISIBLE);
                        ed3.setVisibility(View.VISIBLE);
                        ed3.setText(s3);
                        t3.setVisibility(View.VISIBLE);
                        ed4.setVisibility(View.VISIBLE);
                        ed4.setText(s4);


                    }
                }
            }
        });
    }
}

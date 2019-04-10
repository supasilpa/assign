package com.sup.administrator.homeworkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class markissue extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5;
    Button b1,b2;
String s1,s2,s3,s4,s5;
    dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markissue);
        b1=(Button)findViewById(R.id.mkok);
        b2=(Button)findViewById(R.id.mkback);
        ed1=(EditText)findViewById(R.id.mkname);
        ed2=(EditText)findViewById(R.id.mksub);
        ed3=(EditText)findViewById(R.id.mkrno);
        ed4=(EditText)findViewById(R.id.mksem);
        ed5=(EditText)findViewById(R.id.mkmark);

        db=new dbhelper(this);
        db.getWritableDatabase();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),loginadmin.class);
                startActivity(i);
            }
        });

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        s1= ed1.getText().toString();
        s2=ed2.getText().toString();
        s3=ed3.getText().toString();
        s4=ed4.getText().toString();
        s5=ed5.getText().toString();
        Log.d("mkname",s1);
        Log.d("mksub",s2);
        Log.d("mkrno",s3);
        Log.d("mksem",s4);


        boolean status=db.insertmark(s1,s2,s3,s4,s5);
        if(status==true)
        {
            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
        }
    }
});
    }
}

package com.sup.administrator.homeworkapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class studsearch extends AppCompatActivity {
    Button b,b1,b2;
    EditText ed1,a2,a3,a4,a5,a6;
    dbhelper db;
    String s,s1,s3,s4,s5,s2,getid;
    TextView t1,t2,t3,t4,t5,t6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studsearch);
        b=(Button)findViewById(R.id.search);
        ed1=(EditText)findViewById(R.id.subname);
        a2=(EditText)findViewById(R.id.a2);
        a3=(EditText)findViewById(R.id.a3);
        a4=(EditText)findViewById(R.id.a4);
        a5=(EditText)findViewById(R.id.a5);
        a6=(EditText)findViewById(R.id.a6);
        t1=(TextView) findViewById(R.id.t1);
        t2=(TextView) findViewById(R.id.t2);
        t3=(TextView) findViewById(R.id.t3);
        t4=(TextView) findViewById(R.id.t4);
        t5=(TextView) findViewById(R.id.t5);
        t6=(TextView) findViewById(R.id.t6);
        db=new dbhelper(this);
        db.getWritableDatabase();
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        s=ed1.getText().toString();
        Log.d("s",s);
        Cursor cur=db.search(s);
        if (cur.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "no data", Toast.LENGTH_LONG).show();
        }
        else {
            while (cur.moveToNext()) {
                getid = cur.getString(0);
                s1 = cur.getString(1);
                s2 = cur.getString(2);
                s3 = cur.getString(4);
                s4 = cur.getString(5);
                s5 = cur.getString(6);


                t2.setVisibility(View.VISIBLE);
                a2.setVisibility(View.VISIBLE);
                a2.setText(s1);
                t3.setVisibility(View.VISIBLE);
                a3.setVisibility(View.VISIBLE);
                a3.setText(s3);
                t4.setVisibility(View.VISIBLE);
                a4.setVisibility(View.VISIBLE);
                a4.setText(s2);
                t5.setVisibility(View.VISIBLE);
                a5.setVisibility(View.VISIBLE);
                a5.setText(s4);
                t6.setVisibility(View.VISIBLE);
                a6.setVisibility(View.VISIBLE);
                a6.setText(s5);



                Toast.makeText(getApplicationContext(), getid, Toast.LENGTH_LONG).show();
            }}}
});
    }
}

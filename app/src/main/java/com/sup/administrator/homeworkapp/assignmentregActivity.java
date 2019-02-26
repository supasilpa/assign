package com.sup.administrator.homeworkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class assignmentregActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5;
    Button b1,b2;
    Spinner sp;
    String s1,s2,s3,s4,s5,s6;
    dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignmentreg);
        ed1=(EditText)findViewById(R.id.subname);
        ed2=(EditText)findViewById(R.id.duedate);
        ed3=(EditText)findViewById(R.id.tutor);
        ed4=(EditText)findViewById(R.id.topic);
        ed5=(EditText)findViewById(R.id.message);
        sp=(Spinner) findViewById(R.id.dep);
        b1=(Button)findViewById(R.id.submit);
        b2=(Button)findViewById(R.id.srch);
        db=new dbhelper(this);
        db.getWritableDatabase();
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(i);
    }
});
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=sp.getSelectedItem().toString();
                s2=ed1.getText().toString();
                s3=ed2.getText().toString();
                s4=ed3.getText().toString();
                s5=ed4.getText().toString();
                s6=ed5.getText().toString();
                boolean result=db.insertassign(s1,s2,s3,s4,s5,s6);
                if(result== true)
                {
                    Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

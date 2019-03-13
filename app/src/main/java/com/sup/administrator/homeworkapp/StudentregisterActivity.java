package com.sup.administrator.homeworkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class StudentregisterActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button b1;
    Spinner sp;
    String s1,s2,s3,s4,s5,s6,s7;
    dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentregister);
        ed1=(EditText)findViewById(R.id.sname);
        ed2=(EditText)findViewById(R.id.rno);
        ed3=(EditText)findViewById(R.id.email);
        ed4=(EditText)findViewById(R.id.mob);
        ed5=(EditText)findViewById(R.id.username);
        ed6=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.reg);
        sp=(Spinner)findViewById(R.id.dep);
        db=new dbhelper(this);
        db.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1= ed1.getText().toString();
                s2=sp.getSelectedItem().toString();
                s3=ed2.getText().toString();
                s4=ed3.getText().toString();
                s5= ed4.getText().toString();
                s6=ed5.getText().toString();
                s7= ed6.getText().toString();

                Log.d("name",s1);
                Log.d("department",s2);
                Log.d("rollno",s3);
                Log.d("email",s4);
                Log.d("mobileno",s5);

                boolean status=db.insert(s1,s2,s3,s4,s5,s6,s7);
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

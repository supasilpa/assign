package com.sup.administrator.homeworkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class studentloginActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);
        ed1=(EditText)findViewById(R.id.studuname);
        ed2=(EditText)findViewById(R.id.studpass);
        b1=(Button)findViewById(R.id.studlogin);
    }
}

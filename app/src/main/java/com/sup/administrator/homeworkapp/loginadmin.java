package com.sup.administrator.homeworkapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginadmin extends AppCompatActivity {
 Button b,b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginadmin);
        b=(Button)findViewById(R.id.assigreg);
        b1=(Button)findViewById(R.id.sea);
        b2=(Button)findViewById(R.id.alogout);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(i);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),assignmentregActivity.class);
                startActivity(i);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed=getSharedPreferences("login",MODE_PRIVATE).edit();
                ed.clear();
                ed.apply();
                Intent a=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(a);
            }
        });
    }
}

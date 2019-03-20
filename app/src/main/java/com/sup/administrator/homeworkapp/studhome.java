package com.sup.administrator.homeworkapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class studhome extends AppCompatActivity {
 Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studhome);
        b1 = (Button) findViewById(R.id.searchassig);
        b2 = (Button) findViewById(R.id.pedit);
        b3 = (Button) findViewById(R.id.plogout);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), studsearch.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), profileedit.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed=getSharedPreferences("login",MODE_PRIVATE).edit();
                ed.clear();
                ed.apply();
                Intent a=new Intent(getApplicationContext(),studentloginActivity.class);
                startActivity(a);
            }
        });
    }
}

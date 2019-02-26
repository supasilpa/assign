package com.sup.administrator.homeworkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginadmin extends AppCompatActivity {
 Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginadmin);
        b=(Button)findViewById(R.id.assigreg);
        b1=(Button)findViewById(R.id.sea);
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
    }
}

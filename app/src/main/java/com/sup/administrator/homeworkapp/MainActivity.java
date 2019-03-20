package com.sup.administrator.homeworkapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2;
    Button b1,b2,b3;
    String s1,s2,uname="mzc",pass="admin",checkusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences a=getSharedPreferences("login",MODE_PRIVATE);
        checkusername=a.getString("username",null);
        if(checkusername!=null)
        {
            Intent i =new Intent(getApplicationContext(),loginadmin.class);
            startActivity(i);
        }

        ed1=(EditText)findViewById(R.id.uname);
        ed2=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.login);
        b2=(Button)findViewById(R.id.slogin);
        b3=(Button)findViewById(R.id.sreg);
        s1=ed1.getText().toString();
        s2=ed2.getText().toString();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                if(s1.equals(uname) && (s2.equals(pass)))
                {
                    SharedPreferences.Editor ed=getSharedPreferences("login",MODE_PRIVATE).edit();
                    ed.putString("username",s1);
                    ed.putString("password",s2);
                    ed.apply();
//                    ed.commit();
                    Intent a=new Intent(getApplicationContext(),loginadmin.class);
                    startActivity(a);
                    a.putExtra("username",s1);
                    a.putExtra("password",s2);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Incorrect Password or id",Toast.LENGTH_LONG).show();
                }
            }
        });

b3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(getApplicationContext(),StudentregisterActivity.class)  ;
        startActivity(i);
    }
});
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
     Intent i= new Intent(getApplicationContext(),studentloginActivity.class);
        startActivity(i);
    }
});
    }
}

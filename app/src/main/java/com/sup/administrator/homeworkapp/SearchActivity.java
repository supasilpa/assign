package com.sup.administrator.homeworkapp;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
  Button b,b1,b2;
    EditText ed1,a2,a3,a4,a5,a6;
    String u1,u2,u3,u4,u5,u6;
    dbhelper db;
String s,s1,s3,s4,s5,s2,getid;
    TextView t1,t2,t3,t4,t5,t6;
    AlertDialog.Builder build;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        b=(Button)findViewById(R.id.search);
        b1=(Button)findViewById(R.id.update);
        b2=(Button)findViewById(R.id.del);
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

        build=new AlertDialog.Builder(this);
        build.setTitle("Confirm");
        build.setMessage("Are you sure u want to delete? ");
        build.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               boolean status=db.delete(getid);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();

                }
                Toast.makeText(getApplicationContext(),"yes clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();

            }
        });
        build.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"no clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                u2=a2.getText().toString();
                u3=a3.getText().toString();
                u4=a4.getText().toString();
                u5=a5.getText().toString();
                u6=a6.getText().toString();
                boolean status=db.update(getid,u2,u3,u4,u5,u6);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"updated successfully",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error in updation",Toast.LENGTH_LONG).show();

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert=build.create();
                alert.show();
            }
        });
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
                  while (cur.moveToNext())
                  {
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
//                      b.setVisibility(View.VISIBLE);
                      b1.setVisibility(View.VISIBLE);
                      b2.setVisibility(View.VISIBLE);

//                        Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
                  }

              }
          }
      });
    }
}

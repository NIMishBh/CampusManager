package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class StudentSubActivity extends Activity {

    CheckBox cb1,cb2,cb3,cb4,cb5;
    String uname,name,pwd;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sub);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }



        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);
        cb4 = (CheckBox)findViewById(R.id.checkBox4);
        cb5 = (CheckBox)findViewById(R.id.checkBox5);
        b1=(Button)findViewById(R.id.button1);
        name=getIntent().getStringExtra("name");
        uname=getIntent().getStringExtra("uname");
        pwd=getIntent().getStringExtra("pwd");
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                SQLiteDatabase mydatabase=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                if(cb1.isChecked()){
                    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS SUB1(Stdname varchar,Sid VARCHAR,Present VARCHAR);");
                    mydatabase.execSQL("INSERT INTO SUB1 VALUES('"+name+"','"+uname+"','"+0+"');");
                    Toast.makeText(getApplicationContext(), "Subject selected successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(StudentSubActivity.this,Admin.class));
                }
                if(cb2.isChecked()){
                    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS SUB2(Stdname varchar,Sid VARCHAR,Present VARCHAR);");
                    mydatabase.execSQL("INSERT INTO SUB2 VALUES('"+name+"','"+uname+"','"+0+"');");
                    Toast.makeText(getApplicationContext(), "Subject selected successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(StudentSubActivity.this,Admin.class));
                }
                if(cb3.isChecked()){
                    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS SUB3(Stdname varchar,Sid VARCHAR,Present VARCHAR);");
                    mydatabase.execSQL("INSERT INTO SUB3 VALUES('"+name+"','"+uname+"','"+0+"');");
                    Toast.makeText(getApplicationContext(), "Subject selected successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(StudentSubActivity.this,Admin.class));
                }
                if(cb4.isChecked()){
                    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS SUB4(Stdname varchar,Sid VARCHAR,Present VARCHAR);");
                    mydatabase.execSQL("INSERT INTO SUB4 VALUES('"+name+"','"+uname+"','"+0+"');");
                    Toast.makeText(getApplicationContext(), "Subject selected successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(StudentSubActivity.this,Admin.class));
                }
                if(cb5.isChecked()){
                    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS SUB5(Stdname varchar,Sid VARCHAR,Present VARCHAR);");
                    mydatabase.execSQL("INSERT INTO SUB5 VALUES('"+name+"','"+uname+"','"+0+"');");
                    Toast.makeText(getApplicationContext(), "Subject selected successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(StudentSubActivity.this,Admin.class));
                }
            }
        });
    }
}

package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class TeacherRegActivity extends AppCompatActivity {



        EditText e1,e2,e3;
        Button b1,back;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_teacher_reg);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Window w = getWindow();
                w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }

            e1=(EditText)findViewById(R.id.editText3);
            e2=(EditText)findViewById(R.id.editText4);
            e3=(EditText)findViewById(R.id.editText);
            b1=(Button)findViewById(R.id.button);
            back = (Button)findViewById(R.id.button1);
            back.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    startActivity(new Intent(getApplicationContext(),Admin.class));
                    finish();
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    //error below
                    String st1=e2.getText().toString();
                    String st2=e1.getText().toString();
                    String st3=e3.getText().toString();
                    SQLiteDatabase mydatabase=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS RegTeacher(Tid varchar Primary key,Tname varchar,Password varchar);");
                    mydatabase.execSQL("Insert into RegTeacher values('"+st1+"','"+st2+"','"+st3+"');");

                    Intent i=new Intent(TeacherRegActivity.this,TeacherSubActivity.class);
                    i.putExtra("name",e1.getText().toString());
                    i.putExtra("uname",e2.getText().toString());
                    i.putExtra("pwd",e3.getText().toString());
                    startActivity(i);
                }
            });
        }



    }

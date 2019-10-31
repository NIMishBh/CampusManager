package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentRegActivity extends Activity {
    EditText e1,e2,e3;
    Button b1,back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        e3=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        back = (Button)findViewById(R.id.buttonn);
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getApplicationContext(),Admin.class));
                finish();
            }
        });
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String st1=e2.getText().toString();
                String st2=e1.getText().toString();
                String st3=e3.getText().toString();
                SQLiteDatabase mydatabase=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS RegStudent(Sid VARCHAR Primary key,Sname varchar,Password varchar);");
                mydatabase.execSQL("Insert into RegStudent values('"+st1+"','"+st2+"','"+st3+"');");
                //Toast.makeText(getApplicationContext(),"Data inserted", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(StudentRegActivity.this,StudentSubActivity.class);
                i.putExtra("name",st2);
                i.putExtra("uname",st1);
                i.putExtra("pwd",st3);
                startActivity(i);
            }
        });
    }


}

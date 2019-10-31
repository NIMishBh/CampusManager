/*package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class TeacherLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}
*/
package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherLogin extends AppCompatActivity {
    EditText  e1,e2;
    Button b,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String s1,s2;
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                String comp = "SELECT * FROM RegTeacher WHERE Tid ='" + s1 + "' AND Password='" + s2 + "'";
                Cursor c = db.rawQuery(comp, null);
                c.moveToFirst();
                int flag=0;
                while(!c.isAfterLast())
                {
                    if(s1.equals(c.getString(0))&& s2.equals(c.getString(2)))
                    {
                        flag=1;
                        break;

                    }
                    else
                    {
                        c.moveToNext();
                    }

                }
                c.close();
                if(flag==1)
                {
                    Intent i=new Intent(getApplicationContext(),Teacher.class);
                    i.putExtra("tid", s1);
                    i.putExtra("pass", s2);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Login Info, Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });
        back = (Button)findViewById(R.id.button1);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();

            }
        });





        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}

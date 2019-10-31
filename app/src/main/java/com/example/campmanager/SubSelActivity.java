package com.example.campmanager;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SubSelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sel);
    }*/


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class SubSelActivity extends Activity {

    Button daa,maths,dbms,java,py,back;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sel);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        daa=(Button)findViewById(R.id.button1);
        maths=(Button)findViewById(R.id.button2);
        dbms=(Button)findViewById(R.id.button3);
        java=(Button)findViewById(R.id.button4);
        py=(Button)findViewById(R.id.button5);
        back = (Button)findViewById(R.id.button6);
        str=getIntent().getStringExtra("tid");
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getApplicationContext(),Teacher.class));
                finish();
            }
        });
        daa.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                String subno=String.valueOf(1);
                String comp = "SELECT * FROM TeacherSub WHERE Tid ='"+str+"'";
                Cursor c = db.rawQuery(comp, null);
                c.moveToFirst();
                int flag=0;
                while(!c.isAfterLast())
                {
                    //Toast.makeText(getApplicationContext(), c.getString(0)+" "+c.getString(3), 1000).show();
                    if(str.equals(c.getString(0)) && c.getString(3).equals("1"))
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
                    String s="daa";
                    //Toast.makeText(getApplicationContext(), "Yes2", 1000).show();
                    Intent i=new Intent(getApplicationContext(),UpdateAttActivity.class);
                    i.putExtra("sub", s);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sorry You Don't Teach Teach Subject!",Toast.LENGTH_LONG).show();
                }

            }
        });
        maths.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                String comp = "SELECT * FROM TeacherSub WHERE Tid ='"+str+"'";
                Cursor c = db.rawQuery(comp, null);
                c.moveToFirst();
                int flag=0;
                while(!c.isAfterLast())
                {
                    if(str.equals(c.getString(0)) && c.getString(3).equals("2") )
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
                    String s="maths";
                    Intent i=new Intent(getApplicationContext(),UpdateAttActivity.class);
                    i.putExtra("sub", s);
                    startActivity(i);
                    finish();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sorry You Don't Teach Teach Subject!",Toast.LENGTH_LONG).show();
                }

            }
        });
        dbms.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                String comp = "SELECT * FROM TeacherSub WHERE Tid ='"+str+"'";
                Cursor c = db.rawQuery(comp, null);
                c.moveToFirst();
                int flag=0;
                while(!c.isAfterLast())
                {
                    if(str.equals(c.getString(0)) && c.getString(3).equals("3"))
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
                    String s="dbms";
                    Intent i=new Intent(getApplicationContext(),UpdateAttActivity.class);
                    i.putExtra("sub", s);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sorry You Don't Teach Teach Subject!",Toast.LENGTH_LONG).show();
                }

            }
        });
        java.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                String comp = "SELECT * FROM TeacherSub WHERE Tid ='"+str+"'";
                Cursor c = db.rawQuery(comp, null);
                c.moveToFirst();
                int flag=0;
                while(!c.isAfterLast())
                {
                    if(str.equals(c.getString(0)) && c.getString(3).equals("4"))
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
                    String s="java";
                    Intent i=new Intent(getApplicationContext(),UpdateAttActivity.class);
                    i.putExtra("sub", s);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sorry You Don't Teach Teach Subject!",Toast.LENGTH_LONG).show();
                }

            }
        });
        py.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                String comp = "SELECT * FROM TeacherSub WHERE Tid ='"+str+"'";
                Cursor c = db.rawQuery(comp, null);
                c.moveToFirst();
                int flag=0;
                while(!c.isAfterLast())
                {
                    if(str.equals(c.getString(0)) && c.getString(3).equals("5"))
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
                    String s="py";
                    Intent i=new Intent(getApplicationContext(),UpdateAttActivity.class);
                    i.putExtra("sub", s);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sorry You Don't Teach Teach Subject !",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}

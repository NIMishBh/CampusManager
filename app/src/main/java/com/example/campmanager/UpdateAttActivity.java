package com.example.campmanager;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UpdateAttActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_att);
    }*/

import android.app.Activity;
/*
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateAttActivity extends Activity {

    TextView t1,t2;
    Button b1,b2,logout;
    String str,comp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_att);




        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        str=getIntent().getStringExtra("sub");
        logout =(Button)findViewById(R.id.button3);
        //edit = (Button)findViewById(R.id.button4);

        final SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
        final Cursor c;
        if(str.equals("daa"))
        {
            comp = "SELECT * FROM SUB1";
        }
        else if(str.equals("maths"))
        {
            comp = "SELECT * FROM SUB2";
        }
        else if(str.equals("dbms"))
        {
            comp = "SELECT * FROM SUB3";
        }
        else if(str.equals("java"))
        {
            comp = "SELECT * FROM SUB4";
        }
        else if(str.equals("py"))
        {
            comp = "SELECT * FROM SUB5";
        }
        c = db.rawQuery(comp, null);
        c.moveToFirst();
        t1.setText(c.getString(1));
        t2.setText(c.getString(0));
        c.moveToFirst();
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(str.equals("daa"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB1 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB1 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }

                if(str.equals("maths"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB2 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB2 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("dbms"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB3 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB3 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("java"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB4 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB4 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("py"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB5 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB5 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }

            }
        });
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(str.equals("daa"))
                {
                    if(c.isFirst())
                    {
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }

                if(str.equals("maths"))
                {
                    if(c.isFirst())
                    {
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("dbms"))
                {
                    if(c.isFirst())
                    {
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("java"))
                {
                    if(c.isFirst())
                    {
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("py"))
                {
                    if(c.isFirst())
                    {
                        c.moveToNext();
                        t1.setText(c.getString(1));
                        t2.setText(c.getString(0));
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }

            }
        });

        logout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(getApplicationContext(),TeacherLogin.class);
                startActivity(i);
                finish();

            }
        });


    }

}*/

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateAttActivity extends Activity {

    TextView t1,t2;
    Button b1,b2,logout;
    String str,comp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_att);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        str=getIntent().getStringExtra("sub");
        logout =(Button)findViewById(R.id.button3);
        //edit = (Button)findViewById(R.id.button4);

        final SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
        final Cursor c;
        if(str.equals("daa"))
        {
            comp = "SELECT * FROM SUB1";
        }
        else if(str.equals("maths"))
        {
            comp = "SELECT * FROM SUB2";
        }
        else if(str.equals("dbms"))
        {
            comp = "SELECT * FROM SUB3";
        }
        else if(str.equals("java"))
        {
            comp = "SELECT * FROM SUB4";
        }
        else if(str.equals("py"))
        {
            comp = "SELECT * FROM SUB5";
        }
        c = db.rawQuery(comp, null);
        c.moveToFirst();
        t1.setText(c.getString(1));
        t2.setText(c.getString(0));
        c.moveToFirst();
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(str.equals("daa"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB1 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB1 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }

                if(str.equals("maths"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB2 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB2 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("dbms"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB3 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB3 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("java"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB4 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB4 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("py"))
                {
                    if(c.isFirst())
                    {
                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB5 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        int att=Integer.parseInt(c.getString(2));
                        att+=1;
                        String temp=Integer.toString(att);
                        String sid = c.getString(1);
                        db.execSQL("UPDATE SUB5 SET Present='"+temp+"' WHERE Sid='"+sid+"'");
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }

            }
        });
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(str.equals("daa"))
                {
                    if(c.isFirst())
                    {
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }

                if(str.equals("maths"))
                {
                    if(c.isFirst())
                    {
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }				}
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("dbms"))
                {
                    if(c.isFirst())
                    {
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("java"))
                {
                    if(c.isFirst())
                    {
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }
                if(str.equals("py"))
                {
                    if(c.isFirst())
                    {
                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }
                    }
                    else if(!c.isAfterLast())
                    {

                        if(c.isLast())
                        {
                            Toast.makeText(getApplicationContext(), "No more Students!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            c.moveToNext();
                            t1.setText(c.getString(1));
                            t2.setText(c.getString(0));
                        }

                    }

                }

            }
        });

        logout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(getApplicationContext(),TeacherLogin.class);
                startActivity(i);
                finish();
            }
        });


    }


}


package com.example.campmanager;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_final);
    }
}*/

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
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
import android.widget.Toast;

public class EditFinalActivity extends Activity {
    EditText e;
    Button p, a;
    String subno, sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_final);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        p = (Button) findViewById(R.id.button1);
        a = (Button) findViewById(R.id.button2);
        e = (EditText) findViewById(R.id.editText1);
        subno = getIntent().getStringExtra("subno");
        sid = getIntent().getStringExtra("sid");
        p.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String num = e.getText().toString();
                if (subno.equals("1")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB1 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att + Integer.parseInt(num);
                    String temp = Integer.toString(att);
                    db.execSQL("UPDATE SUB1 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                    Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    c.close();
                } else if (subno.equals("2")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB2 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att + Integer.parseInt(num);
                    String temp = Integer.toString(att);
                    db.execSQL("UPDATE SUB2 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                    Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    c.close();
                } else if (subno.equals("3")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB3 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att + Integer.parseInt(num);
                    String temp = Integer.toString(att);
                    db.execSQL("UPDATE SUB3 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                    Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    c.close();
                } else if (subno.equals("4")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB4 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att + Integer.parseInt(num);
                    String temp = Integer.toString(att);
                    db.execSQL("UPDATE SUB4 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                    Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    c.close();
                } else if (subno.equals("5")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB5 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att + Integer.parseInt(num);
                    String temp = Integer.toString(att);
                    db.execSQL("UPDATE SUB5 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                    Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    c.close();
                } else {

                }

            }
        });
        a.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String num = e.getText().toString();
                if (subno.equals("1")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB1 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att - Integer.parseInt(num);
                    if (att < 0)
                        Toast.makeText(getApplicationContext(), "Attendance can't be negative!", Toast.LENGTH_SHORT).show();

                    else {
                        String temp = Integer.toString(att);
                        db.execSQL("UPDATE SUB1 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                        Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    }
                    c.close();
                } else if (subno.equals("2")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB2 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att - Integer.parseInt(num);
                    if (att < 0)
                        Toast.makeText(getApplicationContext(), "Attendance can't be negative!", Toast.LENGTH_SHORT).show();

                    else {
                        String temp = Integer.toString(att);
                        db.execSQL("UPDATE SUB2 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                        Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    }
                    c.close();
                } else if (subno.equals("3")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB3 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att - Integer.parseInt(num);
                    if (att < 0)
                        Toast.makeText(getApplicationContext(), "Attendance can't be negative!", Toast.LENGTH_SHORT).show();

                    else {
                        String temp = Integer.toString(att);
                        db.execSQL("UPDATE SUB3 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                        Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    }
                    c.close();
                } else if (subno.equals("4")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB4 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att - Integer.parseInt(num);
                    if (att < 0)
                        Toast.makeText(getApplicationContext(), "Attendance can't be negative!", Toast.LENGTH_SHORT).show();

                    else {
                        String temp = Integer.toString(att);
                        db.execSQL("UPDATE SUB4 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                        Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    }
                    c.close();
                } else if (subno.equals("5")) {
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat", MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB5 WHERE Sid='" + sid + "'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();

                    int att = Integer.parseInt(c.getString(2));
                    att = att - Integer.parseInt(num);
                    if (att < 0)
                        Toast.makeText(getApplicationContext(), "Attendance can't be negative!", Toast.LENGTH_SHORT).show();

                    else {
                        String temp = Integer.toString(att);
                        db.execSQL("UPDATE SUB5 SET Present='" + temp + "' WHERE Sid='" + sid + "'");
                        Toast.makeText(getApplicationContext(), "Updated " + c.getString(2), Toast.LENGTH_SHORT).show();
                    }
                    c.close();
                } else {

                }

            }
        });
    }
}

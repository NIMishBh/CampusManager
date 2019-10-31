package com.example.campmanager;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_options);
    }*/

//import android.support.v7.app.ActionBarActivity;
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
import android.widget.TextView;
import android.widget.Toast;

public class EditOptionsActivity extends Activity {
    Button show,update,back;
    String sid,subno;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_options);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        show = (Button)findViewById(R.id.button1);
        update = (Button)findViewById(R.id.button2);
        back = (Button)findViewById(R.id.button3);
        t = (TextView)findViewById(R.id.textView1);
        subno = getIntent().getStringExtra("subno");
        sid = getIntent().getStringExtra("sid");
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getApplicationContext(),Teacher.class));
                finish();
            }
        });
        show.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(subno.equals("1")){
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat",MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB1 WHERE Sid='"+sid+"'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();
                    int pres = Integer.parseInt(c.getString(2));
                    int percent = pres*100/40;
                    t.setText("Days Present = "+pres+", Percentage = "+percent+"%");
                    c.close();
                }
                else if(subno.equals("2")){
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat",MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB2 WHERE Sid='"+sid+"'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();
                    int pres = Integer.parseInt(c.getString(2));
                    int percent = pres*100/40;
                    t.setText("Days Present = "+pres+", Percentage = "+percent+"%");
                    c.close();
                }
                else if(subno.equals("3")){
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat",MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB3 WHERE Sid='"+sid+"'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();
                    int pres = Integer.parseInt(c.getString(2));
                    int percent = pres*100/40;
                    t.setText("Days Present = "+pres+", Percentage = "+percent+"%");
                    c.close();
                }
                else if(subno.equals("4")){
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat",MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB4 WHERE Sid='"+sid+"'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();
                    int pres = Integer.parseInt(c.getString(2));
                    int percent = pres*100/40;
                    t.setText("Days Present = "+pres+", Percentage = "+percent+"%");
                    c.close();
                }
                else if(subno.equals("5")){
                    SQLiteDatabase db = openOrCreateDatabase("camp.dat",MODE_PRIVATE, null);
                    String comp = "SELECT * FROM SUB5 WHERE Sid='"+sid+"'";
                    Cursor c = db.rawQuery(comp, null);
                    c.moveToFirst();
                    int pres = Integer.parseInt(c.getString(2));
                    int percent = pres*100/40;
                    t.setText("Days Present = "+pres+", Percentage = "+percent+"%");
                    c.close();
                }

            }
        });
        update.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),EditFinalActivity.class);
                i.putExtra("sid", sid);
                i.putExtra("subno", subno);
                startActivity(i);
                finish();

            }
        });
    }
}

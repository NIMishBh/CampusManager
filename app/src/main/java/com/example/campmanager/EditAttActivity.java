package com.example.campmanager;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditAttActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_att);
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
import android.widget.EditText;
import android.widget.Toast;

public class EditAttActivity extends Activity {
    EditText e1,e2;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_att);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        e1 = (EditText)findViewById(R.id.editText1);
        e2 = (EditText)findViewById(R.id.editText2);
        b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                boolean flag = false;
                String tid = getIntent().getStringExtra("tid");
                String sid = e1.getText().toString();
                String subno = e2.getText().toString();
                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                String comp = "SELECT * FROM TeacherSub WHERE SubNo='"+subno+"'";

                Cursor c = db.rawQuery(comp, null);
                Toast.makeText(getApplicationContext(), "TeacherSub query", Toast.LENGTH_LONG).show();
                c.moveToFirst();
                while(!c.isAfterLast()){
                    if(tid.equals(c.getString(0))){
                        flag = true;
                        break;
                    }
                    c.moveToNext();
                }
                c.close();
                if(flag==true){
                    //	Toast.makeText(getApplicationContext(), sid+" "+subno, 500).show();
                    Intent i = new Intent(getApplicationContext(),EditOptionsActivity.class);
                    i.putExtra("sid", sid);
                    i.putExtra("subno", subno);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "You don't teach this subject!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}


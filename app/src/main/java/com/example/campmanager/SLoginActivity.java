package com.example.campmanager;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slogin);
    }*/

import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
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
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


public class SLoginActivity extends Activity {

    EditText e1,e2;
    Button b,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slogin);
        //e1=(EditText)findViewById(R.id.editText1);
        //e2=(EditText)findViewById(R.id.editText2);
        b=(Button)findViewById(R.id.button1);
        //logout=(Button)findViewById(R.id.button2);
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String s1,s2;
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                String comp = "SELECT * FROM RegStudent WHERE Sid ='"+s1+"' AND Password='"+s2+"'";
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
                    Intent i=new Intent(getApplicationContext(),Student.class);
                    i.putExtra("stid", s1);
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Login Info, Try Again",Toast.LENGTH_LONG).show();
                }
            }
        });

        logout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(SLoginActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

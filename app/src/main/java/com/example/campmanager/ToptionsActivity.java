package com.example.campmanager;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ToptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toptions);
    }*/
//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ToptionsActivity extends Activity {

    Button b1,b2,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toptions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        logout = (Button)findViewById(R.id.button3);
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(getApplicationContext(),SubSelActivity.class);
                String str=getIntent().getStringExtra("tid");
                i.putExtra("tid",str);
                startActivity(i);
                finish();
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
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(getApplicationContext(),EditAttActivity.class);
                String str=getIntent().getStringExtra("tid");
                i.putExtra("tid",str);
                startActivity(i);
                finish();

            }
        });
    }
}

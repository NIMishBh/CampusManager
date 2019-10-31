/*package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Teacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
    }
}*/

package com.example.campmanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Teacher extends AppCompatActivity {
    CardView cv1,cv2,cv3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        cv1=findViewById(R.id.cardView5);
        cv2=findViewById(R.id.cardView6);
        cv3=findViewById(R.id.cardView7);
        b1=findViewById(R.id.button);
        final String s1=getIntent().getStringExtra("tid");

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                AlertDialog.Builder ab=new AlertDialog.Builder(Teacher.this,R.style.MyDialogTheme);
                ab.setMessage("Do You Want To Log Out?");
                ab.setCancelable(false);
                ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Intent i=new Intent(Teacher.this,MainActivity.class);
                        startActivity(i);
                        finish();

                    }
                });
                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });

                AlertDialog a=ab.create();
                a.setTitle("Log Out?");
                a.show();


            }
        });
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),ToptionsActivity.class);
                i.putExtra("tid", s1);
                //i.putExtra("pass", s2);
                startActivity(i);
                finish();
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Teacher.this,ShareActivityChoose.class);
                startActivity(i);
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Teacher.this,QueryActivity.class);
                startActivity(i);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }
}


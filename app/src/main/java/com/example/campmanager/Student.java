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

public class Student extends AppCompatActivity {
    CardView cv1,cv2,cv3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        cv1=findViewById(R.id.cardView5);
        cv2=findViewById(R.id.cardView6);
        cv3=findViewById(R.id.cardView7);
        b1=findViewById(R.id.button);

        final String sid=getIntent().getStringExtra("stid");

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                AlertDialog.Builder ab=new AlertDialog.Builder(Student.this,R.style.MyDialogTheme);
                ab.setMessage("Do You Want To Log Out?");
                ab.setCancelable(false);
                ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Intent i=new Intent(Student.this,MainActivity.class);
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
                Intent i=new Intent(Student.this,AttDispActivity.class);
                i.putExtra("stid",sid);
                startActivity(i);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Student.this,DownloadActivity.class);
                startActivity(i);
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Student.this,QueryActivity.class);
                startActivity(i);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }
}

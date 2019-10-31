package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.CheckBox;

import java.util.ArrayList;

public class TeacherSubActivity extends Activity {
    CheckBox cb1,cb2,cb3,cb4,cb5;
    CheckBox[] cb={cb1,cb2,cb3,cb4,cb5};

    Button b1;

    ArrayList<String> sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sub);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }





        int i;
        int[] idd={R.id.checkBox1,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4,R.id.checkBox5};
        for(i=0;i<5;i++){
            cb[i]=(CheckBox)findViewById(idd[i]);
        }
		cb1=(CheckBox)findViewById(R.id.checkBox1);
		cb2=(CheckBox)findViewById(R.id.checkBox2);
		cb3=(CheckBox)findViewById(R.id.checkBox3);
		cb4=(CheckBox)findViewById(R.id.checkBox4);
		cb5=(CheckBox)findViewById(R.id.checkBox5);


        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int i;
                //String[] sub=new String[]{};
                sub = new ArrayList<String>();
                sub.add("DAA");
                sub.add("Maths");
                sub.add("DBMS");
                sub.add("JAVA");
                sub.add("Python");
                //String[] sub={"DAA","Maths","DBMS","Java","Python"};
                //String name=getIntent().getStringExtra("name");
                String uname=getIntent().getStringExtra("uname");
                String pwd=getIntent().getStringExtra("pwd");
                SQLiteDatabase mydatabase=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                mydatabase.execSQL("Create table IF NOT EXISTS TeacherSub(Tid varchar  references RegTeacher(Tid),Password varchar,SubName varchar,SubNo varchar);");


                // TODO Auto-generated method stub
                for(i=0;i<5;i++){
                    String str=Integer.toString(i+1);
                    if(cb[i].isChecked()){
                        mydatabase.execSQL("Insert into TeacherSub values('"+uname+"','"+pwd+"','"+sub.get(i)+"','"+str+"');");
                    }
                }
                startActivity(new Intent(TeacherSubActivity.this,Admin.class));
                finish();
            }
        });
    }

}

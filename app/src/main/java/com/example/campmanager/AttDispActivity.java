package com.example.campmanager;



/*import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
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

public class AttDispActivity extends Activity {

    TextView t1,t2,t3,t4,t5;
    Button b1,b2;
    int tot=40;
    String s1;
    int pres,percent;
    boolean flag1,flag2,flag3,flag4,flag5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_disp);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        t1=(TextView)findViewById(R.id.textView6);
        t2=(TextView)findViewById(R.id.textView7);
        t3=(TextView)findViewById(R.id.textView8);
        t4=(TextView)findViewById(R.id.textView9);
        t5=(TextView)findViewById(R.id.textView10);
        b2=(Button)findViewById(R.id.button2);
        b1=(Button)findViewById(R.id.button1);
        s1=getIntent().getStringExtra("sid");

        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //Toast.makeText(getApplicationContext(), ""+s1,1000).show();
                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                Cursor cursor = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB1'",null);

                if(cursor!=null){
                    if(cursor.getCount()>0){
                        cursor.close();
                        flag1=true;

                    }
                    cursor.close();
                }
                else{
                    flag1=false;
                }
                if(flag1==true){
                    //Toast.makeText(getApplicationContext(), "Exists", Toast.LENGTH_LONG).show();
                    String a1= "SELECT * FROM SUB1 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    Toast.makeText(getApplicationContext(), "Query executed", Toast.LENGTH_LONG).show();
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t1.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }
                //////
                Cursor cursor2 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB2'",null);

                if(cursor2!=null){
                    if(cursor2.getCount()>0){
                        cursor2.close();
                        flag2=true;

                    }
                    cursor2.close();
                }
                else{
                    flag2=false;
                }
                if(flag2==true){
                    //Toast.makeText(getApplicationContext(), "Exists", Toast.LENGTH_LONG).show();
                    String a1= "SELECT * FROM SUB2 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    //Toast.makeText(getApplicationContext(), "Query executed", Toast.LENGTH_LONG).show();
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t2.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }
                //////
                Cursor cursor3 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB3'",null);

                if(cursor3!=null){
                    if(cursor3.getCount()>0){
                        cursor3.close();
                        flag3=true;

                    }
                    cursor3.close();
                }
                else{
                    flag3=false;
                }
                if(flag3==true){
                    //Toast.makeText(getApplicationContext(), "Exists", Toast.LENGTH_LONG).show();
                    String a1= "SELECT * FROM SUB3 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    //Toast.makeText(getApplicationContext(), "Query executed", Toast.LENGTH_LONG).show();
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t3.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }
                ///////
                Cursor cursor4 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB4'",null);

                if(cursor4!=null){
                    if(cursor4.getCount()>0){
                        cursor4.close();
                        flag4=true;

                    }
                    cursor4.close();
                }
                else{
                    flag4=false;
                }
                if(flag4==true){
                    String a1= "SELECT * FROM SUB4 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t4.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }
                //////
                Cursor cursor5 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB5'",null);

                if(cursor5!=null){
                    if(cursor5.getCount()>0){
                        cursor5.close();
                        flag5=true;

                    }
                    cursor5.close();
                }
                else{
                    flag5=false;
                }
                if(flag5==true){
                    //Toast.makeText(getApplicationContext(), "Exists", Toast.LENGTH_LONG).show();
                    String a1= "SELECT * FROM SUB5 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    //Toast.makeText(getApplicationContext(), "Query executed", Toast.LENGTH_LONG).show();
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t5.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }

            }
        });
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),StudentLogin.class));
                finish();
            }
        });
    }
}
*/



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

public class AttDispActivity extends Activity {

    TextView t1,t2,t3,t4,t5;
    Button b1,show;
    int tot=40;
    String s1;
    int pres,percent;
    boolean flag1,flag2,flag3,flag4,flag5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_disp);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        t1=(TextView)findViewById(R.id.textView6);
        t2=(TextView)findViewById(R.id.textView7);
        t3=(TextView)findViewById(R.id.textView8);
        t4=(TextView)findViewById(R.id.textView9);
        t5=(TextView)findViewById(R.id.textView10);
        show=(Button)findViewById(R.id.button2);
        b1=(Button)findViewById(R.id.button1);
        s1=getIntent().getStringExtra("stid");
        Toast.makeText(getApplicationContext(), ""+s1,Toast.LENGTH_SHORT).show();

        show.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SQLiteDatabase db=openOrCreateDatabase("camp.dat",MODE_PRIVATE,null);
                Cursor cursor1 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB1'",null);
                Toast.makeText(getApplicationContext(), "Daa Running", Toast.LENGTH_SHORT).show();
                if(cursor1!=null){
                    if(cursor1.getCount()>0){
                        cursor1.close();
                        flag1=true;

                    }
                    cursor1.close();
                }
                else{
                    flag1=false;
                }
                if(flag1==true){
                    Toast.makeText(getApplicationContext(), "DAA exists", Toast.LENGTH_SHORT).show();
                    String a1= "SELECT * FROM SUB1 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t1.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();

                }


                Cursor cursor2 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB2'",null);

                if(cursor2!=null){
                    if(cursor2.getCount()>0){
                        cursor2.close();
                        flag2=true;

                    }
                    cursor2.close();
                }
                else{
                    flag2=false;
                }
                if(flag2==true){
                    Toast.makeText(getApplicationContext(), "maths Exists", Toast.LENGTH_LONG).show();
                    String a1= "SELECT * FROM SUB2 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    //Toast.makeText(getApplicationContext(), "Query executed", Toast.LENGTH_LONG).show();
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t2.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }


                Cursor cursor3 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB3'",null);

                if(cursor3!=null){
                    if(cursor3.getCount()>0){
                        cursor3.close();
                        flag3=true;

                    }
                    cursor3.close();
                }
                else{
                    flag3=false;
                }
                if(flag3==true){
                    Toast.makeText(getApplicationContext(), "Exists dbms", Toast.LENGTH_LONG).show();
                    String a1= "SELECT * FROM SUB3 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    //Toast.makeText(getApplicationContext(), "Query executed", Toast.LENGTH_LONG).show();
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t3.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }

                Cursor cursor4 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB4'",null);

                if(cursor4!=null){
                    if(cursor4.getCount()>0){
                        cursor4.close();
                        flag4=true;

                    }
                    cursor4.close();
                }
                else{
                    flag4=false;
                }
                if(flag4==true){
                    Toast.makeText(getApplicationContext(), "Exists java", Toast.LENGTH_LONG).show();
                    String a1= "SELECT * FROM SUB4 WHERE Sid ='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    //Toast.makeText(getApplicationContext(), "Query executed", Toast.LENGTH_LONG).show();
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t4.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }


                Cursor cursor5 = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='SUB5'",null);

                if(cursor5!=null){
                    if(cursor5.getCount()>0){
                        cursor5.close();
                        flag5=true;

                    }
                    cursor5.close();
                }
                else{
                    flag5=false;
                }
                if(flag5==true){
                    //Toast.makeText(getApplicationContext(), "Exists", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Exists python", Toast.LENGTH_LONG).show();
                    String a1= "SELECT * FROM SUB5 WHERE Sid='"+s1+"'";
                    Cursor c1 = db.rawQuery(a1, null);
                    //Toast.makeText(getApplicationContext(), "Query executed", Toast.LENGTH_LONG).show();
                    c1.moveToFirst();
                    pres=Integer.parseInt(c1.getString(2));
                    percent=(pres*100)/tot;
                    t5.setText("Percentage= "+percent+"%, Days present "+c1.getString(2)+" of "+tot);
                    c1.close();
                }

            }
        });
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SLoginActivity.class));
                finish();
            }
        });
    }


}


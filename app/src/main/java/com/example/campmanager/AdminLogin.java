package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

/*import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

}
*/

/*package com.example.banking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
    }
}
*/

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;

public class AdminLogin extends Activity {
    Button bt;
    EditText et1,et2;
//    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        bt=(Button)findViewById(R.id.button1);
        et1=(EditText)findViewById(R.id.editText3);
        et2=(EditText)findViewById(R.id.editText);

        bt.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String uname="admin";
                String pwd="admin";
                Bundle b=getIntent().getExtras();
                if(b==null){
                    if(et1.getText().toString().equals(uname)){
                        if(et2.getText().toString().equals(pwd)){
                            Intent i =new Intent(AdminLogin.this,Admin.class);
                            String pwdd=et2.getText().toString();
                            i.putExtra("previouspwd", pwdd);
                            startActivity(i);
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Wrong Password!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong Username!",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    pwd=b.getString("newpwd");

                    if(et1.getText().toString().equals(uname)){
                        if(et2.getText().toString().equals(pwd)){
                            Intent i =new Intent(AdminLogin.this,Admin.class);
                            String pwdd=et2.getText().toString();
                            i.putExtra("previouspwd", pwdd);
                            startActivity(i);
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Wrong Password!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong Username!",Toast.LENGTH_SHORT).show();
                    }}
            }
        });

    }


}
/*package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
}
*/
package com.example.campmanager;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

public class Admin extends Activity {
    CardView cv1,cv2,cv3;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        b1 = findViewById(R.id.buttonn);
        cv1 = findViewById(R.id.cardView5);
        cv2 = findViewById(R.id.cardView6);
        cv3 = findViewById(R.id.cardView7);
        cv1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                startActivity(new Intent(Admin.this, TeacherRegActivity.class));
            }
        });
        cv2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                startActivity(new Intent(Admin.this, StudentRegActivity.class));
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                AlertDialog.Builder ab = new AlertDialog.Builder(Admin.this, R.style.MyDialogTheme);
                ab.setMessage("Do You Want To Log Out?");
                ab.setCancelable(false);
                ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(Admin.this, MainActivity.class);
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

                AlertDialog a = ab.create();
                a.setTitle("Log Out?");
                a.show();


            }
        });
        cv3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                startActivity(new Intent(Admin.this, ManageActivity.class));
            }
        });

    }
}
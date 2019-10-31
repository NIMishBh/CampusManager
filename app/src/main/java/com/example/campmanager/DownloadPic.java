package com.example.campmanager;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DownloadPic extends AppCompatActivity {



    Button buttonDownload;


    //ImageView
    ImageView image;

    //a Uri object to store file path
    Uri filePath;
    EditText et1;

    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_pic);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        buttonDownload = findViewById(R.id.download);


        image = findViewById(R.id.imageView);
        et1=findViewById(R.id.filename);






        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= et1.getText().toString();

                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageRef = storage.getReferenceFromUrl("gs://androidchatapp-37d05.appspot.com/images").child(name+".jpg");

                try {


                    File storagePath = new File(Environment.getExternalStorageDirectory(), "CampManager");

                    if(!storagePath.exists()) {
                        storagePath.mkdirs();
                    }

                    final File myFile = new File(storagePath,name+".jpg");

                    storageRef.getFile(myFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(myFile.getAbsolutePath());
                            image.setImageBitmap(bitmap);



                            Toast.makeText(getApplicationContext(), "Download successful!\n File Stored at InternalStorage/CampManager/", Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Toast.makeText(getApplicationContext(), "file not found", Toast.LENGTH_SHORT).show();
                            // Handle any errors
                        }
                    });


                } catch (Exception e) {
                }

            }




});}}

package com.example.campmanager;


import android.app.ProgressDialog;
import android.content.Intent;
        import android.graphics.Bitmap;
        import android.net.Uri;
import android.os.Build;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener /*  implementing click listener */ {


    //a constant to track the file chooser intent
    private static final int PICK_IMAGE_REQUEST = 234;
    //private static final int PIC_DOC_REQUEST = 122;

    //Buttons
    private Button buttonChoose;
    private Button buttonUpload;
    private Button buttonDelete;

    //ImageView
    private ImageView imageView;

    //a Uri object to store file path
    private Uri filePath;
    private EditText et1;

    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        //getting views from layout
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        buttonDelete=findViewById(R.id.buttonDelete);

        imageView = (ImageView) findViewById(R.id.imageView);
        et1=findViewById(R.id.filename);

        //attaching listener
        buttonDelete.setOnClickListener(this);
        buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);

    }

    //method to show file chooser
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }



    //handling the image chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //String pic=data.getData().getLastPathSegment().toString();
        //i=data;
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*if(requestCode == PIC_DOC_REQUEST && resultCode== RESULT_OK && data !=null && data.getData()!=null){
            filePath=data.getData();
        }*/
    }



    private void uploadFile() {
        //if there is a file to upload

        if (filePath != null) {
            //displaying a progress dialog while upload is going on
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();


            String pic = et1.getText().toString();


            StorageReference riversRef = storageReference.child("images/"+pic+".jpg");
            //StorageReference docs = storageReference.child("documents/"+pic+".pdf");
            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //if the upload is successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying a success toast
                            Toast.makeText(getApplicationContext(), "File Uploaded ", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            //if the upload is not successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying error message
                            Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            //calculating progress percentage
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

                            //displaying percentage in progress dialog
                            progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                        }
                    });




        }
        //if there is not any file
        else {
            //you can display an error toast
        }
    }


    @Override
    public void onClick(View view) {
        //if the clicked button is choose
        if (view == buttonChoose) {
            showFileChooser();
        }
        //if the clicked button is upload
        else if (view == buttonUpload) {
            if (et1.getText().toString().equals("")) {
                et1.setError("field cannot be empty");
            } else {
                uploadFile();
            }
        }
        else if (view == buttonDelete) {
                if(et1.getText().toString().equals("")){
                    et1.setError("field cannot be empty");
                }
                else {
                    StorageReference photoRef = storageReference.child("images/"+et1.getText().toString()+".jpg");
                    photoRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            // File deleted successfully
                            Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Uh-oh, an error occurred!
                            Toast.makeText(getApplicationContext(),"not Successful",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

        }
    }


}
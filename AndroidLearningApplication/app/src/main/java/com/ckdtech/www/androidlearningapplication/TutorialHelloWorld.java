package com.ckdtech.www.androidlearningapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class TutorialHelloWorld extends AppCompatActivity {

    PDFView book;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity);


        //String pdf = "your_firebase_storage_url.com";
        //webview.loadUrl("https://www.governmentadda.com/wp-content/uploads/2019/03/5.-Time-Work-free-PDF-Downloaded-from-Governmentadda.com_watermark.pdf");

        //webview.loadUrl("https://firebasestorage.googleapis.com/v0/b/android-learning-d78b5.appspot.com/o/Home.pdf?alt=media&token=6ad70fca-ef41-4223-a96c-c01e3a956e7c");

        StorageReference mStorageRef;
        mStorageRef = FirebaseStorage.getInstance().getReference();

        // File : gs://android-learning-d78b5.appspot.com/

        StorageReference riversRef = mStorageRef.child("Home.pdf");

        book = (PDFView) findViewById(R.id.pdfPage1);
        try {
            final File localFile = File.createTempFile("Home", ".pdf");
            riversRef.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            // Successfully downloaded data to local file


                            book.fromFile(localFile).load();
                            Toast.makeText(TutorialHelloWorld.this, "Book Loaded", Toast.LENGTH_SHORT).show();

                            //book.fromAsset("Home.pdf").load();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle failed download
                    // ...
                    Toast.makeText(TutorialHelloWorld.this, "Error showing Tut", Toast.LENGTH_SHORT).show();
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }




    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // do your stuff
        } else {
            //signInAnonymously();
        }
    }

    private void signInAnonymously() {
        mAuth.signInAnonymously().addOnSuccessListener(this, new  OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                // do your stuff
            }
        })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Log.e("TAG", "signInAnonymously:FAILURE", exception);
                    }
                });
    }
}

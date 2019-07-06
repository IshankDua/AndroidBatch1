package com.example.ishank.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ishank.myapplication.R;

/**
 * Created by ishank on 29/04/18.
 */

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try {
            Thread.sleep(5000);

            Intent i= new Intent(MainActivity2.this,MainActivity.class);

            startActivity(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

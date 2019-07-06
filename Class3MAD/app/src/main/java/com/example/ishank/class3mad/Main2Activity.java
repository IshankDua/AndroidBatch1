package com.example.ishank.class3mad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.PublicKey;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button b=(Button)findViewById(R.id.button2);
        setContentView(R.layout.activity_main2);
    }

    public void bac(View v){
        finish();
    }

}

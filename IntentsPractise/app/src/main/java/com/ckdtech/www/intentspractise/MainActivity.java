package com.ckdtech.www.intentspractise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button lahs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lahs = (Button) findViewById(R.id.priyansh);
    }

    public void btnClickAct1(View v){

        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
    }
}

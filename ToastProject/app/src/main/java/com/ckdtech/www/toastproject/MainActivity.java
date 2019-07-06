package com.ckdtech.www.toastproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.idbtn);

    }

    public void btnClick(View v){
        Toast.makeText(this, "This is Toast Button Example", Toast.LENGTH_LONG).show();

    }

}

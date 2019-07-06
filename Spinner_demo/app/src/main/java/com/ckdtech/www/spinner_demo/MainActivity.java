package com.ckdtech.www.spinner_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       spinner = (Spinner) findViewById(R.id.spinner);
       String [] age = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,age);
        spinner.setAdapter(adapter);





    }
}

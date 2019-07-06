package com.example.ishank.class3mad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button b=(Button)findViewById(R.id.button);
        setContentView(R.layout.activity_main);




    }
    public void switc(View v)
    {
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
    }




}

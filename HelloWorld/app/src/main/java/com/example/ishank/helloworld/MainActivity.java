package com.example.ishank.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button b=(Button)findViewById(R.id.button1);
        setContentView(R.layout.activity_main);

    }
    public void generate(View v)
    {
        Toast.makeText(MainActivity.this,"Hello 4CSA",Toast.LENGTH_LONG).show();

    }


}

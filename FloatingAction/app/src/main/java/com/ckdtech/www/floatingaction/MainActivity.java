package com.ckdtech.www.floatingaction;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      fabEmail = (FloatingActionButton) findViewById(R.id.idFabEmail);
      fabEmail.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //Write Your Logic here
              Toast.makeText(getApplicationContext(),"Button Clicked",Toast.LENGTH_LONG).show();
          }
      });
    }
}

package com.ckdtech.www.snackbar;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
                //Write your Logic here

                Snackbar snackbar = Snackbar.make(findViewById(R.id.idLayout),"No Internet Connection",
                        Snackbar.LENGTH_LONG).setAction("Retry", new View.OnClickListener() {
                            @Override
                    public void onClick(View v){
                                //Write your code here
                            }
                });
                snackbar.show();
            }
        });

    }
}
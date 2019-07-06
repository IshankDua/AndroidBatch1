package com.ckdtech.www.androidlearningapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent a = new Intent(SplashActivity.this,MyMenuActivity.class);
                startActivity(a);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
/*Task To be done
Quiz by phone youtube
Interview questions via html assests
Example ask bhai
tutorials make html and link with all other tutorials.


*/
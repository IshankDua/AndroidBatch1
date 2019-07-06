package com.ckdtech.www.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String msg = "Android : ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "The onCreate() event", Toast.LENGTH_SHORT).show();
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "The onStart() event", Toast.LENGTH_SHORT).show();
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "The onResume() event", Toast.LENGTH_SHORT).show();
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "The onPause() event", Toast.LENGTH_SHORT).show();
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "The onStop() event", Toast.LENGTH_SHORT).show();
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "The onDestroy() event", Toast.LENGTH_SHORT).show();
    }
}

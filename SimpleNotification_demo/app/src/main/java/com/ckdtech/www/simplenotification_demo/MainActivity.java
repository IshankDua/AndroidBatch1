package com.ckdtech.www.simplenotification_demo;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     btn = (Button) findViewById(R.id.idBtn);
     btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             ClickMe();
         }
     });


    }


    private void ClickMe(){

        //Build Notification

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Simple Notification");

        //Gets an instance of the notification manager service

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



        // To post notification to the notification bar

        notificationManager.notify(0,mBuilder.build());


    }
}

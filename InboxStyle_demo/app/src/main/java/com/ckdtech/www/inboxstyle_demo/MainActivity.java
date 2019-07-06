package com.ckdtech.www.inboxstyle_demo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     btn = (Button) findViewById(R.id.button);
     btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             ClickMe();
         }
     });


    }

    private void ClickMe(){

        Intent resultIntent = new Intent (this,MainActivity.class);

        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent piResult = PendingIntent.getActivity(this,(int) Calendar.getInstance()
                .getTimeInMillis(),resultIntent,0);
        //Assign inbox style notification
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        inboxStyle.setBigContentTitle("Inbox Notification");
        inboxStyle.addLine("Line 1");
        inboxStyle.addLine("Line 2");
        inboxStyle.addLine("Line 3");
        inboxStyle.addLine("Line 4");
        inboxStyle.addLine("Line 5");
        inboxStyle.setSummaryText("+2more");
        // build notification
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder)new  NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher).setContentTitle("This is inbox style notification")
                .setContentText("This is text of inbox style notification . ").setStyle(inboxStyle)
                .addAction(R.mipmap.ic_launcher,"show activity",piResult);


        //gets an instance of the notification manager service

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


       // to post your notification to the notification bar

        notificationManager.notify(0,mBuilder.build());


    }
}

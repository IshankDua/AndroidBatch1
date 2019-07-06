package com.ckdtech.www.bigtext_demo;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.solver.widgets.ConstraintAnchor;
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
        //to set large icon in notification

         Bitmap icon1 = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

         // Assign Big text Style Notification

         NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
         bigText.bigText("This is automation for you they provide various technologies with the full of experience");
         bigText.setBigContentTitle("Big Text Notification");
         bigText.setSummaryText("Created By Ishank");      //Optional To Write



         // build notification

         NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                 .setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Big text notification")
                 .setContentText("This is test of big text style notification").setLargeIcon(icon1).setStyle(bigText);


         //gets an instance of the notification manager service
         NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);


         // to post your notification

         mNotificationManager.notify(0,mBuilder.build());

     }


}

package com.ckdtech.www.sendsmsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText phoneET,msgET;
    Button sendSMSBtn;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        phoneET = (EditText)findViewById(R.id.editText);
        msgET  = (EditText)findViewById(R.id.editText2);
        sendSMSBtn = (Button)findViewById(R.id.button);

        sendSMSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send SMS Coding
                String phonStr = phoneET.getText().toString();
                String msgStr = msgET.getText().toString();


                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phonStr,null,msgStr,null,null);

                Toast.makeText(MainActivity.this, "SMS Sent", Toast.LENGTH_SHORT).show();

            }
        });


    }
}

package com.ckdtech.www.smssenddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phoneNumberEdt,msgEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         phoneNumberEdt = (EditText) findViewById(R.id.editText);
         msgEdt = (EditText) findViewById(R.id.editText2);

    }

    public  void sendSMSClicked(View v){

        String phoneNumber = phoneNumberEdt.getText().toString();

        String message = msgEdt.getText().toString();


        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber,null,message,null,null);

    }

}

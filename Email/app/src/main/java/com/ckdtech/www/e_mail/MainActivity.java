package com.ckdtech.www.e_mail;

import android.content.Intent;
import android.net.Uri;
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

  btn = (Button) findViewById(R.id.idbtn);

    }
    public void btnClick(View v){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));
        String [] s= {"abc@gmail.com","xyz@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.putExtra(Intent.EXTRA_SUBJECT,"Introduction");
        i.putExtra(Intent.EXTRA_TEXT,"Hi, This is Email body");
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Launch Email");
        startActivity(chooser);




    }





}

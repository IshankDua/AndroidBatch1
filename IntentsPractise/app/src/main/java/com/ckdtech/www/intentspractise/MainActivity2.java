package com.ckdtech.www.intentspractise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btnActivity2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnActivity2 = (Button) findViewById(R.id.idbtnActivity2);

    }

    public void btnClickAct2(View v ){

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }
}

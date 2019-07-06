package com.ckdtech.www.ui_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        editText=(EditText) findViewById(R.id.ideTxt);
        String s = editText.getText().toString();
        Toast.makeText(this, "Input text is"+s, Toast.LENGTH_SHORT).show();


    }
    public void btnClick(View v){
        Toast.makeText(this, "Button Was Clicked", Toast.LENGTH_SHORT).show();
    }

}

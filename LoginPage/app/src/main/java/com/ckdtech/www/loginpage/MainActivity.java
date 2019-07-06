package com.ckdtech.www.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    EditText edit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onDisplay(View v)
    {

        edit1=(EditText)findViewById(R.id.et1);
        String message = edit1.getText().toString();



        Toast.makeText(this, "Username is:-   "+message, Toast.LENGTH_SHORT).show();

        edit2=(EditText)findViewById(R.id.et2);
        String msg = edit2.getText().toString();

        Toast.makeText(this, "Password is:-  "+msg, Toast.LENGTH_SHORT).show();




    }
}

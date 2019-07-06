package com.example.ishank.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName,editTextEmail,editTextPassword;

    private Button buttonSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    editTextName=(EditText) findViewById(R.id.editTextName);
    editTextEmail=(EditText) findViewById(R.id.editTextEmail);
    editTextPassword=(EditText) findViewById(R.id.editTextPassword);

    buttonSubmit=(Button) findViewById(R.id.buttonSubmit);







buttonSubmit.setOnClickListener(this);




    }
@Override
    public void onClick(View view){

     
        if (view==buttonSubmit){

        }
}


}

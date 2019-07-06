package com.ckdtech.www.introduction;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout usernameWrapper;

    TextInputLayout passwordWrapper;
    Button LoginBtn;
    Button SignInBtn;
    TextInputEditText usernameeditText;
    TextInputEditText passwordeditText;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameeditText = (TextInputEditText) findViewById(R.id.username_editText);
        passwordeditText = (TextInputEditText) findViewById(R.id.password_editText);

        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);


        Button Login = (Button) findViewById(R.id.button1);
        Button SignIn = (Button) findViewById(R.id.button2);




    }

   public void  LoginBtnClicked(View v){

       String username = usernameeditText.getText().toString();

       Toast.makeText(this, "Username is..."+username, Toast.LENGTH_SHORT).show();


       String password = passwordeditText.getText().toString();

       Toast.makeText(this, "Password is..."+password, Toast.LENGTH_SHORT).show();

        Intent a = new Intent(LoginActivity.this,WelcomeActivity.class);
        startActivity(a);
   }

   public void  SignInBtnClicked(View v){

        Intent b = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(b);
   }
}
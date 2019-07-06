package com.ckdtech.www.androidlearningapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    EditText userNameEDT,pwdEdt;
    TextView userNameTV,emailTV;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEDT = (EditText)findViewById(R.id.usernameEDT);
        pwdEdt = (EditText) findViewById(R.id.pwdEDT);

        userNameTV = (TextView) findViewById(R.id.nav_header_name);
        emailTV = (TextView) findViewById(R.id.nav_header_email);

    }

    public void loginButton(View v){

        final String userName,pwd;

        userName = userNameEDT.getText().toString();
        pwd = pwdEdt.getText().toString();
        ParseUser.logInInBackground(userName, pwd, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {

                    if(parseUser.getBoolean("emailVerified")) {

                        sharedPref = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME,Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(Constants.SHARED_PREF_USERNAME_KEY,parseUser.getUsername());
                        editor.putString(Constants.SHARED_PREF_EMAIL_KEY,parseUser.getEmail());
                        editor.commit();
                        //Toast.makeText(LoginActivity.this, "Data Saved Succssfully", Toast.LENGTH_SHORT).show();
                        // Save Data In Shared Prefrences
                        //MyMenuActivity.setUserNameEmail(parseUser.getUsername(),parseUser.getEmail());
                        Intent intent = new Intent(LoginActivity.this, InstructionsActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(Constants.userIntent,parseUser.getUsername());
                        intent.putExtra(Constants.email,parseUser.getEmail());
                        startActivity(intent);
                    }
                    else
                    {
                        ParseUser.logOut();
                        alertDisplayer("Login Fail", "Please Verify Your Email first");
                    }

                } else {
                    ParseUser.logOut();
                    alertDisplayer("Login Fail", e.getMessage());
                    //Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void registerLink(View v){
        Intent i = new Intent(LoginActivity.this,SignupAvtivity.class);
        startActivity(i);

    }

    private void alertDisplayer(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        // don't forget to change the line below with the names of your Activities

                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }
}
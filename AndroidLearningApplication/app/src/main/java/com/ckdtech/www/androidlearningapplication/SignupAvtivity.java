package com.ckdtech.www.androidlearningapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupAvtivity extends AppCompatActivity {

    EditText userEdt,pwdEdt,nameEdt;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userEdt = (EditText)findViewById(R.id.editText);
        pwdEdt = (EditText)findViewById(R.id.editText2);
        nameEdt = (EditText)findViewById(R.id.editText4);
    }

    public void registerationbButtonClicked(View v){
        try {
            // Reset errors
            //<Insert User Email Here>.setError(null);
            // <Insert User Password Here>.setError(null);

            // Sign up with Parse
            ParseUser user = new ParseUser();
            user.setUsername(nameEdt.getText().toString());
            user.setPassword(pwdEdt.getText().toString());
            user.setEmail(userEdt.getText().toString());


            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        ParseUser.logOut();
                        alertDisplayer("Account Created Successfully!", "Please verify your email before Login", false);
                    } else {
                        ParseUser.logOut();
                        alertDisplayer("Error Account Creation failed", "Account could not be created" + " :" + e.getMessage(), true);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Email not coming check logcat optimization
    private void alertDisplayer(String title,String message, final boolean error){
        AlertDialog.Builder builder = new AlertDialog.Builder(SignupAvtivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if(!error) {
                            Intent intent = new Intent(SignupAvtivity.this, LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra(Constants.userIntent,nameEdt.getText().toString());
                            intent.putExtra(Constants.email,userEdt.getText().toString());
                            startActivity(intent);

                        }
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }
}
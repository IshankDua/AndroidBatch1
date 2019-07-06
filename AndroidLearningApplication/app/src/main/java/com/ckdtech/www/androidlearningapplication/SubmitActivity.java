package com.ckdtech.www.androidlearningapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

public class SubmitActivity extends AppCompatActivity {

    String name,email;
    TextView correctTV,inCorrectTV,unansweredTV,scoreTV,finalResultTV,greetingTV;

    Button scheduleBtn,exitBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        Intent i = getIntent();
        name = TestActivity.interviewee.getName();
        greetingTV = (TextView)findViewById(R.id.textView);
        correctTV = (TextView)findViewById(R.id.correctTV);
        inCorrectTV = (TextView)findViewById(R.id.inCorrectTV);
        unansweredTV = (TextView)findViewById(R.id.unansweredTV);
        scoreTV = (TextView)findViewById(R.id.finalScoreTV);
        finalResultTV = (TextView)findViewById(R.id.finalStatusTV);
        //correctTV = (TextView)findViewById(R.id.textView);
        scheduleBtn = (Button)findViewById(R.id.button6);
        exitBtn = (Button)findViewById(R.id.button9);
        greetingTV.setText("Hi "+name+" Please find the detailed analysis of your test below:");


        correctTV.setText(""+TestActivity.interviewee.getCorrectAnswers());
        inCorrectTV.setText(""+TestActivity.interviewee.getWrongAnswers());
        unansweredTV.setText(""+TestActivity.interviewee.getLeftBlank());
        scoreTV.setText(""+TestActivity.interviewee.getFinalTestScore());

        if(Constants.CUT_OFF_SCORE <= TestActivity.interviewee.getFinalTestScore()){
            TestActivity.interviewee.setFinalStatus(true);
        }else{
            TestActivity.interviewee.setFinalStatus(false);
        }

        if(TestActivity.interviewee.isFinalStatus()){
            finalResultTV.setText("SELECTED");
            scheduleBtn.setVisibility(Button.VISIBLE);
        }

        if(!TestActivity.interviewee.isFinalStatus()){
            finalResultTV.setText("REJECTED");
            scheduleBtn.setVisibility(Button.VISIBLE);
            exitBtn.setVisibility(Button.VISIBLE);
        }

    }

    @Override
    public void onBackPressed() {

    }

    public void exitApp(View v){
        ParseUser.logOut();
        finish();
        moveTaskToBack(true);

    }

    public void scheduleF2F(View v){

        Intent i = new Intent(SubmitActivity.this,MyMenuActivity.class);
        startActivity(i);

    }
}
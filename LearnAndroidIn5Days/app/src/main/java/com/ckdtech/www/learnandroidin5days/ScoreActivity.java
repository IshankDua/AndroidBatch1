package com.ckdtech.www.learnandroidin5days;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {
String subj;
int finalscore;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_main);

        Intent i = getIntent();
        subj = i.getStringExtra("subject");


        finalscore=i.getIntExtra("score",0);
        Toast.makeText(this, "Your Final Score Is::::--"+finalscore, Toast.LENGTH_SHORT).show();
    }
}

package com.ckdtech.www.learnandroidin5days;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TopicActivity extends AppCompatActivity {



    Button androidBtn,JavaBtn,pythonBtn,cBtn,feedbackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

    }

    public void androidBtnClicked(View v){

        Intent nextPage = new Intent(TopicActivity.this,MenuActivity.class);
        nextPage.putExtra("subject","Android");
        startActivity(nextPage);

    }

    public void javaBtnClicked(View v){

        Intent nextPage = new Intent(TopicActivity.this,MenuActivity.class);
        nextPage.putExtra("subject","Java");
        startActivity(nextPage);

    }

    public void pythonBtnClicked(View v){

        Intent nextPage = new Intent(TopicActivity.this,MenuActivity.class);
        nextPage.putExtra("subject","Python");
        startActivity(nextPage);

    }

    public void cPlusPlusdBtnClicked(View v){

        Intent nextPage = new Intent(TopicActivity.this,MenuActivity.class);
        nextPage.putExtra("subject","cplusplus");
        startActivity(nextPage);

    }

   public void feedbackBtnClicked(View v){

        Intent nextPage = new Intent(TopicActivity.this,FeedbackActivity.class);
        startActivity(nextPage);
   }



}

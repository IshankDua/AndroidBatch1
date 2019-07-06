package com.ckdtech.www.learnandroidin5days;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    String subj = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        Intent i = getIntent();
        subj = i.getStringExtra("subject");

        Toast.makeText(this, "Subject is :"+subj, Toast.LENGTH_SHORT).show();
    }

    public void tutorialButtonClicked(View v){

        Intent k = new Intent(MenuActivity.this,TutorialTopicActivity.class);
        k.putExtra("subject",subj);
        startActivity(k);
    }

    public void quizzesButtonClicked(View v){


        if (subj.equalsIgnoreCase("android")){
            Intent a = new Intent(MenuActivity.this,AndroidQuizActivity.class);
            startActivity(a);
        }

        if (subj.equalsIgnoreCase("java")){
            Intent b =new Intent(MenuActivity.this,JavaQuizActivity.class);
            startActivity(b);
        }

        if (subj.equalsIgnoreCase("Python")){
            Intent c = new Intent(MenuActivity.this,PythonQuizActivity.class);
            startActivity(c);
        }

        if (subj.equalsIgnoreCase("cplusplus")){
            Intent d =  new Intent(MenuActivity.this,CplusplusQuizActivity.class);
            startActivity(d);
        }

    }

    public void exampleslButtonClicked(View v) {

        if (subj.equalsIgnoreCase("android")) {
            Intent a = new Intent(MenuActivity.this, ExampleActivity.class);
            a.putExtra("subject",subj);
            startActivity(a);
        }

        if ((subj.equalsIgnoreCase("java"))) {
            Intent b = new Intent(MenuActivity.this, ExampleActivity.class);
            b.putExtra("subject",subj);
            startActivity(b);
        }

        if (subj.equalsIgnoreCase("Python")) {
            Intent c = new Intent(MenuActivity.this, ExampleActivity.class);
            c.putExtra("subject",subj);
            startActivity(c);
        }

        if (subj.equalsIgnoreCase("cplusplus")) {
            Intent d = new Intent(MenuActivity.this, ExampleActivity.class);
            d.putExtra("subject",subj);
            startActivity(d);
        }
    }



    public void interviewquesButtonClicked(View v){

        Intent n = new Intent(MenuActivity.this,InterviewquesTopicActivity.class);
        n.putExtra("Subj",subj);
        startActivity(n);
    }
}

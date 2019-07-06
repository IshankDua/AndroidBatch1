package com.ckdtech.www.androidlearningapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cv1;
    CardView cv2;
    CardView cv3;
    CardView cv4;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);



        cv1 = (CardView)findViewById(R.id.cardView1);
        cv1.setOnClickListener(this);

        cv2 = (CardView)findViewById(R.id.cardView2);
        cv2.setOnClickListener(this);

        cv3 = (CardView)findViewById(R.id.cardView3);
        cv3.setOnClickListener(this);


        cv4 = (CardView)findViewById(R.id.cardView4);
        cv4.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cardView1){
            Toast.makeText(this, "TutorialButtonClicked", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(MenuActivity.this,TutorialListActivity.class);
            startActivity(a);
        }

        if (v.getId() == R.id.cardView2){
            Toast.makeText(this, "ExampleButtonClicked", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(MenuActivity.this,ExampleActivity.class);
            startActivity(a);
        }

        if (v.getId() == R.id.cardView3){
            Toast.makeText(this, "QuizButtonClicked", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(MenuActivity.this,LoginActivity.class);
            startActivity(a);
        }  if (v.getId() == R.id.cardView4){
            Toast.makeText(this, "InterviewQuesButtonClicked", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(MenuActivity.this,InterviewQuesActivity.class);
            startActivity(a);
        }
    }
}

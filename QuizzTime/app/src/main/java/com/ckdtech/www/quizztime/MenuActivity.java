package com.ckdtech.www.quizztime;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cv1;
    CardView cv2;
    CardView cv3;
    CardView cv4;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);


        cv1=(CardView) findViewById(R.id.cardView1);     //Card View For Beginners
        cv1.setOnClickListener((View.OnClickListener) this);


        cv2=(CardView) findViewById(R.id.cardView2);     //Card View For Moderaters
        cv2.setOnClickListener((View.OnClickListener) this);


        cv3=(CardView) findViewById(R.id.cardView3);     //Card View For Experts
        cv3.setOnClickListener((View.OnClickListener) this);


        cv4=(CardView) findViewById(R.id.cardView1);     //Card View For Exit
        cv4.setOnClickListener((View.OnClickListener) this);


    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cardView1){
            Intent a = new Intent(MenuActivity.this,BeginnerActivity.class);
            startActivity(a);
            Toast.makeText(this, "Beginner's Level Clicked", Toast.LENGTH_LONG).show();
        }


        if (v.getId() == R.id.cardView2){
            Intent a = new Intent(MenuActivity.this,ModerateActivity.class);
            startActivity(a);
            Toast.makeText(this, "Moderate's Level Clicked", Toast.LENGTH_LONG).show();
        }


        if (v.getId() == R.id.cardView3){
            Intent a = new Intent(MenuActivity.this,ExpertActivity.class);
            startActivity(a);
            Toast.makeText(this, "Expert's Level Clicked", Toast.LENGTH_LONG).show();
        }



        if (v.getId() == R.id.cardView4){
            Intent a = new Intent(MenuActivity.this,ExitActivity.class);
            startActivity(a);
            Toast.makeText(this, "Exit Clicked", Toast.LENGTH_LONG).show();
        }





    }
}

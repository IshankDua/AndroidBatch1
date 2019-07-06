package com.example.adua.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cv1;

    CardView cv2;
    CardView cv3;
    CardView cv4;
    RadioButton rb1;
    RadioButton rb2;

    RadioButton rb3;
    RadioButton rb4;

    int correctAnswer = 1;
    TextView questionTextView;
    static int finalQuizScore=0;
    static int counter=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);

        Parse.initialize(this);

        ParseInstallation.getCurrentInstallation().saveInBackground();
        rb1 = findViewById(R.id.radioButton6);
        rb2 = findViewById(R.id.radioButton3);
        rb3 = findViewById(R.id.radioButton4);
        rb4 = findViewById(R.id.radioButton5);
        questionTextView = (TextView)findViewById(R.id.questionTextView);
        rb1.setClickable(false);
        rb2.setClickable(false);
        rb3.setClickable(false);
        rb4.setClickable(false);




        GRadioGroup gr = new GRadioGroup(new RadioButton[] {rb1,rb2,rb3,rb4});

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

        if (counter > 10) {
            Intent i = new Intent(MainActivity.this,ScoreActivity.class);
            startActivity(i);

        } else {

            if (v.getId() == R.id.cardView1) {
                rb1.callOnClick();
                Toast.makeText(MainActivity.this, "Question "+counter+" response saved successfully !", Toast.LENGTH_SHORT).show();
                counter++;
                if (correctAnswer == 1) {
                    // Logic to update the score and show next question
                    finalQuizScore++;
                    questionTextView.setText("Question with Answer 1 is Correct");
                    rb1.setText("Option 11 Correct");
                    rb2.setText("Option 21 Correct");
                    rb3.setText("Option 31 Correct");
                    rb4.setText("Option 41 Correct");

                } else {
                    // Show next question
                    questionTextView.setText("Question with Answer 1 is InCorrect");
                    rb1.setText("Option 11 InCorrect");
                    rb2.setText("Option 21 InCorrect");
                    rb3.setText("Option 31 InCorrect");
                    rb4.setText("Option 41 InCorrect");

                }


            } else if (v.getId() == R.id.cardView2) {


                rb2.callOnClick();
                Toast.makeText(MainActivity.this, "Question "+counter+" response saved successfully !", Toast.LENGTH_SHORT).show();
                counter++;
                if (correctAnswer == 2) {
                    // Logic to update the score and show next question
                    finalQuizScore++;
                    questionTextView.setText("Question with Answer 2 is Correct");
                    rb1.setText("Option 12 Correct");
                    rb2.setText("Option 22 Correct");
                    rb3.setText("Option 32 Correct");
                    rb4.setText("Option 42 Correct");

                } else {
                    // Show next question
                    questionTextView.setText("Question with Answer 2 is InCorrect");
                    rb1.setText("Option 12 InCorrect");
                    rb2.setText("Option 22 InCorrect");
                    rb3.setText("Option 32 InCorrect");
                    rb4.setText("Option 42 InCorrect");

                }


            } else if (v.getId() == R.id.cardView3) {


                rb3.callOnClick();
                Toast.makeText(MainActivity.this, "Question "+counter+" response saved successfully !", Toast.LENGTH_SHORT).show();
                counter++;
                if (correctAnswer == 3) {
                    // Logic to update the score and show next question
                    finalQuizScore++;
                    questionTextView.setText("Question with Answer 3 is Correct");
                    rb1.setText("Option 13 Correct");
                    rb2.setText("Option 23 Correct");
                    rb3.setText("Option 33 Correct");
                    rb4.setText("Option 43 Correct");

                } else {
                    // Show next question
                    questionTextView.setText("Question with Answer 3 is InCorrect");
                    rb1.setText("Option 13 InCorrect");
                    rb2.setText("Option 23 InCorrect");
                    rb3.setText("Option 33 InCorrect");
                    rb4.setText("Option 43 InCorrect");

                }


            } else if (v.getId() == R.id.cardView4) {


                rb4.callOnClick();
                Toast.makeText(MainActivity.this, "Question "+counter+" response saved successfully !", Toast.LENGTH_SHORT).show();
                counter++;
                if (correctAnswer == 4) {
                    // Logic to update the score and show next question
                    finalQuizScore++;
                    questionTextView.setText("Question with Answer 4 is Correct");
                    rb1.setText("Option 14 Correct");
                    rb2.setText("Option 24 Correct");
                    rb3.setText("Option 34 Correct");
                    rb4.setText("Option 44 Correct");

                } else {
                    // Show next question
                    questionTextView.setText("Question with Answer 4 is InCorrect");
                    rb1.setText("Option 14 InCorrect");
                    rb2.setText("Option 24 InCorrect");
                    rb3.setText("Option 34 InCorrect");
                    rb4.setText("Option 44 InCorrect");

                }
            }

        }
    }
}

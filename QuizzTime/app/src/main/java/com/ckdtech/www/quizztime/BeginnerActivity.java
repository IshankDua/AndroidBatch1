package com.ckdtech.www.quizztime;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BeginnerActivity extends AppCompatActivity {

    String [] androidquestions={

            "Ques1  What is Android?",
            "Ques2  What are the layouts available in android?",
            "Ques3  What are the functionalities in asyncTask in android?",
            "Ques4  What is the use of content provider in android?",
            "Ques5  Which features are considered while creating android application?",
            "Ques6  What is a base adapter in android?",
            "Ques7  What is the library of Map View in android?",
            "Ques8  Fragment in Android can be found through",
            "Ques9  What are commands needed to create APK in android?",
            "Ques10 How do you join two notifications in android? "

    };

    String [] optionsA={

            "OptionA Android is a stack of software's for mobility",
            "OptionA Linear Layout",
            "OptionA onPreExecution()",
            "OptionA To send the data from an application to another application",
            "OptionA Screen Size",
            "OptionA Base Adapter is a common class for any adapter, which can we use for both ListView and spinner",
            "OptionA com.map",
            "OptionA findByID()",
            "OptionA No need to write any commands",
            "OptionA Give same id for both notifications",
    };

    String [] optionsB={

            "OptionB  Google mobile device name",
            "OptionB  Frame Layout",
            "OptionB  doInBackground()",
            "OptionB  To store the data in a database",
            "OptionB  Input configuration",
            "OptionB  A kind of adapter",
            "OptionB  com.goggle.gogglemaps",
            "OptionB  findFragmentByID()",
            "OptionB  Create apk_android in command line",
            "OptionB   Write notification code two times",


    };

    String [] optionsC={

            "OptionC  Virtual machine",
            "OptionC  Table Layout",
            "OptionC  onProgressUpdate()",
            "OptionC  To share the data between applications",
            "OptionC  Platform Version",
            "OptionC  Data storage space",
            "OptionC  in.maps",
            "OptionC  getContext.findFragmentByID()",
            "OptionC Javac,dxtool, aapt tool, jarsigner tool, and zipalign",
            "OptionC  A & B",


    };

    String [] optionsD={

            "OptionD None of the above",
            "OptionD  All of above",
            "OptionD  onPostExecution()",
            "OptionD None of the above.",
            "OptionD All of above",
            "OptionD None of the above.",
            "OptionD com.goggle.android.maps",
            "OptionD  FragmentManager.findFragmentByID()",
            "OptionD None of the above",
            "OptionD A & C",

    };
    String [] correctoption={
            "A","D","D","C","D","A","D","D","C","D"
    };
    Button button;

    TextView questionTextView;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;

    int counter = 0;
    int finalScore;
    TextView countTextView;
    String answer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginner_activity);



        rb1 = (RadioButton) findViewById(R.id.radioButton2);
        rb2 = (RadioButton) findViewById(R.id.radioButton);

        rb3 = (RadioButton) findViewById(R.id.radioButton3);

        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        questionTextView = (TextView) findViewById(R.id.textView2);
        button = findViewById(R.id.button8);

        questionTextView.setText(androidquestions[counter]);
        rb1.setText(optionsA[counter]);
        rb2.setText(optionsB[counter]);
        rb3.setText(optionsC[counter]);
        rb4.setText(optionsD[counter]);

        countTextView = (TextView) findViewById(R.id.textView);
        countTextView.setText("You are here : " + (counter + 1) + " of 10");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;   // counter +

                // check kar counter ki value 10 ho gayi to ruk ja
                // final score ko le aur print kara de aur user ko homepage par bhej de

                if (counter > 9) {
                    Intent a = new Intent(BeginnerActivity.this, ScoreActivity.class);
                    a.putExtra("subject", "android");
                    a.putExtra("score", finalScore);
                    startActivity(a);

                }else{
                    // check for option corrected
                    answer = optionSelected();

                    if(answer.equals(correctoption[counter-1])){
                        finalScore++;
                    }else{

                    }

                    questionTextView.setText(androidquestions[counter]);
                    rb1.setText(optionsA[counter]);
                    rb2.setText(optionsB[counter]);
                    rb3.setText(optionsC[counter]);
                    rb4.setText(optionsD[counter]);
                    countTextView.setText("You are here : " + (counter + 1) + " of 10");



                }
                // correct option

            }


        });

    }

    private String optionSelected(){
        if(rb1.isChecked()){
            return "A";
        }else if(rb2.isChecked()){
            return "B";
        }else if(rb3.isChecked()){
            return "C";
        }else if(rb4.isChecked()){
            return "D";
        }else{
            Toast.makeText(this, "Please select a value to continue", Toast.LENGTH_SHORT).show();
            return "error";
        }

    }
}




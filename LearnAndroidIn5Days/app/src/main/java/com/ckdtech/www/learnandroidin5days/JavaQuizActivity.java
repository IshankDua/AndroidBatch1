package com.ckdtech.www.learnandroidin5days;

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

public class JavaQuizActivity extends AppCompatActivity {

    String [] javaquestions={

            "  Can we compare int variable with a boolean variable?",
            "  Can we have two public classes in one java file?",
            "   What is the default value of String variable?",
            "  Which of the following is false about String?",
            "  What is an immutable object?",
            "  What is an applet?",
            "  What is composition?",
            "  What are Wrapper classes?",
            "  Can try statements be nested?",
            " In which case, a program is expected to recover?"

    };

    String [] optionsA={

            " True",
            " True",
            "  \"\"",
            " String is immutable",
            " An immutable object can be changed once it is created",
            " An applet is a Java program that runs in a Web browser",
            " Composition is a data structure",
            " These are classes that allow primitive types to be accessed as objects",
            " True.",
            " If an error occurs",
    };

    String [] optionsB={

            "  False",
            "  False",
            "  ''",
            "  String can be created using new operator",
            "  An immutable object can't be changed once it is created",
            "  Applet is a standalone java program",
            "  Composition is a way to create an object",
            "  These are classes that wraps functionality of an existing class",
            "  False",
            "  If an exception occurs",


    };

    String [] optionsC={

            "   ",
            "   ",
            "   null",
            "  String is a primary data type",
            "  An immutable object is an instance of an abstract class",
            "  Applet is a tool",
            "  Holding the reference of the other class within some other class is known as composition",
            "  Both of the above",
            "  ",
            "  Both of the above",


    };

    String [] optionsD= {

            "  ",
            "   ",
            "  not defined",
            " None of the above.",
            " None of the above",
            " Applet is a run time environment",
            " None of the above",
            "  None of the above",
            "  ",
            " None of the above",
    };

    String [] correctoption={

            "B","B","C","C","B","A","C","A","A","B"
    };

    Button button;

    TextView questionTextView;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;

    int counter = 0;
    int finalscore;
    TextView countTextView;
    String answer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_quiz_main);


        rb1 = (RadioButton) findViewById(R.id.radioButton13);
        rb2 = (RadioButton) findViewById(R.id.radioButton14);
        rb3 = (RadioButton) findViewById(R.id.radioButton15);
        rb4 = (RadioButton) findViewById(R.id.radioButton16);

        questionTextView = (TextView) findViewById(R.id.textView8);
        button = findViewById(R.id.button10);


        questionTextView .setText(javaquestions[counter]);
        rb1.setText(optionsA[counter]);
        rb2.setText(optionsB[counter]);
        rb3.setText(optionsC[counter]);
        rb4.setText(optionsD[counter]);

        countTextView = (TextView) findViewById(R.id.textView7);
        countTextView.setText("You Are here : " + (counter + 1) + " of 10");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;

                if (counter>9){
                    Intent a = new Intent(JavaQuizActivity.this,ScoreActivity.class);
                    a.putExtra("subject","java");
                    a.putExtra("score",finalscore);

                    startActivity(a);
                }
                else {
                    answer = optionSelected();

                    if (answer.equals(correctoption[counter-1])){
                        finalscore++;

                    }else{

                    }

                    questionTextView.setText(javaquestions[counter]);
                    rb1.setText(optionsA[counter]);
                    rb2.setText(optionsB[counter]);
                    rb3.setText(optionsC[counter]);
                    rb4.setText(optionsD[counter]);
                    countTextView.setText("You are here :" + (counter + 1) +  " of 10");






                }
            }
        });

    }



    private String optionSelected() {
        if (rb1.isChecked()) {
            return "A";
        } else if (rb2.isChecked()) {
            return "B";
        } else if (rb3.isChecked()) {
            return "C";
        } else if (rb2.isChecked()) {
            return "D";
        } else {
            Toast.makeText(this, "Please select a value to continue ", Toast.LENGTH_SHORT).show();
            return "error";
        }


    }


}

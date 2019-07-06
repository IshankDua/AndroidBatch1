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

public class PythonQuizActivity extends AppCompatActivity {

    String [] phythonquestions={

            "  Which of the following is correct about Python?",
            "  What is the output of print list[1:3] if list = [ 'abcd', 786 , 2.23, 'john', 70.2 ]?",
            "  Which of the following is correct about tuples in python?",
            "  Which of the following function convert a string to an int in python?",
            "  Which of the following operator in python evaluates to true if the variables on either side of the operator point to the same object and false otherwise?",
            "  Which of the following function sets the integer starting value used in generating random numbers?",
            "  Which of the following function checks in a string that all characters are titlecased?",
            "  Which of the following function returns titlecased version of string?",
            "  What is the output of L[1:] if L = [1,2,3]?",
            " What is the following function sorts a list?"

    };

    String [] optionsA= new String[]{

            " It supports functional and structured programming methods as well as OOP.",
            "  [ 'abcd', 786 , 2.23, 'john', 70.2 ]",
            " A tuple is another sequence data type that is similar to the list.",
            " int(x [,base])",
            " **",
            " choice(seq)",
            " islower()",
            " replace(old, new [, max])",
            " 2,3",
            " list.reverse()",
    };

    String [] optionsB={

            "  It can be used as a scripting language or can be compiled to byte-code for building large applications",
            "  abcd",
            " A tuple consists of a number of values separated by commas",
            "   long(x [,base] )",
            "  //",
            "  randrange ([start,] stop [,step])",
            "  isnumeric()",
            "  strip([chars])",
            "  2",
            "   list.sort([func])",


    };

    String [] optionsC={

            "  It provides very high-level dynamic data types and supports dynamic type checking",
            "  [786, 2.23]",
            "  Unlike lists, however, tuples are enclosed within parentheses",
            "  float(x)",
            "  is",
            "  random()",
            "  isspace()",
            "  swapcase()",
            "  3",
            "  list.pop(obj=list[-1])",


    };

    String [] optionsD={

            " All of the above",
            "  None of the above",
            "  All of the above",
            " str(x).",
            " not in",
            " seed([x])",
            " istitle()",
            "  title()",
            " None of the above",
            " list.remove(obj)",

    };

    String  [] correctoption={
            "D","C", "D","A","C","D","D","D","A","B"
    };

    Button button;

    TextView questionTextView;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;

    int counter=0;
    int finalScore;
    TextView countTextView;
    String answer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phython_quiz_main);


        rb1 = (RadioButton) findViewById(R.id.radioButton9);
        rb2 = (RadioButton) findViewById(R.id.radioButton10);

        rb3 = (RadioButton) findViewById(R.id.radioButton11);

        rb4 = (RadioButton) findViewById(R.id.radioButton12);

        questionTextView = (TextView) findViewById(R.id.textView6);
        button = findViewById(R.id.button12);

        questionTextView.setText(phythonquestions[counter]);
        rb1.setText(optionsA[counter]);
        rb2.setText(optionsB[counter]);
        rb3.setText(optionsC[counter]);
        rb4.setText(optionsD[counter]);

        countTextView = (TextView) findViewById(R.id.textView5);
        countTextView.setText("You are here : " + (counter + 1) + " of 10");




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;

                if (counter > 9) {
                    Intent a = new Intent(PythonQuizActivity.this, ScoreActivity.class);
                    a.putExtra("subject", "phython");
                    a.putExtra("score", finalScore);
                    startActivity(a);

                }else{

                    answer = optionSelected();

                    if(answer.equals(correctoption[counter-1])){
                        finalScore++;
                    }else{

                    }

                    questionTextView.setText(phythonquestions[counter]);
                    rb1.setText(optionsA[counter]);
                    rb2.setText(optionsB[counter]);
                    rb3.setText(optionsC[counter]);
                    rb4.setText(optionsD[counter]);
                    countTextView.setText("You are here : " + (counter + 1) + " of 10");



                }


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

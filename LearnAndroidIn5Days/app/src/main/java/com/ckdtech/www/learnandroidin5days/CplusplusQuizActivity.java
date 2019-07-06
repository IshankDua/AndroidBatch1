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

public class CplusplusQuizActivity extends AppCompatActivity {


    String[] cplusplusquestions = {

            "Ques1   C++ does not supports the following",
            "Ques2   Which operator is required to be overloaded as member function only?",
            "Ques3  We can have varying number of arguments for the overloaded form of () operator",
            "Ques4  What is the output of the following program?\n" +
                    "\n" +
                    "#include<iostream>\n" +
                    "\n" +
                    "using namespace std;\n" +
                    "class Base {\n" +
                    "public:\n" +
                    "   void f() {\n" +
                    "      cout<<\"Base\\n\";\n" +
                    "   }\n" +
                    "};\n" +
                    "\n" +
                    "class Derived:public Base {\n" +
                    "public:\n" +
                    "   void f() {\n" +
                    "      cout<<\"Derived\\n\";\n" +
                    "   }\n" +
                    "};\n" +
                    "main() {\n" +
                    "   Base *p = new Derived(); \n" +
                    "   \n" +
                    "   p->f();\n" +
                    "}",
            "Ques5  Objects created using new operator are stored in __ memory.",
            "Ques6  i) single file can be opened by several streams simultaneously.\n" +
                    "\n" +
                    "ii) several files simultaneously can be opened by a single stream",
            "Ques7   What is the output of the following program?\n" +
                    "\n" +
                    "#include<iostream>\n" +
                    "\n" +
                    "using namespace std;\n" +
                    "main() { \n" +
                    "   const int a = 5;\n" +
                    "   \n" +
                    "   a++; \n" +
                    "   cout<<a; \n" +
                    "}",
            "Ques8  What is the output of the following program?\n" +
                    "\n" +
                    "#include<iostream>\n" +
                    "\n" +
                    "using namespace std;\n" +
                    "main() { \n" +
                    "   int r, x = 2;\n" +
                    "   \n" +
                    "   float y = 5;\n" +
                    "  \n" +
                    "   r = y%x;\n" +
                    "   cout<<r; \n" +
                    "}",
            "Ques9  A single line comment in C++ language source code can begin with _____",
            "Ques10 Does both the loops in the following programs prints the correct string length?\n" +
                    "\n" +
                    "#include<iostream>\n" +
                    "\n" +
                    "using namespace std;\n" +
                    "main() {\n" +
                    "   int i;\n" +
                    "   \n" +
                    "   char s[] = \"hello\";\n" +
                    "\n" +
                    "   for(i=0; s[i]; ++i);\n" +
                    "      cout<<i<<endl;\n" +
                    "\n" +
                    "   i=0; \n" +
                    "   \n" +
                    "   while(s[i++]);\n" +
                    "      cout<<i;\n" +
                    "}"

    };

    String[] optionsA = {

            " Multilevel inheritance",
            " _",
            " True",
            "",
            " Cache",
            " (i) and (ii) are true",
            "  5",
            " 1",
            " ;",
            " Yes, both the loops prints the correct length",
    };

    String[] optionsB = {

            "  Hierarchical inheritance",
            "  _ _",
            " False",
            "  Derived",
            "  Heap",
            "  (i) and (ii) are false",
            "  6",
            "  0()",
            "  :",
            "  Only for loop prints the correct length",


    };

    String[] optionsC = {

            " Hybrid inheritance",
            "  ++ (postfix version)",
            "  ",
            "  Compile error",
            "  Stack",
            "  Only (i) is true",
            "   Runtime error",
            "  2",
            "  /*",
            " Only while loop prints the correct length",


    };

    String[] optionsD = {

            " None of the above",
            "  =",
            "   ",
            " None of the above.",
            " None of the above.",
            "  Only (ii) is true",
            " Compile error",
            " Compile error",
            " //",
            " Compile error in the program",

    };

    String[] correctoption = {
            "D", "D", "A", "A", "B", "C", "D", "D", "D", "B"
    };

    Button button;

    TextView questionTextView;
    RadioGroup rg;
    RadioButton rb1, rb2, rb3, rb4;

    int counter = 0;
    int finalScore;
    TextView countTextView;
    String answer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cplusplus_quiz_main);

        rb1 = (RadioButton) findViewById(R.id.radioButton5);
        rb2 = (RadioButton) findViewById(R.id.radioButton6);
        rb3 = (RadioButton) findViewById(R.id.radioButton7);
        rb4 = (RadioButton) findViewById(R.id.radioButton8);

        questionTextView = (TextView) findViewById(R.id.textView4);
        button = findViewById(R.id.button9);


        questionTextView.setText(cplusplusquestions[counter]);
        rb1.setText(optionsA[counter]);
        rb2.setText(optionsB[counter]);
        rb3.setText(optionsC[counter]);
        rb4.setText(optionsD[counter]);

        countTextView = (TextView) findViewById(R.id.textView3);
        countTextView.setText("You are here :" + (counter + 1) + "of 10");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;

                if (counter > 9) {
                    Intent a = new Intent(CplusplusQuizActivity.this, ScoreActivity.class);
                    a.putExtra("subject", "cplusplus");
                    a.putExtra("score", finalScore);
                    startActivity(a);

                } else {

                    answer = optionSelected();

                    if (answer.equals(correctoption[counter - 1])) {
                        finalScore++;

                    } else {


                    }

                    questionTextView.setText(cplusplusquestions[counter]);
                    rb1.setText(optionsA[counter]);
                    rb2.setText(optionsB[counter]);
                    rb3.setText(optionsC[counter]);
                    rb4.setText(optionsD[counter]);
                    countTextView.setText("You are here : " + (counter + 1) + "of 10");

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
            Toast.makeText(this, "Please select a value to continue", Toast.LENGTH_SHORT).show();
            return "error";
        }

    }
}



















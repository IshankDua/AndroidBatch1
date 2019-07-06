package com.ckdtech.www.androidlearningapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.ckdtech.www.androidlearningapplication.model.Questions;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InstructionsActivity extends AppCompatActivity {


    TextView greetingTV;

    public List<Questions> questionsList = new ArrayList<>();
    static List<Questions> finalQuestionList = new ArrayList<>();
    String name,email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);


        Intent i = getIntent();
        name = i.getStringExtra(Constants.SHARED_PREF_USERNAME_KEY);
        email = i.getStringExtra(Constants.SHARED_PREF_EMAIL_KEY);
        greetingTV = (TextView)findViewById(R.id.textView2);
        greetingTV.setText(greetingTV.getText().toString()+i.getStringExtra(Constants.SHARED_PREF_USERNAME_KEY)+" ,");

    }

    public void startTest(View v){

        Toast.makeText(this, "Please wait while we load the test for you", Toast.LENGTH_SHORT).show();
        readObject();

        Intent i = new Intent(InstructionsActivity.this,TestActivity.class);
        i.putExtra(Constants.email,email);
        i.putExtra(Constants.userIntent,name);
        startActivity(i);

    }
    public void readObject() {


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Questions");
        // The query will search for a ParseObject, given its objectId.
        // When the query finishes running, it will invoke the GetCallback
        // with either the object, or the exception thrown


        // Fetches data synchronously
        try {
            List<ParseObject> results = query.find();
            HashSet<Integer> questionIndex = new HashSet<>();
            int randonmNumber;
            boolean insertFlag;
            Questions q;
            if (results != null) {
                for (ParseObject result : results) {
                    System.out.println("Object found asynchronously " + result.getObjectId());
                    Log.d("Log","Object found asynchronously "+result.getObjectId());
                    q= new Questions(result.get("Questions").toString(),
                            result.get("Option1").toString(),
                            result.get("Option2").toString(),
                            result.get("Option3").toString(),
                            result.get("Option4").toString(),
                            result.get("correct_ans").toString(),
                            result.getObjectId());
                    Log.d("Question Read",q.toString());
                    questionsList.add(q);
                    Log.d("Questions List",Integer.toString(questionsList.size()));
                }

                if(Constants.NO_OF_QUESTIONS > questionsList.size()){
                    Log.d("readObject:IF:ERROR","Test Configuration Error, please contact the administrator");
                    Toast.makeText(this, "There seems an error in the test configuration, please contact administrator", Toast.LENGTH_SHORT).show();

                }else{
                    for(int i =0 ; i<Constants.NO_OF_QUESTIONS ; i++){
                        randonmNumber = generateRandomNumber(0,(questionsList.size()-1));
                        insertFlag =  questionIndex.add(randonmNumber);
                        if(insertFlag){
                            Log.d("readObject:insertFlag","insertFlag :: "+insertFlag);
                            finalQuestionList.add(questionsList.get(randonmNumber));
                        }else{
                            i--;
                        }
                    }


                }


            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private int generateRandomNumber(int min,int max){
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            return randomNum;
    }


}

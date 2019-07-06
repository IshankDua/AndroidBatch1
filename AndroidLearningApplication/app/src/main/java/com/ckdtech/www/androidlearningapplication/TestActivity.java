package com.ckdtech.www.androidlearningapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.ckdtech.www.androidlearningapplication.model.Interviewee;
import com.ckdtech.www.androidlearningapplication.model.Questions;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class TestActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    int questionNumber = 0;
    RadioButton option1RB,option2RB,option3RB,option4RB;
    RadioGroup rg;
    TextView questionTV,timeTV,indexTV,totalQuestionsTV;
    Questions q;
    Button prevBtn,nextBtn,flagBtn,viewFlaggedQuestions,submitTest;
    String name,email;
    static Interviewee interviewee;
    int counter = (Constants.TOTAL_TIME_IN_MILLIS)/1000;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.quiz_main);
        Intent i = getIntent();
        name = i.getStringExtra(Constants.userIntent);
        email = i.getStringExtra(Constants.email);

        indexTV = (TextView)findViewById(R.id.questionNumber);
        timeTV = (TextView)findViewById(R.id.timeRemainingTV);
        questionTV = (TextView)findViewById(R.id.textView5);
        totalQuestionsTV = (TextView)findViewById(R.id.totalQuestions);

        option1RB = (RadioButton) findViewById(R.id.radioButton);
        option2RB = (RadioButton) findViewById(R.id.radioButton2);
        option3RB = (RadioButton) findViewById(R.id.radioButton3);
        option4RB = (RadioButton) findViewById(R.id.radioButton4);

        rg = (RadioGroup) findViewById(R.id.radiogroup);

        prevBtn = (Button)findViewById(R.id.button4);
        nextBtn = (Button)findViewById(R.id.button2);
        flagBtn = (Button)findViewById(R.id.button3);

        viewFlaggedQuestions = (Button)findViewById(R.id.button7);
        submitTest = (Button)findViewById(R.id.button8);

        submitTest.setVisibility(Button.INVISIBLE);
        viewFlaggedQuestions.setVisibility(Button.INVISIBLE);

        indexTV.setText("1");
        totalQuestionsTV.setText(" Of "+Constants.NO_OF_QUESTIONS);
        Log.d("Questions List",Integer.toString(InstructionsActivity.finalQuestionList.size()));

        if(InstructionsActivity.finalQuestionList.size()>0){
            q = InstructionsActivity.finalQuestionList.get(0);

            questionTV.setText(q.getQuestionText());
            option1RB.setText(q.getOption1());
            option2RB.setText(q.getOption2());
            option3RB.setText(q.getOption3());
            option4RB.setText(q.getOption4());


        }else{
            Toast.makeText(this, "Seems you are not connected to internet", Toast.LENGTH_SHORT).show();
        }
        startTimer();
        rg.setOnCheckedChangeListener(this);


    }

    public void nextQuestion(View v){
        Log.i("Next Question :"," "+questionNumber);
        questionNumber++;
        if((questionNumber+1)==Constants.NO_OF_QUESTIONS){
            prevBtn.setEnabled(true);
            nextBtn.setEnabled(false);
            submitTest.setVisibility(Button.VISIBLE);
            viewFlaggedQuestions.setVisibility(Button.VISIBLE);
        }else if(questionNumber == 0){
            prevBtn.setEnabled(false);
            nextBtn.setEnabled(true);
            submitTest.setVisibility(Button.INVISIBLE);
            viewFlaggedQuestions.setVisibility(Button.INVISIBLE);
        }else{
            prevBtn.setEnabled(true);
            nextBtn.setEnabled(true);
            submitTest.setVisibility(Button.INVISIBLE);
            viewFlaggedQuestions.setVisibility(Button.INVISIBLE);
        }
        String text = indexTV.getText().toString();

        if(InstructionsActivity.finalQuestionList.size() > questionNumber){
            Log.i("Next Question If "," with Question Number :"+questionNumber+" Previous Selected Answer is :"+InstructionsActivity.finalQuestionList.get(questionNumber).getSelectedAnswer());

            q = InstructionsActivity.finalQuestionList.get(questionNumber);

            indexTV.setText(Integer.toString(questionNumber+1));
            questionTV.setText(q.getQuestionText());
            option1RB.setText(q.getOption1());
            option2RB.setText(q.getOption2());
            option3RB.setText(q.getOption3());
            option4RB.setText(q.getOption4());
            //questionNumber++;

            rg.clearCheck();
            Log.i("NQ: Switch Start"," "+questionNumber);
            switch (InstructionsActivity.finalQuestionList.get(questionNumber).getSelectedAnswer()){
                case 1:
                    Log.i("NQ: Switch "," case 1 called"+questionNumber);
                    option1RB.setChecked(true);
                    break;
                case 2:
                    Log.i("NQ: Switch "," case 2 called"+questionNumber);
                    option2RB.setChecked(true);
                    break;
                case 3:
                    Log.i("NQ: Switch "," case 3 called"+questionNumber);
                    option3RB.setChecked(true);
                    break;
                case 4:
                    Log.i("NQ: Switch "," case 4 called"+questionNumber);
                    option4RB.setChecked(true);
                    break;

                default:
                    Log.i("NQ: Switch "," default called"+questionNumber);
                    rg.clearCheck();
                    break;
            }
            if(InstructionsActivity.finalQuestionList.get(questionNumber).isFlagQuestion()){
                flagBtn.setText("UNFLAG");
            }else{
                flagBtn.setText("FLAG");
            }

        }else{
            Toast.makeText(this, "Seems you are not disconnected to internet!", Toast.LENGTH_SHORT).show();
        }
    }

    public void prevQuestion(View v){
        Log.i("Prev Question :"," "+questionNumber);
        questionNumber--;
        if(questionNumber == 0){
            prevBtn.setEnabled(false);
            nextBtn.setEnabled(true);
            submitTest.setVisibility(Button.INVISIBLE);
            viewFlaggedQuestions.setVisibility(Button.INVISIBLE);
        }else{
            prevBtn.setEnabled(true);
            nextBtn.setEnabled(true);
            submitTest.setVisibility(Button.INVISIBLE);
            viewFlaggedQuestions.setVisibility(Button.INVISIBLE);
        }

        if(InstructionsActivity.finalQuestionList.size()>questionNumber){
            Log.i("Prev Question :IF:"," "+questionNumber);

            q = InstructionsActivity.finalQuestionList.get(questionNumber);

            indexTV.setText(Integer.toString(questionNumber+1));
            questionTV.setText(q.getQuestionText());
            option1RB.setText(q.getOption1());
            option2RB.setText(q.getOption2());
            option3RB.setText(q.getOption3());
            option4RB.setText(q.getOption4());

            rg.clearCheck();

            Log.i("NQ: Switch Start"," "+questionNumber);

            switch (InstructionsActivity.finalQuestionList.get(questionNumber).getSelectedAnswer()){

                case 1:
                    option1RB.setChecked(true);
                    break;
                case 2:
                    option2RB.setChecked(true);
                    break;
                case 3:
                    option3RB.setChecked(true);
                    break;
                case 4:
                    option4RB.setChecked(true);
                    break;

                default: rg.clearCheck();
                    break;
            }
            if(InstructionsActivity.finalQuestionList.get(questionNumber).isFlagQuestion()){
                flagBtn.setText("UNFLAG");
            }else{
                flagBtn.setText("FLAG");
            }

        }else{
            Toast.makeText(this, "Seems you are not disconnected to internet!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.i("onCheckedChanged"," with QN: "+questionNumber+"checkedId is :"+checkedId);

        switch (checkedId){
            case R.id.radioButton :

                Toast.makeText(this, "Saving answer as 1 for Question "+questionNumber, Toast.LENGTH_SHORT).show();
                InstructionsActivity.finalQuestionList.get(questionNumber).setSelectedAnswer(1);
                break;
            case R.id.radioButton2 :

                Toast.makeText(this, "Saving answer 2 as for Question "+questionNumber, Toast.LENGTH_SHORT).show();
                InstructionsActivity.finalQuestionList.get(questionNumber).setSelectedAnswer(2);
                break;
            case R.id.radioButton3 :
                Toast.makeText(this, "Saving answer 3 as for Question "+questionNumber, Toast.LENGTH_SHORT).show();
                InstructionsActivity.finalQuestionList.get(questionNumber).setSelectedAnswer(3);
                break;
            case R.id.radioButton4 :
                Toast.makeText(this, "Saving answer 4 as for Question "+questionNumber, Toast.LENGTH_SHORT).show();
                InstructionsActivity.finalQuestionList.get(questionNumber).setSelectedAnswer(4);
                break;
            default:
                 Toast.makeText(this, "Nothing to save for "+questionNumber, Toast.LENGTH_SHORT).show();
                InstructionsActivity.finalQuestionList.get(questionNumber).setSelectedAnswer(0);
                break;
        }

    }
    public void flagQuestion(View v){

        if(InstructionsActivity.finalQuestionList.get(questionNumber).isFlagQuestion()){
            InstructionsActivity.finalQuestionList.get(questionNumber).setFlagQuestion(false);
            flagBtn.setText("FLAG");
        }else{
            InstructionsActivity.finalQuestionList.get(questionNumber).setFlagQuestion(true);
            flagBtn.setText("UNFLAG");
            Toast.makeText(this, "Question has been flagged for you to review it later", Toast.LENGTH_SHORT).show();
        }

    }

    public void submitTest(View v){
        submitTestAndSaveDate();
        countDownTimer.cancel();
    }

    public void viewFlagged(View v){
        for(int i =0;i<Constants.NO_OF_QUESTIONS;i++){
            if(InstructionsActivity.finalQuestionList.get(i).isFlagQuestion()){
                questionNumber = i;


            }

        }

    }

    private void submitTestAndSaveDate(){
        int finalScore=0,correct=0,inCorrect=0,unanswered=0;
        Questions q;
        for(int i =0;i<Constants.NO_OF_QUESTIONS;i++){
            q = InstructionsActivity.finalQuestionList.get(i);

            if(q.getSelectedAnswer() == 0 || q.getSelectedAnswer() == -1){
                unanswered++;
            }else if(q.getSelectedAnswer() == Integer.parseInt(q.getCorrectAns())){
                correct++;
            }else{
                inCorrect++;
            }
        }

        finalScore = correct*2;

        interviewee = new Interviewee(name,email,finalScore,correct,inCorrect,unanswered);

        /*ParseObject entity = new ParseObject("Interviewee");

        entity.put("Name", interviewee.getName());
        entity.put("Email", interviewee.getEmailID());
        entity.put("PhoneNumber", interviewee.getPhoneNumber());
        entity.put("finalTestScore", Integer.toString(interviewee.getFinalTestScore()));
        entity.put("correctAnswers", Integer.toString(interviewee.getCorrectAnswers()));
        entity.put("wrongAnswers", Integer.toString(interviewee.getWrongAnswers()));
        entity.put("leftBlank", Integer.toString(interviewee.getLeftBlank()));
        entity.put("finalStatus", interviewee.isFinalStatus());

     //   Saves the new object.
        //Notice that the SaveCallback is totally optional!
       entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                // Here you can handle errors, if thrown. Otherwise, "e" should be null
                if(e == null){
                    Log.d("saveInBackground","Data Saved");
                }else{
                    Log.e("saveInBackground",e.getMessage());
                }
            }
        });

        Utility.sendEmail(interviewee.getEmailID(),"Result for Test || "+interviewee.getName(),createEmailTestScoreBody(interviewee));*/
        Intent i = new Intent(TestActivity.this,SubmitActivity.class);
        // Intent Add put Extra......
        startActivity(i);
    }


    private String createEmailTestScoreBody(Interviewee interviewee){
        String emailBodyString = "Hello {{USER}},\n" +
                "\n" +
                "Thanks for taking out time and attempting the assessment with NTT Data Global Delivery.\n" +
                "\n" +
                "You have registered with the id {{EMAIL}}.\n" +
                "\n" +
                "Your Score Card is as below:\n" +
                "\n" +
                "Correct Answers           {{CORRECT}}\n" +
                "Wrong Answers             {{WRONG}}\n" +
                "Left Blank                {{BLANK}}\n" +
                "Final Score               {{FINAL}}\n" +
                "\n" +
                "Your final Status is : {{STATUS}}\n" +
                "\n" +
                "We wish you all the best for your future.\n" +
                "\n" +
                "Thanks,\n" +
                "NTT Data Test Team";

        emailBodyString = emailBodyString.replace("{{USER}}",interviewee.getName());
        emailBodyString = emailBodyString.replace("{{EMAIL}}",interviewee.getEmailID());
        emailBodyString = emailBodyString.replace("{{CORRECT}}",Integer.toString(interviewee.getCorrectAnswers()));
        emailBodyString = emailBodyString.replace("{{WRONG}}",Integer.toString(interviewee.getWrongAnswers()));
        emailBodyString = emailBodyString.replace("{{FINAL}}",Integer.toString(interviewee.getFinalTestScore()));
        if(interviewee.isFinalStatus()){
            emailBodyString = emailBodyString.replace("{{STATUS}}","SELECTED");
        }else{
            emailBodyString = emailBodyString.replace("{{STATUS}}","REJECTED");
        }

        return emailBodyString;

    }
    /*private String createEmailSubject(){

    }*/

    private void startTimer(){


        countDownTimer = new CountDownTimer(Constants.TOTAL_TIME_IN_MILLIS,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeTV.setText(String.valueOf(counter));
                if(counter<5){
                    Toast.makeText(TestActivity.this, "Test will end in "+counter+" seconds", Toast.LENGTH_SHORT).show();
                    timeTV.setTextColor(Color.RED);

                }else {
                    timeTV.setTextColor(Color.BLACK);
                }
                counter--;
            }

            @Override
            public void onFinish() {
                Toast.makeText(TestActivity.this, "Test will end!!", Toast.LENGTH_SHORT).show();
                submitTestAndSaveDate();
            }
        }.start();
    }

}


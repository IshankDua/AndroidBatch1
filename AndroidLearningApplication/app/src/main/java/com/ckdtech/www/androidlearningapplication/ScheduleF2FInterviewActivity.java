package com.ckdtech.www.androidlearningapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ckdtech.www.androidlearningapplication.model.F2FInterview;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ScheduleF2FInterviewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView nameTV,emailTV;
    EditText phoneET;
    Spinner dateSpinner,timeSpinner;
    ArrayAdapter<String> dateAdapter,timeAdapter;
    ArrayList<String> dateAvailableList = new ArrayList<>();
    List<F2FInterview> allInterviewList = new ArrayList<>();
    ArrayList<String> timeAvailableList = new ArrayList<>();
    String dateSelected,timeSelected;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_f2f_interview);

        dateSpinner = (Spinner)findViewById(R.id.dateSpinner);
        timeSpinner = (Spinner)findViewById(R.id.timeSpinner);

        nameTV = (TextView)findViewById(R.id.textView12);
        emailTV = (TextView)findViewById(R.id.textView15);

        phoneET = (EditText) findViewById(R.id.editText3);

        nameTV.setText(TestActivity.interviewee.getName());
        emailTV.setText(TestActivity.interviewee.getEmailID());

        dateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Date Spinner","Date Spinner");
                dateSelected = dateAvailableList.get(position);
                readObjectForTime(allInterviewList.get(position).getObjectID());

                timeSpinner.setVisibility(Spinner.VISIBLE);
                dateSpinner.setEnabled(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Time Spinner","Time Spinner");
                Log.d("View",view.getId()+" ");
                timeSelected = timeAvailableList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        readObject();
    }

    public void readObject() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("F2FSchedule");
        List<ParseObject> results = null;
        F2FInterview f2f;

        try {
            results = query.find();
            if (results != null) {

                for (ParseObject result : results) {
                    System.out.println("Object found asynchronously " + result.getObjectId());
                    Log.d("Log","Object found asynchronously "+result.getObjectId());
                    f2f = new F2FInterview(result.get("DateAvailable").toString(),
                            result.get("JobId").toString(),
                            result.get("PanelName").toString(),
                            result.get("PanelEmailAddress").toString(),
                            result.getObjectId());
                    Log.d("Question Read",f2f.toString());
                    allInterviewList.add(f2f);
                }
                if(allInterviewList.size()>0){
                    for(int i =0;i<allInterviewList.size();i++){
                        if(allInterviewList.get(i).getJobID().equalsIgnoreCase(Constants.JOB_ID)){
                            dateAvailableList.add(allInterviewList.get(i).getDateAvailable());
                        }else{
                            dateAvailableList.remove(i);
                        }

                    }

                    dateAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,dateAvailableList);
                    dateSpinner.setAdapter(dateAdapter);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        Log.d("Item Selected",allInterviewList.get(position).toString());
        switch (view.getId()){
            case R.id.dateSpinner:


                break;

            case R.id.timeSpinner:

                break;



            default:                 Log.d("In Default","In default");
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void readObjectForTime(String ObjectID) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("F2FSchedule");

        // The query will search for a ParseObject, given its objectId.
        // When the query finishes running, it will invoke the GetCallback
        // with either the object, or the exception thrown
        query.getInBackground(ObjectID, new GetCallback<ParseObject>() {
            public void done(ParseObject result, ParseException e) {
                if (e == null) {
                    System.out.println(result);
                    JSONArray jsonArr = result.getJSONArray("TimeAvailable");


                    for (int j = 0; j < jsonArr.length(); j++) {
                        try {
                            timeAvailableList.add((String)jsonArr.get(j));
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }

                    }
                    timeAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,timeAvailableList);
                    timeSpinner.setAdapter(timeAdapter);
                    Log.d("timeAvailableList",timeAvailableList.get(0)+" "+timeAvailableList.size());
                } else {
                    // something went wrong
                    Log.d("Error JSONArray",e.getMessage());
                }
            }
        });
    }

    public void confirmButton(View v){

        String emailBody="Dear {{USER}},\n" +
                "\n" +
                "Your interview is scheduled on {{DATE}} at {{TIME}} with the Panel.Please be available if in case you don’t appear you shall not be allowed to appear in any of the drives/walkin conducted by NTT Data in India.\n" +
                "\n" +
                "Thanks,\n" +
                "Test Team";

        emailBody = emailBody.replace("{{USER}}",TestActivity.interviewee.getName());
        if(dateSelected != null){
            emailBody = emailBody.replace("{{DATE}}",dateSelected);
        }else{
            //emailBody = emailBody.replace("{{DATE}",dateSelected);
        }

        if(timeSelected != null){
            emailBody = emailBody.replace("{{TIME}}",timeSelected);
        }else{
            //emailBody = emailBody.replace("{{DATE}",dateSelected);
        }
        //emailBody.replace("{{DATE}",dateSelected);
        //emailBody.replace("{{TIME}}",timeSelected);
        Utility.sendEmail(TestActivity.interviewee.getEmailID(),"Interview Booking Confirmation ||"+ TestActivity.interviewee.getName() +"|| NTT Data Global Data Services Pvt Ltd",emailBody);
        Toast.makeText(this, "We have emailed you the details,please be available !", Toast.LENGTH_SHORT).show();
        ParseUser.logOut();
    }
}
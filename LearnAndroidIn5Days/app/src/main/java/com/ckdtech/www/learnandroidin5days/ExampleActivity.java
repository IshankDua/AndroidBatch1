package com.ckdtech.www.learnandroidin5days;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExampleActivity extends AppCompatActivity {


    String subject = "";
    ListView lv;
    ArrayAdapter<String> subjectArrayAdapter;

    String[] androidExampleList = {

            "A", "B", "C",
    };

    String[] javaExampleList = {
            "A", "B", "C",
    };

    String[] pythonExampleList = {

            "A", "B", "C",
    };

    String[] cplusplusExampleList = {
            "A", "B", "C",
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);

        Intent i = getIntent();
        String subject = i.getStringExtra("subject");

        lv = (ListView) findViewById(R.id.exampleListView);

        createAdapterForListView(subject);
        lv.setAdapter(subjectArrayAdapter);


    }

    private void createAdapterForListView(String subject) {

        if (subject.equalsIgnoreCase("android")) {
            subjectArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, androidExampleList);

        } else if (subject.equalsIgnoreCase("java")) {
            subjectArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, javaExampleList);


        } else if (subject.equalsIgnoreCase("python")) {
            subjectArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, pythonExampleList);


        } else if (subject.equalsIgnoreCase("cplusplus")) {
            subjectArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, cplusplusExampleList);
        }


    }
}



























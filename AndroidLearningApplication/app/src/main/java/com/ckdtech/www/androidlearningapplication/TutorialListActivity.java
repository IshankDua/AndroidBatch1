package com.ckdtech.www.androidlearningapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TutorialListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView tutorialListView;

    String [] androidTopicList={

            "Android - Home",
            "Android - Overview",
            "Android - Environment Setup",
            "Android - Architecture",
            "Android - Application Components",
            "Android - Hello World Example",
            "Android - Resources",
            "Android - Activities",
            "Android - Services",
            "Android - Broadcast Receivers",
            "Android - Content Providers",
            "Android - Fragments",
            "Android - Intents/Filters",
            "Android - User Interface",
            "Android - UI Layouts",
            "Android - UI Controls",
            "Android - Event Handling",
            "Android - Styles and Themes",
            "Android - Custom Components",
            "Android-Advanced Concepts",
            "Android - Drag and Drop",
            "Android - Notifications",
            "Location Based Services",
            "Android - Sending Email",
            "Android - Sending SMS",
            "Android - Phone Calls",
            "Publishing Android Application"


    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_list_activity);

        tutorialListView = (ListView)findViewById(R.id.tutorialList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,androidTopicList);

        tutorialListView.setAdapter(adapter);
        tutorialListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i = new Intent(TutorialListActivity.this,TutorialActivity.class);
        i.putExtra("tutorial_name",androidTopicList[position]);
        startActivity(i);

    }
}


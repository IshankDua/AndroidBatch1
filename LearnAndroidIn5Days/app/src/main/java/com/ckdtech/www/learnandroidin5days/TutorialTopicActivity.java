package com.ckdtech.www.learnandroidin5days;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TutorialTopicActivity extends AppCompatActivity {


    String subject = "";
    ListView lv;
    ArrayAdapter<String> subjectArrayAdapter;
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
            "Publishing Android Application",


    };
    String [] javaTopicList={

            "Java - Home",
            "Java - Overview",
            "Java - Environment Setup",
            "Java - Basic Syntax",
            "Java - Object & Classes",
            "Java - Basic Datatypes",
            "Java - Variable Types",
            "Java - Modifier Types",
            "Java - Basic Operators",
            "Java - Loop Control",
            "Java - Decision Making",
            "Java - Numbers",
            "Java - Characters",
            "Java - Strings",
            "Java - Arrays",
            "Java - Date & Time",
            "Java - Regular Expressions",
            "Java - Methods",
            "Java - Files and I/O",
            "Java - Exceptions",
            "Java - Inner classes",
            "Java Object Oriented",
            "Java - Inheritance",
            "Java - Overriding",
            "Java - Polymorphism",
            "Java - Abstraction",
            "Java - Encapsulation",
            "Java - Interfaces",
            "Java - Packages",
            "Java Advanced",
            "Java - Data Structures",
            "Java - Collections",
            "Java - Generics",
            "Java - Serialization",
            "Java - Networking",
            "Java - Sending Email",
            "Java - Multithreading",
            "Java - Applet Basics",
            "Java - Documentation"

    };
    String [] pythonTopicList={

            "Python - Home",
            "Python - Overview",
            "Python - Environment Setup",
            "Python - Basic Syntax",
            "Python - Variable Types",
            "Python - Basic Operators",
            "Python - Decision Making",
            "Python - Loops",
            "Python - Numbers",
            "Python - Strings",
            "Python - Lists",
            "Python - Tuples",
            "Python - Dictionary",
            "Python - Date & Time",
            "Python - Functions",
            "Python - Modules",
            "Python - Files I/O",
            "Python - Exceptions",
            "Python Advanced Tutorial",
            "Python - Classes/Objects",
            "Python - Reg Expressions",
            "Python - CGI Programming",
            "Python - Database Access",
            "Python - Networking",
            "Python - Sending Email",
            "Python - Multithreading",
            "Python - XML Processing",
            "Python - GUI Programming",
            "Python - Further Extensions"

    };
    String [] cplusplusTopicList={


            "C++ Home",
            "C++ Overview",
            "C++ Environment Setup",
            "C++ Basic Syntax",
            "C++ Comments",
            "C++ Data Types",
            "C++ Variable Types",
            "C++ Variable Scope",
            "C++ Constants/Literals",
            "C++ Modifier Types",
            "C++ Storage Classes",
            "C++ Operators",
            "C++ Loop Types",
            "C++ Decision Making",
            "C++ Functions",
            "C++ Numbers",
            "C++ Arrays",
            "C++ Strings",
            "C++ Pointers",
            "C++ References",
            "C++ Date & Time",
            "C++ Basic Input/Output",
            "C++ Data Structures",
            "C++ Object Oriented",
            "C++ Classes & Objects",
            "C++ Inheritance",
            "C++ Overloading",
            "C++ Polymorphism",
            "C++ Abstraction",
            "C++ Encapsulation",
            "C++ Interfaces",
            "C++ Advanced",
            "C++ Files and Streams",
            "C++ Exception Handling",
            "C++ Dynamic Memory",
            "C++ Namespaces",
            "C++ Templates",
            "C++ Preprocessor",
            "C++ Signal Handling",
            "C++ Multithreading",
            "C++ Web Programming"

    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_topic_main);

        Intent i = getIntent();
        String subject = i.getStringExtra("subject");

        lv = (ListView)findViewById(R.id.topicListView);

        createAdapterForListView(subject);
        lv.setAdapter(subjectArrayAdapter);
    }

    private void createAdapterForListView(String subject){

        if(subject.equalsIgnoreCase("android")){
            subjectArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,androidTopicList);
        }else if(subject.equalsIgnoreCase("java")){
            subjectArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,javaTopicList);
        }else if(subject.equalsIgnoreCase("python")){
            subjectArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,pythonTopicList);
        }else if(subject.equalsIgnoreCase("cplusplus")){
            subjectArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,cplusplusTopicList);
        }

    }




}

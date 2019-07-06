package com.ckdtech.www.androidlearningapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

public class MyMenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    CardView cv1;
    CardView cv2;
    CardView cv3;
    CardView cv4;
    TextView userNameTV,emailTV;
    SharedPreferences sharedPref;
    NavigationView navigationView;
    String userName,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_menu);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        userNameTV = (TextView) headerView.findViewById(R.id.nav_header_name);
        emailTV = (TextView) headerView.findViewById(R.id.nav_header_email);

        sharedPref = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME,Context.MODE_PRIVATE);
        if(sharedPref.getString(Constants.SHARED_PREF_USERNAME_KEY,"").equals("")){


        }else{
            Constants.USER_LOGGED_IN = true;
            userName = sharedPref.getString(Constants.SHARED_PREF_USERNAME_KEY,"");
            email = sharedPref.getString(Constants.SHARED_PREF_EMAIL_KEY,"");
            userNameTV.setText(userName);
            emailTV.setText(email);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cv1 = (CardView)findViewById(R.id.cardView1);
        cv1.setOnClickListener(this);

        cv2 = (CardView)findViewById(R.id.cardView2);
        cv2.setOnClickListener(this);

        cv3 = (CardView)findViewById(R.id.cardView3);
        cv3.setOnClickListener(this);


        cv4 = (CardView)findViewById(R.id.cardView4);
        cv4.setOnClickListener(this);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tutorials) {
            // Handle the tutorials Activity

            Intent a = new Intent(MyMenuActivity.this,TutorialListActivity.class);
            startActivity(a);
        } else if (id == R.id.nav_examples) {
            // Handle the examples Activity

            Intent a = new Intent(MyMenuActivity.this,ExampleActivity.class);
            startActivity(a);

        } else if (id == R.id.nav_quiz) {
            // Handle the Quiz Activity

            Intent a = new Intent(MyMenuActivity.this,LoginActivity.class);
            startActivity(a);

        } else if (id == R.id.nav_interview) {
            // Handle the Interview Activity

            Intent a = new Intent(MyMenuActivity.this,InterviewQuesActivity.class);
            startActivity(a);

        } else if (id == R.id.nav_feedback) {
            //Handle the feedback Activity

            Intent a = new Intent(MyMenuActivity.this,FeedbackActivity.class);
            startActivity(a);
        } else if (id == R.id.nav_login) {



        } else if (id == R.id.nav_logout) {
            sharedPref.edit().clear().commit();
            ParseUser.logOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.cardView1){
            Toast.makeText(this, "TutorialButtonClicked", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(MyMenuActivity.this,TutorialListActivity.class);
            startActivity(a);
        }

        if (v.getId() == R.id.cardView2){
            Toast.makeText(this, "ExampleButtonClicked", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(MyMenuActivity.this,AppYoutubeActivity.class);
            startActivity(a);
        }

        if (v.getId() == R.id.cardView3){
            // Check if user exists :: Data is present in shared Pref....
            //if(dataPresent){
            // Instruction Activity : User Logged in
            // }else{
            //  Take user to login Activity
            // }
            if(Constants.USER_LOGGED_IN){
                Toast.makeText(this, "QuizButtonClicked", Toast.LENGTH_SHORT).show();

                Intent a = new Intent(MyMenuActivity.this,InstructionsActivity.class);
                a.putExtra(Constants.SHARED_PREF_USERNAME_KEY,userName);
                a.putExtra(Constants.SHARED_PREF_EMAIL_KEY,email);
                startActivity(a);
            }else{
                Toast.makeText(this, "QuizButtonClicked", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(MyMenuActivity.this,LoginActivity.class);
                startActivity(a);
            }

        }  if (v.getId() == R.id.cardView4){
            Toast.makeText(this, "InterviewQuesButtonClicked", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(MyMenuActivity.this,InterviewQuesActivity.class);
            startActivity(a);
        }
    }


}

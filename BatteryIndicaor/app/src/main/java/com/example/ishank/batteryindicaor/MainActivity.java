package com.example.ishank.batteryindicaor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public class BatteryIndicatorActivity extends Activity {

        //Create Broadcast Receiver Object along with class definition

        private MainActivity mBatInfoReceiver = new BroadcastReceiver() {

            @Override

        //When Event is published, onReceive method is called

            public void onReceive(Context c, Intent i) {

                //Get Battery %

                int level = i.getIntExtra("level", 0);

                //Find the progressbar creating in main.xml

                ProgressBar pb = (ProgressBar) findViewById(R.id.progressbar);

                //Set progress level with battery % value

                pb.setProgress(level);

                //Find textview control created in main.xml

                TextView tv = (TextView) findViewById(R.id.textfield);

                //Set TextView with text

                tv.setText("Battery Level: " + Integer.toString(level) + "%");

            }



        };


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package com.ckdtech.www.widget_demo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calender;
    private TextView textView;
    int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        calender = Calendar.getInstance();

        year = calender.get(Calendar.YEAR);
        month = calender.get(Calendar.MONTH);
        day = calender.get(Calendar.DAY_OF_MONTH);

    }

    public void showDateDailog (View v){
        showDialog(101);
        Toast.makeText(this,"Date Dialog Created",Toast.LENGTH_SHORT).show();

    }
      @Override
    protected Dialog onCreateDialog(int id) {
          if (id == 100) {
              return new DatePickerDialog(this, myDateListener, year, month, day);
          }

          if (id == 101){
              return new TimePickerDialog(this,null,12,12,false);

          }
      return null;
    }


    private DatePickerDialog.OnDateSetListener myDateListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            textView.setText(i2+"/"+(i1+1)+"/"+i);

        }


    };


}
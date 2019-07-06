package com.ckdtech.www.optionmenu_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText numTxt;
    String sNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exampe,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item1:
                Toast.makeText(this, "Item 1 is selected", Toast.LENGTH_SHORT).show();
                 return true;


            case R.id.item2:
                Toast.makeText(this, "Item 2 is selected", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.item3:
                Toast.makeText(this, "Item 3 is selected", Toast.LENGTH_SHORT).show();
                 return true;


                 default:
                     return super.onOptionsItemSelected(item);





        }





    }
}

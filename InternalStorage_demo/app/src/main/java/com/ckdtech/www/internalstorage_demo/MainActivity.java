package com.ckdtech.www.internalstorage_demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String FileName = "myFile";
    Button BtnSave,BtnRead;
    EditText editName;
    TextView readName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnSave = (Button) findViewById(R.id.idBtnSave);
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile();
            }
        });

        BtnRead = (Button) findViewById(R.id.idBtnRead);
        BtnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });

        editName = (EditText) findViewById(R.id.idName);
        readName =(TextView) findViewById(R.id.idReadtxt);

    }


      private void readFile() {


          try {
              FileInputStream fin = openFileInput(FileName);
              InputStreamReader inputStream = new InputStreamReader(fin);
              BufferedReader bufferedReader = new BufferedReader(inputStream);
              StringBuilder stringBuilder = new StringBuilder();
              String line = null;
              while((line=bufferedReader.readLine())!=null){
                  stringBuilder.append(line);
              }
              fin.close();
              inputStream.close();
              readName.setText("Name:"+stringBuilder.toString());
              Toast.makeText(this, "Data Retrived", Toast.LENGTH_SHORT).show();


          }catch (java.io.IOException e){
              e.printStackTrace();
          }
      }





        private void saveFile(){

        try{
            FileOutputStream fos = openFileOutput(FileName, Context.MODE_PRIVATE);
            name = editName.getText().toString();
            fos.write(name.getBytes());
            fos.close();
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        } catch (java.io.IOException e){
            e.printStackTrace();
        }




    }





















}

package com.ckdtech.www.uicontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText eText;
    ImageButton imgButton;
    TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtview = (TextView) findViewById(R.id.textview);

        eText = (EditText) findViewById(R.id.edittext);
        btn = (Button) findViewById(R.id.button);
        imgButton = (ImageButton) findViewById(R.id.imageButton);



    }
}
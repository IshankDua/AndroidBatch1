package com.example.ishank.optionmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Call = (Button) findViewById(R.id.button);

        final EditText editText = (EditText) findViewById(R.id.editText);

        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Phone = editText.getText().toString();
                Intent i = new Intent (Intent.ACTION_CALL, Uri.parse("tel:"+Phone));
                startActivity(i);


            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);






    }

}

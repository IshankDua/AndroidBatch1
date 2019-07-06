package com.ckdtech.www.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      listview = (ListView) findViewById(R.id.idlistView);
      String[] planets = {"Mercury","Venus","Earth","Jupitor","Mars","Saturn"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planets);
        listview.setAdapter(adapter);
         registerForContextMenu(listview);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0,v.getId(),0,"Delete");
        menu.add(0,v.getId(),0,"UpperCase");
        menu.add(0,v.getId(),0,"LowerCase");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle() =="Delete"){
            Toast.makeText(this, "Delete was Pressed", Toast.LENGTH_SHORT).show();
        }


        if(item.getTitle() =="UpperCase"){
            Toast.makeText(this, "Uppercase was Pressed", Toast.LENGTH_SHORT).show();
        }


        if(item.getTitle() =="LowerCase"){
            Toast.makeText(this, "LowerCase was Pressed", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}

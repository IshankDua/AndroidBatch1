package com.ckdtech.www.bluetooth_chat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class FrontActivity extends AppCompatActivity {
    private BluetoothManager bltManager;
    private Context context;
    private BluetoothAdapter bltAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        context = this;
        bltAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bltAdapter.isEnabled())
        {
            // check if the bluetooth is enabled
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            context.startActivity(enableBluetooth);
        }
        MyDeviceData.adress = bltAdapter.getAddress();
        MyDeviceData.name = bltAdapter.getName();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.front, menu);
        return true;
    }

    public void clientClick(View v)
    {
        Intent clt = new Intent(FrontActivity.this, ClientActivity.class);
        startActivity(clt);
    }

    public void serverClick(View v)
    {
        Intent srv = new Intent(FrontActivity.this, ServerActivity.class);
        startActivity(srv);
    }

}
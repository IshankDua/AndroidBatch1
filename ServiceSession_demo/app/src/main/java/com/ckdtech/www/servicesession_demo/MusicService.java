package com.ckdtech.www.servicesession_demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RadioButton;

public class MusicService extends Service {

    MediaPlayer mp;


    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(getApplicationContext(), R.raw.song);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        mp.start();

        mp.setLooping(true);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mp.stop();
        super.onDestroy();
    }
}
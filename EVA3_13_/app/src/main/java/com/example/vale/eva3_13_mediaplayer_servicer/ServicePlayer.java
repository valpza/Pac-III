package com.example.vale.eva3_13_mediaplayer_servicer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicePlayer extends Service{
    MediaPlayer mpReproductor = null;
    public ServicePlayer(){
        mpReproductor = MediaPlayer.create(this,R.raw.spaceunicornatbyparryrintong);
    }
    public void onCreate(){
        super.onCreate();
        mpReproductor= MediaPlayer.create(getApplicationContext(), R.raw.spaceunicornatbyparryrintong);
    }
    public void onStart (Intent intent, int stardId){
        super.onStart(intent,stardId);
        if(mpReproductor !=null){
            mpReproductor.start();
        }
    }
    public void onDestroy(){
        super.onDestroy();
        if (mpReproductor != null){
            mpReproductor.stop();
            mpReproductor.release();
        }
    }
    public IBinder onBind (Intent intent){

        throw new UnsupportedOperationException("no se ");
    }

}

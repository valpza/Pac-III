package com.example.vale.eva3_12_media_player;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {
    MediaPlayer mpReproductor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        mpReproductor = MediaPlayer.create(this, R.raw.spaceunicornatbyparryrintong);
    }
    public void onResume() {
        super.onResume();
        if (mpReproductor != null) {
            mpReproductor.start();
        }
    }

    public void onStop() {
        super.onStop();
        if (mpReproductor != null) {
            mpReproductor.stop();
            mpReproductor.start();
        }
    }

}

 /*  ESTA MAL NO SE QUE HICE
  public void onStart (Intent intent, int stardId){
        super.onStart();
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
}*/

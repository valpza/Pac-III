package com.example.vale.eva3_4_banner;

import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    ImageView imgVBanner;
    int iCont = 1;
    Handler hManejador = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //recibir un mensaje
            //cambar la iamagen
            switch (iCont) {
                case 1:
                    imgVBanner.setImageResource(R.drawable.rainy);
                    iCont++;
                    break;
                case 2:
                    imgVBanner.setImageResource(R.drawable.cloudy);
                    iCont++;
                    break;
                case 3:
                    imgVBanner.setImageResource(R.drawable.sunny);
                    iCont++;
                    break;
                case 4:
                    imgVBanner.setImageResource(R.drawable.light_rain);
                    iCont = 1;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgVBanner = findViewById(R.id.imgVBanner);
        Banner  ñe = new Banner();
        ñe.start();

    }

    class Banner extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    Message mmg = hManejador.obtainMessage();
                    hManejador.sendMessage(mmg);
                    //txtVwDatos.setText(i + "");
                    Thread.sleep(1000);//trabajo pesado
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}

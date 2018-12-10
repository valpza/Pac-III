package com.example.vale.eva3_2_hilos;

import android.util.Log;

public class MiHilo extends Thread {
    public void run() {
        super.run();
        while(true){
            try{
                Log.wtf("HILO","HOLA");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

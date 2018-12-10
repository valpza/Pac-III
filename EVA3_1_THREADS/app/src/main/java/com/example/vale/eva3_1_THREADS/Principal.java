package com.example.vale.eva3_1_THREADS;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {
    Runnable rMiHiloRun = new Runnable() { //clase anonima y es l act que se ejecutara en segundo plano
        @Override
        public void run() {
            for (int i = 0; i<20; i++){
                Log.wtf("RUNNABLE", i+"");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //runnables (interfaz) y thead (clase)
        Thread tHlo = new Thread(rMiHiloRun);
        tHlo.start(); //el hilo afuerzas tiene que terminar su ejecucion
        MiHilo tMiHilo = new MiHilo();
//        mPerpetuo.start();
        tMiHilo.start();
//        mhPerpetuo.run();//trabaja la app
        //mhPerpuetuo.start();//genera trabajo en segundo plano
    }
    class MiHilo extends Thread {//es unaa clase de mi runable

        @Override
        public void run() {
            super.run();
            for (int i = 0; i<20; i++){
                Log.wtf("THREAD", i+"");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    };
}

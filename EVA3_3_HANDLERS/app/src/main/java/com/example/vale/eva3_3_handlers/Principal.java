package com.example.vale.eva3_3_handlers;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwDatos;
    Thread tHilo;

    Handler hManejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                int i = (int)msg.obj;
                txtVwDatos.append(i+"-");
            }
        }
    };// pertenece al hilo de la clase principal


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwDatos= findViewById(R.id.txtVwDatos);
        MiHilo mhHilo = new MiHilo();
        tHilo = new Thread(mhHilo);
        tHilo.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tHilo.interrupt();
    }

    class MiHilo implements Runnable{
        @Override
        public void run() {
            int i =0;
            while (true){
                i++;
                try{
                    Message mmg = hManejador.obtainMessage(1,i);
                    hManejador.sendMessage(mmg);
                    Log.wtf("Hilo", i +"");
                    //txtVwDatos.setText(i + "");
                    Thread.sleep(1000);//trabajo pesado
                }catch (InterruptedException e){
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}

package com.example.vale.eva3_6_handler_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwDatos;
    Handler hManejador =  new Handler();
    Runnable rHeavyMetal  = new Runnable() {
        @Override
        public void run() {//proceso que ara el hilo
            hManejador.post(rPop);
            while (true){
                hManejador.post(rPop);//el metodo post envia runnables
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                e.printStackTrace();
                }
            }
        }
    };
    int iNum=1;
    Runnable rPop = new Runnable() {// se le enviara un runnable para que se ejecute
        @Override
        public void run() {
            //aqui interactua la interfaz
            txtVwDatos.append((iNum++) + "");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Thread tHilo = new Thread(rHeavyMetal);
        tHilo.start();
        txtVwDatos = findViewById(R.id.txtVwDatos);
    }
}

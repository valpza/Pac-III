package com.example.vale.eva3_2_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView lblHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblHello = findViewById(R.id.lblHello);

        Runnable rHilo = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        lblHello.setText("Holi");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        Thread tRunnable = new Thread(rHilo);
        //tRunnable.start();
        MiHilo mhPerpetuo = new MiHilo();
        mhPerpetuo.start();
    }
}

package com.example.vale.eva3_11_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    Intent inServicio;
    BroadcastReceiver miBroadCast;
    TextView lblEtiqueta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblEtiqueta = findViewById(R.id.lblEtiqueta);
        inServicio = new Intent(this,Miservicio.class);
        miBroadCast = new MiBroadCast();
        IntentFilter ifFiltrarServicios = new IntentFilter("MI_SERVICIO");
        registerReceiver(miBroadCast,ifFiltrarServicios);


    }

    public void inicio(View v) {
        startService(inServicio);

    }

    public void detener(View v) {

        stopService(inServicio);
    }

    class MiBroadCast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //AQUI VAMOS A LEER EL MENSAJE
            String datos = intent.getStringExtra("MENSAJE");
            lblEtiqueta.append(datos);
        }
    }
}

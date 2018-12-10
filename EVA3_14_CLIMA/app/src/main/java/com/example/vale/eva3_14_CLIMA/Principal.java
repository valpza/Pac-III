package com.example.vale.eva3_14_CLIMA;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Principal extends AppCompatActivity {
    TextView txtVDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVDatos = findViewById(R.id.txtVDatos);

    }
    public void onClick (View v){
      new Conexion().execute();

    }

    class Conexion extends AsyncTask <Void,Void,String>{
        final String sLink ="http://api.openweathermap.org/data/2.5/group?id=524901,703448,2643743&units=metric";


        @Override
        protected String doInBackground(Void... voids) {//metodo para trabajar en segundo plano
            String sResu ="";
            try{
                URL url= new URL (sLink);//donde esta la direccion de nuetros datos a descargaar
                HttpURLConnection httpCon = (HttpURLConnection)
                        url.openConnection();
                if(httpCon.getResponseCode()==HttpURLConnection.HTTP_OK){
                    //es como leer un archivo de tex
                    BufferedReader brDatos= new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return sResu;
        }
        protected void onPostExcute (String s){
            super.onPostExecute(s);
            //lectura de los dato
            JSONArray jCiudades = null;
            if(!s.equals("")){//equals es un metodo para comparar
                try{
                    //creamos objeto de texto recibido
                    JSONObject jsDatos = new JSONObject(s);
                    jCiudades =jsDatos.getJSONArray("list");
                    for(int i =0; i<jCiudades.length();i++){
                        JSONObject jCiudad = jCiudades.getJSONObject(i);
                        txtVDatos .append("Ciudad" + jCiudad.getString("name"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}


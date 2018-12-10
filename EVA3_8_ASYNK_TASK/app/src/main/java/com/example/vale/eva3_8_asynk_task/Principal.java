package com.example.vale.eva3_8_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwDatos;
    int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        MiClaseAsincrona maTareaAsin = new MiClaseAsincrona();//declarar un objeto en mi clase
        maTareaAsin.execute("Hola","Mundo"); // aqui van los parametros de entrada es equivalente a .start
    }
    class MiClaseAsincrona extends AsyncTask<String, Integer, Void>{
        String sCade;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwDatos.setText( "iniciamos la tarea asincrona");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);// es lo que pasa para que termine
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values); //manda a llamar a metodo doInBa...
            txtVwDatos.append(i+"");

        }

        @Override
        protected Void doInBackground(String... strings) {
            sCade = strings[0] + " " + strings[1];
            while (true){
                try{
                    Thread.sleep(1000);
                    publishProgress(i++);//para comunicar

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }


        }
    }
}

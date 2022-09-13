package com.jogom.myappaniobisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.Year;
import java.util.Calendar;

public class DatosCalendario extends AppCompatActivity {

    private TextView textViewDato,textViewM,textViewS,textViewD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_calendario);
        textViewDato = findViewById(R.id.txtDato);
        textViewM = findViewById(R.id.txtMeses);
        textViewS = findViewById(R.id.txtSemanas);
        textViewD = findViewById(R.id.txtDias);
        this.obtenerDatos();
    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String an =bundle.getString("dat");
            int anio = Integer.parseInt(an);
            if((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
                textViewDato.setText(String.valueOf(anio)+" ES AÑO BISIESTO");
            }
            else{
                textViewDato.setText(String.valueOf(anio)+"  NO ES AÑO BISIESTO");
            }
        }
    }
}
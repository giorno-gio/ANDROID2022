package com.jogom.myappmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MACelebraciones extends AppCompatActivity {


    TextView textViewNombreMes, textViewcelebracion, textViewDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macelebraciones);

        textViewNombreMes = findViewById(R.id.txtNombreMes);
        textViewcelebracion = findViewById(R.id.txtNombreCeleb);
        textViewDesc = findViewById(R.id.txtDescrCeleb);

        this.obtenerDatos();
    }


    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String nomMes = bundle.getString("nomMes");
        String celebracion = bundle.getString("celebracion");
        int descripcion = bundle.getInt("descripcion");

        textViewNombreMes.setText(String.valueOf(nomMes));
        textViewcelebracion.setText(String.valueOf(celebracion));
        textViewDesc.setText(descripcion);
    }



}
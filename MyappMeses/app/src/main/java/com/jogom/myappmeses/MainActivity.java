package com.jogom.myappmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listMeses);

        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, meses());
        AdapterPersonalizado adapterPersonalizado = new AdapterPersonalizado(this, R.layout.listapersonalizada,
         numeroMes(), meses(),celebracionesMes(),descripcionCelebracionMes());
        listView.setAdapter(adapterPersonalizado);
    }


    private ArrayList<Integer> numeroMes(){
        ArrayList<Integer>  numeroMes = new ArrayList<>();
        for(int i = 1; i<=12; i++){
            numeroMes.add(i);
        }
        return numeroMes;
    }

    private ArrayList<String> meses(){
        ArrayList<String> meses = new ArrayList<>();
        meses.add("enero");
        meses.add("febrero");
        meses.add("marzo");
        meses.add("abril");
        meses.add("mayo");
        meses.add("junio");
        meses.add("julio");
        meses.add("agosto");
        meses.add("septiembre");
        meses.add("octubre");
        meses.add("noviembre");
        meses.add("diciembre");
        return meses;
    }

    private ArrayList<String> celebracionesMes(){
        ArrayList<String> celebracionesMes = new ArrayList<>();
        celebracionesMes.add("Año Nuevo");
        celebracionesMes.add("Huelga de Dolores");
        celebracionesMes.add("Semana Santa");
        celebracionesMes.add("Semana Santa");
        celebracionesMes.add("Santa Cruz");
        celebracionesMes.add("Baile de los Gigantes");
        celebracionesMes.add(" Fiesta Nacional Indígena Rabin Ajaw");
        celebracionesMes.add("Festival Folklórico Nacional El Paab’anc");
        celebracionesMes.add(" Día de la Independencia ");
        celebracionesMes.add("San Francisco de Asís");
        celebracionesMes.add("Todos los Santos");
        celebracionesMes.add(" Quema del Diablo");
        return celebracionesMes;
    }

    private ArrayList<Integer> descripcionCelebracionMes(){
        ArrayList<Integer> descripcionCelebracionMes = new ArrayList<>();
        descripcionCelebracionMes.add(R.string.mes1);
        descripcionCelebracionMes.add(R.string.mes2);
        descripcionCelebracionMes.add(R.string.mes3);
        descripcionCelebracionMes.add(R.string.mes4);
        descripcionCelebracionMes.add(R.string.mes5);
        descripcionCelebracionMes.add(R.string.mes6);
        descripcionCelebracionMes.add(R.string.mes7);
        descripcionCelebracionMes.add(R.string.mes8);
        descripcionCelebracionMes.add(R.string.mes9);
        descripcionCelebracionMes.add(R.string.mes10);
        descripcionCelebracionMes.add(R.string.mes11);
        descripcionCelebracionMes.add(R.string.mes12);
        return descripcionCelebracionMes;
    }
}
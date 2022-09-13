package com.jogom.myappgridviewautos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private GridView gridViewMarcas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewMarcas = findViewById(R.id.gridMarcas);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, marcas());
        gridViewMarcas.setAdapter(arrayAdapter);

        gridViewMarcas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Pulsaste "+marcas().get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private ArrayList<String> marcas(){
        ArrayList<String> marcas = new ArrayList<>();
        marcas.add("MAZDA");
        marcas.add("TOYOTA");
        marcas.add("MERCEDES BENZ");
        marcas.add("FERRARI");
        marcas.add("BMW");
        marcas.add("HIUNDAY");
        marcas.add("CHEVROLET");
        marcas.add("LEXUS");
        marcas.add("MASERATI");
        marcas.add("BUGATTI");
        return marcas;
    }
}
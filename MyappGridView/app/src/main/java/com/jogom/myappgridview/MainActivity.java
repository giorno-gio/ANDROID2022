package com.jogom.myappgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private GridView gridViewAni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewAni = findViewById(R.id.gridAnimales);

        ArrayAdapter arrayAdapter =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, animales());
        gridViewAni.setAdapter(arrayAdapter);

        gridViewAni.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "A pulsado "+animales().get(i),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private ArrayList<String> animales() {
        ArrayList<String> animales = new ArrayList<>();
        animales.add("PERRO");
        animales.add("GATO");
        animales.add("HAMSTER");
        animales.add("LORO");
        animales.add("TORTUGA");
        animales.add("PERICO");

        return animales;
    }
}
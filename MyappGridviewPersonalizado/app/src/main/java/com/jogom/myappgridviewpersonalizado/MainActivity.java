package com.jogom.myappgridviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridColores);
        AdapterGrid adapterGrid = new AdapterGrid(this, R.layout.grid_personalizado,
                colores(),nombresColores());
        gridView.setAdapter(adapterGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                traslado(i);
            }
        });
    }

    private ArrayList<Integer> colores(){
        ArrayList<Integer> colores = new ArrayList<>();
        colores.add(R.color.azul_sheika);
        colores.add(R.color.amarillo_pikachu);
        colores.add(R.color.cafe_eve);
        colores.add(R.color.celeste_canela);
        colores.add(R.color.naranja_sonrise);
        colores.add(R.color.morado_waluigi);
        colores.add(R.color.plateado_crepusculo);
        colores.add(R.color.rosa_kirby);
        colores.add(R.color.salmon);
        colores.add(R.color.purple_200);
        colores.add(R.color.teal_200);
        colores.add(R.color.teal_700);
        colores.add(R.color.verdem);
        colores.add(R.color.white);
        colores.add(R.color.black);
        return colores;
    }

    private ArrayList<String> nombresColores(){
        ArrayList<String> nombresColores = new ArrayList<>();
        nombresColores.add("Azul Sheika");
        nombresColores.add("Amarillo Pikachu");
        nombresColores.add("Cafe eve");
        nombresColores.add("Celeste canela");
        nombresColores.add("Naranja sunrise");
        nombresColores.add("Morado waluigi");
        nombresColores.add("Plateado Crepusculo");
        nombresColores.add("Rosa Kirby");
        nombresColores.add("Salmon");
        nombresColores.add("Purple 200");
        nombresColores.add("Teal 200");
        nombresColores.add("Teal 700");
        nombresColores.add("Verde Menta");
        nombresColores.add("Blanco");
        nombresColores.add("Negro");
        return nombresColores;
    }

    private ArrayList<String> hexa(){
        ArrayList<String> hexa = new ArrayList<>();
        hexa.add("#23C4D7");
        hexa.add("#E6F806");
        hexa.add("#FB8100");
        hexa.add("#69FFDD");
        hexa.add("#F5B041");
        hexa.add("#7636F7");
        hexa.add("#9E9191");
        hexa.add("#FF56FA");
        hexa.add("#FA8072");
        hexa.add("#FFBB86FC");
        hexa.add("#FF3700B3");
        hexa.add("#58D68D");
        hexa.add("#FFFFFFFF");
        hexa.add("#FF000000");
        return hexa;
    }

    private void traslado(int position){
        Intent intent = new Intent(this, MAColor.class);
        intent.putExtra("img", this.colores().get(position));
        intent.putExtra("hex", this.hexa().get(position));
        startActivity(intent);
    }
}
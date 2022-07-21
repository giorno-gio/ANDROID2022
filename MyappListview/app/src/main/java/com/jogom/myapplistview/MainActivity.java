    package com.jogom.myapplistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

    private ListView listView;
    //ArrayList<String> vocales = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,vocales()); //this, layout res un estilo de un layout de la carpeta res
        //y un entero(id que devuelve de la carpeta r)
        //arrayadapter une el contenido del xml con este lado con el arraylist vocales
        listView.setAdapter(arrayAdapter);

        this.clickItem();
    }

    public void clickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                traslado(i);
            }
        });
    }

    //1 tener en cuenta los datos que se van a representar en la lista
        //podría trabajar esto en el oncreate xd
    ArrayList<String> vocales = new ArrayList<>();
        private ArrayList<String> vocales(){
        this.vocales.add("A");
        this.vocales.add("E");
        this.vocales.add("I");
        this.vocales.add("O");
        this.vocales.add("U");
        return vocales;
        }

        //metodo que retorna un array pa las imagenes como datos
        private ArrayList<Integer> imagenes(){
            ArrayList<Integer> img = new ArrayList<>();
            //los elementos de la R regresan un numero entero por eso
            //el arraylist de tipo int porque retorna un int
            img.add(R.drawable.ic_a);
            img.add(R.drawable.ic_e);
            img.add(R.drawable.ic_i);
            img.add(R.drawable.ic_o);
            img.add(R.drawable.ic_u);
            return img;
        }

        //metodo que retorna un array pa la informacion
        private ArrayList<Integer> informacion(){
            ArrayList<Integer> info= new ArrayList<>();
            //los elementos de la R regresan un numero entero por eso
            //el arraylist de tipo int porque retorna un int
           info.add(R.string.vocalA);
           info.add(R.string.vocalE);
            info.add(R.string.vocalI);
            info.add(R.string.vocalO);
            info.add(R.string.vocalU);
           return info;
        }

        //metodo que hace la apertura y el tralado de datos a otra activity
        private void traslado(int posicion){
            Intent intent = new Intent(this, MaVocales.class);
            intent.putExtra("imagenes", imagenes().get(posicion));
            intent.putExtra("informacion", informacion().get(posicion));
            startActivity(intent);
        }
}
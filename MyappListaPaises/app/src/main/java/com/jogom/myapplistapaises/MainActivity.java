package com.jogom.myapplistapaises;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listPaises);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, paises());
        listView.setAdapter(arrayAdapter);
        this.clickItem();
    }

    private void clickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                traslado(i);
            }
        });
    }

    ArrayList<String> paises(){
        ArrayList<String> paises = new ArrayList<>();
        paises.add("Mexico");
        paises.add("Brazil");
        paises.add("Guatemala");
        paises.add("Colombia");
        paises.add("Argentina");
        paises.add("Italia");
        paises.add("España");
        paises.add("Francia");
        paises.add("Costa Rica");
        paises.add("Portugal");
        return paises;
    }

    ArrayList<Integer> imagenes(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_mexico);
        img.add(R.drawable.ic_brasil);
        img.add(R.drawable.ic_guate);
        img.add(R.drawable.ic_colombia);
        img.add(R.drawable.ic_argentina);
        img.add(R.drawable.ic_italia);
        img.add(R.drawable.ic_espana);
        img.add(R.drawable.ic_francia);
        img.add(R.drawable.ic_costar);
        img.add(R.drawable.ic_portugal);
        return img;
    }

    ArrayList<Integer> poblacion(){
        ArrayList<Integer> pob = new ArrayList<>();
        pob.add(R.string.pMexico);
        pob.add(R.string.pBrazil);
        pob.add(R.string.pGuatemala);
        pob.add(R.string.pColombia);
        pob.add(R.string.pArgentina);
        pob.add(R.string.pItalia);
        pob.add(R.string.pEspaña);
        pob.add(R.string.pFrancia);
        pob.add(R.string.pCR);
        pob.add(R.string.pPortugal);
        return pob;
    }

    private void traslado(int position){
        Intent intent = new Intent(this, DatosPaises.class);
        intent.putExtra("imagenes", imagenes().get(position));
        intent.putExtra("poblacion", poblacion().get(position));
        startActivity(intent);
    }
}
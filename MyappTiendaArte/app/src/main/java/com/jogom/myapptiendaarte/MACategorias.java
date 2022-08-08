package com.jogom.myapptiendaarte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MACategorias extends AppCompatActivity {



    private ListView listElementosA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macategorias);

        listElementosA = findViewById(R.id.listElementosA);

        AdapterElementosCat adp = new AdapterElementosCat(this, R.layout.listaelementoscategorias,nombreElementos(),
                precioElementos(),descripcionPinturas(),fotosPinturas());
        listElementosA.setAdapter(adp);

        //obtenerDatos();

    }

    /*private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String categoria = bundle.getString("nomcat");
        textViewEncabezado.setText(String.valueOf(categoria));
    }*/

    private ArrayList<String> nombreElementos(){
        ArrayList<String> nombreElementos = new ArrayList<>();
        nombreElementos.add("Entierro en Ornans");
        nombreElementos.add("El angelus");
        nombreElementos.add("Olympia");
        return nombreElementos;
    }

  private ArrayList<Integer> precioElementos(){

        ArrayList<Integer> precioElementos = new ArrayList<>();

        precioElementos.add(855000);
        precioElementos.add(98550);
        precioElementos.add(7596321);

        return precioElementos;
  }

    private ArrayList<Integer> descripcionPinturas(){
        ArrayList<Integer> descripcionPinturas = new ArrayList<>();

        descripcionPinturas.add(R.string.EntierroOrnans);
        descripcionPinturas.add(R.string.Elangelus);
        descripcionPinturas.add(R.string.Olympia);
        return descripcionPinturas;
  }

  private ArrayList<Integer> fotosPinturas(){
        ArrayList<Integer> fotosPinturas = new ArrayList<>();

      fotosPinturas.add(R.drawable.ic_entierro);
      fotosPinturas.add(R.drawable.ic_angelus);
      fotosPinturas.add(R.drawable.ic_olympia);

      return fotosPinturas;
  }

}
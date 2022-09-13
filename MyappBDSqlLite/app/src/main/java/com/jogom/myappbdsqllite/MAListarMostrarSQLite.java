package com.jogom.myappbdsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jogom.myappbdsqllite.basededatos.BebidaDao;
import com.jogom.myappbdsqllite.basededatos.BebidaVo;

import java.util.ArrayList;

public class MAListarMostrarSQLite extends AppCompatActivity {


    private ListView listView;
    private BebidaDao bDao = new BebidaDao();
    private BebidaVo bVo = new BebidaVo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malistar_mostrar_sqlite);

        listView = findViewById(R.id.lvListadoBebidas);

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,llenarLista());
        clickLista();
        listView.setAdapter(adp);

    }
    private void clickLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                trasladarDatos(i, MADetalle.class);
            }
        });
    }

    private ArrayList<String> llenarLista(){
        ArrayList<String> lista = new ArrayList<>();
        if(bDao.listarBebida(bVo,getApplicationContext()) != null) {
            for (BebidaVo listaVo : bDao.listarBebida(bVo, getApplicationContext())) {
                lista.add(listaVo.getNombreBebida());
            }
        }
        return lista;
    }

    private void trasladarDatos(int position, Class actividad){
        Intent intent = new Intent(this, actividad);
        intent.putExtra("codigo",bDao.listarBebida(bVo,getApplicationContext()).get(position).getCodBebida().toString());
        intent.putExtra("nombre",bDao.listarBebida(bVo,getApplicationContext()).get(position).getNombreBebida().toString());
        intent.putExtra("sabor",bDao.listarBebida(bVo,getApplicationContext()).get(position).toString());
        intent.putExtra("presentacion",bDao.listarBebida(bVo,getApplicationContext()).get(position).toString());
        intent.putExtra("tipo",bDao.listarBebida(bVo,getApplicationContext()).get(position).getTipoBebida().toString());
        intent.putExtra("precio", bDao.listarBebida(bVo,getApplicationContext()).get(position).getPrecioBebida().toString());
        startActivity(intent);
    }

}
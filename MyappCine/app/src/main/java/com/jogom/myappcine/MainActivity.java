package com.jogom.myappcine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle("CINEPOLIOS");
        getSupportActionBar().setTitle("CINEPOLIOS");

        recyclerView = findViewById(R.id.rvId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdaptadorRecycler adp = new AdaptadorRecycler(this.setDataCartelera());
        clickRecycler(adp);
        recyclerView.setAdapter(adp);



    }
    private void clickRecycler(AdaptadorRecycler adaptadorRecycler){
      adaptadorRecycler.setItemClickListener(new ClickListener() {
          @Override
          public void itemClick(Integer position, View v) {
              enviarDataPelis(position);
          }
      });
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
               recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.item2:
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<DatosCineVo> setDataCartelera(){
        ArrayList<DatosCineVo> data = new ArrayList<>();
        data.add(new DatosCineVo(R.drawable.ic_deadpool,R.string.nombreP1,R.string.duracionP1,
                R.string.boletoP1));
        data.add(new DatosCineVo(R.drawable.ic_godzilla,R.string.nombreP2,R.string.duracionP1,
                R.string.boletoP1));
        data.add(new DatosCineVo(R.drawable.ic_jujutsu,R.string.nombreP3,R.string.duracionP3,
                R.string.boletoP3));
        data.add(new DatosCineVo(R.drawable.ic_jw3parabelum,R.string.nombreP4,R.string.duracionP4,
                R.string.boletoP4));
        data.add(new DatosCineVo(R.drawable.ic_thorrag,R.string.nombreP5,R.string.duracionP5,
                R.string.boletoP5));
        return data;
    }
    
    private ArrayList<DatosCineVo> setInfoAdicional(){
        ArrayList<DatosCineVo> info = new ArrayList<>();
        return info;
    }

    private void enviarDataPelis(int position){
        Intent intent = new Intent(getApplicationContext(), MaInformacionPelicula.class);
        intent.putExtra("imgpe", setDataCartelera().get(position).getImagenPelicula());
        intent.putExtra("nomp", setDataCartelera().get(position).getNombrePelicula());
        intent.putExtra("durac", setDataCartelera().get(position).getDuracion());
        intent.putExtra("boleto", setDataCartelera().get(position).getPrecioBoleto());
        startActivity(intent);
    }
}
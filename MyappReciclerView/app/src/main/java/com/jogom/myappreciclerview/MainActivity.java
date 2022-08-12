package com.jogom.myappreciclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rvId);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterRecyclerView adapterRecyclerView = new adapterRecyclerView(imagenes());
        recyclerView.setAdapter(adapterRecyclerView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("RecyclerView");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.item2:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Integer> imagenes(){
        ArrayList<Integer> imagenes = new ArrayList<>();
        imagenes.add(R.drawable.ic_durazno);
        imagenes.add(R.drawable.ic_fresa);
        imagenes.add(R.drawable.ic_manzana);
        imagenes.add(R.drawable.ic_melon);
        imagenes.add(R.drawable.ic_mora);
        imagenes.add(R.drawable.ic_pera);
        imagenes.add(R.drawable.ic_pina);
        imagenes.add(R.drawable.ic_platano);
        imagenes.add(R.drawable.ic_sandia);
        imagenes.add(R.drawable.ic_uva);
        return imagenes;
    }
}
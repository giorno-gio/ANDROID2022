package com.jogom.myapptiendaarte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewcategoriaLista;
    private TextView textViewCategorias;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listViewcategoriaLista = findViewById(R.id.listCategoriasPintura);

        AdapterListaTipoPintura adp = new AdapterListaTipoPintura(this, R.layout.listapersonalizada,
                categoriasPintura(),imagenes());
        listViewcategoriaLista.setAdapter(adp);

        listViewcategoriaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                trasladoCategoria(i);
            }
        });

            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("TIENDA GRIEGA");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.item1:
                Toast.makeText(this, "Tienda donde puedes comprar arte", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<String> categoriasPintura(){
        ArrayList<String> categoriasPintura = new ArrayList<>();
        categoriasPintura.add("REALISMO");
        categoriasPintura.add("ABSTRACTO");
        categoriasPintura.add("SURREALISMO");
        return categoriasPintura;
    }


    private ArrayList<Integer> imagenes(){
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_realismo);
        img.add(R.drawable.ic_abstracta);
        img.add(R.drawable.ic_surrealista);
        return img;
    }

    private void trasladoCategoria(int position){
        Intent intent = new Intent(this, MACategorias.class);
        if (position == 0){
            this.startActivity(intent);
        }
    }

    private ArrayList<String> nombreCategoria(){
        ArrayList<String> nombreCategoria = new ArrayList<>();
        nombreCategoria.add("REALISMO");
        return nombreCategoria;
    }
}

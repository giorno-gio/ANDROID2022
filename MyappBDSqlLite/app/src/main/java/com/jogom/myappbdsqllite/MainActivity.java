package com.jogom.myappbdsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button buttonInsertar,buttonbuscar,buttonListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsertar = findViewById(R.id.btnInsertarMenu);
        buttonbuscar = findViewById(R.id.btnBuscarMenu);
        buttonListar = findViewById(R.id.btnListarMenu);

        navegacionMenu();
    }

    private void navegacionMenu(){
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirInsertar();
            }
        });
        buttonbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirBuscar();
            }
        });

        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirListar();
            }
        });

    }

    private void abrirInsertar(){
        Intent intent = new Intent(getApplicationContext(), MAInsertarSQLite.class);
        startActivity(intent);
    }

    private void abrirBuscar(){
        Intent intent = new Intent(getApplicationContext(), MABuscarIdSQLite.class);
        startActivity(intent);
    }
    private void abrirListar(){
        Intent intent = new Intent(getApplicationContext(), MAListarMostrarSQLite.class);
        startActivity(intent);
    }

}
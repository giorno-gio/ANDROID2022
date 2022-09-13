package com.jogom.myapprepaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnSuma);
        this.click();
    }

    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aperturaSuma();
            }
        });
    }

    private void aperturaSuma(){
        Intent intent = new Intent(this, MASuma.class); //elemento que proporsiona una vinculacion entre 2 o mas actividades
        //contexto = donde se desenvuelve el objeto en el proyecto
        startActivity(intent);
    }
}
package com.jogom.myappcuentosfragmentdinamicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButtonsiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonsiguiente = findViewById(R.id.btnSiguiente);
        this.click();
    }

    private void click(){
        imageButtonsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irActivityCuentos();
            }
        });
    }

    private void irActivityCuentos(){
        Intent intent = new Intent(this, Cuentos.class);
        startActivity(intent);
    }

}
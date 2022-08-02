package com.jogom.myappbisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText editTextDatos;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDatos = findViewById(R.id.edtdatos);
        button = findViewById(R.id.btnTraslado);
        this.click();
    }

    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarAnio();
            }
        });
    }

    private void enviarAnio(){
        String fecha = editTextDatos.getText().toString();
        if (!fecha.isEmpty()){
            Intent intent = new Intent(this, MADatosCalendario.class);
            intent.putExtra("an", fecha);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Debes ingresar un año", Toast.LENGTH_SHORT).show();
        }

    }
}
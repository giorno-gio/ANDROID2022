package com.jogom.myappnombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private TextView textViewResultado;
    private EditText editTextEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombre);
        textViewResultado = findViewById(R.id.txtResultado);
        editTextEdad = findViewById(R.id.edtEdad);
    }

    private void mostrar(){
        String nombre = this.editTextNombre.getText().toString();
        String dato = this.editTextEdad.getText().toString();
        if (!nombre.isEmpty() && dato.isEmpty()){
            Calendar c = Calendar.getInstance();
            int nacimiento = c.get(Calendar.YEAR)-Integer.parseInt(dato);
            textViewResultado.setText("Su nombre es: "+ nombre+" naciste en: "+nacimiento);
        }
        else{
            Toast.makeText(this, "No has ingresado tu nombre", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMostrar:
                    this.mostrar();
            break;
        }
    }
}
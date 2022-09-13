package com.jogom.myapptrasladodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Mareceptor extends AppCompatActivity {

    private TextView textViewN,textViewA,textViewE,textViewD,textViewT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mareceptor);

        textViewN = findViewById(R.id.txtNombre);
        textViewA = findViewById(R.id.txtApellido);
        textViewE = findViewById(R.id.txtEdad);
        textViewD = findViewById(R.id.txtDire);
        textViewT = findViewById(R.id.txtTelefon);

        obtenerDatos(); //lo pongo aqui porque lo primero que se crea
        //y se ejecuta es el oncreate
    }

    private void obtenerDatos(){
        //agregamos el objeto Bundle para recibir de forma optima
        //los datos traladados por el intent

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) { //en el caso que venga algo
            String nombre = bundle.getString("nom");
            String apellido = bundle.getString("ape");
            String edad  = bundle.getString("eda");
            String dir = bundle.getString("dir");
            String telefono = bundle.getString("tel");

            this.textViewN.setText("Nombre: "+nombre);
            this.textViewA.setText("Apellido: "+apellido);
            this.textViewE.setText("Edad: "+edad+" años");
            this.textViewD.setText("Direccion: "+dir);
            this.textViewT.setText("Telefono: "+telefono);

        }
        else {
            Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        }
    }
}
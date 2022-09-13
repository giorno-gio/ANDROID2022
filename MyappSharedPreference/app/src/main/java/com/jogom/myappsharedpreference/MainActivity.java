package com.jogom.myappsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextnombre, editTextedad;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextnombre = findViewById(R.id.edtNombresp);
        editTextedad = findViewById(R.id.edtEdadsp);
        button = findViewById(R.id.button);

        click();
    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                almacenarDatos();
            }
        });
    }

    private void almacenarDatos(){
        if (!editTextnombre.getText().toString().isEmpty() && !editTextedad.getText().toString().isEmpty()){
            //Instanciar clase Sharedpreference para utilizar su objeto, es el que me permite almacenar
            SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
            //crea el archivo pero en modo secreto ese es el punto que nadie lo vea
            String nombre = editTextnombre.getText().toString();
            int edad = Integer.parseInt(editTextedad.getText().toString());

            //almacenar datos que se encuentran en las variables
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre",nombre);
            editor.putInt("edad",edad);
            if (editor.commit() == true){
                editTextnombre.setText("");
                editTextedad.setText("");
                Toast.makeText(this, "Datos Almacenados correctamente", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Error almacenamiento datos", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void obtenerDatos(){
        SharedPreferences preferences = getSharedPreferences("DatosPreferidos",Context.MODE_PRIVATE);
        //asignar datos almacenados al preference
        //luego definimos valore por defecto ya que el archivo puede estar vacio
        String nombre = preferences.getString("nombre","---");
        int edad  = preferences.getInt("edad",0);

        if (edad == 0){
            editTextedad.setText(String.valueOf(""));
        }
        else{
            editTextedad.setText(String.valueOf(0));
        }
        editTextnombre.setText(String.valueOf(nombre));

    }
}
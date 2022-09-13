package com.jogom.myapptrasladodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextN,editTextA,editTextE,editTextD,editTextT;
    private Button buttonTD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextN = findViewById(R.id.edtNombre);
        editTextA = findViewById(R.id.edtApellido); //abstraccion de datos
        editTextE = findViewById(R.id.edtEdad); //finciona como hash o map
        editTextD = findViewById(R.id.edtDire); //indice y valor, indice y valor y así..
        editTextT = findViewById(R.id.edtTel);
        buttonTD = findViewById(R.id.btnTD);

        this.click();
    }

    private void click(){
        buttonTD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datosATrasladar();
            }
        });
    }

    private void datosATrasladar(){
        String nombre = editTextN.getText().toString();
        String apellido = editTextA.getText().toString();
        String edad = editTextE.getText().toString();
        String dire = editTextD.getText().toString();
        String tel =  editTextT.getText().toString();

        if(!nombre.isEmpty() && !apellido.isEmpty() && !edad.isEmpty() && !dire.isEmpty()
           && !tel.isEmpty()){
            Intent intent = new Intent(this, Mareceptor.class);
            intent.putExtra("nom",nombre);
            intent.putExtra("ape",apellido);
            intent.putExtra("eda", edad);
            intent.putExtra("dir", dire);
            intent.putExtra("tel", tel);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "No has ingresado todos tus datos", Toast.LENGTH_SHORT).show();
        }
    }
}
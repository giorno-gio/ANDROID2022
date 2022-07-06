package com.jogom.myappadultoninio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnEdad);
        editText1 = findViewById(R.id.txtNombre);
        editText2 = findViewById(R.id.txtEdad);
        this.click();
    }

    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar();
            }
        });
    }

    private void validar(){
        Intent intent1 = new Intent(this, MainActivity2.class);
        Intent intent2 = new Intent(this, MainActivity3.class);
        String nombreSt = this.editText1.getText().toString();
        String edadSt = this.editText2.getText().toString();
        if (!edadSt.isEmpty()&&!nombreSt.isEmpty()){
            int edad = Integer.parseInt(edadSt);
            if (edad < 18){
                startActivity(intent1);
            }
            else if (edad >= 18 ){
                startActivity(intent2);
            }
        }
        else{
            Toast.makeText(MainActivity.this, "Debes Ingresar tu edad", Toast.LENGTH_SHORT).show();
        }
    }
}
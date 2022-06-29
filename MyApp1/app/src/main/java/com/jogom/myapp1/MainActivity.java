package com.jogom.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables globales que representan elementos o views
    private TextView textViewcontador;
    private int contador = 0;


    //cada vez que inicia la ap se crea
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Establecer las view que se van a utilizar identificandolas por ID
        textViewcontador = findViewById(R.id.txtContador);
    }

    private void mas(){
        this.contador++;
        this.textViewcontador.setText(String.valueOf(contador));

    }

    private  void menos(){
        this.contador--;
        this.textViewcontador.setText(String.valueOf(contador));

    }
    
    private void reset(){
        this.contador = 0;
        this.textViewcontador.setText(String.valueOf(contador));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnMas){ //reconoce el id y hace el metodo
            this.mas();
            Toast.makeText(this, "Estoy sumando", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.btnMenos){
            this.menos();
            Toast.makeText(this, "Estoy restando", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.btnReset){
            this.reset();
            Toast.makeText(this, "El contador se Reinicio a 0", Toast.LENGTH_SHORT).show();
        }
    }
}
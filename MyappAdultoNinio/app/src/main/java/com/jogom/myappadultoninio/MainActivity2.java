package com.jogom.myappadultoninio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    private TextView textView1, textView2, textViewResul;
    private Button button,button1;
    private EditText editTextres;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //ciclo de actividades
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1 = findViewById(R.id.txtN1);
        textView2 = findViewById(R.id.txtN2);
        textViewResul = findViewById(R.id.txtResultado);
        button = findViewById(R.id.btnsuma);
        button1 = findViewById(R.id.btnsalir);
        editTextres = findViewById(R.id.edtRespuesta);

        this.click();
        this.asignarValores(); //no se si esto sea lo correcto
        salir();
    }

    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumar();
            }
        });
    }

    private void salir(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void asignarValores(){

        int aleatorio = 0;
        int aleatorio2 = 0;

        aleatorio = (int) (Math.random() * 20);
        aleatorio2 = (int) (Math.random() * 20);


        textView1.setText(String.valueOf(aleatorio));
        textView2.setText(String.valueOf(aleatorio2));


    }

    private void sumar(){
        String n1 = textView1.getText().toString();
        String n2 = textView2.getText().toString();
        String resultado = editTextres.getText().toString();

       if (!resultado.isEmpty()){
           int suma = (Integer.parseInt(n1)+Integer.parseInt(n2));
           int resultado2 = Integer.parseInt(resultado);
           if (suma == resultado2){
               textViewResul.setText(resultado2+" Es correcto ya no eres tan bebe");
           }
           else{
               Toast.makeText(this, "Aun eres un bebe", Toast.LENGTH_SHORT).show();
           }
       }
       if (resultado.isEmpty()){
           Toast.makeText(this, "Debes ingresar un valor", Toast.LENGTH_SHORT).show();
       }
    }

}
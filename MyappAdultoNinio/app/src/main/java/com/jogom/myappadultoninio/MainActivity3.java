package com.jogom.myappadultoninio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {


    private TextView textView,textView1,textView2;
    private EditText editText;
    private Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView = findViewById(R.id.txtNM1);
        textView1 = findViewById(R.id.txtNM2);
        textView2 = findViewById(R.id.txtResultadoM);
        editText = findViewById(R.id.edtRespuestaM);
        button = findViewById(R.id.btnMulti);
        button1 = findViewById(R.id.btnsalir);
        this.click();
        this.asignarValores();
        salir();
    }

    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicacion();
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

    private  void asignarValores(){
        int aleatorio = 0;
        int aleatorio2 = 0;

        aleatorio = (int) (Math.random()*100);
        aleatorio2 = (int) (Math.random()*100);


        textView.setText(String.valueOf(aleatorio));
        textView1.setText(String.valueOf(aleatorio2));
    }

    private void multiplicacion(){
        String n1 = textView.getText().toString();
        String n2 = textView1.getText().toString();
        String resultado = editText.getText().toString();

        if(!resultado.isEmpty()){
            int multi = (Integer.parseInt(n1)*Integer.parseInt(n2));
            int resultado2 = Integer.parseInt(resultado);

            if(multi == resultado2){
                textView2.setText(resultado2+" Es correcto eres un adulto");
            }
            else {
                Toast.makeText(this, "No le sabes al pov", Toast.LENGTH_SHORT).show();
            }
        }
        if (resultado.isEmpty()){
            Toast.makeText(this, "Debes Ingresar un valor", Toast.LENGTH_SHORT).show();
        }
    }
}
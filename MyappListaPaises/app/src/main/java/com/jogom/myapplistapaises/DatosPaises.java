package com.jogom.myapplistapaises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DatosPaises extends AppCompatActivity {


    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_paises);

        textView = findViewById(R.id.txtPobla);
        imageView = findViewById(R.id.imgPais);

        obtener();
    }

    private void obtener(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagenes");
        int pob = bundle.getInt("poblacion");

        imageView.setImageResource(imagen);
        textView.setText(pob);
    }
}
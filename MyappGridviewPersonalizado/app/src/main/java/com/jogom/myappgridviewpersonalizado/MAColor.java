package com.jogom.myappgridviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MAColor extends AppCompatActivity {


    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macolor);

        imageView = findViewById(R.id.imgMostrar);
        textView = findViewById(R.id.txtMostrarColor);

        this.obtener();
    }


    private void obtener(){
        Bundle bundle = getIntent().getExtras();
        int img = bundle.getInt("img");
        String hex = bundle.getString("hex");

        imageView.setImageResource(img);
        textView.setText(String.valueOf(hex));
    }
}
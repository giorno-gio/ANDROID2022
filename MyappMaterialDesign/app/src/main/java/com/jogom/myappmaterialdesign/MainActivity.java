package com.jogom.myappmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton materialButtonHacha, materialButtonSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialButtonHacha = findViewById(R.id.buttonHacha);
        materialButtonSalir = findViewById(R.id.buttonSalir);


        this.click();
    }

    public void click(){
        materialButtonHacha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abirOtraActivity();
            }
        });

        materialButtonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void abirOtraActivity(){
        Intent intent = new Intent(this, MAHacha.class);
        startActivity(intent);
    }
}
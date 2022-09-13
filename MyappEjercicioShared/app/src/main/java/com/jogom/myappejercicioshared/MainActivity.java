package com.jogom.myappejercicioshared;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText editTextnom1, editTextnom2, editTextnom3, editTextnom4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextnom1 = findViewById(R.id.edtNombresp);
        editTextnom2 = findViewById(R.id.edtNombrespDos);
        editTextnom3 = findViewById(R.id.edtNombrespTres);
        editTextnom4 = findViewById(R.id.edtNombrespCuatr);
    }
}
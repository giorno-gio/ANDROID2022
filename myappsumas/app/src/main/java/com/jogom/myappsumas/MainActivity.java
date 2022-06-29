package com.jogom.myappsumas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNum1, edtNum2;
    private TextView txtresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        txtresultado = findViewById(R.id.txtresultado);
    }


    private void sumar(){
        String n1 = this.edtNum1.getText().toString();
        String n2 = this.edtNum2.getText().toString();

        if (!n1.isEmpty() && !n2.isEmpty()){
            int suma = (Integer.parseInt(n1)+Integer.parseInt(n2));
            this.txtresultado.setText(String.valueOf(suma));
        }
        else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnsumar:
                this.sumar();
                break;
        }
    }
}
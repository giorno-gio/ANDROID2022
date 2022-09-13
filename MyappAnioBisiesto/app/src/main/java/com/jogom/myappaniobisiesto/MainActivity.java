package com.jogom.myappaniobisiesto;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText editTextan;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextan = findViewById(R.id.edtAn);
        button = findViewById(R.id.btnDatos);
        this.click();
    }

    private void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarDatos();
            }
        });
    }

    private void enviarDatos(){
        String fecha = editTextan.getText().toString();

        if (!fecha.isEmpty()){
            Intent intent = new Intent(this, DatosCalendario.class);
            intent.putExtra("dat", fecha);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Debes ingresar un año", Toast.LENGTH_SHORT).show();
        }
    }
}
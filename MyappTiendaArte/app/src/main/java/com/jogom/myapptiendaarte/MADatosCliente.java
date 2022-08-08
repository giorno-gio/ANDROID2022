package com.jogom.myapptiendaarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MADatosCliente extends AppCompatActivity {


    private ImageView imageViewPintura;
    private TextView textViewNombrePintura, textViewPrecioPintura;
    private EditText editTextNombre,editTextApellido,editTextNit;
    private Button buttonComprar, buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madatos_cliente);

        imageViewPintura = findViewById(R.id.imgPintura);
        textViewNombrePintura = findViewById(R.id.txtNombrePintura);
        textViewPrecioPintura = findViewById(R.id.txtPrecioPintura);
        editTextNombre = findViewById(R.id.edtNombre);
        editTextApellido = findViewById(R.id.edtApelllido);
        editTextNit = findViewById(R.id.edtNit);
        buttonComprar = findViewById(R.id.btnComprar);
        buttonCancelar = findViewById(R.id.btnCancelar);

        this.obtenerDatos();
        this.click();
        clickCancelar();
    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        int img = bundle.getInt("fot");
        int precio = bundle.getInt("pre");
        String nombre = bundle.getString("nom");

        imageViewPintura.setImageResource(img);
        textViewNombrePintura.setText(String.valueOf(nombre));
        textViewPrecioPintura.setText(String.valueOf(precio));
    }

    private void enviarDatosCompra(){
        String nombrePintura = textViewNombrePintura.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();
        String nit = editTextNit.getText().toString();
        String precio = textViewPrecioPintura.getText().toString();

        if(!nombre.isEmpty() && !apellido.isEmpty() && !nit.isEmpty()){
            Intent intent = new Intent(this, MADatosCompra.class);
            intent.putExtra("np", nombrePintura);
            intent.putExtra("noc", nombre);
            intent.putExtra("ape", apellido);
            intent.putExtra("nit", nit);
            intent.putExtra("prec", precio);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }


    }

    private void click(){
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarDatosCompra();
            }
        });
    }

    private void clickCancelar(){
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
package com.jogom.myappproducto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ContentInfoCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText edtArticulo,edtValor,edtCantidad;
    public TextView txtSolu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtArticulo = findViewById(R.id.edtArticulo);
        edtValor = findViewById(R.id.edtValor);
        edtCantidad = findViewById(R.id.edtCantidad);
        txtSolu = findViewById(R.id.txtSolu);
    }

    private void mostrar(){
        String articulo = this.edtArticulo.getText().toString();
        String valor = this.edtValor.getText().toString();
        String cantidad = this.edtCantidad.getText().toString();

        if (!articulo.isEmpty() && !valor.isEmpty() && !cantidad.isEmpty()){
            float va = Float.parseFloat(valor)*Float.parseFloat(cantidad);
            float noIva = (float) (va*0.12);
            float total = (va+noIva);
            this.txtSolu.setText("cantidad "+String.valueOf(articulo)+" Valor sin IVA "+String.valueOf(noIva)
            +" Total "+String.valueOf(total));

        }
        else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnProcesar:
                this.mostrar();
                break;
        }
    }
}
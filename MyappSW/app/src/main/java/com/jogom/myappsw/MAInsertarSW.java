package com.jogom.myappsw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.jogom.myappsw.basededatossw.ProductoDao;
import com.jogom.myappsw.basededatossw.ProductoVo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MAInsertarSW extends AppCompatActivity {

    private TextInputEditText editTextNombre, editTextPrecio, editTextFecha,
            editTextPeso, editTextExistencias;

    private MaterialButton button;
    ProductoDao pDao = new ProductoDao();
    ProductoVo pVo = new ProductoVo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsertar_sw);

        editTextNombre = findViewById(R.id.tfmNombreInsertar);
        editTextPrecio = findViewById(R.id.tfmPrecioUInsertar);
        editTextFecha = findViewById(R.id.tfmFechaIngInsertar);
        editTextPeso = findViewById(R.id.tfmPesoInsertar);
        editTextExistencias = findViewById(R.id.tfmExistenciasInsertar);

        button = findViewById(R.id.btnmInsertarProducto);

        this.clickRegistrar();
    }


    private void clickRegistrar() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarProductos();
            }
        });
    }

    private void registrarProductos() {
        //condicion edittex
        if (!editTextNombre.getText().toString().isEmpty() &&
                !editTextPrecio.getText().toString().isEmpty() &&
                !editTextFecha.getText().toString().isEmpty() &&
                !editTextPeso.getText().toString().isEmpty() &&
                !editTextExistencias.getText().toString().isEmpty()) {

            //llenado de varialbes vo por medio de set
            pVo.setNombreProducto(editTextNombre.getText().toString());
            pVo.setPrecioUnitario(Double.parseDouble(editTextPrecio.getText().toString()));
            String fecha = editTextFecha.getText().toString();
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = formato.parse(fecha);
                String fechaFormato = new SimpleDateFormat("yyyy/MM/dd").format(date);
                pVo.setFechaIngresoProducto(fechaFormato);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            pVo.setPesoProducto(Double.parseDouble(editTextPeso.getText().toString()));
            pVo.setExistenciasProducto(Integer.parseInt(editTextExistencias.getText().toString()));

            if(pDao.insertarSW(pVo,getApplicationContext())){
                editTextNombre.setText("");
                editTextPrecio.setText("");
                editTextFecha.setText("");
                editTextPeso.setText("");
                editTextExistencias.setText("");
                Toast.makeText(this, "cliente registrado correctamente", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "error en el registro", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
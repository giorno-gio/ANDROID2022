package com.jogom.myappbdsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jogom.myappbdsqllite.basededatos.BebidaDao;
import com.jogom.myappbdsqllite.basededatos.BebidaVo;

public class MAInsertarSQLite extends AppCompatActivity {


    private EditText editTextNombre, editTextSabor, editTextPresentacion, editTextTipo, editTextPrecio;
    Button buttonInsertar;
    private BebidaDao bDao = new BebidaDao();
    private BebidaVo bVo = new BebidaVo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsertar_sqlite);

        editTextNombre = findViewById(R.id.edtNombreBebidaInsertar);
        editTextSabor = findViewById(R.id.edtSaborBebidaInsertar);
        editTextPresentacion = findViewById(R.id.edtPresentacionBebidaInsertar);
        editTextTipo = findViewById(R.id.edtTipoBebidaInsertar);
        editTextPrecio = findViewById(R.id.edtPrecioBebidaInsertar);
        buttonInsertar = findViewById(R.id.btnInsertarRegistro);

        this.clickInsertar();
    }

    private void clickInsertar() {
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarBebida();
            }
        });
    }

    private void registrarBebida() {
        if (!editTextNombre.getText().toString().isEmpty() &&
                !editTextSabor.getText().toString().isEmpty() && !editTextPresentacion.getText().toString().isEmpty() &&
                !editTextTipo.getText().toString().isEmpty() && !editTextPrecio.getText().toString().isEmpty()) {
            bVo.setNombreBebida(editTextNombre.getText().toString());//llenan todos los elementos los set
            bVo.setSaborBebida(editTextSabor.getText().toString());
            bVo.setPresentacionBebida(Integer.parseInt(editTextPresentacion.getText().toString()));
            bVo.setTipoBebida(editTextTipo.getText().toString());
            bVo.setPrecioBebida(Double.parseDouble(editTextPrecio.getText().toString()));
            if(bDao.insertarBebida(bVo,getApplicationContext())){
                editTextNombre.setText("");
                editTextSabor.setText("");
                editTextPresentacion.setText("");
                editTextTipo.setText("");
                editTextPrecio.setText("");
                Toast.makeText(this, "Bebida registrada correctamente", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Error al registrar bebida", Toast.LENGTH_SHORT).show();
            }
        }

        else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }


    }
}
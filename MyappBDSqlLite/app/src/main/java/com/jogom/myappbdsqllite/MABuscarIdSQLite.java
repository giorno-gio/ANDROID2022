package com.jogom.myappbdsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jogom.myappbdsqllite.basededatos.BebidaDao;
import com.jogom.myappbdsqllite.basededatos.BebidaVo;

public class MABuscarIdSQLite extends AppCompatActivity {

    private EditText editTextCodigo;
    private TextView textViewCodigo, textViewNombre, textViewSabor, textViewPresentacion, textViewTipo,
            textViewPrecio;
    private ImageButton imageButton;
    private BebidaVo bVo = new BebidaVo();
    private BebidaDao bDao = new BebidaDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mabuscar_id_sqlite);

        editTextCodigo = findViewById(R.id.edtCodigoBuscar);
        textViewCodigo = findViewById(R.id.txtCodigoBuscar);
        textViewNombre = findViewById(R.id.txtNombreBuscar);
        textViewSabor = findViewById(R.id.txtSaborBuscar);
        textViewPresentacion = findViewById(R.id.txtPresentacionBuscar);
        textViewTipo = findViewById(R.id.txtTipoBuscar);
        textViewPrecio = findViewById(R.id.txtPrecioBuscar);
        imageButton = findViewById(R.id.imgBuscar);
        this.clickBuscar();
    }

    private void clickBuscar() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarBebida();
            }
        });
    }

    private void buscarBebida() {
        if (!editTextCodigo.getText().toString().isEmpty()) {
            bVo.setCodBebida(Integer.parseInt(editTextCodigo.getText().toString()));
            if (bDao.buscarBebida(bVo, getApplicationContext()) != null) {
                if (bDao.buscarBebida(bVo, getApplicationContext()).getCount() > 0) {
                    textViewCodigo.setText(String.valueOf(bVo.getCodBebida()));
                    textViewNombre.setText(String.valueOf(bVo.getNombreBebida()));
                    textViewSabor.setText(String.valueOf(bVo.getSaborBebida()));
                    textViewPresentacion.setText(String.valueOf(bVo.getPresentacionBebida()));
                    textViewTipo.setText(String.valueOf(bVo.getTipoBebida()));
                    textViewPrecio.setText(String.valueOf(bVo.getPrecioBebida()));
                }
                else{
                    textViewCodigo.setText("");
                    textViewNombre.setText("");
                    textViewSabor.setText("");
                    textViewPresentacion.setText("");
                    textViewTipo.setText("");
                    textViewPrecio.setText("");
                    Toast.makeText(MABuscarIdSQLite.this, "No se encontro bebida con ese codigo", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(MABuscarIdSQLite.this, "Error en la busqueda", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Debes ingresar un codigo", Toast.LENGTH_SHORT).show();
        }
    }


}
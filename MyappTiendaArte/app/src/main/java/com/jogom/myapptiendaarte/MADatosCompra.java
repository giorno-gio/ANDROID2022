package com.jogom.myapptiendaarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MADatosCompra extends AppCompatActivity {
    private TextView textViewNomPintura,textViewNomPersona,textViewApePersona,
    textViewNitPersona,textViewTotal;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madatos_compra);

        textViewNomPintura = findViewById(R.id.txtNPintura);
        textViewNomPersona = findViewById(R.id.txtNomPersona);
        textViewApePersona = findViewById(R.id.txtApePersona);
        textViewNitPersona = findViewById(R.id.txtNitPersona);
        textViewTotal = findViewById(R.id.txtTotal);
        button = findViewById(R.id.btnfin);
        this.obtener();
        this.precio();
        this.clickf();
    }

    private void obtener(){
        Bundle bundle = getIntent().getExtras();
        String nomPintu = bundle.getString("np");
        String nomCliente = bundle.getString("noc");
        String apePersona = bundle.getString("ape");
        String nit = bundle.getString("nit");

        if(bundle != null){
            textViewNomPintura.setText(String.valueOf(nomPintu));
            textViewNomPersona.setText(String.valueOf(nomCliente));
            textViewApePersona.setText(String.valueOf(apePersona));
            textViewNitPersona.setText(String.valueOf(nit));
        }
        else{
            Toast.makeText(this, "DATOS NO ENCONTRADOS", Toast.LENGTH_SHORT).show();
        }

    }

    private void precio(){
        Bundle bundle = getIntent().getExtras();
        String precio = bundle.getString("prec");
        int pr = Integer.parseInt(precio);
        textViewTotal.setText("Total: "+String.valueOf(pr));
    }

    private void clickf(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminar();
            }
        });
    }

    private void terminar(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//esto segun lei cierra todas las activitys que llevo en cola
        intent.putExtra("SALIR", true);
        startActivity(intent);
    }

}
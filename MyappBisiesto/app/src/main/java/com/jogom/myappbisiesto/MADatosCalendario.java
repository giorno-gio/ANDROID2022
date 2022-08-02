package com.jogom.myappbisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MADatosCalendario extends AppCompatActivity {

    private TextView textViewAn,textViewDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madatos_calendario);
        textViewAn = findViewById(R.id.txtAn);
        textViewDias = findViewById(R.id.txtDias);

        anBisesto();
    }

    private void anBisesto(){
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String an = bundle.getString("an");
            int ani = Integer.parseInt(an);
            GregorianCalendar calendar = new GregorianCalendar();

            if (calendar.isLeapYear(ani)){
                textViewAn.setText(ani+" ES AÑO BISIESTO");
                textViewDias.setText("TIENE 366 DIAS");
            }
            else{
                textViewAn.setText(ani+"NO ES AÑO BISIESTO");
                textViewDias.setText("TIENE 365 DIAS");
            }

        }
    }
}
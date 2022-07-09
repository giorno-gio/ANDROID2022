package com.jogom.myapppoemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button button,button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnRomanze);
        button1 = findViewById(R.id.btnSati);
        button2 = findViewById(R.id.btnOda);

        this.clickRomanze();
        this.clickOda();
        this.clickSati();
    }

    private void clickRomanze(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poemasRomanze();
            }
        });
    }
    private void clickSati(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poemasSatira();
            }
        });
    }
    private void clickOda(){
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poemasOda();
            }
        });
    }

    private void poemasRomanze(){
        Intent intent = new Intent(this, Romanze.class);
        startActivity(intent);
    }

    private void poemasSatira(){
        Intent intent = new Intent(this, Satira.class);
        startActivity(intent);
    }

    private void poemasOda(){
        Intent intent = new Intent(this, Oda.class);
        startActivity(intent);
    }
}
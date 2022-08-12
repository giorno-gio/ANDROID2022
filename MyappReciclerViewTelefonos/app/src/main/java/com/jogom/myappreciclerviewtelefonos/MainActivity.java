package com.jogom.myappreciclerviewtelefonos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        AdaptadorRecyclerView adptr = new AdaptadorRecyclerView(this.envioDatos());
        recyclerView.setAdapter(adptr);
    }

    private ArrayList<DatosVo> envioDatos(){
        ArrayList<DatosVo> datos = new ArrayList<>();
        datos.add(new DatosVo(R.drawable.ic_aloyy,"Aloy","74859632"));
        datos.add(new DatosVo(R.drawable.ic_cbum,"Cbum","147859632"));
        datos.add(new DatosVo(R.drawable.ic_kirby,"kiby","78965741"));
        datos.add(new DatosVo(R.drawable.ic_kratos,"kratos","12345789"));
        datos.add(new DatosVo(R.drawable.ic_luigi,"Luigi","74896374"));
        datos.add(new DatosVo(R.drawable.ic_maki,"maki","7485963"));
        datos.add(new DatosVo(R.drawable.ic_miss,"Sara","78932141"));
        datos.add(new DatosVo(R.drawable.ic_samira,"Samira","7832962"));
        datos.add(new DatosVo(R.drawable.ic_yoshi,"Yoshi","74136525"));
        datos.add(new DatosVo(R.drawable.ic_zelda,"Zelda","79321485"));
        return datos;
    }
}
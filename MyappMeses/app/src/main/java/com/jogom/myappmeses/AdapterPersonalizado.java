package com.jogom.myappmeses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

//PASO 1
//se debe realizar el extends de la clase BaseAdapter para poder utilizar
//los metodos abstractos que está tiene y así poder crear nuestro propio adapter

public class AdapterPersonalizado extends BaseAdapter {

    //paso 2
    //declarar de variables a utilizar para el item personalizado de la lista
    private Context context; //solicite una clase objeto dentro del ciclo de vida de la actividad
    private int referenciaLista;
    ArrayList<Integer> numeroMes = new ArrayList<>();
    ArrayList<String> nombreMes = new ArrayList<>();
    ArrayList<String> celebracionesMes = new ArrayList<>();
    ArrayList<Integer> descripcionCelebracionMes = new ArrayList<>();

    public AdapterPersonalizado(Context context, int referenciaLista,
                                ArrayList<Integer> numeroMes, ArrayList<String> nombreMes,
                                ArrayList<String> celebracionesMes, ArrayList<Integer> descripcionCelebracionMes) {

        this.context = context;
        this.referenciaLista = referenciaLista;
        this.numeroMes = numeroMes;
        this.nombreMes = nombreMes;
        this.celebracionesMes = celebracionesMes;
        this.descripcionCelebracionMes = descripcionCelebracionMes;

    }

    //metodo que da el tamaño de la lista
    @Override
    public int getCount() {
        return this.numeroMes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //variable para el retorno, esta sera de tipo View
        View v = view; //elementos que van a tener accion en mi lista personalizada :v
        //permite la implementacion de un view ya hecho el cual reconoce el contexto de donde se va a mostrar esa vista
        LayoutInflater layoutInflater = LayoutInflater.from(context);//reconocer archivo xml que va a ser parte de este adaptador (relacionar logica con grafico)
        v = layoutInflater.inflate(R.layout.listapersonalizada, null);


        //recibir informacion por posicion de los ArrayList
        int numeroMes = this.numeroMes.get(i); //get en que posicion se agrega un item
        String nombreMes = this.nombreMes.get(i);
        String celebracionMes = this.celebracionesMes.get(i);
        int descripcionCelebracion = this.descripcionCelebracionMes.get(i);


        TextView textViewnumMes = v.findViewById(R.id.txtNumeroMes);
        TextView textviewNomMes = v.findViewById(R.id.txtNomMes);
        TextView textViewAni = v.findViewById(R.id.txtAnio);
        Button ver = v.findViewById(R.id.btnVer);

        textViewnumMes.setText(String.valueOf(numeroMes));
        textviewNomMes.setText(String.valueOf(nombreMes));
        textViewAni.setText(String.valueOf(anActual()));

        //metodo del click del boton...

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trasladarDatos(nombreMes, celebracionMes, descripcionCelebracion);
            }
        });


        return v;
    }

    private int anActual() {
        Calendar calendar = Calendar.getInstance();
        int an = calendar.get(Calendar.YEAR);
        return an;
    }

    private void trasladarDatos(String nomMes, String celebracion, int descripcion) {
        Intent intent = new Intent(context, MACelebraciones.class);
        intent.putExtra("nomMes", nomMes);
        intent.putExtra("celebracion", celebracion);
        intent.putExtra("descripcion", descripcion);
        context.startActivity(intent);
    }
}

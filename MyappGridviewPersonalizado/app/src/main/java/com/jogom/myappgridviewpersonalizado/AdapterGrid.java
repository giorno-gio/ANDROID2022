package com.jogom.myappgridviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterGrid extends BaseAdapter {

    private Context context;
    int referenciaGrid;
    ArrayList<Integer> colores =new ArrayList<>();
    ArrayList<String> nombreColores = new ArrayList<>();

    public AdapterGrid(Context context, int referenciaGrid, ArrayList<Integer> colores, ArrayList<String> nombreColores) {
        this.context = context;
        this.referenciaGrid = referenciaGrid;
        this.colores = colores;
        this.nombreColores = nombreColores;
    }

    @Override
    public int getCount() {
        return this.nombreColores.size();
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
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.grid_personalizado, null);


        int imagen = colores.get(i);
        String nombre = nombreColores.get(i);

        ImageView imageView = v.findViewById(R.id.imgGrid);
        TextView textView = v.findViewById(R.id.txtGrid);

        textView.setText(String.valueOf(nombre));
        imageView.setImageResource(imagen);

        return v;
    }
}

package com.jogom.myapptiendaarte;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterListaTipoPintura extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    ArrayList<String> categoriasPintura = new ArrayList<>();
    ArrayList<Integer> imagenesLista = new ArrayList<>();

    public AdapterListaTipoPintura(Context context, int referenciaLista, ArrayList<String> categoriasPintura, ArrayList<Integer> imagenesLista) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.categoriasPintura = categoriasPintura;
        this.imagenesLista = imagenesLista;
    }

    @Override
    public int getCount() {
        return this.categoriasPintura.size();
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
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.listapersonalizada, null);

        String catergoriasPintura = this.categoriasPintura.get(i);
        int imglista = this.imagenesLista.get(i);
        TextView textViewCategoriaPintura = v.findViewById(R.id.txtcategoriaPintura);
        ImageView imageViewLista = v.findViewById(R.id.imgListaIcono);





        textViewCategoriaPintura.setText(String.valueOf(catergoriasPintura));
        imageViewLista.setImageResource(imglista);

        return v;
    }


}



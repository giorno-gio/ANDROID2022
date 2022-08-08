package com.jogom.myapptiendaarte;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterElementosCat extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    ArrayList<String> nombreElementos = new ArrayList<>();
    ArrayList<Integer> precioElementos = new ArrayList<>();
    ArrayList<Integer> descripcionPinturas = new ArrayList<>();
    ArrayList<Integer> fotosPinturas = new ArrayList<>();


    public AdapterElementosCat(Context context, int referenciaLista, ArrayList<String> nombreElementos, ArrayList<Integer> precioElementos,
                               ArrayList<Integer> descripcionPinturas, ArrayList<Integer> fotosPinturas) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.nombreElementos = nombreElementos;
        this.precioElementos = precioElementos;
        this.descripcionPinturas = descripcionPinturas;
        this.fotosPinturas = fotosPinturas;
    }

    @Override
    public int getCount() {
        return this.nombreElementos.size();
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
        v = layoutInflater.inflate(R.layout.listaelementoscategorias, null);


        String nombreElementos = this.nombreElementos.get(i);
        int precioElementos = this.precioElementos.get(i);
        int descripcionElementos = this.descripcionPinturas.get(i);
        int fotosPinturas = this.fotosPinturas.get(i);


        TextView textViewNombre = v.findViewById(R.id.txtNombre);
        TextView textViewPrecio = v.findViewById(R.id.txtPrecio);
        TextView textViewDescrip = v.findViewById(R.id.txtDescripcion);
        ImageView imageView = v.findViewById(R.id.imgElemento);
        Button buttonComprar = v.findViewById(R.id.btnAdquirir);

        textViewNombre.setText(String.valueOf(nombreElementos));
        textViewPrecio.setText(String.valueOf(precioElementos));
        textViewDescrip.setText(descripcionElementos);
        imageView.setImageResource(fotosPinturas);


        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trasladarDatosPintura(nombreElementos,precioElementos,fotosPinturas);
            }
        });


        return v;
    }

    private void trasladarDatosPintura(String nombrePintura, int precio, int imagen) {
        Intent intent = new Intent(context, MADatosCliente.class);
        intent.putExtra("nom",nombrePintura);
        intent.putExtra("pre", precio);
        intent.putExtra("fot",imagen);
        context.startActivity(intent);

    }
}

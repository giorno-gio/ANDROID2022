package com.jogom.myappbdsqllite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentDetalle extends Fragment {


    public FragmentDetalle() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }
    private void llenarFragmento(View v){
        TextView textViewCod,textViewNombre,textViewSabor, textviewpresentacion,textViewTipo,textviewPrecio;
        textViewCod = v.findViewById(R.id.txtCodigoFragment);
        textViewNombre = v.findViewById(R.id.txtNombreFragment);
        textViewSabor= v.findViewById(R.id.txtSaborFragment);
        textviewpresentacion= v.findViewById(R.id.txtPresentacionFragment);
        textViewTipo = v.findViewById(R.id.txtTipoFragment);
        textviewPrecio = v.findViewById(R.id.txtPrecioFragment);

       
    }

}
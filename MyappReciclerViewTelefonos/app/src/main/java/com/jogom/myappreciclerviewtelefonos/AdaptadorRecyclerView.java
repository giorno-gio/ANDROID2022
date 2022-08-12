package com.jogom.myappreciclerviewtelefonos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {

    private ArrayList<DatosVo> datosVo = new ArrayList<>();

    public AdaptadorRecyclerView(ArrayList<DatosVo> datosVo) {
        this.datosVo = datosVo;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerView.ViewHolder holder, int position) {
        holder.asignarDatos(datosVo.get(position).getImg(), datosVo.get(position).getNombre(),
                datosVo.get(position).getNumero());
    }

    @Override
    public int getItemCount() {
        return this.datosVo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewNombre, textViewNumero;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNombre = itemView.findViewById(R.id.txtNombre);
            textViewNumero = itemView.findViewById(R.id.txtNumeroTelefono);
            imageView = itemView.findViewById(R.id.imgRecycler);
        }

        private void asignarDatos(int img, String nombre, String numero){
            imageView.setImageResource(img);
            textViewNombre.setText(String.valueOf(nombre));
            textViewNumero.setText(String.valueOf(numero));
        }
    }
}

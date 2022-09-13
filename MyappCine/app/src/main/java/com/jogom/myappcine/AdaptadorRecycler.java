package com.jogom.myappcine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {


    private static ClickListener clickListener;

    private ArrayList<DatosCineVo> datosCine = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosCineVo> datosCine) {
        this.datosCine = datosCine;
    }

    @NonNull
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.setData(datosCine.get(position).getImagenPelicula(),
                datosCine.get(position).getNombrePelicula(),
                datosCine.get(position).getDuracion(),
                datosCine.get(position).getPrecioBoleto());
    }

    @Override
    public int getItemCount() {
        return this.datosCine.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageButton imageButton;
        private TextView textViewNombre, textViewDuracion, textViewBoleto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButton = itemView.findViewById(R.id.btnImgPeliRecycler);
            textViewNombre = itemView.findViewById(R.id.txtNombrePeliRecycler);
            textViewDuracion = itemView.findViewById(R.id.txtDuracionPeliRecycler);
            textViewBoleto = itemView.findViewById(R.id.txtPrecioBoletoRecycler);

            itemView.setOnClickListener(this);
        }

        private void setData(Integer img, Integer nombre, Integer durac,
                             Integer boleto){
            imageButton.setImageResource(img);
            textViewNombre.setText(nombre);
            textViewDuracion.setText(durac);
            textViewBoleto.setText(boleto);
        }

        @Override
        public void onClick(View view) {
            clickListener.itemClick(getAdapterPosition(), view);
        }


    }
    public void setItemClickListener(ClickListener clickListener){
        AdaptadorRecycler.clickListener = clickListener;
    }
}

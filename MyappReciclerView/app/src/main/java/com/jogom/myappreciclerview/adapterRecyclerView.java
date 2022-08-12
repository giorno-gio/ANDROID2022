package com.jogom.myappreciclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapterRecyclerView extends RecyclerView.Adapter<adapterRecyclerView.ViewHolder> {

    private ArrayList<Integer> img = new ArrayList<>();

    public adapterRecyclerView(ArrayList<Integer> img) {
        this.img = img;
    }

    @NonNull
    @Override
    public adapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull adapterRecyclerView.ViewHolder holder, int position) {
        holder.asignarimg(img.get(position));
    }

    @Override
    public int getItemCount() {
        return this.img.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgRecicler);
        }

        private void asignarimg(int img){
            imageView.setImageResource(img);
        }
    }
}

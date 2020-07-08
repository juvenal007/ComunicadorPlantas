package com.example.juvenalsalas.comunicadorplantas;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juvenalsalas.comunicadorplantas.basededatos.Planta;

import java.util.List;

public class AdaptadorHumedad extends RecyclerView.Adapter<AdaptadorHumedad.HumedadHolder>{

    List<Planta> list;
    Fragment fragment;
    int resource;

    public AdaptadorHumedad(List<Planta> list, Fragment fragment, int resource) {
        this.list = list;
        this.fragment = fragment;
        this.resource = resource;
    }

    @NonNull
    @Override
    public HumedadHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource,
                viewGroup, false);
        return new HumedadHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HumedadHolder humedadHolder, int i) {
        Planta p = list.get(i);
        humedadHolder.fecha.setText(p.fecha+"");
        humedadHolder.humedad.setText(p.humedad+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HumedadHolder extends RecyclerView.ViewHolder{

        private TextView fecha,humedad;

        public HumedadHolder(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.fecha_humedad);
            humedad = itemView.findViewById(R.id.humedad);
        }
    }

}

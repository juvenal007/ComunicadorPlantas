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

public class AdaptadorTemperatura extends RecyclerView.Adapter<AdaptadorTemperatura.TemperaturaHolder>{

    List<Planta> list;
    Fragment fragment;
    int resource;

    public AdaptadorTemperatura(List<Planta> list, Fragment fragment, int resource) {
        this.list = list;
        this.fragment = fragment;
        this.resource = resource;
    }

    @NonNull
    @Override
    public TemperaturaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource,
                viewGroup, false);
        return new TemperaturaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemperaturaHolder temperaturaHolder, int i) {
        Planta p = list.get(i);
        temperaturaHolder.fecha.setText(p.fecha+"");
        temperaturaHolder.temperatura.setText(p.temperatura+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TemperaturaHolder extends RecyclerView.ViewHolder{

        private TextView fecha,temperatura;

        public TemperaturaHolder(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.fecha_temp);
            temperatura = itemView.findViewById(R.id.temperatura);

        }
    }

}

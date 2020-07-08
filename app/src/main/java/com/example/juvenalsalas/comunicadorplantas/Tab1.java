package com.example.juvenalsalas.comunicadorplantas;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juvenalsalas.comunicadorplantas.basededatos.Crud;
import com.example.juvenalsalas.comunicadorplantas.basededatos.Planta;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1 extends Fragment {

    private TextView titulo,nombreComun,nombreCientifico,altura,descripcion;
    private ImageView foto1;

    public Tab1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);



      /*  Crud crud = new Crud();

        Planta p = crud.buscar(0);

        titulo = view.findViewById(R.id.titulo);
        titulo.setText(p.titulo);

        nombreComun = view.findViewById(R.id.comun);
        nombreComun.setText(p.nombreComun);

        nombreCientifico = view.findViewById(R.id.cientifico);
        nombreCientifico.setText(p.nombreCientifico);

        altura = view.findViewById(R.id.altura);
        altura.setText(p.altura);

        descripcion = view.findViewById(R.id.descripcion);
        descripcion.setText(p.descripcion);

        foto1 = view.findViewById(R.id.foto1);
        foto1.setImageResource(p.foto1);*/

        return view;
    }

}

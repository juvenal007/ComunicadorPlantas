package com.example.juvenalsalas.comunicadorplantas;


import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.transition.ChangeScroll;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.juvenalsalas.comunicadorplantas.basededatos.Planta;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3 extends Fragment {


    private RecyclerView recycler;
    private NuevoFragmento.OnFragmentInteractionListener mListener;
    public Tab3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        recycler = view.findViewById(R.id.list_recycler);
        buscar();

    return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
            buscar();
        }
    }


    public void buscar(){
        String Url="http://www.todojava.net/salas_list.php";

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    String respuesta = new String(responseBody);
                    cargar(respuesta);
                    Log.e("INFO", respuesta);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void cargar(String respuesta){

        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(lm);

        try {

            List<Planta> list = new ArrayList<>();
            JSONArray json = new JSONArray(respuesta);

            for (int i = 0; i < json.length(); i++){
                Planta p = new Planta();
                p.id = json.getJSONObject(i).getInt("id");
                p.nombre = json.getJSONObject(i).getString("name");
                p.temperatura = json.getJSONObject(i).getDouble("valor1");
                p.humedad = json.getJSONObject(i).getDouble("valor2");
                p.fecha = json.getJSONObject(i).getString("fecha");
                list.add(p);
                Log.e("INFO",   p.nombre);
            }
            AdaptadorTemperatura ad = new AdaptadorTemperatura(list, this, R.layout.item_temperatura);
            recycler.setAdapter(ad);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

        void onFragmentInteraction(Uri uri);
    }

}

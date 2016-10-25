package com.example.seratic.drawerfalabella.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.seratic.drawerfalabella.R;


public class Denegado4 extends Fragment implements View.OnClickListener {

    Button aceptar;
    TextView nombre,estado,doc;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.solo_descripcion, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_solo_descripcion);
        aceptar.setOnClickListener(this);
        nombre = (TextView) view.findViewById(R.id.tvNombre_descripcion);
        doc = (TextView) view.findViewById(R.id.tvDocumento_descripcion);
        estado = (TextView) view.findViewById(R.id.tvEstado_descripcion);
        nombre.setText("Pablo Sanjuan");
        doc.setText("8234723");
        estado.setText("DENEGADO");
        estado.setTextColor(Color.parseColor("#FF5722"));
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_solo_descripcion:
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                BandejaClientes bandejaClientes = new BandejaClientes();
                fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                fragmentTransaction.commit();
        }
    }
}

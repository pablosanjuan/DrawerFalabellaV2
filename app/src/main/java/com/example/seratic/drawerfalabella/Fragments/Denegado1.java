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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class Denegado1 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no;
    TextView pregunta,nombre,doc,estado;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_2rtas, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg);
        pregunta = (TextView) view.findViewById(R.id.preg_una_preg_2r);
        pregunta.setText("Se ofrece cuneta de ahorros?");
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_2r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_2r);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_2r);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_2r);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_2r);
        nombre.setText("Pablo Sanjuan");
        doc.setText("8234723");
        estado.setText("DENEGADO");
        estado.setTextColor(Color.parseColor("#FF5722"));
        aceptar.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_una_preg:
                if (si.isChecked()){
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Denegado2 denegado2= new Denegado2();
                    fragmentTransaction.replace(R.id.fragment, denegado2);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Denegado3 denegado3= new Denegado3();
                    fragmentTransaction.replace(R.id.fragment, denegado3);
                    fragmentTransaction.commit();
            }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
        }
    }
}

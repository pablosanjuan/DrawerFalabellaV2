package com.example.seratic.drawerfalabella.Fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class NoEncontrado3 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no,otro;
    TextView pregunta,estado,nombre,doc;
    private SharedPreferences prefs;
    private ImageButton atras;
    TextView numero_preg;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_3rtas, container, false);

        numero_preg = (TextView) view.findViewById(R.id.numero_preg);
        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg_3rtas);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_3r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_3r);
        otro = (RadioButton) view.findViewById(R.id.rb_otro_1p_3r);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_3r);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_3r);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_3r);
        prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
        String nombre_shp = prefs.getString("nombre", "");
        String doc_shpdoc = prefs.getString("dni", "");
        nombre.setText(nombre_shp);
        doc.setText(doc_shpdoc);
        estado.setText("NO ENCONTRADO");
        estado.setTextColor(Color.parseColor("#2196F3"));
        si.setText("No Interesado");
        no.setText("Ya Posee");
        otro.setText("Otro, cual?");
        si.setOnClickListener(this);
        no.setOnClickListener(this);
        otro.setOnClickListener(this);
        aceptar.setOnClickListener(this);
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);
        numero_preg.setText("2 de 2");
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (view.getId()){
            case R.id.btn_atras:
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                NoEncontrado1 noEncontrado1= new NoEncontrado1();
                fragmentTransaction.replace(R.id.fragment, noEncontrado1);
                fragmentTransaction.commit();
                break;
            case R.id.aceptar_una_preg_3rtas:
                SharedPreferences preferencias=getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
                if (si.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("estado", 1);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes = new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("estado", 2);
                    editor.putString("descripcion", "");
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes = new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }else if(otro.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("estado", 3);
                    editor.putString("descripcion", "");
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    NoEncontrado4 noEncontrado4 = new NoEncontrado4();
                    fragmentTransaction.replace(R.id.fragment, noEncontrado4);
                    fragmentTransaction.commit();
                }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.rb_si_1p_3r:
                numero_preg.setText("2 de 2");
                aceptar.setText("Finalizar");
                break;
            case R.id.rb_no_1p_3r:
                numero_preg.setText("2 de 2");
                aceptar.setText("Finalizar");
                break;
            case R.id.rb_otro_1p_3r:
                numero_preg.setText("2 de 3");
                aceptar.setText("Siguiente");
                break;
        }
    }
}

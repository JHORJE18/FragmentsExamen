package com.example.jhorje.jorgelopezgilexamen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragBotonera.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragBotonera#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragBotonera extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Variables
    private Button btnDatosPersonales;
    private Button btnAficiones;
    private ImageButton btnInfo;
        //Fragments
        private FragmentManager fm;
        private FragmentTransaction ft;

    private OnFragmentInteractionListener mListener;

    public FragBotonera() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragBotonera.
     */
    // TODO: Rename and change types and number of parameters
    public static FragBotonera newInstance(String param1, String param2) {
        FragBotonera fragment = new FragBotonera();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_botonera, container, false);

        //Añadimos valores de los botones
        btnDatosPersonales = (Button) v.findViewById(R.id.btn_dades_personals);
        btnAficiones = (Button) v.findViewById(R.id.btn_aficions);
        btnInfo = (ImageButton) v.findViewById(R.id.btn_info);

        //Añadimos listener de los botones
        btnDatosPersonales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Datos personales",Toast.LENGTH_SHORT).show();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.add(R.id.framePrincipal,DatosPersonalesFragment.newInstance("",""));
                ft.commit();

                MainActivity.mostrando = true;
            }
        });
        btnAficiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Aficiones",Toast.LENGTH_SHORT).show();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.add(R.id.framePrincipal,AficionesFragment.newInstance("",""));
                ft.commit();

                MainActivity.mostrando = true;
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Info",Toast.LENGTH_SHORT).show();
                MainActivity valores = (MainActivity) getActivity();

                //Iniciamos activity mandandole parametros
                Intent intent;
                intent = new Intent(valores,ActivityInfo.class);
                startActivity(intent);

                //Datos guardados
                String nombre_apedillos = valores.nombre_apedillos;
                String edad = valores.edad;
                String sexo = valores.sexo;
                String lectura = valores.lectura;
                String puntuacion = valores.puntuacion;

                //Incluimos valores al intent
                intent.putExtra("nombre_apedillos", nombre_apedillos);
                intent.putExtra("edad", edad);
                intent.putExtra("sexo", sexo);
                intent.putExtra("lectura", lectura);
                intent.putExtra("puntuacion", puntuacion);

                startActivity(intent);
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

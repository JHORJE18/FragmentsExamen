package com.example.jhorje.jorgelopezgilexamen;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jhorje.jorgelopezgilexamen.DatosPersonalesFragment.enviarDatosPersonales;
import com.example.jhorje.jorgelopezgilexamen.AficionesFragment.enviarAficiones;

public class MainActivity extends AppCompatActivity implements enviarAficiones, enviarDatosPersonales, FragBotonera.OnFragmentInteractionListener{

    //Variables
    public static boolean mostrando;      //Variable que determina si se esta mostrando algo en pantalla

        //Datos a guardar
        public String nombre_apedillos;
        public String edad;
        public String sexo;
        public String lectura;
        public String puntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Gestor boton atrás
    @Override
    public void onBackPressed() {
        FragmentTransaction ft;
        android.app.FragmentManager fm;
        fm = getFragmentManager();
        ft = fm.beginTransaction();

        if (mostrando){
            ft.remove(getFragmentManager().findFragmentById(R.id.framePrincipal));
            ft.commit();

            Toast.makeText(getApplicationContext(),"Fragment eliminado",Toast.LENGTH_LONG).show();
            mostrando = false;
        } else {
            //Si no hay ningun fragment, sal de la aplicación
            super.onBackPressed();
        }
    }

    public void onFragmentInteraction(Uri uri){}

    //Recibir Datos Personales
    @Override
    public void recibirDatosPersonales(String nameApedillos, String age, String sex) {
        nombre_apedillos = nameApedillos;
        edad = age;
        sexo = sex;
        Log.d("#DATOS","Datos del Datos Personales recibidos!");
    }

    //Recibir Aficiones
    @Override
    public void recibirAficiones(String lecture, float points) {
        lectura = lecture;
        puntuacion = Float.toString(points);
        Log.d("#DATOS","Datos del Aficiones recibidos!");
    }

    //Al volver del SubActivity
    @Override
    protected void onResume() {


        super.onResume();
    }
}

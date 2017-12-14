package com.example.jhorje.jorgelopezgilexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityInfo extends AppCompatActivity {

    //Elementos vista
    TextView txtNombreApedillos, txtEdad, txtSexo, txtPuntuacion, txtLectura;
    Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Conectamos Vista - Controlador
        txtNombreApedillos = (TextView) findViewById(R.id.txtNombreApedillos);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        txtSexo = (TextView) findViewById(R.id.txtSexo);
        txtPuntuacion = (TextView) findViewById(R.id.txtPuntuacion);
        txtLectura = (TextView) findViewById(R.id.txtLecturas);
        btnCerrar = (Button) findViewById(R.id.btnCerrarInfo);

        //Recibimos parametros
        Intent intent = getIntent();
        txtNombreApedillos.setText(intent.getStringExtra("nombre_apedillos"));
        txtEdad.setText(intent.getStringExtra("edad"));
        txtSexo.setText(intent.getStringExtra("sexo"));
        txtPuntuacion.setText(intent.getStringExtra("puntuacion"));
        txtLectura.setText(intent.getStringExtra("lectura"));

        //Cerrar activity
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

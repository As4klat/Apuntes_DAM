package com.example.examen_android_gamaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class Entrada extends AppCompatActivity {

    protected Button btnIntroducir,btnModificar, btnBuscar;
    protected EditText editPalabraEspanol,editPalabraIngles,editBusqueda;
    private Palabra palabraAModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        final ControladorBd controladorBd = new ControladorBd(getApplicationContext());
        editPalabraEspanol = findViewById(R.id.editPalabraEspanol);
        editPalabraIngles = findViewById(R.id.editPalabraIngles);
        editBusqueda = findViewById(R.id.editBusqueda);

        btnIntroducir = findViewById(R.id.btnIntroducir);
        btnIntroducir.setOnClickListener(view -> {
            Date fechaActual = new Date();
            controladorBd.agregarPalabra(new Palabra(
                    -1,
                    0,
                    editPalabraEspanol.getText().toString(),
                    editPalabraIngles.getText().toString(),
                    fechaActual.toString(),
                    ""
            ));
            editBusqueda.setText("");
            editPalabraEspanol.setText("");
            editPalabraIngles.setText("");
            Toast.makeText(getApplicationContext(),"Se agrego correctamente su palabra", Toast.LENGTH_SHORT).show();
        });
        btnModificar = findViewById(R.id.btnModificar);
        btnModificar.setOnClickListener(view -> {
            palabraAModificar.setPalabra_espanol(editPalabraEspanol.getText().toString());
            palabraAModificar.setPalabra_ingles(editPalabraIngles.getText().toString());
            controladorBd.editarPalabra(palabraAModificar);
            editBusqueda.setText("");
            editPalabraEspanol.setText("");
            editPalabraIngles.setText("");
            Toast.makeText(getApplicationContext(),"Se actualizo correctamente", Toast.LENGTH_SHORT).show();
        });

        btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(view -> {
            palabraAModificar = controladorBd.buscarPalabra(editBusqueda.getText().toString());
            editPalabraEspanol.setText(palabraAModificar.getPalabra_espanol());
            editPalabraIngles.setText(palabraAModificar.getPalabra_ingles());
        });
    }
}
package com.example.examen_android_gamaza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Tests extends AppCompatActivity {

    private RecyclerView listaPalabrasRecyclerTest;
    private PalabrasPreAdapter palabrasPreAdapterTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        final ControladorBd controladorBd = new ControladorBd(getApplicationContext());
        Diccionario diccionario = new Diccionario(controladorBd.mostrarPalabras());
        List<Palabra> listaPalabras = diccionario.listaDesordenada();

        listaPalabrasRecyclerTest = findViewById(R.id.listaPalabrasRecyclerTest);

        LinearLayoutManager linearLayoutManagerTest = new LinearLayoutManager(this);
        listaPalabrasRecyclerTest.setLayoutManager(linearLayoutManagerTest);
        palabrasPreAdapterTest = new PalabrasPreAdapter(listaPalabras);
        listaPalabrasRecyclerTest.setAdapter(palabrasPreAdapterTest);

    }
}
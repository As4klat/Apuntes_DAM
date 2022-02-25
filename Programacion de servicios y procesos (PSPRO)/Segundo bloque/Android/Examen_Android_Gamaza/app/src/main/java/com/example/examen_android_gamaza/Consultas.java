package com.example.examen_android_gamaza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class Consultas extends AppCompatActivity {

    private RecyclerView listaPalabrasRecycler;
    private PalabrasPreAdapter palabrasPreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        final ControladorBd controladorBd = new ControladorBd(getApplicationContext());

        listaPalabrasRecycler = findViewById(R.id.listaPalabrasRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listaPalabrasRecycler.setLayoutManager(linearLayoutManager);
        palabrasPreAdapter = new PalabrasPreAdapter(controladorBd.mostrarPalabras());
        listaPalabrasRecycler.setAdapter(palabrasPreAdapter);
    }
}
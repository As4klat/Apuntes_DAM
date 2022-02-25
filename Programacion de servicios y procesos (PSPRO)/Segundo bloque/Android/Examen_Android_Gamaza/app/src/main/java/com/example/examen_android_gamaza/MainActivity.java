package com.example.examen_android_gamaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button btnEntrada,btnConsulta,btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrada = findViewById(R.id.btnEntrada);
        btnEntrada.setOnClickListener(view -> {
            Intent i = new Intent(this, Entrada.class);
            startActivity(i);
        });
        btnConsulta = findViewById(R.id.btnConsulta);
        btnConsulta.setOnClickListener(view -> {
            Intent i = new Intent(this, Consultas.class);
            startActivity(i);
        });
        btnTest = findViewById(R.id.btnTest);
        btnTest.setOnClickListener(view -> {
            Intent i = new Intent(this, Tests.class);
            startActivity(i);
        });
    }
}
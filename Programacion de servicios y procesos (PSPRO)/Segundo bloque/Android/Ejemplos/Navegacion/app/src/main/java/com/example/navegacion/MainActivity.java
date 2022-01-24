package com.example.navegacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero = 1;
    }

    public void lanzarOtraActividad(View view){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

    public int getNumero(){
        return numero;
    }
}
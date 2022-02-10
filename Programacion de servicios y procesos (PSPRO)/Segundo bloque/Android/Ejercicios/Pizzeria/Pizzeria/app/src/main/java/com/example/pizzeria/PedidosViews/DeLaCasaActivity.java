package com.example.pizzeria.PedidosViews;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.controls.Control;
import android.view.View;

import com.example.pizzeria.R;

import java.io.Serializable;

import Clases.Pizza;
import Clases.PizzasPreAdapter;
import Clases.RecyclerItemClickListener;
import Controlador.Controlador;

public class DeLaCasaActivity extends AppCompatActivity {
    private RecyclerView listaPredeterminadas;
    private PizzasPreAdapter pizzasPreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_la_casa);

        listaPredeterminadas = findViewById(R.id.listaPredeterminadas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listaPredeterminadas.setLayoutManager(linearLayoutManager);

        pizzasPreAdapter = new PizzasPreAdapter(Controlador.PizzasDeLaCasa());
        listaPredeterminadas.setAdapter(pizzasPreAdapter);
        listaPredeterminadas.addOnItemTouchListener(
                new RecyclerItemClickListener(this, listaPredeterminadas, (view, position) -> {
                    Pizza pizza = Controlador.PizzasDeLaCasa().get(position);
                    Intent i = new Intent(view.getContext(), PizzaInfoActivity.class);
                    i.putExtra("pizza", pizza);
                    startActivity(i);
                })
        );
    }
}
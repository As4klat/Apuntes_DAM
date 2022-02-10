package com.example.pizzeria.PedidosViews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pizzeria.R;

import Clases.Pizza;

public class PizzaInfoActivity extends AppCompatActivity {

    TextView textNombrePizza;
    TextView textIngredientesPizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_info);
        Pizza pizza = (Pizza) getIntent().getExtras().getSerializable("pizza");
        textNombrePizza = findViewById(R.id.textNombrePizza);
        textNombrePizza.setText(pizza.getNombre());
        textIngredientesPizza = findViewById(R.id.textIngredientesPizza);
        textIngredientesPizza.setText(pizza.ingredientesToString());
    }
}
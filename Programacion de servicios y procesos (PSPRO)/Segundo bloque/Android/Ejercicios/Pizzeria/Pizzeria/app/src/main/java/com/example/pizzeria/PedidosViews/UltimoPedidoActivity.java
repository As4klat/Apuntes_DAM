package com.example.pizzeria.PedidosViews;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pizzeria.R;

import Clases.Pizza;
import Controlador.Controlador;

public class UltimoPedidoActivity extends AppCompatActivity {
    TextView textNombrePizzaRepe;
    TextView textIngredientesPizzaRepe;
    Button btnVolverPedir;
    Pizza pizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimo_pedido);

        textNombrePizzaRepe = findViewById(R.id.textNombrePizzaRepe);
        textIngredientesPizzaRepe = findViewById(R.id.textIngredientesPizzaRepe);
        btnVolverPedir = findViewById(R.id.btnVolverPedir);
        btnVolverPedir.setOnClickListener(view ->{
            if(pizza != null){
                Intent i = new Intent(view.getContext(), PizzaInfoActivity.class);
                i.putExtra("pizza", pizza);
                startActivity(i);
            }else{
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Pizza Not Found :(");
                alertDialog.setMessage("Aún no has pedido, ve a pedidos y pidete una.");
                alertDialog.show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    protected void onResume() {
        super.onResume();
        SharedPreferences loadPrefs = getSharedPreferences("ultimo_pedido", Context.MODE_PRIVATE);
        int id = loadPrefs.getInt("id",-1);
        String nombre = loadPrefs.getString("nombre","");
        String ingredientes = loadPrefs.getString("ingredientes","");
        pizza = null;
        if(!ingredientes.equals("")){

            pizza = new Pizza(id,nombre,ingredientes.split(";"));
            textNombrePizzaRepe.setText(pizza.getNombre());
            textIngredientesPizzaRepe.setText(pizza.ingredientesToString());
        }
        else{
            textNombrePizzaRepe.setText("Aún no has pedido!");
        }


    }
}


package com.example.pizzeria.PedidosViews;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pizzeria.HomeActivity;
import com.example.pizzeria.R;

import Clases.Pizza;

public class PizzaInfoActivity extends AppCompatActivity {

    TextView textNombrePizza;
    TextView textIngredientesPizza;
    Button btnRealizarPedido;
    ProgressBar progressBar;
    Pizza pizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_info);
        pizza = (Pizza) getIntent().getExtras().getSerializable("pizza");

        textNombrePizza = findViewById(R.id.textNombrePizza);
        textNombrePizza.setText(pizza.getNombre());
        textIngredientesPizza = findViewById(R.id.textIngredientesPizza);
        textIngredientesPizza.setText(pizza.ingredientesToString());
        btnRealizarPedido = findViewById(R.id.btnRealizarPedido);

        btnRealizarPedido.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            View progressBarView = inflater.inflate(R.layout.progress_bar, null);
            progressBar = progressBarView.findViewById(R.id.progressBar);
            builder.setView(progressBarView);
            builder.setTitle("Tramitando pedido");
            builder.setCancelable(false);
            AlertDialog alert = builder.create();
            alert.show();
            Thread h = new Thread(() -> {
                int porcentaje = 0;

                while (porcentaje <= 100){
                    progressBar.setProgress(porcentaje);
                    try {
                        Thread.sleep(200);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    porcentaje++;
                }
                alert.dismiss();
                redirecionarMenu();
            });
            h.start();
        });
        SharedPreferences savePrefs = getSharedPreferences("ultimo_pedido", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = savePrefs.edit();
        editor.putInt("id", pizza.getId());
        editor.putString("nombre", pizza.getNombre());
        editor.putString("ingredientes", pizza.ingredientesToFormatCSV());
        editor.apply();
    }

    private void redirecionarMenu(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }
}


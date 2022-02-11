package com.example.pizzeria.PedidosViews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pizzeria.R;

import Clases.Pizza;
import Controlador.Controlador;

public class AtuGustoActivity extends AppCompatActivity {

    ListView listViewIngredientes;
    ArrayAdapter<String> adapter;
    String[] arrayIngredientes = {"Tomate","Queso","Queso suave","Queso azul","Mozzarella",
            "Jamón","Salchichas","Pimientos","Atún",
            "Bacon","pollo","Pepperoni","Aceitunas","Salami","Piña"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atu_gusto);

        listViewIngredientes = findViewById(R.id.listViewIngredientes);
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                arrayIngredientes);
        listViewIngredientes.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if(id == R.id.item_done){
            String itemSelected = "";
            for(int i = 0; i < listViewIngredientes.getCount(); i++){
                if(listViewIngredientes.isItemChecked(i)){
                    itemSelected += listViewIngredientes.getItemAtPosition(i) + ";";
                }
            }
            if(!itemSelected.equals("")){
                Pizza pizza = new Pizza(-1,"Al gusto",itemSelected.split(";"));
                Intent i = new Intent(this, PizzaInfoActivity.class);
                i.putExtra("pizza", pizza);
                startActivity(i);
            }
            else{
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("No puedes avanzar si no creas tu pizza :(");
                alertDialog.show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
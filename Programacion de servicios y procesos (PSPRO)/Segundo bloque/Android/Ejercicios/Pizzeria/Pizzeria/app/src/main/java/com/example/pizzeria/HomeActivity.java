package com.example.pizzeria;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pizzeria.PedidosViews.PedidosActivity;

import Controlador.LoginStatusUser;

public class HomeActivity extends AppCompatActivity {

    TextView textUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textUsuario = findViewById(R.id.textUsuario);

        if(LoginStatusUser.getUser().getNombre()==null){
            textUsuario.setText(LoginStatusUser.getUser().getEmail());
        }else{
            textUsuario.setText(LoginStatusUser.getUser().getNombre());
        }

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder builderalert = new AlertDialog.Builder(HomeActivity.this);
                builderalert.setTitle("Salir de la aplicación");
                builderalert.setMessage("¿Deseas cerrar sesión?")
                        .setPositiveButton("Confirmar", (dialog, id) -> {
                            finishAffinity();
                        })
                        .setNegativeButton("Cancelar", (dialog, id) -> {

                        });
                AlertDialog alertDialog = builderalert.create();
                alertDialog.show();
            }
        };
        this.getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (LoginStatusUser.getUser().getNombre() == null) {
            textUsuario.setText(LoginStatusUser.getUser().getEmail());
        } else {
            textUsuario.setText(LoginStatusUser.getUser().getNombre());
        }
    }

    public void onMenuBtnCliked(View v) {
        Intent i = null;
        switch (v.getId()){
            case R.id.btnConfig:
                i = new Intent(this, ConfigActivity.class);
                break;
            case R.id.btnWeb:
                Uri uri = Uri.parse("https://www.dominospizza.es/carta-de-pizzas");
                i = new Intent(Intent.ACTION_VIEW, uri);
                break;
            case R.id.btnPedido:
                i = new Intent(this, PedidosActivity.class);
                break;
        }
        startActivity(i);
    }
}
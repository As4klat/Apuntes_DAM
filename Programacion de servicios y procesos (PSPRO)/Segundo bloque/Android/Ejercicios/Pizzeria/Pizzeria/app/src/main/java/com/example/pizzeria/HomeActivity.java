package com.example.pizzeria;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.PedidosViews.PedidosActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog alertDialog = new AlertDialog.Builder(getBaseContext()).create();
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("El usuario o la contaseña es incorrecto.");
                alertDialog.show();
            }
        };
        this.getOnBackPressedDispatcher().addCallback(this, callback);
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
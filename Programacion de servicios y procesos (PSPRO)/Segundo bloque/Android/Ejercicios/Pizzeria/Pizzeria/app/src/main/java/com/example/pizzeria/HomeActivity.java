package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.PedidosViews.PedidosActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onMenuBtnCliked(View v) {
        Intent i = null;
        switch (v.getId()){
            case R.id.btnConfig:
                i = new Intent(this, ConfigActivity.class);
                break;
            case R.id.btnWeb:
                i = new Intent(this, WebActivity.class);
                break;
            case R.id.btnPedido:
                i = new Intent(this, PedidosActivity.class);
                break;
        }
        startActivity(i);
    }
}
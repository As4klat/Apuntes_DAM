package com.example.pizzeria.PedidosViews;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzeria.ConfigActivity;
import com.example.pizzeria.R;

public class PedidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);


    }

    public void onMenuPedidoBtnCliked(View v) {
        Intent i = null;
        switch (v.getId()){
            case R.id.btnUltimaPizza:
                i = new Intent(this, AtuGustoActivity.class);
                break;
            case R.id.btnPedidosAtuGusto:
                i = new Intent(this, UltimoPedidoActivity.class);
                break;
            case R.id.btnPedidosPredeterminadas:
                i = new Intent(this, DeLaCasaActivity.class);
                break;
        }
        startActivity(i);
    }
}
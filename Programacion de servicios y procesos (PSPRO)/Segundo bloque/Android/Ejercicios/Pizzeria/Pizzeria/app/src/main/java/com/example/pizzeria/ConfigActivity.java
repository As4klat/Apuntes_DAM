package com.example.pizzeria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import Clases.Usuario;
import Controlador.Controlador;
import Controlador.LoginStatusUser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {
    Button btnGuardarCambios;
    EditText inNombreConfig;
    EditText inApellidosConfig;
    EditText inEmailConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        /*
        inNombreConfig = findViewById(R.id.inNombreConfig);
        inApellidosConfig = findViewById(R.id.inApellidosConfig);
        inEmailConfig = findViewById(R.id.inEmailConfig);

        inNombreConfig.setText(LoginStatusUser.getUser().getEmail());
        if (!LoginStatusUser.getUser().getNombre().equals("null")) {
            inNombreConfig.setText(LoginStatusUser.getUser().getNombre());
        }
        if (!LoginStatusUser.getUser().getApellidos().equals("null")) {
            inApellidosConfig.setText(LoginStatusUser.getUser().getApellidos());
        }

        btnGuardarCambios = findViewById(R.id.btnSaveOptions);
        btnGuardarCambios.setOnClickListener(view -> {
            Usuario userMod = new Usuario(
                    inEmailConfig.getText().toString(),
                    LoginStatusUser.getUser().getPassword(),
                    inNombreConfig.getText().toString(),
                    inApellidosConfig.getText().toString(),
                    1,
                    null);
            if(Controlador.ActualizarUsuario(userMod)){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("No se ha podido modificar el usuario.");
                alertDialog.show();
            }else {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Erorabuena");
                alertDialog.setMessage("Se ha modificado el usuario satifactoriamente.");
                alertDialog.show();
            }

        });*/
    }
}
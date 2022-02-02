package com.example.pizzeria.auth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pizzeria.HomeActivity;
import com.example.pizzeria.R;
import com.google.android.material.snackbar.Snackbar;

import Controlador.Controlador;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText inEmail,inPasswd,inConfirmPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inEmail = findViewById(R.id.inEmail);
        inPasswd = findViewById(R.id.inPasswd);
        inConfirmPasswd = findViewById(R.id.inConfirmPasswd);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(view -> {
            String email = inEmail.getText().toString();
            String passwd = inPasswd.getText().toString();
            String confirmPasswd = inConfirmPasswd.getText().toString();
            if(passwd.equals(confirmPasswd)){
                if(!Controlador.usuarioExist(email)){
                    Controlador.registrarUsuario(email,passwd);
                    inEmail.setText("");
                    inPasswd.setText("");
                    inConfirmPasswd.setText("");
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                    Snackbar.make(findViewById(R.id.btnLogin), "Usuario creado satifactoriamente!",
                            Snackbar.LENGTH_SHORT)
                            .show();
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("Error al crear usuario:");
                    alertDialog.setMessage("El usuario ya existe.");
                    alertDialog.show();
                }

            }
            else
            {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("Las contraseñas no coinciden.");
                alertDialog.show();
            }
        });
    }
}
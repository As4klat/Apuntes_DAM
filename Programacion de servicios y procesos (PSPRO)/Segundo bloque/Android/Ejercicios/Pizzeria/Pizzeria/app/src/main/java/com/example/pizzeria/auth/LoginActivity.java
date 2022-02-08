package com.example.pizzeria.auth;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import Controlador.*;

import com.example.pizzeria.HomeActivity;
import com.example.pizzeria.R;

import Controlador.Controlador;

public class LoginActivity extends AppCompatActivity {

    private EditText textEmail;
    private EditText textPasswd;
    private Button btnLogin;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmail = findViewById(R.id.inEmail);
        textPasswd = findViewById(R.id.inPasswd);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> {
            boolean error = Controlador.comprobarLogin(textEmail.getText().toString(),textPasswd.getText().toString());

            if(error){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Error!");
                alertDialog.setMessage("El usuario o la contaseña es incorrecto.");
                alertDialog.show();
            }
            else{
                LoginStatusUser.setUser(Controlador.tomarUsuario(textEmail.getText().toString()));
                Intent i = new Intent(btnLogin.getContext(), HomeActivity.class);
                startActivity(i);
            }
        });
    }

    public void loginToRegister(View view){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}
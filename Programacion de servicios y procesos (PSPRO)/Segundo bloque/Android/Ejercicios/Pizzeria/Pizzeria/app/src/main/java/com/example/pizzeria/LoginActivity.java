package com.example.pizzeria;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import Controlador.*;
import android.widget.TextView;
import android.widget.Toast;

import Controlador.Controlador;

public class LoginActivity extends AppCompatActivity {

    private EditText textEmail;
    private EditText textPasswd;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmail = findViewById(R.id.inEmail);
        textPasswd = findViewById(R.id.inPasswd);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                boolean error = Controlador.comprobarLogin("KSNDPK","ñksndkvñ");

                if(error){
                    System.out.println("El usuario o la contraseña es incorrecto.");
                }
                else{
                    LoginStatus.setUser(Controlador.tomarUsuario(textEmail.getText().toString()));
                    Intent i = new Intent(btnLogin.getContext(), HomeActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    public void loginToRegister(View view){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}
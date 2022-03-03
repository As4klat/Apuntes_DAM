package com.example.pizzeria;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import Clases.Usuario;
import Controlador.Controlador;
import Controlador.LoginStatusUser;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

public class ConfigActivity extends AppCompatActivity {
    private Button btnGuardarCambios;
    private EditText inNombreConfig;
    private EditText inApellidosConfig;
    private EditText inEmailConfig;
    private EditText inNewPasswd;
    private EditText inConfirmNewPasswd;
    private SwitchCompat sModeOscure;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        inNombreConfig = findViewById(R.id.inNombreConfig);
        inApellidosConfig = findViewById(R.id.inApellidosConfig);
        inEmailConfig = findViewById(R.id.inEmailConfig);
        inNewPasswd = findViewById(R.id.inNewPasswd);
        inConfirmNewPasswd = findViewById(R.id.inConfirmNewPasswd);
        sModeOscure = findViewById(R.id.sModeOscure);
        sModeOscure.setOnClickListener(view -> {
            if(sModeOscure.isChecked()){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            recreate();
        });

        inEmailConfig.setText(LoginStatusUser.getUser().getEmail());
        if (LoginStatusUser.getUser().getNombre() != null) {
            inNombreConfig.setText(LoginStatusUser.getUser().getNombre());
        }
        if (LoginStatusUser.getUser().getApellidos() != null) {
            inApellidosConfig.setText(LoginStatusUser.getUser().getApellidos());
        }

        btnGuardarCambios = findViewById(R.id.btnSaveOptions);
        btnGuardarCambios.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ConfigActivity.this);
            LayoutInflater inflater = this.getLayoutInflater();

            View dialogView = inflater.inflate(R.layout.alerta_confirma_contrasena, null);
            EditText oldPasswd = dialogView.findViewById(R.id.inOldPasswd);
            builder.setView(dialogView)
                    .setPositiveButton("Confirmar", (dialog, id) -> {
                        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                        String old = oldPasswd.getText().toString();
                        if(!Controlador.comprobarLogin(LoginStatusUser.getUser().getEmail(),oldPasswd.getText().toString())){
                            actualizarUsuario(alertDialog);
                        }else
                        {
                            alertDialog.setTitle("Error!");
                            alertDialog.setMessage("La contraseña es incorrecta.");
                            alertDialog.show();
                        }
                    })
                    .setNegativeButton("Cancelar", (dialog, id) -> {
                    });
            builder.create().show();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            sModeOscure.setChecked(true);
        }
    }

    private void actualizarUsuario(AlertDialog alertDialog){
        if(inNombreConfig.getText().toString().equals("")){
            inNombreConfig.setText(null);
        }
        if(inApellidosConfig.getText().toString().equals("")){
            inApellidosConfig.setText(null);
        }
        if(inNewPasswd.getText().toString().equals(inConfirmNewPasswd.getText().toString()) ||
                (inNewPasswd.getText().toString().equals("") && inConfirmNewPasswd.getText().toString().equals(""))){
            if(inNewPasswd.getText().toString().equals("")){
                inNewPasswd.setText(LoginStatusUser.getUser().getPassword());
            }
            Usuario userMod = new Usuario(
                    inEmailConfig.getText().toString(),
                    inNewPasswd.getText().toString(),
                    inNombreConfig.getText().toString(),
                    inApellidosConfig.getText().toString(),
                    1,
                    null);

            switch (Controlador.ActualizarUsuario(userMod)){
                case 0:
                    alertDialog.setTitle("Erorabuena");
                    alertDialog.setMessage("Se ha modificado el usuario satifactoriamente.");
                    alertDialog.show();
                    break;
                case 1:
                    alertDialog.setTitle("Error!");
                    alertDialog.setMessage("No se ha podido modificar el usuario.");
                    alertDialog.show();
                    break;
                case 2:
                    alertDialog.setTitle("Error!");
                    alertDialog.setMessage("El correo ya existe.");
                    alertDialog.show();
                    break;
            }
            inNewPasswd.setText("");
            inConfirmNewPasswd.setText("");
        }
        else{
            alertDialog.setTitle("Error!");
            alertDialog.setMessage("Las contraseñas no coinciden.");
            alertDialog.show();
        }
    }
}
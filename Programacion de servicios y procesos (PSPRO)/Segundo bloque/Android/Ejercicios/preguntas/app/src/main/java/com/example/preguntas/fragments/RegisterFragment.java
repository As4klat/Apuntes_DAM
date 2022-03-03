package com.example.preguntas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.preguntas.Clases.Usuario;
import com.example.preguntas.Controller.ControladorUsuario;
import com.example.preguntas.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

public class RegisterFragment extends Fragment {
    private static final String TEXT = "text";
    private Button btnRegister;
    private EditText inEmail,inPasswd,inConfirmPasswd;

    public static RegisterFragment newInstance(String text) {
        RegisterFragment frag = new RegisterFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.register_fragment, container, false);

        inEmail = layout.findViewById(R.id.inEmail);
        inPasswd = layout.findViewById(R.id.inPasswd);
        inConfirmPasswd = layout.findViewById(R.id.inConfirmPasswd);
        btnRegister = layout.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(view -> {
            String email = inEmail.getText().toString();
            String passwd = inPasswd.getText().toString();
            String confirmPasswd = inConfirmPasswd.getText().toString();
            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
            if(comprobarCampos(email,passwd)){
                if(passwd.equals(confirmPasswd)){
                    HashMap <String,String> conexion = ControladorUsuario.getInstance(getContext()).registrarse(
                            new Usuario(email,passwd)
                    );
                    alertDialog.setMessage(conexion.get("mensaje"));
                    if(conexion.get("status").equals("ok")){
                        ControladorUsuario.getInstance(getContext()).login(email,passwd);
                        Fragment fragment = InicioFragment.newInstance(getString(R.string.inicio_string));
                        getParentFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit)
                                .replace(R.id.home_content, fragment)
                                .commit();
                    }
                }
                else{
                    alertDialog.setMessage("Las contraseña debe coincidir.");
                }
            }else{
                alertDialog.setMessage("Campos vacios.");
            }
            alertDialog.show();
        });

        return layout;
    }

    public boolean comprobarCampos(String email, String password){
        boolean valido = false;
        if(!email.equals("")&&!password.equals("")){
            valido=true;
        }
        return valido;
    }
}

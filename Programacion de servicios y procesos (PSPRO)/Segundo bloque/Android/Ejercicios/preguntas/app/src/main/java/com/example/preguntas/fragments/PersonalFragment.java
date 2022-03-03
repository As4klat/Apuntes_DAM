package com.example.preguntas.fragments;

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
import com.example.preguntas.Controller.LoginStatus;
import com.example.preguntas.R;

import java.util.HashMap;

public class PersonalFragment extends Fragment {
    private static final String TEXT = "text";
    private Button btnGuardarCambios;
    private EditText inNombreConfig,inEmailConfig,inNewPasswd,inConfirmNewPasswd,inOldPasswd;


    public static PersonalFragment newInstance(String text) {
        PersonalFragment frag = new PersonalFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.personal_fragment, container, false);

        inNombreConfig = layout.findViewById(R.id.inNombreConfig);
        inEmailConfig = layout.findViewById(R.id.inEmailConfig);
        inNewPasswd = layout.findViewById(R.id.inNewPasswd);
        inConfirmNewPasswd = layout.findViewById(R.id.inConfirmNewPasswd);

        inEmailConfig.setText(LoginStatus.devolverUsuario().getEmail());
        if (LoginStatus.devolverUsuario().getNombre() != null) {
            inNombreConfig.setText(LoginStatus.devolverUsuario().getNombre());
        }

        btnGuardarCambios = layout.findViewById(R.id.btnSaveOptions);
        btnGuardarCambios.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            LayoutInflater inflaterNew = this.getLayoutInflater();

            View dialogView = inflaterNew.inflate(R.layout.alerta_confirma_contrasena, null);
            EditText oldPasswd = dialogView.findViewById(R.id.inOldPasswd);
            builder.setView(dialogView)
                    .setPositiveButton("Confirmar", (dialog, id) -> {
                        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                        String old = oldPasswd.getText().toString();
                        Usuario user = LoginStatus.devolverUsuario();
                        if(user.getPassword().equals(old)){
                            user.setEmail(inEmailConfig.getText().toString());
                            user.setNombre(inNombreConfig.getText().toString());
                            if(!inNewPasswd.getText().toString().equals("")){
                                user.setPassword(inNewPasswd.getText().toString());
                            }
                            if(inNewPasswd.getText().toString().equals(inConfirmNewPasswd.getText().toString())){
                                HashMap<String,String> conexion = ControladorUsuario.getInstance(getContext()).editarUsuario(user);
                                alertDialog.setMessage(conexion.get("mensaje"));
                                if(conexion.get("status").equals("ok")){
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
                        }else
                        {
                            alertDialog.setMessage("La contraseña es incorrecta.");
                        }
                        alertDialog.show();
                    })
                    .setNegativeButton("Cancelar", (dialog, id) -> {
                    });
            builder.create().show();
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

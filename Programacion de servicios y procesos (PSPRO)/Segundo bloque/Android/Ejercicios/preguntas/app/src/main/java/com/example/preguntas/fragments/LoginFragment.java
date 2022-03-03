package com.example.preguntas.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.preguntas.Controller.ControladorUsuario;
import com.example.preguntas.R;

public class LoginFragment extends Fragment {
    private static final String TEXT = "text";
    private EditText email,password;
    private Button btnLogin;

    public static LoginFragment newInstance(String text) {
        LoginFragment frag = new LoginFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.login_fragment, container, false);

        email = layout.findViewById(R.id.inEmail);
        password = layout.findViewById(R.id.inPasswd);
        btnLogin = layout.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener( view -> {
            if(ControladorUsuario.getInstance(this.getContext()).login(email.getText().toString(),password.getText().toString())){
                Toast.makeText(this.getContext(),"El email o la contraseña invalido", Toast.LENGTH_LONG).show();
            }
            else{
                Fragment fragment = InicioFragment.newInstance(getString(R.string.inicio_string));
                getParentFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit)
                        .replace(R.id.home_content, fragment)
                        .commit();
                getActivity().setTitle(getString(R.string.inicio_string));
            }
        });

        return layout;
    }
}

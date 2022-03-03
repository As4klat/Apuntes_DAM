package com.example.preguntas.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.preguntas.R;

public class ConfigFragment extends Fragment {
    private static final String TEXT = "text";
    private RadioGroup opciones_npreguntas;
    private Button btnCrearPregunta, btnEditarPregunta, btnActualizar;

    public static ConfigFragment newInstance(String text) {
        ConfigFragment frag = new ConfigFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.config_fragment, container, false);
        opciones_npreguntas = layout.findViewById(R.id.opciones_npreguntas);

        btnCrearPregunta = layout.findViewById(R.id.btnCrearPregunta);
        btnCrearPregunta.setOnClickListener(view -> {
            Fragment fragment = CrearPreguntaFragment.newInstance("Crear Pregunta");
            getParentFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit)
                    .replace(R.id.home_content, fragment)
                    .commit();
            getActivity().setTitle("Crear Pregunta");
        });

        btnEditarPregunta = layout.findViewById(R.id.btnEditarPregunta);
        btnEditarPregunta.setOnClickListener(view -> {
            Fragment fragment = EditarPreguntaFragment.newInstance("Editar Pregunta");
            getParentFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit)
                    .replace(R.id.home_content, fragment)
                    .commit();
            getActivity().setTitle("Editar Pregunta");
        });

        btnActualizar = layout.findViewById(R.id.btnActualizar);
        btnActualizar.setOnClickListener(view -> {
            switch (opciones_npreguntas.getCheckedRadioButtonId()){
                case R.id.opcion15:

                    break;
                case R.id.opcion10:

                    break;
                case R.id.opcion5:

                    break;
                default:
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
        return layout;
    }
}

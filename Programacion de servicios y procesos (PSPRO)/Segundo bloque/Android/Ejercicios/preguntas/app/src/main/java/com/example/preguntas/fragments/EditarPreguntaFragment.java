package com.example.preguntas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.preguntas.Clases.Pregunta;
import com.example.preguntas.Clases.PreguntaPreAdapter;
import com.example.preguntas.Clases.RecyclerItemClickListener;
import com.example.preguntas.Controller.ControladorPreguntas;
import com.example.preguntas.R;

import java.io.Serializable;

public class EditarPreguntaFragment extends Fragment {
    private static final String TEXT = "text";
    private RecyclerView listaPreguntas;
    private PreguntaPreAdapter pizzasPreAdapter;

    public static EditarPreguntaFragment newInstance(String text) {
        EditarPreguntaFragment frag = new EditarPreguntaFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.editar_pregunta_fragment, container, false);

        listaPreguntas = layout.findViewById(R.id.listaPreguntas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        listaPreguntas.setLayoutManager(linearLayoutManager);

        pizzasPreAdapter = new PreguntaPreAdapter(ControladorPreguntas.getInstance(getContext()).listaPreguntas(-1,false));
        listaPreguntas.setAdapter(pizzasPreAdapter);
        listaPreguntas.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), listaPreguntas, (view, position) -> {
                    Pregunta pregunta = ControladorPreguntas.getInstance(getContext()).listaPreguntas(-1,false).get(position);

                    Fragment fragment = ItemEditarPreguntaFragment.newInstance("Editar Pregunta " + pregunta.getId());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("pregunta", (Serializable) pregunta);
                    fragment.setArguments(bundle);
                    getParentFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit)
                            .replace(R.id.home_content, fragment)
                            .commit();
                    getActivity().setTitle("Editar Pregunta " + pregunta.getId());
                    /*
                    Intent i = new Intent(view.getContext(), PizzaInfoActivity.class);
                    i.putExtra("pizza", pizza);
                    startActivity(i);*/
                })
        );

        return layout;
    }
}

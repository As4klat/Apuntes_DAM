package com.example.preguntas.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.preguntas.Clases.Pregunta;
import com.example.preguntas.Clases.Respuesta;
import com.example.preguntas.Controller.ControladorPreguntas;
import com.example.preguntas.Controller.ControladorUsuario;
import com.example.preguntas.R;

import java.util.ArrayList;
import java.util.List;

public class CrearPreguntaFragment extends Fragment {
    private static final String TEXT = "text";
    private EditText inPregunta,inRespuesta1,inRespuesta2,inRespuesta3,inRespuesta4,inPreguntaCorrecta;
    private Button btnCrearPreguntaNueva;

    public static CrearPreguntaFragment newInstance(String text) {
        CrearPreguntaFragment frag = new CrearPreguntaFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.crear_pregunta_fragment, container, false);
        inPregunta = layout.findViewById(R.id.inPregunta);
        inRespuesta1 = layout.findViewById(R.id.inRespuesta1);
        inRespuesta2 = layout.findViewById(R.id.inRespuesta2);
        inRespuesta3 = layout.findViewById(R.id.inRespuesta3);
        inRespuesta4 = layout.findViewById(R.id.inRespuesta4);
        inPreguntaCorrecta = layout.findViewById(R.id.inPreguntaCorrecta);
        btnCrearPreguntaNueva = layout.findViewById(R.id.btnCrearPreguntaNueva);
        btnCrearPreguntaNueva.setOnClickListener(view -> {
            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
            try {
                List<Respuesta> listaRespuestas = new ArrayList<>();
                listaRespuestas.add(new Respuesta(inRespuesta1.getText().toString(),false));
                listaRespuestas.add(new Respuesta(inRespuesta2.getText().toString(),false));
                listaRespuestas.add(new Respuesta(inRespuesta3.getText().toString(),false));
                listaRespuestas.add(new Respuesta(inRespuesta4.getText().toString(),false));
                listaRespuestas.get(Integer.parseInt(inPreguntaCorrecta.getText().toString())-1).setValida(true);
                Pregunta pregunta = new Pregunta(inPregunta.getText().toString(),listaRespuestas);
                if(validar(pregunta)){
                    ControladorPreguntas.getInstance(getContext()).nuevaPregunta(pregunta);
                }
                else{
                    alertDialog.setMessage("No se pueden dejar campos vacios.");
                }

            }catch (Exception ex){
                alertDialog.setMessage("Error al crear la pregunta");
            }
            alertDialog.show();
        });

        return layout;
    }
    private boolean validar(Pregunta pregunta){
        boolean valida=true;
        if(pregunta.getPregunta().equals("")){
            valida=false;
        }else{
            for (Respuesta r:pregunta.getRespuestas()) {
                if(r.getRespuesta().equals("")){
                    valida=false;
                    break;
                }
            }
        }
        return valida;
    }
}

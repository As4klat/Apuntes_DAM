package com.example.preguntas.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.preguntas.Clases.Pregunta;
import com.example.preguntas.Clases.Respuesta;
import com.example.preguntas.Controller.ControladorPreguntas;
import com.example.preguntas.R;

import java.util.ArrayList;
import java.util.List;

public class ItemEditarPreguntaFragment extends Fragment {
    private static final String TEXT = "text";
    private List<TextView> listaText;
    private EditText inPregunta,inRespuesta1,inRespuesta2,inRespuesta3,inRespuesta4,inPreguntaCorrecta;
    private Button btnEditarPreguntaNueva;

    public static ItemEditarPreguntaFragment newInstance(String text) {
        ItemEditarPreguntaFragment frag = new ItemEditarPreguntaFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.item_editar_pregunta_fragment, container, false);
        Pregunta pregunta = (Pregunta) getArguments().getSerializable("pregunta");

        inPregunta = layout.findViewById(R.id.inPregunta);

        inPregunta.setText(pregunta.getPregunta());
        listaText = new ArrayList<>();
        listaText.add(layout.findViewById(R.id.inRespuesta1));
        listaText.add(layout.findViewById(R.id.inRespuesta2));
        listaText.add(layout.findViewById(R.id.inRespuesta3));
        listaText.add(layout.findViewById(R.id.inRespuesta4));
        int i=0;
        for (TextView t:listaText) {
            t.setText(pregunta.getRespuestas().get(i).getRespuesta());
            i++;
        }
        inPreguntaCorrecta = layout.findViewById(R.id.inPreguntaCorrecta);
        inPreguntaCorrecta.setText("1");
        btnEditarPreguntaNueva = layout.findViewById(R.id.btnEditarPreguntaNueva);
        btnEditarPreguntaNueva.setOnClickListener(view -> {
            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
            try {
                pregunta.setPregunta(inPregunta.getText().toString());
                List<Respuesta>listaRespuestas=new ArrayList<>();
                for (TextView t:listaText) {
                    listaRespuestas.add(new Respuesta(t.getText().toString(),false));
                }
                listaRespuestas.get(Integer.parseInt(inPreguntaCorrecta.getText().toString())-1).setValida(true);
                pregunta.setRespuestas(listaRespuestas);

                if(validar(pregunta)){
                    ControladorPreguntas.getInstance(getContext()).editarPregunta(pregunta);
                    alertDialog.setMessage("Pregunta modificada");
                    Fragment fragment = EditarPreguntaFragment.newInstance("Editar Pregunta");
                    getParentFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit)
                            .replace(R.id.home_content, fragment)
                            .commit();
                    getActivity().setTitle("Editar Pregunta");
                }
                else{
                    alertDialog.setMessage("No se pueden dejar campos vacios.");
                }

            }catch (Exception ex){
                alertDialog.setMessage("Error al editar la pregunta");
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

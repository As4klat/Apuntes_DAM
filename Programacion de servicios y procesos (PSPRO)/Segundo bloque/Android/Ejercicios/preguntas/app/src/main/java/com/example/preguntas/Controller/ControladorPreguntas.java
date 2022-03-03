package com.example.preguntas.Controller;

import android.content.Context;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.preguntas.BaseDatos.SQLiteBD;
import com.example.preguntas.Clases.Pregunta;
import com.example.preguntas.Clases.Respuesta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ControladorPreguntas {
    private static ControladorPreguntas controller =  null;
    private final SQLiteBD sqLiteBD;

    private ControladorPreguntas(Context context){
        sqLiteBD = new SQLiteBD(context);
    }

    public static ControladorPreguntas getInstance(Context context) {
        if (controller == null) {
            controller = new ControladorPreguntas(context);
        }
        return controller;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void nuevaPregunta(Pregunta pregunta){
        pregunta.ordenarRespuestas();
        sqLiteBD.agregarPregunta(pregunta);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void editarPregunta(Pregunta pregunta){
        pregunta.ordenarRespuestas();
        sqLiteBD.editarPregunta(pregunta);
    }

    public List<Pregunta> listaPreguntas(int nPreguntas, boolean desordenada){
        List<Pregunta> preguntas = null;
        preguntas = sqLiteBD.listarPreguntas();
        if(desordenada){
            for (Pregunta p : preguntas) {
                p.respuestasAleatorias();
            }
            Collections.shuffle(preguntas);
        }
        if(nPreguntas != -1){
            for (int i = nPreguntas; i < preguntas.size(); i++){
                preguntas.remove(i);
            }
        }
        return preguntas;
    }

    public void preCargarDatos(){
        if(sqLiteBD.isInitPreguntas()){
            List<Pregunta> listPreguntas = new ArrayList<>();
            List<Respuesta> listRespuestas = new ArrayList<>();
            String pregunta;

            //Pregunta 1
            pregunta = "¿Cuantos dioses viven a dia de hoy?";
            listRespuestas.add(new Respuesta("5", true));
            listRespuestas.add(new Respuesta("6", false));
            listRespuestas.add(new Respuesta("7", false));
            listRespuestas.add(new Respuesta("4", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 2
            listRespuestas.clear();
            pregunta = "¿Como se llama la asura que nos acompaña en la historia?";
            listRespuestas.add(new Respuesta("Taimi", true));
            listRespuestas.add(new Respuesta("Taemi", false));
            listRespuestas.add(new Respuesta("Taimy", false));
            listRespuestas.add(new Respuesta("Teimi", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 3
            listRespuestas.clear();
            pregunta = "¿Que clases son de armadura ligera?";
            listRespuestas.add(new Respuesta("Elementalista, Hipnotizador, Nigromante", true));
            listRespuestas.add(new Respuesta("Elementalista, Hipnotizador, Ladron", false));
            listRespuestas.add(new Respuesta("Guerrero, Ingeniero, Hipnotizador", false));
            listRespuestas.add(new Respuesta("Nigromante, Guardabosque, Guardian", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 4
            listRespuestas.clear();
            pregunta = "¿Cuantos dragones anciano existian antes del exodo?";
            listRespuestas.add(new Respuesta("6", true));
            listRespuestas.add(new Respuesta("5", false));
            listRespuestas.add(new Respuesta("7", false));
            listRespuestas.add(new Respuesta("2", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 5
            listRespuestas.clear();
            pregunta = "Personaje principal de la trama que porta una espada latigo";
            listRespuestas.add(new Respuesta("Canach", true));
            listRespuestas.add(new Respuesta("Logan", false));
            listRespuestas.add(new Respuesta("Tix", false));
            listRespuestas.add(new Respuesta("Marjory", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 6
            listRespuestas.clear();
            pregunta = "Año cuando los dioses le dan magia a las razas de Tyria";
            listRespuestas.add(new Respuesta("1 a.E", true));
            listRespuestas.add(new Respuesta("1 d.E", false));
            listRespuestas.add(new Respuesta("100 a.E", false));
            listRespuestas.add(new Respuesta("100 d.E", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 7
            listRespuestas.clear();
            pregunta = "Cual de las siguientes razas no perteneces a las antiguas";
            listRespuestas.add(new Respuesta("Silvari", true));
            listRespuestas.add(new Respuesta("Enanos", false));
            listRespuestas.add(new Respuesta("Videntes", false));
            listRespuestas.add(new Respuesta("Jotuns", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 8
            listRespuestas.clear();
            pregunta = "¿Que afirmación es cierta?";
            listRespuestas.add(new Respuesta("Primordius y Jormag son hermanos y sus puntos debiles son el uno contra el otro.", true));
            listRespuestas.add(new Respuesta("Primordius y Jormag no son hermanos y sus puntos debiles son el uno contra el otro.", false));
            listRespuestas.add(new Respuesta("La debilidad de Jormag es el fuego", false));
            listRespuestas.add(new Respuesta("La debilidad de Primordius es el hielo", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 9
            listRespuestas.clear();
            pregunta = "¿Quien fue el/la primer seguidor de Grenth?";
            listRespuestas.add(new Respuesta("Desmina", true));
            listRespuestas.add(new Respuesta("Kormir", false));
            listRespuestas.add(new Respuesta("Beyond", false));
            listRespuestas.add(new Respuesta("Segadores", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 10
            listRespuestas.clear();
            pregunta = "¿Quien fue el primer dios en surgir de las aguas artesianas?";
            listRespuestas.add(new Respuesta("Dwayna", true));
            listRespuestas.add(new Respuesta("Melandru", false));
            listRespuestas.add(new Respuesta("Lyssa", false));
            listRespuestas.add(new Respuesta("Balthazar", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 11
            listRespuestas.clear();
            pregunta = "¿Quien fue el famoso escultor?";
            listRespuestas.add(new Respuesta("Malchor", true));
            listRespuestas.add(new Respuesta("Malcon", false));
            listRespuestas.add(new Respuesta("Logan", false));
            listRespuestas.add(new Respuesta("Hipnos", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 12
            listRespuestas.clear();
            pregunta = "¿Que razas introducieron su poder en la hematites?";
            listRespuestas.add(new Respuesta("Enanos, videntes, olvidados y jotuns", true));
            listRespuestas.add(new Respuesta("Enanos, videntes, olvidados y mursats", false));
            listRespuestas.add(new Respuesta("Enanos, videntes, chars y jotuns", false));
            listRespuestas.add(new Respuesta("Enanos, videntes, olvidados y nors", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 13
            listRespuestas.clear();
            pregunta = "¿Quien es realmente el lazaro que aparece por primera vez en el ls3?";
            listRespuestas.add(new Respuesta("Balthazar", true));
            listRespuestas.add(new Respuesta("Lazaro", false));
            listRespuestas.add(new Respuesta("Kormir", false));
            listRespuestas.add(new Respuesta("Caudecus", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 14
            listRespuestas.clear();
            pregunta = "¿Cual fue el primer dragón en despertar despues de la hambruna de magia?";
            listRespuestas.add(new Respuesta("Primordus", true));
            listRespuestas.add(new Respuesta("Zhaitan", false));
            listRespuestas.add(new Respuesta("Jormag", false));
            listRespuestas.add(new Respuesta("Mordremoth", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            //Pregunta 15
            listRespuestas.clear();
            pregunta = "Excelsior es una expresión usada comúnmente por...";
            listRespuestas.add(new Respuesta("Asuras", true));
            listRespuestas.add(new Respuesta("Sylvaris", false));
            listRespuestas.add(new Respuesta("Humanos", false));
            listRespuestas.add(new Respuesta("Chars", false));
            listPreguntas.add(new Pregunta(pregunta, listRespuestas));

            for (Pregunta p : listPreguntas) {
                sqLiteBD.agregarPregunta(p);
            }
        }
    }
}

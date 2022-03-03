package com.example.preguntas.Clases;

import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pregunta implements Serializable {
    private int id;
    private String pregunta;
    private List<Respuesta> respuestas = new ArrayList<>();

    public Pregunta(String pregunta, List<Respuesta> respuestasN) {
        this.id = -1;
        this.pregunta = pregunta;
        this.respuestas.addAll(respuestasN);
    }

    public Pregunta(int id, String pregunta, List<Respuesta> respuestasN) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuestas.addAll(respuestasN);
    }

    public int getId() {
        return id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public String respuestasToString(){
        String respuestasString = "";
        for (int i =0;i < respuestas.size(); i++) {
            if (i == respuestas.size()-1){
                respuestasString += respuestas.get(i).getRespuesta();
            }else{
                respuestasString += respuestas.get(i).getRespuesta()+";";
            }
        }
        return respuestasString;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void ordenarRespuestas(){
        for (int i = 0; i<respuestas.size();i++){
            if(i!=0 && respuestas.get(i).getValida()){
                Respuesta aux = respuestas.get(i);
                respuestas.set(i,respuestas.get(0));
                respuestas.set(0,aux);
            }
        }
    }

    public void respuestasAleatorias(){
        Collections.shuffle(respuestas);
    }
}

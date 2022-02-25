package com.example.examen_android_gamaza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Diccionario {
    private List<Palabra> listaPalabras;

    public Diccionario(List<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public List<Palabra> listaDesordenada(){

        List<Palabra> preguntas5 = new ArrayList<>();
        preguntas5.addAll(listaPalabras);
        Collections.sort(preguntas5,new SortPorNaciertos());
        while (preguntas5.size()!=5) {
            preguntas5.remove(preguntas5.size()-1);
        }
        return preguntas5;
    }
}

class SortPorNaciertos implements Comparator<Palabra> {

    public int compare(Palabra a, Palabra b)
    {
        return a.getContador_aciertos() - b.getContador_aciertos();
    }
}

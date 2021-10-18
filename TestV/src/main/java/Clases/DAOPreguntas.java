/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Alejandro
 */
public class DAOPreguntas {
    List<Pregunta> listPreguntas;
    
    public DAOPreguntas(){
        crearLista();
    }
    
    public List<Pregunta> getListPreguntas(){
        return this.listPreguntas;
    }
    
    public void addPregunta(Pregunta p){
        this.listPreguntas.add(p);
    }
    
    private void crearLista(){
        this.listPreguntas = new LinkedList<Pregunta>();
        List<Respuesta> listRespuestas = new LinkedList<Respuesta>();
        String pregunta;
        
        //Pregunta 1
        pregunta = "¿Cuantos dioses viven a dia de hoy?";
        listRespuestas.add(new Respuesta("5", true));
        listRespuestas.add(new Respuesta("6", false));
        listRespuestas.add(new Respuesta("7", false));
        listRespuestas.add(new Respuesta("4", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 2
        listRespuestas.clear();
        pregunta = "¿Como se llama la asura que nos acompaña en la historia?";
        listRespuestas.add(new Respuesta("Taimi", true));
        listRespuestas.add(new Respuesta("Taemi", false));
        listRespuestas.add(new Respuesta("Taimy", false));
        listRespuestas.add(new Respuesta("Teimi", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 3
        listRespuestas.clear();
        pregunta = "¿Que clases son de armadura ligera?";
        listRespuestas.add(new Respuesta("Elementalista, Hipnotizador, Nigromante", true));
        listRespuestas.add(new Respuesta("Elementalista, Hipnotizador, Ladron", false));
        listRespuestas.add(new Respuesta("Guerrero, Ingeniero, Hipnotizador", false));
        listRespuestas.add(new Respuesta("Nigromante, Guardabosque, Guardian", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 4
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 5
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 6
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 7
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 8
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 9
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 10
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 11
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 12
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 13
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 14
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 15
        listRespuestas.clear();
        pregunta = "¿?";
        listRespuestas.add(new Respuesta("hola", true));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        listRespuestas.add(new Respuesta("hola", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        Collections.shuffle(listPreguntas);
    }
}

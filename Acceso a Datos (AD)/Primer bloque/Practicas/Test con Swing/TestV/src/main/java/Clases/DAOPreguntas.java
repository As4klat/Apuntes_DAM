/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

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
        pregunta = "¿Cuantos dragones anciano existian antes del exodo?";
        listRespuestas.add(new Respuesta("6", true));
        listRespuestas.add(new Respuesta("5", false));
        listRespuestas.add(new Respuesta("7", false));
        listRespuestas.add(new Respuesta("2", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 5
        listRespuestas.clear();
        pregunta = "Personaje principal de la trama que porta una espada latigo";
        listRespuestas.add(new Respuesta("Canach", true));
        listRespuestas.add(new Respuesta("Logan", false));
        listRespuestas.add(new Respuesta("Tix", false));
        listRespuestas.add(new Respuesta("Marjory", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 6
        listRespuestas.clear();
        pregunta = "Año cuando los dioses le dan magia a las razas de Tyria";
        listRespuestas.add(new Respuesta("1 a.E", true));
        listRespuestas.add(new Respuesta("1 d.E", false));
        listRespuestas.add(new Respuesta("100 a.E", false));
        listRespuestas.add(new Respuesta("100 d.E", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 7
        listRespuestas.clear();
        pregunta = "Cual de las siguientes razas no perteneces a las antiguas";
        listRespuestas.add(new Respuesta("Silvari", true));
        listRespuestas.add(new Respuesta("Enanos", false));
        listRespuestas.add(new Respuesta("Videntes", false));
        listRespuestas.add(new Respuesta("Jotuns", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 8
        listRespuestas.clear();
        pregunta = "¿Que afirmación es cierta?";
        listRespuestas.add(new Respuesta("Primordius y Jormag son hermanos y sus puntos debiles son el uno contra el otro.", true));
        listRespuestas.add(new Respuesta("Primordius y Jormag no son hermanos y sus puntos debiles son el uno contra el otro.", false));
        listRespuestas.add(new Respuesta("La debilidad de Jormag es el fuego", false));
        listRespuestas.add(new Respuesta("La debilidad de Primordius es el hielo", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 9
        listRespuestas.clear();
        pregunta = "¿Quien fue el/la primer seguidor de Grenth?";
        listRespuestas.add(new Respuesta("Desmina", true));
        listRespuestas.add(new Respuesta("Kormir", false));
        listRespuestas.add(new Respuesta("Beyond", false));
        listRespuestas.add(new Respuesta("Segadores", false));
        Collections.shuffle(listRespuestas);
        this.listPreguntas.add(new Pregunta(pregunta, listRespuestas));
        
        //Pregunta 10
        listRespuestas.clear();
        pregunta = "¿Quien fue el primer dios en surgir de las aguas artesianas?";
        listRespuestas.add(new Respuesta("Dwayna", true));
        listRespuestas.add(new Respuesta("Melandru", false));
        listRespuestas.add(new Respuesta("Lyssa", false));
        listRespuestas.add(new Respuesta("Balthazar", false));
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

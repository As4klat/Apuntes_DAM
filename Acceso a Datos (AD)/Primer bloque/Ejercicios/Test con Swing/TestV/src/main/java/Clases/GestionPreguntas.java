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
public class GestionPreguntas {
    
    private List<Pregunta> listPreguntas;
    private List<Pregunta> listPreguntasJuego;
    private static DAOPreguntas dao;
    private int puntuacion;
    
    public GestionPreguntas(){
        dao = new DAOPreguntas();
        listPreguntas = dao.getListPreguntas();
        listPreguntasJuego = new LinkedList<Pregunta>();
    }
    
    public List<Pregunta> getListPreguntas(){
        return listPreguntas;
    }
    
    public int getPuntuacion(){
        return puntuacion;
    }
    
    public void resetearPuntuacion(){
        puntuacion=0;
    }
    
    public void addPregunta(Pregunta p){
        this.listPreguntas.add(p);
        dao.setListPreguntas(listPreguntas);
    }
    
    public void borrarPregunta(Pregunta p){
        this.listPreguntas.remove(p);
        dao.setListPreguntas(listPreguntas);
    }
    
    public void modificarPregunta(int posicion, Pregunta p){
        this.listPreguntas.set(posicion, p);
        dao.setListPreguntas(listPreguntas);
    }
    
    public List<Pregunta> iniciarJuego(int nPreguntas){
        for (int i = 0; i < nPreguntas; i++){
            listPreguntasJuego.add(listPreguntas.get(i));
        }
        Collections.shuffle(listPreguntasJuego);
        return listPreguntasJuego;
    }
    public void modificarPuntos(Pregunta p,int posicion ,int dificultad){
        if(dificultad == 0){
            if(p.esValida(posicion)){
                this.puntuacion++;
            }
        }
        else if(dificultad == 1){
            
            if(p.esValida(posicion)){
                this.puntuacion++;
            }
            else{
                this.puntuacion-=2;
            }
        }
        if(this.puntuacion < 0){
            this.puntuacion = 0;
        }
    }
    public boolean comprobarPregunta(Pregunta p,int posicion){
        boolean comp=false;
        if(p.esValida(posicion)){
            comp = true;
        }
        return comp;
    }
}

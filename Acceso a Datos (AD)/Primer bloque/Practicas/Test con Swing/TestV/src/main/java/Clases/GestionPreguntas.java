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
public class GestionPreguntas {
    
    private List<Pregunta> listPreguntas;
    private List<Pregunta> listPreguntasJuego;
    private DAOPreguntas dao;
    private int puntiacion;
    
    public GestionPreguntas(){
        DAOPreguntas dao = new DAOPreguntas();
        listPreguntas = dao.getListPreguntas();
        listPreguntasJuego = new LinkedList<Pregunta>();
    }
    
    public int getPuntuacion(){
        return puntiacion;
    }
    public void resetearPuntuacion(){
        puntiacion=0;
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
    
    public boolean comprobarPregunta(Pregunta p,int posicion ,int dificultad){
        boolean comp=false;
        if(dificultad == 0){
            if(p.esValida(posicion)){
                this.puntiacion++;
                comp = true;
            }
            else{
                comp = false;
            }
        }
        else{
            
            if(p.esValida(posicion)){
                comp = true;
                this.puntiacion++;
            }
            else{
                comp = false;
                this.puntiacion-=2;
            }
        }
        return comp;
    }
}

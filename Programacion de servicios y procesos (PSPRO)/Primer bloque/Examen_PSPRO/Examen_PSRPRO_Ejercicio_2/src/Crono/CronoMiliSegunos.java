/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crono;

/**
 *
 * @author Alejandro
 */
public class CronoMiliSegunos {
    private int milisegundos;
    
    public CronoMiliSegunos(){
        milisegundos = 0;
    }
    
    public int getMilisegundos(){
        return milisegundos;
    }
    
    public void contador(){
        milisegundos+=4;
    }
    
    public void reiniciar(){
        milisegundos = 0;
    }
}

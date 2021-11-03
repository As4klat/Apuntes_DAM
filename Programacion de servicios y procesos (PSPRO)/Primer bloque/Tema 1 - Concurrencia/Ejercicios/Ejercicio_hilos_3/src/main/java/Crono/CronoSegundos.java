/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crono;

/**
 *
 * @author Alejandro
 */
public class CronoSegundos {
    
    private int segundos;
    
    public CronoSegundos(){
        segundos = 0;
    }
    
    public int getSegundos(){
        return segundos;
    }
    
    public void contador(){
        segundos++;
    }
    
    public void reiniciar(){
        segundos = 0;
    }
}

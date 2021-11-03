/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crono;

/**
 *
 * @author Alejandro
 */
public class CronoMinutos {
    private int minutos;
    
    public CronoMinutos(){
        minutos = 0;
    }
    
    public int getMinutos(){
        return minutos;
    }
    
    public void contador(){
        minutos++;
    }
    
    public void reiniciar(){
        minutos = 0;
    }
}

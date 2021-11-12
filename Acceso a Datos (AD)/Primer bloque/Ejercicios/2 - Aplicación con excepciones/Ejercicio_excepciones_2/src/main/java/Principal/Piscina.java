/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.text.DecimalFormat;

/**
 *
 * @author Alejandro
 */
public class Piscina {
    
    private int nivel;
    private int MAX_NIVEL;
    
    public Piscina(){
        DecimalFormat f = new DecimalFormat("#.000");
        nivel = 0;
        MAX_NIVEL = 1300;
    }
    
    public int getNivel(){
        return nivel;
    }
    
    public int getMAX_NIVEL(){
        return MAX_NIVEL;
    }
    
    public void settNivel(int nivel){
        this.nivel = nivel;
    }
    
    public void setMAX_NIVEL(int MAX_NIVEL){
        this.MAX_NIVEL = MAX_NIVEL;
    }
    
    public void llenar(int litros) throws LimitePiscinaExcedidoException{
        if((nivel+litros) <= MAX_NIVEL){
            nivel += litros;
        }
        else{
            throw new LimitePiscinaExcedidoException();
        }
    }
    
    public void vaciar(int litros) throws VaciarPiscina0Exception{
        if((nivel-litros) >= 0)
        {
            nivel -= litros;
        }
        else{
            throw new VaciarPiscina0Exception();
        } 
    }
    
    public void vaciarCompleta(){
        nivel = 0;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alejandro
 */
public class Respuesta {
    private String respuesta;
    private boolean valida;
    
    public Respuesta(String respuesta, boolean valida){
        this.respuesta = respuesta;
        this.valida = valida;
    }
    
    public String getRespuesta(){
        return this.respuesta;
    }
    public boolean getValida(){
        return this.valida;
    }
}

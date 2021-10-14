/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Pregunta {
    private String pregunta;
    private List<Respuesta> listRespuestas = new ArrayList<>();
    
    public Pregunta(String pregunta, List<Respuesta> listRespuestas){
        this.pregunta = pregunta;
        this.listRespuestas.addAll(listRespuestas);
    }
    
    public String getPregunta(){
        return this.pregunta;
    }
    
    public List<Respuesta> getListRespuestas(){
        return this.listRespuestas;
    }
    
    @Override
    public String toString(){
        
        String[] letra = {"A","B","C","D"};
        String cadena="\n"+this.pregunta;
        
        for (int i = 0; i < this.listRespuestas.size(); i++){
            cadena += "\n["+letra[i]+"] " + listRespuestas.get(i).getRespuesta();
        }
        
        return cadena;
    }
    
    public boolean esValida(int posicion){
        return listRespuestas.get(posicion).getValida();
    }
}

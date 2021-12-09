/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class SalaCine {
    private int nButacas;
    private List<Persona> personas;
    private int nButacasLibres;
    
    public SalaCine(){
        this.nButacas = 40;
        this.personas = new ArrayList<>();
        updateButacas();
    }
    
    public SalaCine(int nButacas){
        this.nButacas = nButacas;
    }
    
    public void addPersona(Persona p){
        personas.add(p);
        updateButacas();
    }
    
    private void updateButacas(){
        this.nButacasLibres = nButacas - personas.size();
    }

    //
    // Getters y Setters
    //
    public int getnButacas() {
        return nButacas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setnButacas(int nButacas) {
        this.nButacas = nButacas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}

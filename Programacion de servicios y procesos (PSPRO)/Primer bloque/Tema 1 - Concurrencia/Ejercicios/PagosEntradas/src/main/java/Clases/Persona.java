package Clases;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alejandro
 */
public class Persona {

    private int id;
    private List<Entrada> entrada;

    public Persona(int id) {
        this.id = id;
    }

    public void comprarEntrada(List<Entrada> entrada) {
        this.entrada = entrada;
    }
    
    //
    //  Getters y Setters
    //
    public int getId() {
        return id;
    }

    public List<Entrada> getEntrada() {
        return entrada;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEntrada(List<Entrada> entrada) {
        this.entrada = entrada;
    }
    
}

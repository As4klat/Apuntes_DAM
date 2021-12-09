package Clases;

import java.util.List;
import java.util.Random;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

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
    public int nEntradasCompra;

    public Persona(int id) {
        this.id = id;
        nEntradasRandom();
    }

    public void guardarEntradas(List<Entrada> entrada) {
        this.entrada = entrada;
    }

    private void nEntradasRandom() {
        int[] values = {1,2,3,4};
        double[] probs = {0.6,0.4,0.2,0.1};
        EnumeratedIntegerDistribution nRandom = new EnumeratedIntegerDistribution(values, probs);
        this.nEntradasCompra = nRandom.sample();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Procesos.Lanzador;

/**
 *
 * @author Alejandro
 */
public class Controlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lanzador l = new Lanzador();
        
        int n = l.lanzarMax(8,4);
        int factorial = l.lanzarFact(n);
        int espar = l.lanzarPar(factorial);
        l.lanzarVisual(n, factorial, espar);
    }
}

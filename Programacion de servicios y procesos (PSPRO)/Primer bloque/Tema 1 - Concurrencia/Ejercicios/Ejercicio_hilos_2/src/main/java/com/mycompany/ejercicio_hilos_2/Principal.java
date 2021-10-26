
package com.mycompany.ejercicio_hilos_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(2);
        lista.add(4);
        lista.add(2);
        lista.add(3);
        lista.add(1);
        lista.add(6);
        lista.add(5);
        lista.add(7);
        Thread hilo1 = new Thread(new Hilo());
        Thread hilo2 = new Thread(new Hilo());
        Thread hilo3 = new Thread(new Hilo());
        Thread hilo4 = new Thread(new Hilo());
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        
    }
    
}

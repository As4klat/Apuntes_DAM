
package com.mycompany.ejercicio_hilos_2;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<>();
        ls.add(3);
        ls.add(1);
        ls.add(7);
        ls.add(6);
        ls.add(5);
        ls.add(2);
        ls.add(4);
        ls.add(6);
        
        System.out.println("Lista: " + ls.toString());
        
        Thread hilo1 = new Thread(new RunnableClass(ls));
        Thread hilo2 = new Thread(new RunnableClass(ls));
        Thread hilo3 = new Thread(new RunnableClass(ls));
        Thread hilo4 = new Thread(new RunnableClass(ls));
        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        hilo3.start();
        try {
            hilo3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        hilo4.start();
        try {
            hilo4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

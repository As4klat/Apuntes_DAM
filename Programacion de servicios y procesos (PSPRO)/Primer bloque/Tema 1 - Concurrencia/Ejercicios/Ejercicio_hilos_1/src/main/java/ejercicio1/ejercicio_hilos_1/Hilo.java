/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.ejercicio_hilos_1;

/**
 *
 * @author Alejandro
 */
public class Hilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RunnableClass rc = new RunnableClass();
        Thread hilo1 = new Thread(rc);
        Thread hilo2 = new Thread(rc);
        Thread hilo3 = new Thread(rc);
        hilo1.setName("hilo 1");
        hilo2.setName("hilo 2");
        hilo3.setName("hilo 3");
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
    
}

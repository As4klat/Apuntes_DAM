/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.ejercicio_hilos_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class RunnableClass implements Runnable{
    private int opcion;
    
    public RunnableClass(int opcion){
        this.opcion = opcion;
    }
    public void run(){
        String nombre_hilo = Thread.currentThread().getName();
        
        switch(opcion){
            case 1:
                for (int i  = 0; i <= 10; i++){
                    System.out.println("El " + nombre_hilo + " vale: " + i);
                }
                break;
            case 2:
                String[] abe = {"a","b","c","d","e","f","g","h"};
                for (int i  = 0; i <= abe.length; i++){
                    System.out.println("El " + nombre_hilo + " vale: " + abe[i]);
                }
                break;
                  
        }
        /*System.out.println("Comenzando: " + nombre_hilo);
        try {
            for(int i = 0; i < 10; i++){
                Thread.sleep(1* 1000);
                System.out.println("AL " + nombre_hilo + " tiene contador: " + i);
            }
        } catch (InterruptedException exc) {
            System.out.println("El " + nombre_hilo + " se ha interrumpido");
        }
        System.out.println("FInalizado " + nombre_hilo);
        /*for (int i = 0; i <= 5; i++){
            try {
                Thread.sleep(1*1000);
                System.out.println("Ejecutando: " + Thread.currentThread().getName() + ": " + i);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunnableClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }
}

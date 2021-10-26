/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.practica_hilos_4;

/**
 *
 * @author Alejandro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreadGroup grupo1 = new ThreadGroup("Grupo 1");
        grupo1.setMaxPriority(Thread.MIN_PRIORITY);
        Hilo hilo1 = new Hilo(grupo1, "Hilo 1");
        Hilo hilo2 = new Hilo(grupo1, "Hilo 2");
        Hilo hilo3 = new Hilo(grupo1, "Hilo 3");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        Thread[] vector = new Thread[grupo1.activeCount()];
        
        hilo1.getThreadGroup().enumerate(vector);
        
        /*for(Thread hilo: vector){
            System.out.println(hilo.getName());
        }*/
        
        ThreadGroup grupo2 = new ThreadGroup("Grupo 2");
        grupo2.setMaxPriority(Thread.MAX_PRIORITY);
        Hilo hilo5 = new Hilo(grupo2, "Hilo 5");
        Hilo hilo6 = new Hilo(grupo2, "Hilo 6");
        Hilo hilo7 = new Hilo(grupo2, "Hilo 7");
        hilo5.start();
        hilo6.start();
        hilo7.start();
        
        Thread[] vector2 = new Thread[grupo2.activeCount()];
        
        hilo5.getThreadGroup().enumerate(vector);
        
        /*for(Thread hilo: vector2){
            System.out.println(hilo.getName());
        }*/
        boolean findGroup1 = false;
        boolean findGroup2 = false;
        do{
            if(grupo1.activeCount()==0 && !findGroup1){
                System.out.println("Grupo 1 acabo.");
                findGroup1 = true;
            }
            else if(grupo2.activeCount()==0 && !findGroup2){
                System.out.println("Grupo 2 acabo.");
                findGroup2 = true;
            }
        }while (!findGroup1 || !findGroup2);
        
        System.err.println("Fin del main");
    }
    
}

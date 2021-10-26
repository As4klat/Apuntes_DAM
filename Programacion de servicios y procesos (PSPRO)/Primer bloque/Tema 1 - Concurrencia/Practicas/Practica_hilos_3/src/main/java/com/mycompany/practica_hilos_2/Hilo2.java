/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_hilos_2;

/**
 *
 * @author Alejandro
 */
public class Hilo2 implements Runnable{

    private Thread hilo;
    
    public Hilo2(Thread hilo){
        super();
        this.hilo = hilo;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
    
}

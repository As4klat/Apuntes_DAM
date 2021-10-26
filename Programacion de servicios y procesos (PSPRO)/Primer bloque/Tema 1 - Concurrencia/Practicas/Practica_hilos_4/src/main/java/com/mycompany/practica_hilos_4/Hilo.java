/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_hilos_4;

/**
 *
 * @author Alejandro
 */
public class Hilo extends Thread{
    private String name;
    
    public Hilo(ThreadGroup grupo, String name){
        super(grupo, name);
    }

    @Override
    public void run() {
        for(int i = 0; i <= 1000; i++){
            
        }
        System.out.println(this.getThreadGroup().getName() + " -----> " + this.currentThread().getName());
    }
}

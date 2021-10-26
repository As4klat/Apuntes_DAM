/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.practica_hilos_2;

/**
 *
 * @author Alejandro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new Hilo());
        hilo1.start();
        Thread hilo2 = new Thread(hilo1);
        hilo2.start();
    }
    
}

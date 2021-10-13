/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2_Treadh;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Hilo hilo1 = new Hilo("1º Hilo");
        System.err.println(hilo1.getState());
        hilo1.start();
        hilo1.join();
        Hilo hilo2 = new Hilo("2º Hilo");
        hilo2.start();
        System.err.println(hilo2.getState());
        Hilo hilo3 = new Hilo("3º Hilo");
        hilo3.start();
        System.err.println(hilo3.getState());
    }
    
}

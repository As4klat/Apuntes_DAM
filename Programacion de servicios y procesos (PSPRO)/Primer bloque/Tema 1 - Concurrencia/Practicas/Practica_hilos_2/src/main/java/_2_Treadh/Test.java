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
        Contador contador = new Contador();
        Hilo hilo1 = new Hilo("1º Hilo", contador);
        hilo1.start();
        Hilo hilo2 = new Hilo("2º Hilo", contador);
        hilo2.start();
        Hilo hilo3 = new Hilo("3º Hilo", contador);
        hilo3.start();
    }
    
}

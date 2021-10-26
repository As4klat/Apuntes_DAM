/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _1_Treadh;

/**
 *
 * @author Alejandro
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Hilo hilo = new Hilo("1º Hilo");
        hilo.start();
        
        Thread hr = new Thread(new HiloRunnable(), "2º Hilo");
        hr.start();
        
        Hilo hilo2 = new Hilo("3º Hilo");
        hilo2.start();
        
        for(int cont=1; cont <100; cont++){
            System.out.println(cont);
        }
        
    }
    
}

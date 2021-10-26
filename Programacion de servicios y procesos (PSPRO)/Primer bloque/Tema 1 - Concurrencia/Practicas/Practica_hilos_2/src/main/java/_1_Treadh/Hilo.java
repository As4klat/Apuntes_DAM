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
public class Hilo extends Thread {

    public Hilo(String name) {
        super(name);
    }

    
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        System.out.println(this.currentThread().getName());
    }
    
    
}

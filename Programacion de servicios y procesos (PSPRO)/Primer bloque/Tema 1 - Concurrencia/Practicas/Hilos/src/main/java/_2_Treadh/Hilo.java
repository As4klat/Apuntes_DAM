/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2_Treadh;

/**
 *
 * @author Alejandro
 */
public class Hilo extends Thread{
    private Contador contador;
           
    public Hilo(String name, Contador contador) {
        super(name);
        this.contador = contador;
    }

    
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        for(; contador.getContador()< 100;){
            Thread.yield();
            synchronized(contador){
                System.out.println(this.currentThread().getName() + " contador: " + contador.getContador());
                contador.incremento();
            }
        }
    }
}

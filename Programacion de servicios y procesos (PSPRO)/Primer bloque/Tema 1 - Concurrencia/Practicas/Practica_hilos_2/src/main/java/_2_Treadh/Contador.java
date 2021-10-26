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
public class Contador {
    private int contador;

    public Contador() {
        super();
        this.contador = 0;
    }
    public int getContador(){
        return contador;
    }
    public void incremento(){
        contador++;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

/**
 *
 * @author Alejandro
 */
public class ProcesoFact {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.exit(factorial(Integer.parseInt(args[0])));
    }
    public static int factorial(int n){
        int factorial=1;
        for(int i = n; i > 0; i--){
            factorial = factorial*i;
        }
        return factorial;
    }
}

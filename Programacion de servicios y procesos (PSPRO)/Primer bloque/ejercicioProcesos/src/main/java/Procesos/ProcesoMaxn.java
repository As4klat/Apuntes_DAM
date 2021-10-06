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
public class ProcesoMaxn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        1º Proceso que calcule el maximo de 2 numeros
        2º Proceso que pilla el numero anterior y hacerle el factorial 3! = 3*2*1 = 6
        3º Proceso decir si es par o impar
        4º Proceso que muestre el resultado si es par o es impar
        */
        
        System.exit(nMax( Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        
    }
    public static int nMax(int a, int b){
        int max;
        if(a > b){
            max = a;
        }
        else
        {
            max = b;
        }
        return max;
    }
}

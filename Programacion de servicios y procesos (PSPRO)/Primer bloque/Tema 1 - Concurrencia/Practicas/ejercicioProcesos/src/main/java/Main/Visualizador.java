/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Alejandro
 */
public class Visualizador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena = "Numero mayor: " + args[0];
        
        cadena += "\nEl factorial de " + args[0] + " es: " + args[0] + "! = ";
        for(int i = Integer.parseInt(args[0]); i > 0; i--){
            if(i != 1){
                cadena += i + " x ";
            }
            else
            {
                cadena += i;
            }
        }
        cadena += " = " + args[1];
        
        
        String par = "no";
        if(intToBoolean(Integer.parseInt(args[2]))){
            par = "si";
        }
        
        cadena += "\nEs par? " + par;
        
        System.out.println(cadena);
    }
    
    public static boolean intToBoolean(int n){
        boolean bool = false;
        if(n==1){
            bool=true;
        }
        return bool;
    }
}

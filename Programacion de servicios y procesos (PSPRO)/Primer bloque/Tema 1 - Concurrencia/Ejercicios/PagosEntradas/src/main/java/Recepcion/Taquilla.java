/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Recepcion;

import Clases.Entrada;
import Clases.Persona;
import Clases.SalaCine;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Taquilla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SalaCine sala = new SalaCine(60);
        
        List<Entrada> entradas = new LinkedList<>();
        for(int i = 1; i <= sala.getnButacas(); i++){
            entradas.add(new Entrada(i, i));
        }
        
        List<Persona> personas = new LinkedList<>();
        for(int i = 1; i <= 50; i++){
            personas.add(new Persona(i));
        }
        
        for(int i = 0; i < 5; i++){
            Operador o = new Operador(personas, entradas);
            o.start();
        }
    }
}

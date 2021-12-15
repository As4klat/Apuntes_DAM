/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Navidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int nPersonas = 5;
        List<Persona> listaPersonas = new ArrayList<>();
        Sala.iniciarSala();
        for(int i = 0; i < nPersonas; i++){
            listaPersonas.add(new Persona("Persona " + (i+1)));
        }
        for(Persona p : listaPersonas){
            p.start();
        }
        
        Thread.sleep(1000*2);
        Sala.getInstance().setPuerta(true);
    }
    
}

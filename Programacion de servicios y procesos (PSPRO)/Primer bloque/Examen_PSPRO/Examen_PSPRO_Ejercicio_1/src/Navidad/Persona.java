/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Navidad;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Persona extends Thread {

    private boolean tieneCesta;
    private int ndeIntentos;
    private Sala sala;
    private Random r;

    public Persona(String nombre) {
        super(nombre);
        this.tieneCesta = false;
        this.ndeIntentos = 0;
        sala = Sala.getInstance();
        r = new Random();
    }

    public boolean isTieneCesta() {
        return tieneCesta;
    }

    private void cogerCesta() {
        tieneCesta = true;
    }

    private int tiempoAleatorio() {
        return r.nextInt(4) + 1;
    }

    @Override
    public void run() {

        boolean cansado = false;

        /*
            Se entra de 1 en 1.
            Despues de 3 intentos abandonan.
            Cada persona comprueba al azar si la puerta esta cerrada.
            1s en pasar por la puerta y estara ocupada.
            
            si la persona entra y no quedan cesta se marcha.
         */
 /*
        while (ndeIntentos <= 3 && !tieneCesta) {
            if (sala.quedanCestas()) {
                sala.cogerCesta();
                cogerCesta();
                System.out.println("La " + this.getName() + " se lleva una cesta");
            } else {
                ndeIntentos++;
            }
        }
        if(!tieneCesta){
            System.out.println("La " + this.getName() + " se acabaron las cestas");
        }*/
        do {
            try {
                //esperando a que se abra
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("La " + this.getName() + " Puerta cerrada");
        } while (!sala.isPuertabierta());

        while (!cansado && !tieneCesta) {
            
            try {
                sleep(1000 * tiempoAleatorio());
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!sala.isPuertaOcupada()) {
                sala.setPuertaOcupada(true);
                System.out.println("La " + this.getName() + ": esta pasando.");
                try {
                    sleep(1000 * 1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (sala.quedanCestas()) {
                    sala.cogerCesta();
                    cogerCesta();
                    System.out.println("La " + this.getName() + ": se lleva una cesta.");
                } else {
                    System.out.println("La " + this.getName() + ": se queda sin cesta :(");
                    cansado = true;
                }
                
                sala.setPuertaOcupada(false);

            } else {
                System.out.println("La " + this.getName() + ": puerta ocupada.");
                ndeIntentos++;
            }
            
            if (ndeIntentos == 3) {
                System.out.println("La " + this.getName() + ": abandona: 3 intentos");
                cansado = true;
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Alejandro
 */
public class CorredorHilo extends Thread {

    private JProgressBar corredor;
    private boolean pausa = false;
    private boolean finalizar = false;
    private int posicion = -1;

    public CorredorHilo(String nombre, JProgressBar corredor) {
        super(nombre);
        this.corredor = corredor;
    }

    @Override
    public void run() {
        Random rc = new Random();
        int min = corredor.getMinimum();
        int max = corredor.getMaximum();
        int velocidad = rc.nextInt(150) + 50;

        for (int i = min; i <= max; i++) {
            try {
                synchronized (this) {
                    if (pausa) {
                        this.wait();
                    }
                }
                sleep(velocidad);
                corredor.setValue(i);
                if (i % 10 == 0) {
                    velocidad = rc.nextInt(150) + 50;
                }
            } catch (InterruptedException ex) {
                interrupt();
            }

        }
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public synchronized void parar() {
        this.pausa = true;
        notify();
    }

    public synchronized void reanudar() {
        this.pausa = false;
        notify();
    }

    public synchronized void finalizar() {
        corredor.setValue(0);
        notify();
    }

}

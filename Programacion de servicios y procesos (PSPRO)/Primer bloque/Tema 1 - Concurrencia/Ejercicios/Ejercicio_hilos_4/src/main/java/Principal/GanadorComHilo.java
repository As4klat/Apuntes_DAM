/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Paneles.Podiun;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro
 */
public class GanadorComHilo extends Thread {

    private CorredorHilo[] corredores = new CorredorHilo[4];
    private JFrame ventana;
    private boolean hilosFinalizados[] = {false, false, false, false};
    private boolean finCarrera = false;
    private boolean pausa = false;
    private boolean finalizar = false;

    public GanadorComHilo(CorredorHilo[] corredores, JFrame ventana) {
        this.corredores = corredores;
        this.ventana = ventana;
    }

    @Override
    public void run() {
        int posicion=1;
        while (!finCarrera) {
            try {
                synchronized (this) {
                    if (pausa) {
                        wait();
                    }
                }
            } catch (InterruptedException ex) {
                this.interrupt();
            }
            for (int i = 0; i < corredores.length; i++) {
                if (!corredores[i].isAlive()) {
                    hilosFinalizados[i] = true;
                    if (corredores[i].getPosicion() == -1) {
                        corredores[i].setPosicion(posicion);
                        posicion++;
                    }
                }
            }
            if (isHilosTerminados()) {
                finCarrera = true;
            }
        }
        
        try {
            sleep(1*1000);
            mostrarPanel();
        } catch (InterruptedException ex) {
            this.interrupt();
        }
    }

    private void mostrarPanel(){
        Podiun p = new Podiun(corredores, ventana);
        p.setSize(400,300);
        p.setLocation(0,0);
        p.setVisible(true);
        ventana.getRootPane().removeAll();
        ventana.getRootPane().add(p);
        ventana.getRootPane().validate();
        ventana.getRootPane().repaint();
    }
    
    private boolean isHilosTerminados() {
        boolean finHilo = false;
        int cont = 0;
        for (int i = 0; i < hilosFinalizados.length; i++) {
            if (hilosFinalizados[i]) {
                cont++;
            }
        }
        if (cont == 4) {
            finHilo = true;
        }

        return finHilo;
    }

    public synchronized void parar() {
        this.pausa = true;
        notify();
    }

    public synchronized void reanudar() {
        this.pausa = false;
        notify();
    }
}

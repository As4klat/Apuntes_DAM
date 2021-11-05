/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crono;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alejandro
 */
public class Crono extends Thread {

    private CronoMinutos cm;
    private CronoSegundos cs;
    private String cronoVista;
    private JLabel label;
    private boolean pausado;

    public Crono(JLabel label) {
        cm = new CronoMinutos();
        cs = new CronoSegundos();
        pausado = false;
        format();
        this.label = label;
        this.label.setText(cronoVista);
    }

    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            cs.contador();
            try {
                synchronized (this) {
                    while (pausado) {
                        this.wait();
                    }
                }
                this.sleep(1 * 1000);
            } catch (InterruptedException ex) {
                this.interrupt();
            }
            if (cs.getSegundos() == 60) {
                cs.reiniciar();
                cm.contador();
                if (cm.getMinutos() == 60) {
                    cm.reiniciar();
                }
            }
            format();
            label.setText(cronoVista);

        }

    }

    public synchronized void pausar() {
        pausado = true;
        notify();
    }

    public synchronized void reanudar() {
        pausado = false;
        notify();
    }

    public void reset() {
        cm.reiniciar();
        cs.reiniciar();
    }

    public CronoMinutos getCm() {
        return cm;
    }

    private void format() {
        if (cm.getMinutos() < 10) {
            cronoVista = "0" + cm.getMinutos() + " : ";
        } else {
            cronoVista = cm.getMinutos() + " : ";
        }

        if (cs.getSegundos() < 10) {
            cronoVista += "0" + cs.getSegundos();
        } else {
            cronoVista += cs.getSegundos();
        }
    }
}

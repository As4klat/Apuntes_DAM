/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crono;

import javax.swing.JLabel;

/**
 *
 * @author Alejandro
 */
public class Crono extends Thread {

    private CronoMinutos cm;
    private CronoSegundos cs;
    private CronoMiliSegunos cms;
    private String cronoVista;
    private boolean pausado;

    public Crono() {
        cm = new CronoMinutos();
        cs = new CronoSegundos();
        cms = new CronoMiliSegunos();
        pausado = false;
        format();
    }

    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                cms.contador();
                if (cms.getMilisegundos() == 1000) {
                    cms.reiniciar();
                    cs.contador();
                    if (cs.getSegundos() == 60) {
                        cs.reiniciar();
                        cm.contador();
                        if (cm.getMinutos() == 60) {
                            cm.reiniciar();
                        }
                    }
                }
                format();
                synchronized (this) {
                    if (pausado) {
                        this.wait();
                    }
                }
                this.sleep(4);
            } catch (InterruptedException ex) {
                this.interrupt();
            }
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
        cronoVista = "";
        cms.reiniciar();
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
            cronoVista += "0" + cs.getSegundos() + " : ";
        } else {
            cronoVista += cs.getSegundos() + " : ";
        }

        cronoVista += contarCerosMiliSegundos();
    }

    private String contarCerosMiliSegundos() {
        String ceros = String.format("%03d", cms.getMilisegundos());
        return ceros;
    }

    public String getCrono() {
        return cronoVista;
    }
}

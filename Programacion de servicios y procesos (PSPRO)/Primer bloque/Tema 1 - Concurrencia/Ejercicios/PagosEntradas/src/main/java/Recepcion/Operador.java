/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recepcion;

import Clases.Entrada;
import Clases.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Gamaza
 */
public class Operador extends Thread {

    private List<Persona> personas;
    private List<Entrada> entradas;

    public Operador(List<Persona> personas, List<Entrada> entradas) {
        this.personas = personas;
        this.entradas = entradas;
    }

    @Override
    public void run() {
        while (entradasStok() && personasEnCola()) {
            Persona p = personas.get(0);
            boolean compraFallida = true;
            while (compraFallida) {
                Random r = new Random();
                int idEntrada = r.nextInt(entradas.size()) + 1;
                if (butacasLibres(idEntrada, p.nEntradasCompra)) {
                    List<Entrada> entradasCompradas = new ArrayList<>();
                    for (int i = idEntrada; i <= p.nEntradasCompra; i++) {
                        entradasCompradas.add(entradas.get(i));
                        entradas.get(i).setComprada(true);
                    }
                    p.setEntrada(entradasCompradas);
                    compraFallida = false;
                }
            }

        }
    }

    private boolean entradasStok() {
        boolean existen = false;
        for (int i = 0; i < entradas.size(); i++) {
            if (!entradas.get(i).getComprada()) {
                existen = true;
                i = entradas.size();
            }
        }
        return existen;
    }

    private boolean personasEnCola() {
        boolean existen = false;
        if (personas.isEmpty()) {
            existen = true;
        }
        return existen;
    }

    private boolean butacasLibres(int idEntrada, int nEntradasCompra) {
        boolean libres = true;
        for (int i = idEntrada; i <= nEntradasCompra; i++) {
            if (entradas.get(i).getComprada()) {
                libres = false;
                i = nEntradasCompra;
            }
        }
        return libres;
    }
}

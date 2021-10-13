/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Lanzador {

    public int lanzarMax(int a, int b){
        
        File ruta = new File(".\\target\\classes");
        ProcessBuilder pb = new ProcessBuilder("java","Procesos.ProcesoMaxn", String.valueOf(a), String.valueOf(b));
        
        pb.directory(ruta);
        
        int numero=0;
        try {
            Process p = pb.start();
            try {
                numero = p.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }
    public int lanzarFact(int n){
        
        File ruta = new File(".\\target\\classes");
        ProcessBuilder pb = new ProcessBuilder("java","Procesos.ProcesoFact", String.valueOf(n));
        
        pb.directory(ruta);
        
        int numero=0;
        
        try {
            Process p = pb.start();
            try {
                numero = p.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }
    public int lanzarPar(int n){
       
        File ruta = new File(".\\target\\classes");
        ProcessBuilder pb = new ProcessBuilder("java","Procesos.ProcesoPar", String.valueOf(n));
        
        pb.directory(ruta);
        
        int espar=0;
        
        try {
            Process p = pb.start();
            try {
                espar = p.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espar;
    }
    public void lanzarVisual(int n, int factorial, int espar){
        File ruta = new File(".\\target\\classes");
        ProcessBuilder pb = new ProcessBuilder("java","Main.Visualizador", String.valueOf(n), String.valueOf(factorial), String.valueOf(espar));
        
        pb.directory(ruta);
        pb.redirectError(new File("error.txt"));
        pb.redirectOutput(new File("salida.txt"));
        try {
            Process p = pb.start();
        } catch (IOException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

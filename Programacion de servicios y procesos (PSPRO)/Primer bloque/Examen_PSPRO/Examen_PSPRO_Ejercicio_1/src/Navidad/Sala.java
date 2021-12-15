/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Navidad;

/**
 *
 * @author Alejandro
 */
public class Sala {
    private int nCestas;
    private boolean puertaAbierta; //true abiertas, false cerrada
    private boolean puertaOcupada; // true = esta ocupada | false = no lo esta
    private static Sala sala = null;

    private Sala() {
        nCestas = 2;
        puertaAbierta = false;
        puertaOcupada = false;
    }
    
    public static void iniciarSala(){
        sala = new Sala();
    }
    
    public static Sala getInstance() {
        return sala;
    }
    
    public boolean quedanCestas(){
        boolean hayCestas = true;
        if(nCestas==0){
            hayCestas=false;
        }
        return hayCestas;
    }
    
    public synchronized void cogerCesta(){
        nCestas--;
    }
    
    //Getters y Setters
    public synchronized int getnCestas() {
        return nCestas;
    }

    public synchronized boolean isPuertabierta() {
        return puertaAbierta;
    }

    public synchronized boolean isPuertaOcupada() {
        return puertaOcupada;
    }

    public synchronized void setnCestas(int nCestas) {
        this.nCestas = nCestas;
    }

    public synchronized void setPuerta(boolean puerta) {
        this.puertaAbierta = puerta;
    }

    public synchronized void setPuertaOcupada(boolean puertaOcupada) {
        this.puertaOcupada = puertaOcupada;
    }
    
}

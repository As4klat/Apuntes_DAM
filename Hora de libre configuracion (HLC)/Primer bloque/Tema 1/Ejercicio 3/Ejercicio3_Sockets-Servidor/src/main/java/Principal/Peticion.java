/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Clases.SalaChat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Peticion extends Thread {

    private Socket cliente;
    private SalaChat room;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private List<Peticion> listaHilos;

    public Peticion(Socket cliente, SalaChat room, List<Peticion> listaHilos) {
        this.cliente = cliente;
        this.room = room;
        this.listaHilos = listaHilos;
    }

    @Override
    public void run() {
        String msn = null;
        System.out.println("Se ha lanzado un hilo. Name: " + this.getName());

        while (!cliente.isClosed()) {
            try {
                entrada = new DataInputStream(cliente.getInputStream());
                salida = new DataOutputStream(cliente.getOutputStream());

                msn = entrada.readUTF();
                room.add(msn + "\n:" + cliente.getPort()+ "\n");              
                
                for(int i = 0; i < listaHilos.size(); i++){
                    listaHilos.get(i).actualizar(room.getList());
                }
                
            } catch (IOException ex) {
                try {
                    cliente.close();
                } catch (IOException ex1) {
                    Logger.getLogger(Peticion.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        System.out.println("Hilo " + this.getName() + " ha finalizado sin problemas.");
    }
    
    public void actualizar(String chats) throws IOException{
        salida.writeUTF(chats);
    }
}

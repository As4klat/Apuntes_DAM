/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class ServidorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int puerto = 4000;
        ChatSala chatSala = new ChatSala();
        
        try {
            
            ServerSocket servidor = new ServerSocket(puerto, 2);
            System.out.println("Servidor escuchando en el puerto 4000.");
            
            while (true) {         
                Socket cliente = servidor.accept();
                Hilo h =  new Hilo(cliente, chatSala);
            }
            
        } catch (IOException ex) {
            System.out.println("Error al lanzar el servidor.");
        }
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejercicio1_sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int puerto = 6000;
        int nClientes = 3;
        try { 
            ServerSocket server = new ServerSocket(puerto, nClientes);
            System.out.println("Escuchando en el puerto: " + server.getLocalPort());
            OutputStream salida = null;
            
            Socket cliente1 = server.accept();
            
            System.out.println("------ Cliente 1 -------");
            System.out.println("Puerto local: " + cliente1.getPort());
            try{
                salida = cliente1.getOutputStream();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("Estas conectado al puerto: " + cliente1.getPort());
            Socket cliente2 = server.accept();
            
            System.out.println("------ Cliente 2 -------");
            System.out.println("Puerto local: " + cliente2.getPort());
            try{
                salida = cliente2.getOutputStream();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("Estas conectado al puerto: " + cliente2.getPort());
            Socket cliente3 = server.accept();
            
            System.out.println("------ Cliente 3 -------");
            System.out.println("Puerto local: " + cliente3.getPort());
            try{
                salida = cliente3.getOutputStream();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("Estas conectado al puerto: " + cliente3.getPort());
            
            server.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

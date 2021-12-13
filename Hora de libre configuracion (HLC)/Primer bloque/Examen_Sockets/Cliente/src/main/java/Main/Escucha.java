/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Escucha extends Thread{
    
    private Socket connection;
    
    public Escucha(Socket connection){
        this.connection = connection;
    }

    @Override
    public void run() {
        DataInputStream flujoEntrada = null;
        try {
            flujoEntrada = new DataInputStream(connection.getInputStream());
            System.out.println(flujoEntrada.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Escucha.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                flujoEntrada.close();
            } catch (IOException ex) {
                Logger.getLogger(Escucha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}

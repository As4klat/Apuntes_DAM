/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Hilo extends Thread{

    private Socket cliente;
    private ChatSala chatSala;
    
    public Hilo(Socket cliente, ChatSala chatSala){
        this.cliente = cliente;
        this.chatSala = chatSala;
    }
    
    @Override
    public void run() {
        try {
            String msgWelcome = "Buenas tardes mr.cliente";
            
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
            
            flujoSalida.writeUTF(msgWelcome);
            
            while (!flujoEntrada.equals("*")) {
                
            }
            flujoEntrada.close();
            flujoSalida.close();
            
            System.out.println("Hilo terminado." + this.getName());
            
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

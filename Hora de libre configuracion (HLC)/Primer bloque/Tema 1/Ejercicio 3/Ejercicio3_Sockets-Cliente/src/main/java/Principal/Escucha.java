/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Alejandro
 */
public class Escucha extends Thread {

    private Socket cliente;
    private JTextArea areaTxt;
    private DataInputStream entrada;

    public Escucha(Socket cliente, JTextArea areaTxt) {
        this.cliente = cliente;
        this.areaTxt = areaTxt;
    }

    @Override
    public void run() {
        String texto = "";
        String[] chats;
        
        while (true) {
            try {
                entrada = new DataInputStream(cliente.getInputStream());

                texto = entrada.readUTF();
                    
                    chats = texto.split(",");
                    texto = "";
                    for (int i = 0; i < chats.length; i++){
                        
                        if(chats[i].split(":")[1].equals(String.valueOf(cliente.getLocalPort()))){
                            texto += "                                             " + chats[i].split(":")[0];
                        }
                        else{
                            texto += chats[i].split(":")[0];
                        }
                        
                    }
                    
                    areaTxt.setText(texto);
            } catch (IOException ex) {
                Logger.getLogger(Escucha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

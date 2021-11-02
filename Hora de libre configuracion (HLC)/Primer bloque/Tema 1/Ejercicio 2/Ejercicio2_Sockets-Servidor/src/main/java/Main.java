
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Alejandro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean serverOpen = true;
        try {
            ServerSocket servidor = new ServerSocket(6666, 4);
            Socket cliente = null;
            int cont = 0;
            System.out.println("Escuchando en el puerto: " + servidor.getLocalPort());
            while (serverOpen) {
                cliente = servidor.accept();
                Thread th = new Thread(new RunnableClass(cliente));
                th.start();
                System.out.println("Hilo lanzado");
                cont++;
                if(cont == 4){
                    serverOpen = false;
                }
            }
            servidor.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

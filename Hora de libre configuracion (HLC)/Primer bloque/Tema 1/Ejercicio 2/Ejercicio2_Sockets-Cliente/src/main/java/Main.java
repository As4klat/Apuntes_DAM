
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        try {
            Socket cliente = new Socket("localhost", 6666);
            InputStream entrada = null;
            OutputStream salida = null;
            
            String cadena = "";
            while (!cadena.equals("*")) {
                System.out.println("-> ");
                cadena = sc.next();
                // Salida de datos del servidor
                salida = cliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                flujoSalida.writeUTF(cadena);
                
                // Entrada de datos del cliente
                entrada = cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);
                System.out.println(flujoEntrada.readUTF());
            }
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

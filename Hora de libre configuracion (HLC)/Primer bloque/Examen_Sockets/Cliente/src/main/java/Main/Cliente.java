/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int puerto = 4000;
        String direccion = "localhost";
        Scanner sc = new Scanner(System.in);
        String texto = "";
        try {
            Socket connection = new Socket(direccion,puerto);
            Escucha e = new Escucha(connection);
            System.out.println("Conexion establecida.");
            
            DataOutputStream flujoSalida = new DataOutputStream(connection.getOutputStream());
            
            while (!texto.equals("*")) {
                texto = sc.nextLine();
                flujoSalida.writeUTF(texto);
            }
            connection.close();
            
        } catch (IOException ex) {
            System.out.println("No se ha podido conectar.");
        }
    }
    
}

package Principal;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {
        int puerto = 90;
        String direccion = "localhost";
        DataInputStream entrada;
        DataOutputStream salida;
        boolean conectado = true;
        String peticion;

        Scanner sc = new Scanner(System.in);
        Socket cliente = new Socket(direccion, puerto);

        while (conectado) {
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());

            System.out.println("Buscar: " + "\n->");
            peticion = sc.nextLine();
            
            salida.writeUTF(peticion);
            if (!peticion.equals("*")) {
                mostrarTexto(entrada.readUTF());
            } else {
                conectado = false;
            }
        }
        cliente.close();
    }
    
    static public void mostrarTexto(String texto){
        System.out.println(texto.replace("<br>", "\n"));
    }

}

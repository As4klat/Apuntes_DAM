package Principal;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor = new ServerSocket(90);
        
        System.out.println("Escuchando en el puerto: " + servidor.getLocalPort());
        int cont=0;
        while (true) {
            Socket cliente = new Socket();
            cliente = servidor.accept();
            Thread th = new Thread(new RunnableClass(cliente), "Cliente-" + cont);
            th.start();
            cont++;
            System.out.println("Hilo " + th.getName() + " lanzado");
        }
    }

}

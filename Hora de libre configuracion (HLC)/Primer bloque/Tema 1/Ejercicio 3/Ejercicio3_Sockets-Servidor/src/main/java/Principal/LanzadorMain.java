package Principal;

import Clases.SalaChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LanzadorMain {

    public static void main(String[] args) throws IOException {
        final int puerto = 6006;

        ServerSocket server = new ServerSocket(puerto);
        System.out.println("Servidor iniciado en el puerto: " + puerto);
        SalaChat sala = new SalaChat();
        
        List<Peticion> listaHilos = new ArrayList<>();
        
        while (true) {
            Socket cliente = new Socket();
            cliente = server.accept();
            Peticion p = new Peticion(cliente, sala, listaHilos);
            listaHilos.add(p);
            p.start();
        }
    }
}

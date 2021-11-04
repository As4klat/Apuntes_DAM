package Principal;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableClass implements Runnable {

    private Socket cliente;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private final String ruta = "./www";

    public RunnableClass(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        boolean conectado = true;
        try {
            while (conectado) {
                entrada = new DataInputStream(cliente.getInputStream());
                salida = new DataOutputStream(cliente.getOutputStream());
                String entradaDatos = entrada.readUTF();
                if (!entradaDatos.equals("*")) {
                    if (entradaDatos.contains(" ")) {
                        String cadena[] = entradaDatos.split(" ");
                        String peticion = cadena[0];
                        String archivo = cadena[1];

                        if (peticion.equals("GET")) {
                            salida.writeUTF(leerArchivo(archivo));
                        } else {
                            salida.writeUTF("status 404 - error not found");
                        }
                    } else {
                        salida.writeUTF("status 404 - error not found");
                    }
                }
                else{
                    conectado = false;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(RunnableClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Hilo " + Thread.currentThread().getName() + " finalizado.");
    }

    private String leerArchivo(String nombreFile) throws FileNotFoundException, IOException {
        String texto = "";
        String linea;
        boolean leido = false;
        String path = ruta + "\\" + nombreFile;

        File archivo = new File(path);

        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        while (!leido) {
            if ((linea = br.readLine()) != null) {
                texto += linea + "\n";
            } else {
                leido = true;
            }
        }
        br.close();
        fr.close();

        return texto;
    }
}

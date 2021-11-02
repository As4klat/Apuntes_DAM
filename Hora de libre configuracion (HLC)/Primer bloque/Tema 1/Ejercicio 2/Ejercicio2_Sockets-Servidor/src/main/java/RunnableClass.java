
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alejandro
 */
public class RunnableClass implements Runnable{
    private Socket cliente;
    public RunnableClass(Socket cliente){
        this.cliente = cliente;
    }
    
    @Override
    public void run() {
        InputStream entrada = null;
        OutputStream salida = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
      
        try {
            String url = "";
            while (url.equals("*")) {
                // Entrada de datos del cliente
                entrada = cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);
                
                // Salida de datos del servidor
                salida = cliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                
                url = flujoEntrada.readUTF();
                String msg = null;
            
                try{
                    archivo = new File(url);
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);
                    String linea;
                    while((linea=br.readLine())!=null){
                        msg += linea + "\n";
                    }
                    
                    flujoSalida.writeUTF(msg);
                }
                catch(Exception e){
                    flujoSalida.writeUTF("Error 404 not found");
                }
                fr.close();
                br.close();
            }
            cliente.close();
        } catch (IOException ex) {
            
        }
    }
}

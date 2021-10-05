package ejemplo2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Alejandro
 */
public class CrearProceso {
    public void creaProceso(Integer num1, Integer num2){
        
            File ruta = new File(".\\bin");
            ProcessBuilder pb = new ProcessBuilder("java", "ejemplo2.Sumatorio", num1.toString(), num2.toString());
            
            pb.directory(ruta);
            pb.redirectError(new File("error.txt"));
            pb.redirectOutput(new File("salida.txt"));
            
            
        try {    
            Process p = pb.start();
                try {
                    System.out.println(p.waitFor());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

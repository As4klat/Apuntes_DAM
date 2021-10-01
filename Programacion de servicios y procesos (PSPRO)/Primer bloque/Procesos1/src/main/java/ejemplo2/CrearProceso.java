package ejemplo2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class CrearProceso {
    public void creaProceso(int num1, int num2){
        try {
            File ruta = new File(".\\bin");
            ProcessBuilder pb = new ProcessBuilder("JAVA", "ejemplo2.Sumatorio");
            pb.directory(ruta);
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(CrearProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

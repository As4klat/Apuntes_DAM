
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class Proceso {
    public void creaProceso(int num1, int num2){
        
            File ruta = new File(".\\bin");
            ProcessBuilder pb = new ProcessBuilder("java", "Sumatorio", String.valueOf(num1), String.valueOf(num2));
            
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

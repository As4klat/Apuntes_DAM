
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Program Files\\Google\\Chrome\\Application");
        ProcessBuilder pb = new ProcessBuilder("\\chrome.exe"); 
        pb.directory(file);
        Process p = pb.start();
        
        /*
        Process p = pb.start();  
        if(){
            InputStream file = p.getErrorStream();
        }
        else
        {
            InputStream file = p.getInputStream();
        }
        
        
        int i;        
        
        i = file.read();
        while(i != -1){
            System.out.print((char)i);
            i = file.read();
        }
        */
    }   
}

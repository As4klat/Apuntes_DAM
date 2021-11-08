/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Alejandro
 */
public class CorredorHilo extends Thread{

    private JProgressBar corredor;
    
    public CorredorHilo(JProgressBar corredor) {
        this.corredor = corredor;
    }
    
    @Override
    public void run() {
        int min = corredor.getMinimum();
        int max = corredor.getMaximum();
        for(int i = min; i < max; i++){
            corredor.setValue(i);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(CorredorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

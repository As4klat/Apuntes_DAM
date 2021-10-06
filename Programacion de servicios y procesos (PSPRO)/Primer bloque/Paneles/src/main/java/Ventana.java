
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class Ventana extends JFrame {
    
    public JPanel panelActivo;
    
    public Ventana(){
        super();
        
        setSize(400,400);
        setLocation(200,200);
        panelActivo = new PanelA(this);
        getContentPane().add(panelActivo);
        setVisible(true);
        
    }
}

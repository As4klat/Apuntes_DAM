
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class PanelA extends JPanel{

    private JFrame ventana;
    
    public PanelA(Ventana ventana) {
        super();

        this.ventana = ventana;
        
        this.setLayout(new FlowLayout());
        
        JButton btnIraPanelB = new JButton("Ir a panel B");
        this.add(btnIraPanelB);
        
        btnIraPanelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.panelActivo.setVisible(false);
                ventana.panelActivo = new PanelB(ventana);
                ventana.getContentPane().add(ventana.panelActivo);
            }
            
        });
    }
    
    
}

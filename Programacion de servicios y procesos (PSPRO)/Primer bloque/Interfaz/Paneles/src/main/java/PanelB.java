/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 */
public class PanelB extends JPanel {
    private JFrame ventana;
    
    public PanelB(Ventana ventana) {
        super();
        
        this.ventana = ventana;
        
        this.setLayout(new FlowLayout());
        
        JButton btnIraPanelA = new JButton("Ir a panel A");
        this.add(btnIraPanelA);
        
        btnIraPanelA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.panelActivo.setVisible(false);
                ventana.panelActivo = new PanelA(ventana);
                ventana.getContentPane().add(ventana.panelActivo);
            }
 
        });    
    }
}
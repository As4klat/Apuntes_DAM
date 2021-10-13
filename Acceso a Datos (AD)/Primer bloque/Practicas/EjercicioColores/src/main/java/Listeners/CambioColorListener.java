/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 */
public class CambioColorListener implements ActionListener {

    private JPanel panel;
    
    public CambioColorListener(JPanel panel){
        super();
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        panel.setBackground(Color.BLUE);
        panel.repaint();
    }
    
}

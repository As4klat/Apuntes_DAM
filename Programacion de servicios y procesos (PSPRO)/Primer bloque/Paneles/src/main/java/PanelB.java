/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 */
public class PanelB extends JPanel {
    public PanelB() {
        super();
        this.setLayout(new FlowLayout());
        
        JButton btnIrBa = new JButton("Ir a panel A");
        this.add(btnIrBa);
        
    }
}

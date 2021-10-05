
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicSliderUI;

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

    public PanelA() {
        super();
        this.setLayout(new FlowLayout());
        
        JButton btnIraPanelB = new JButton("Ir a panel B");
        this.add(btnIraPanelB);
        
        btnIraPanelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });
    }
    
    
}

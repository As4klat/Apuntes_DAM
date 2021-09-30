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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 */

public class Ventana extends JFrame {
    
    public Ventana(){
        super();
        this.setSize(400,400);
        this.setLocation(200,200);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        
        JButton botonSaludo = new JButton("Saludar");
        panel.add(botonSaludo);
        
        botonSaludo.addActionListener( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Hola mundo");
            }
        });
        pack();
    }
}

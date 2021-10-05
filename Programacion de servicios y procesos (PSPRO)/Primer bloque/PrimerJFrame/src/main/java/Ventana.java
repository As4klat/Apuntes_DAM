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
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */

public class Ventana extends JFrame implements ActionListener{  
    private JTextField texto;
    public JPanel panel, panel2;
    JButton btnSaludo, btnDespedida;
    
    public Ventana(){
        super();
        this.setSize(400,400);
        this.setLocation(200,200);
        
        this.setLayout(new FlowLayout());
        
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        
        btnSaludo = new JButton("Saludar");
        panel.add(btnSaludo);
        btnSaludo.addActionListener(this);
        
        btnDespedida = new JButton("Despedida");
        panel.add(btnDespedida);
        btnDespedida.addActionListener(this);
        
        texto = new JTextField(20);
        panel.add(texto);
        
        //pack();
        
        setVisible(true);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnSaludo){
            texto.setText("holaaaa");
        }
        else if(e.getSource() == btnDespedida){
            texto.setText("Adioooo");
        } 
    }
}

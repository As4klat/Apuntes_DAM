
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class Ventana extends JFrame implements ActionListener{
    public JPanel panel;
    JButton btnRojo, btnAzul, btnVerde;
    
    public Ventana(){
        super();
        this.setSize(400,400);
        this.setLocation(200,200);
        
        this.setLayout(new FlowLayout());
        
        panel = new JPanel();
        this.getContentPane().add(panel);
        
        btnRojo = new JButton("Rojo");
        panel.add(btnRojo);
        btnRojo.addActionListener(this);
        
        btnAzul = new JButton("Azul");
        panel.add(btnAzul);
        btnAzul.addActionListener(this);
        
        btnVerde = new JButton("Verde");
        panel.add(btnVerde);
        btnVerde.addActionListener(this);
        
        setVisible(true);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRojo){
            panel.setBackground(Color.RED);
            panel.repaint();
        }
        else if(e.getSource() == btnAzul){
            panel.setBackground(Color.BLUE);
            panel.repaint();
        }
        else if(e.getSource() == btnVerde){
            panel.setBackground(Color.GREEN);
            panel.repaint();
        }
    }
    
    
}

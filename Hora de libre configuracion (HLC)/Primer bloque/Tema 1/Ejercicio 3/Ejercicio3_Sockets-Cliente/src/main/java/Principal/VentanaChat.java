/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class VentanaChat extends javax.swing.JFrame {

    private Socket cliente = null;
    private String nombre;

    public VentanaChat() throws IOException {

        final int puerto = 6006;
        

        final String host = mostrarModoConexion();

        try {
            this.cliente = new Socket(host, puerto);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido conectar con el servidor.");
            System.exit(0);
        }
        initComponents();
        Escucha e = new Escucha(cliente, areaTxt);
        e.start();

        mostrarUsuarioPanel();
        usuarioConectado();
        areaTxt.setContentType("text/html");
    }

    private void mostrarUsuarioPanel() {
        nombre = JOptionPane.showInputDialog(
                this,
                "Nombre de usuario",
                JOptionPane.QUESTION_MESSAGE);
        if(nombre == null){
           System.exit(0); 
        }
        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "Su nombre de usuario predeterminado es: User" + cliente.getLocalPort());
        } else {
            nombre += ":" + cliente.getLocalPort();
        }
    }

    private String mostrarModoConexion() {
        String host = null;
        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Seleccione modo de conexion",
                "Selector tipo conexion",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Local", "Online"},
                "Local");
        
        switch(seleccion){
            case 0:
                host = "localhost"; 
                break;
            case 1:
                host = "asklat.asuscomm.com";
                break;
            default:
                host = "1";
                break;
        }
        System.out.println(host);
        return host;
    }

    private void usuarioConectado() throws IOException {
        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
        salida.writeUTF(nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        textSend = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTxt = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        areaTxt.setEditable(false);
        areaTxt.setContentType("text/html"); // NOI18N
        areaTxt.setText(null);
        areaTxt.setToolTipText("");
        areaTxt.setAutoscrolls(false);
        jScrollPane1.setViewportView(areaTxt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textSend, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(textSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(VentanaChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (textSend.getText() != null) {
            try {
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                salida.writeUTF(textSend.getText() + ":" + nombre);
                textSend.setText(null);
            } catch (IOException ex) {
                Logger.getLogger(VentanaChat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaChat().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane areaTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textSend;
    // End of variables declaration//GEN-END:variables
}

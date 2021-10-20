/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_CambioJpanel.JpanelMultiple.folder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Dam
 */
public class Principal extends javax.swing.JFrame{

    /**
     * Creates new form Principal
     */
    Panel1 panel1 = new Panel1();
    Panel2 panel2 = new Panel2();
    
    public Principal() {
        initComponents();
        
        contenedor.add(panel1);
        deshabilitarBoton();
    }
    
    private void deshabilitarBoton(){
        if(panel1.isVisible()){
           btn_siguiente.setEnabled(true);
           btn_atras.setEnabled(false);
        }
        else if(panel2.isVisible()){
           btn_siguiente.setEnabled(false);
           btn_atras.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_atras = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenedor.setLayout(new java.awt.BorderLayout());

        btn_atras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_atras.setText("Atras");
        btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_atrasMouseClicked(evt);
            }
        });
        jPanel1.add(btn_atras);

        btn_siguiente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_siguiente.setText("Siguiente");
        btn_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_siguienteMouseClicked(evt);
            }
        });
        jPanel1.add(btn_siguiente);

        contenedor.add(jPanel1, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_atrasMouseClicked
        contenedor.add(panel1);
        panel2.setVisible(false);
        panel1.setVisible(true);
        contenedor.validate();
        deshabilitarBoton();
    }//GEN-LAST:event_btn_atrasMouseClicked

    private void btn_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_siguienteMouseClicked
        contenedor.add(panel2);
        panel1.setVisible(false);
        panel2.setVisible(true);
        contenedor.validate();
        deshabilitarBoton();
    }//GEN-LAST:event_btn_siguienteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}

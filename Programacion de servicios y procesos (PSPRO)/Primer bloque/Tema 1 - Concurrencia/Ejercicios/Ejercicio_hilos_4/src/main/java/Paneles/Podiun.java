/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Principal.CorredorHilo;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alejandro
 */
public class Podiun extends javax.swing.JPanel {

    private JFrame ventana;
    CorredorHilo[] corredores;
    
    public Podiun(CorredorHilo[] corredores, JFrame ventana) {
        this.ventana = ventana;
        this.corredores = corredores;
        initComponents();
        
        JLabel arrayLabels[] = {
            labelCorredorPrimero,
            labelCorredorSegundo,
            labelCorredorTercero,
            labelCorredorCuarto
        };
        
        for(int i = 0; i < arrayLabels.length; i++){
            for(int j = 0; j < corredores.length; j++){
                if(corredores[j].getPosicion()==(i+1)){
                    arrayLabels[i].setText(arrayLabels[i].getText() + ponEspacios(20) + corredores[j].getName()
                                            + ponEspacios(20) + corredores[j].getTiempo());
                }
            }
        }
        
    }
    
    private String ponEspacios(int nEspacios){
        String espacios="";
        for(int i = 0; i <= nEspacios; i++){
            espacios += " ";
        }
        return espacios;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCorredorPrimero = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelCorredorSegundo = new javax.swing.JLabel();
        labelCorredorTercero = new javax.swing.JLabel();
        labelCorredorCuarto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        labelCorredorPrimero.setText("1º");

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel2.setText("Ranking");

        labelCorredorSegundo.setText("2º");

        labelCorredorTercero.setText("3º");

        labelCorredorCuarto.setText("4º");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tiempos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(199, 199, 199))
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel1)
                .addGap(130, 140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelCorredorPrimero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCorredorSegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCorredorTercero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCorredorCuarto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(labelCorredorPrimero)
                .addGap(18, 18, 18)
                .addComponent(labelCorredorSegundo)
                .addGap(18, 18, 18)
                .addComponent(labelCorredorTercero)
                .addGap(18, 18, 18)
                .addComponent(labelCorredorCuarto)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ventana.getRootPane().removeAll();
        ventana.getRootPane().add(ventana.getContentPane());
        ventana.getRootPane().validate();
        ventana.getRootPane().repaint();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelCorredorCuarto;
    private javax.swing.JLabel labelCorredorPrimero;
    private javax.swing.JLabel labelCorredorSegundo;
    private javax.swing.JLabel labelCorredorTercero;
    // End of variables declaration//GEN-END:variables
}

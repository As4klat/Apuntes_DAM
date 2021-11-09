package Principal;

import Crono.Crono;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Ventana extends javax.swing.JFrame {

    private CorredorHilo[] corredores = new CorredorHilo[4];
    private GanadorComHilo gh;
    private List<JProgressBar> posicionesCorredores = new LinkedList<JProgressBar>();
    private boolean inicio = false;
    private Crono c = new Crono();

    public Ventana() {
        initComponents();
        btnParar.setEnabled(false);
        
        int panelX = (getWidth() - panelCorredores.getWidth() - getInsets().left - getInsets().right) / 2;
        int panelY = ((getHeight() - panelCorredores.getHeight() - getInsets().top - getInsets().bottom) / 2);
        panelCorredores.setLocation(panelX, panelY);

        corredores[0] = new CorredorHilo(labelCorredor1.getText(), this.corredor1, c);
        corredores[1] = new CorredorHilo(labelCorredor2.getText(), this.corredor2, c);
        corredores[2] = new CorredorHilo(labelCorredor3.getText(), this.corredor3, c);
        corredores[3] = new CorredorHilo(labelCorredor4.getText(), this.corredor4, c);

        gh = new GanadorComHilo(corredores, this);
    }

    private void iniciarCarrera() {
        btnParar.setEnabled(true);
        for (int i = 0; i < corredores.length; i++) {
            corredores[i].start();
        }
        gh.start();
        c.start();
        inicio = true;
    }

    private void detenerCorredores() {
        inicio = false;
        btnParar.setEnabled(false);
        gh.interrupt();
        c.interrupt();
        c.reset();

        for (int i = 0; i < corredores.length; i++) {
            corredores[i].finalizar();
            corredores[i].interrupt();
        }
        
        c = new Crono();
        corredores[0] = new CorredorHilo(labelCorredor1.getText(), this.corredor1, c);
        corredores[1] = new CorredorHilo(labelCorredor2.getText(), this.corredor2, c);
        corredores[2] = new CorredorHilo(labelCorredor3.getText(), this.corredor3, c);
        corredores[3] = new CorredorHilo(labelCorredor4.getText(), this.corredor4, c);

        gh = new GanadorComHilo(corredores, this);
    }

    private void pausarCorredores() {
        gh.parar();
        c.pausar();
        btnParar.setEnabled(false);
        for (int i = 0; i < corredores.length; i++) {
            corredores[i].parar();
        }
    }

    private void reanudarCorredores() {
        gh.reanudar();
        c.reanudar();
        btnParar.setEnabled(true);
        for (int i = 0; i < corredores.length; i++) {
            corredores[i].reanudar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCorredores = new javax.swing.JPanel();
        corredor1 = new javax.swing.JProgressBar();
        labelCorredor1 = new javax.swing.JLabel();
        labelCorredor2 = new javax.swing.JLabel();
        corredor2 = new javax.swing.JProgressBar();
        labelCorredor3 = new javax.swing.JLabel();
        corredor3 = new javax.swing.JProgressBar();
        corredor4 = new javax.swing.JProgressBar();
        labelCorredor4 = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        corredor1.setForeground(new java.awt.Color(0, 204, 204));
        corredor1.setStringPainted(true);

        labelCorredor1.setText("Corredor 1");

        labelCorredor2.setText("Corredor 2");

        corredor2.setForeground(new java.awt.Color(0, 180, 249));
        corredor2.setStringPainted(true);

        labelCorredor3.setText("Corredor 3");

        corredor3.setForeground(new java.awt.Color(255, 0, 98));
        corredor3.setStringPainted(true);

        corredor4.setForeground(new java.awt.Color(204, 0, 204));
        corredor4.setStringPainted(true);

        labelCorredor4.setText("Corredor 4");

        panelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnParar.setText("Parar");
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotonesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnIniciar, btnParar, btnReiniciar});

        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnParar)
                    .addComponent(btnReiniciar))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout panelCorredoresLayout = new javax.swing.GroupLayout(panelCorredores);
        panelCorredores.setLayout(panelCorredoresLayout);
        panelCorredoresLayout.setHorizontalGroup(
            panelCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCorredoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCorredoresLayout.createSequentialGroup()
                        .addGroup(panelCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(corredor1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(corredor2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(corredor3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(corredor4, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCorredor1)
                            .addComponent(labelCorredor2)
                            .addComponent(labelCorredor3)
                            .addComponent(labelCorredor4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelCorredoresLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {corredor1, corredor2, corredor3, corredor4});

        panelCorredoresLayout.setVerticalGroup(
            panelCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCorredoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(labelCorredor1)
                .addGap(4, 4, 4)
                .addComponent(corredor1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCorredor2)
                .addGap(4, 4, 4)
                .addComponent(corredor2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCorredor3)
                .addGap(4, 4, 4)
                .addComponent(corredor3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCorredor4)
                .addGap(4, 4, 4)
                .addComponent(corredor4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCorredores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCorredores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if (!inicio) {
            iniciarCarrera();
        } else {
            reanudarCorredores();
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        pausarCorredores();
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        detenerCorredores();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JProgressBar corredor1;
    private javax.swing.JProgressBar corredor2;
    private javax.swing.JProgressBar corredor3;
    private javax.swing.JProgressBar corredor4;
    private javax.swing.JLabel labelCorredor1;
    private javax.swing.JLabel labelCorredor2;
    private javax.swing.JLabel labelCorredor3;
    private javax.swing.JLabel labelCorredor4;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCorredores;
    // End of variables declaration//GEN-END:variables
}

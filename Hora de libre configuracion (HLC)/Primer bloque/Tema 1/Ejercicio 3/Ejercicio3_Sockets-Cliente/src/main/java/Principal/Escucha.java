/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;

/**
 *
 * @author Alejandro
 */
public class Escucha extends Thread {

    private Socket cliente;
    private JEditorPane areaTxt;
    private DataInputStream entrada;

    public Escucha(Socket cliente, JEditorPane areaTxt) {
        this.cliente = cliente;
        this.areaTxt = areaTxt;
    }

    @Override
    public void run() {
        String texto = "";
        String str = null;
        String[] msn;

        while (true) {
            try {
                entrada = new DataInputStream(cliente.getInputStream());

                texto = entrada.readUTF();

                str = areaTxt.getText();
                str = str.substring(str.indexOf("<body>") + 6, str.indexOf("</body>"));
                str = str.replaceAll("<p style=\"margin-top: 0\">", "");
                msn = texto.split(":");
                if (msn.length == 2) {
                    texto = "<b>" + msn[0] + " se ha unido a la sala</b><br>";
                } else {
                    if (msn[2].equals(String.valueOf(cliente.getLocalPort()))) {
                        texto = cuentaEspacios() +"<b>Tu: </b>"+ msn[0] + "<br>";
                    } else {
                        texto = "<b>" + msn[1] + ":</b> " + msn[0] + "<br>";
                    }
                }

                areaTxt.setText(str + texto);
            } catch (IOException ex) {
                Logger.getLogger(Escucha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private String cuentaEspacios() {
        String espacios = "";
        for (int i = 0; i < areaTxt.getSize().getWidth() / 6; i++) {
            espacios += "&nbsp;";
        }
        return espacios;
    }
}

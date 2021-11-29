/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PelotaRebotaRebota;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {

    private static final int ANCHURA = 15;
    private static final int ALTURA = 15;
    private double x = 0;
    private double y = 0;
    private double avanceX = 1;
    private double avanceY = 1;
    private Rectangle2D limites;
    private PanelRebota panelRebote;

    public Pelota(PanelRebota panelRebote) {
        this.limites = panelRebote.getBounds();
        this.panelRebote = panelRebote;
    }

    public void update() {
        x += avanceX;
        y += avanceY;
        if (x < limites.getMinX()) {
            x = limites.getMinX();
            avanceX = -avanceX;
        }
        if (x + ANCHURA >= limites.getMaxX()) {
            x = limites.getMaxX() - ANCHURA;
            avanceX = -avanceX;
        }
        if (y < limites.getMinY()) {
            y = limites.getMinY();
            avanceY = -avanceY;
        }
        if (y + ALTURA >= limites.getMaxY()) {
            y = limites.getMaxY() - ALTURA;
            avanceY = -avanceY;
        }
    }

    public Ellipse2D getForma() {
        return new Ellipse2D.Double(x, y, ANCHURA, ALTURA);
    }

    public void paint() {
        this.update();
        panelRebote.paint(panelRebote.getGraphics());
    }
}

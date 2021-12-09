/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Entrada {
    private int id;
    private int butaca;
    private boolean comprada;

    public Entrada(int id, int butaca) {
        this.id = id;
        this.butaca = butaca;
        comprada = false;
    }
    
    //
    //  Getters y Setters
    //
    public int getId() {
        return id;
    }

    public int getButaca() {
        return butaca;
    }
    
    public boolean getComprada() {
        return comprada;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setButaca(int butaca) {
        this.butaca = butaca;
    }

    public void setComprada(boolean comprada) {
        this.comprada = comprada;
    }
}

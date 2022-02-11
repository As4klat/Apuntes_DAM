package Clases;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {

    private int id;
    private String nombre;
    private String[] ingredientes;

    public Pizza(int id, String nombre, String[] ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String ingredientesToString(){
        StringBuilder cadena = new StringBuilder();
        for (String ingrediente : ingredientes) {
            if (ingrediente.equals(ingredientes[ingredientes.length-1])) {
                cadena.append(ingrediente);
            } else {
                cadena.append(ingrediente).append(", ");
            }

        }
        return cadena.toString();
    }
    public String ingredientesToFormatCSV(){
        StringBuilder cadena = new StringBuilder();
        for (String ingrediente : ingredientes) {
            if (ingrediente.equals(ingredientes[ingredientes.length-1])) {
                cadena.append(ingrediente);
            } else {
                cadena.append(ingrediente).append(";");
            }

        }
        return cadena.toString();
    }
}

package Clases;

import java.util.List;

public class Usuario {
    private String email;
    private String password;
    private String nombre;
    private String apellidos;
    private int emailConfirm;
    private List<Pizza> pizzasFav;

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
        emailConfirm = 1;
        nombre = null;
        apellidos = null;
        pizzasFav = null;
    }

    public Usuario(String email, String password, String nombre, String apellidos, int emailConfirm, List<Pizza> pizzasFav) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.emailConfirm = emailConfirm;
        this.pizzasFav = pizzasFav;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEmailConfirm() {
        return emailConfirm;
    }

    public void setEmailConfirm(int emailConfirm) {
        this.emailConfirm = emailConfirm;
    }

    public List<Pizza> getPizzasFav() {
        return pizzasFav;
    }

    public void setPizzasFav(List<Pizza> pizzasFav) {
        this.pizzasFav = pizzasFav;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Alejandro
 */
public class Usuario {
    private int id;
    private String usuario;
    private String password;
    private String email;
    private int nivel;

    public Usuario(int id, String usuario, String password, String email, int nivel) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}

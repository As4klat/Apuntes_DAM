package Controlador;

import Clases.Usuario;

public class LoginStatusUser {
    private static Usuario usuarioLogeado;

    public static void setUser(Usuario u){
        usuarioLogeado = u;
    }

    public static boolean isConfirmed(){
        boolean confirmado =false;
        if(usuarioLogeado.getEmailConfirm()==1){
            confirmado=true;
        }
        return confirmado;
    }

    public static Usuario getUser(){
        return usuarioLogeado;
    }

    public static void modUsuario(Usuario u){
        usuarioLogeado.setEmail(u.getEmail());
        usuarioLogeado.setNombre(u.getNombre());
        usuarioLogeado.setApellidos(u.getApellidos());
        usuarioLogeado.setPassword(u.getPassword());
        usuarioLogeado.setEmailConfirm(u.getEmailConfirm());
        usuarioLogeado.setPizzasFav(u.getPizzasFav());
    }
}

package com.example.preguntas.Controller;

import com.example.preguntas.Clases.Usuario;

public class LoginStatus {
    private static Usuario usuario;

    public static void login(Usuario u){
        usuario = u;
    }
    public static Usuario devolverUsuario(){
        return usuario;
    }
    public static boolean logeado(){
        boolean logeado = false;
        if (usuario != null)
        {
            logeado = true;
        }
        return logeado;
    }
    public static void desconectar(){
        usuario = null;
    }
}

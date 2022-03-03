package com.example.preguntas.Controller;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.preguntas.BaseDatos.SQLiteBD;
import com.example.preguntas.Clases.Pregunta;
import com.example.preguntas.Clases.Usuario;

import java.util.HashMap;

public class ControladorUsuario {
    private static ControladorUsuario controller =  null;
    private final SQLiteBD sqLiteBD;

    private ControladorUsuario(Context context){
        sqLiteBD = new SQLiteBD(context);
    }

    public static ControladorUsuario getInstance(Context context) {
        if (controller == null) {
            controller = new ControladorUsuario(context);
        }
        return controller;
    }

    public HashMap registrarse(Usuario usuario){
        return sqLiteBD.agregarUsuario(usuario);
    }

    public HashMap editarUsuario(Usuario usuario){
        return sqLiteBD.editarUsuario(usuario);
    }

    public boolean login(String email, String password){
        boolean error= true;
        Usuario usuario = sqLiteBD.buscarUsuario(email,password);
        if(usuario!=null){
            LoginStatus.login(usuario);
            error= false;
        }
        return error;
    }
}

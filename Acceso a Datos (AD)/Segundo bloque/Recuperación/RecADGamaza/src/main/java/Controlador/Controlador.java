/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAOUsuarios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Controlador {
    public static void iniciar(){
        DAOUsuarios.getInstance();
    }
    
    public static List<String[]> Consultar(String consulta){
        String[] estadoConsulta={"0"}; // 0 es buena; 1 es un error en la consulta; 2 la consulta no ha encontrado nada;
        List<String[]> listaPersonalizada = new ArrayList<>();
        if(consulta.split(" ")[0].equals("SELECT") || consulta.split(" ")[0].equals("select")){
            listaPersonalizada = DAOUsuarios.getInstance().consultaPersonalizada(consulta);
        }else{
            estadoConsulta[0] = "1";
            listaPersonalizada.add(estadoConsulta);
        }
        return listaPersonalizada;
    }
}

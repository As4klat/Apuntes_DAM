/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import Clases.Usuario;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IDAOUsuarios {
    public List<String[]> consultaPersonalizada(String consulta);
    public List<Usuario> listarUsuarios(int nivel);
}

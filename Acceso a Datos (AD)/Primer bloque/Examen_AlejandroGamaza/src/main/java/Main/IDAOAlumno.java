/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Main;

import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IDAOAlumno {
    public int addAlumno(Alumno alumno);
    public int deleteAlumno(String dni);
    public Alumno getAlumno(String dni);
    public List<Alumno> getAlumnos();
    public void DeshacerEliminarAlumno();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Alejandro
 */
public class Controlador {

    public static void cargarTabla(JTable tabalaAlumnos) {

        List<Alumno> listaAlumnos = DAOAlumnos.getInstance().getAlumnos();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Dni");
        modelo.addColumn("Nombre");
        modelo.addColumn("Asignatura");
        modelo.addColumn("Nota");

        Object[] registroLeido = new Object[4];

        for (Alumno alumno : listaAlumnos) {
            registroLeido[0] = alumno.getDni();
            registroLeido[1] = alumno.getNombre();
            registroLeido[2] = alumno.getAsignatura();
            registroLeido[3] = String.valueOf(alumno.getNota());
            modelo.addRow(registroLeido);
        }
        tabalaAlumnos.setModel(modelo);
    }

    public static boolean eliminarAlumno(JTable tabalaAlumnos) {

        boolean eliminado = false;
        TableModel selecion = tabalaAlumnos.getModel();
        String dni = selecion.getValueAt(tabalaAlumnos.getSelectedRows()[0], 0).toString();

        if (DAOAlumnos.getInstance().deleteAlumno(dni) == 1) {
            eliminado = true;
            cargarTabla(tabalaAlumnos);
        }
        return eliminado;
    }
    
    public static boolean addAlumno(JTable tabalaAlumnos) {

        return true;
    }
}

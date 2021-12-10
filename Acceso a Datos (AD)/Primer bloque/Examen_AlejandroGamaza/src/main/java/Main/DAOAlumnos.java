/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class DAOAlumnos implements IDAOAlumno{

    private List<Alumno> alumnos;
    private static IDAOAlumno dao = null;
    private Connection connection;

    private DAOAlumnos(){
        super();
        this.alumnos = new ArrayList<>();
        String connectionUrl
                = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=ExamenADGamaza;user=luis; password=luis;";

        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * FROM dbo.AlumnosNotas;";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                alumnos.add(new Alumno(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.valueOf(resultSet.getString(4))));
            }

        } catch (SQLException e) {
            connection = null;
            System.out.println(e);
        }
    }
    
    
    
    @Override
    public int addAlumno(Alumno alumno) {
        int insertado = 1;
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getDni().equals(alumno.getDni())) {
                insertado = 0;
                i = alumnos.size();
            }
        }
        if (insertado == 1) {
            String orden = "INSERT INTO dbo.AlumnosNotas VALUES ('" + alumno.getDni()+ "', '" + alumno.getNombre()+ "', '" + alumno.getAsignatura()+ "' '" + alumno.getNota() + "');";
            try {
                PreparedStatement stmt = connection.prepareStatement(orden);
                stmt.executeUpdate();
                alumnos.add(alumno);
            } catch (SQLException ex) {
                System.out.println("No se ha podido registrar al alumno.");
            }
        }
        return insertado;
    }

    @Override
    public int deleteAlumno(String dni) {
        int eliminado = 1;
        String orden = "DELETE FROM dbo.AlumnosNotas WHERE dni = '" + dni + "';";
        try {
            PreparedStatement stmt = connection.prepareStatement(orden);
            stmt.executeUpdate();
            List<Alumno> listaRemoveAlumnos = new ArrayList<>();
            for(Alumno alumno : alumnos){
                if(alumno.getDni().equals(dni)){
                    listaRemoveAlumnos.add(alumno);
                }
            }
            alumnos.removeAll(listaRemoveAlumnos);
        } catch (SQLException ex) {
            eliminado = 0;
            System.out.println("No se pudo eliminar al alumno.");
        }
        return eliminado;
    }

    @Override
    public Alumno getAlumno(String dni) {
        Alumno a = null;
        for (Alumno al : alumnos) {
            if (al.getDni().equals(dni)) {
                a = al;
            }
        }
        return a;
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public void DeshacerEliminarAlumno() {
        
    }

    public static IDAOAlumno getInstance() {
        if (dao == null) {
            dao = new DAOAlumnos();
        }
        return dao;
    }
}

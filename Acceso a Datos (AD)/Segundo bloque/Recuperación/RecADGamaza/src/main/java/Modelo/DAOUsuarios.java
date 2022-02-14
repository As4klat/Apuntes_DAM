/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class DAOUsuarios implements IDAOUsuarios{

    private List<Usuario> listaUsuarios;
    private Connection connection;
    private static IDAOUsuarios dao = null;
    
    private DAOUsuarios(){
        super();
        listaUsuarios = new ArrayList<>();
        String connectionUrl
                = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=ExamenRecADGamaza;user=ra; password=admin;";

        //ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);

        } catch (SQLException e) {
            connection = null;
            System.out.println(e);
        }
    }
    
    public static IDAOUsuarios getInstance(){
        if (dao == null) {
            dao = new DAOUsuarios();
        }
        return dao;
    }
    
    @Override
    public List<String[]> consultaPersonalizada(String consulta) {
        String[] error = {"0"}; // 0 es buena; 1 es un error en la consulta; 2 la consulta no ha encontrado nada.
        List<String[]> resultadoPerosnalizado = new ArrayList<>();
        resultadoPerosnalizado.add(error);
        
        ResultSet resultSet = null;
        try{
            Statement statement = connection.createStatement();
            String selectSql = consulta;
            resultSet = statement.executeQuery(selectSql);
            
            while (resultSet.next()) {
                
                String[] resultado = {resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)};
                resultadoPerosnalizado.add(resultado);
            }
            
            if(resultadoPerosnalizado.size() == 1){
                error[0] = "2";
                resultadoPerosnalizado.get(0)[0] = error[0];
            }
        }catch(Exception ex){
            error[0] = "1";
            resultadoPerosnalizado.get(0)[0] = error[0];
        }
        
        
        return resultadoPerosnalizado;
    }

    @Override
    public List<Usuario> listarUsuarios(int nivel) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

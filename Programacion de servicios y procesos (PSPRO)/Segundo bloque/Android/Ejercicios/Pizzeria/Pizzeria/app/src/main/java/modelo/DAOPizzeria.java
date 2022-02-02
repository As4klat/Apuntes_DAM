package modelo;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.Pizza;
import Clases.Usuario;

public class DAOPizzeria implements IDAOPizzeria{

    private List<Pizza> listaPizzas;
    private List<Usuario> listaUsuarios;
    private static IDAOPizzeria dao = null;
    private Connection connection;

    private DAOPizzeria(){
        super();

        this.listaPizzas = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        String conexionBD = "jdbc:jtds:sqlserver://localhost:1433;"
                + "databaseName=Pizzeria;user=ra;password=admin;";

        ResultSet resultSet = null;

        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection(conexionBD);
            /*Statement statement = connection.createStatement();

            String selectSql = "SELECT * FROM dbo.Pizzas;";
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                listaPizzas.add(new Pizza(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3).split(";")));
            }

            selectSql = "SELECT * FROM dbo.Usuarios;";
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                listaUsuarios.add(new Usuario(
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        null));
            }*/

        }
        catch (SQLException | ClassNotFoundException e) {
            connection = null;
            e.printStackTrace();
        }
    }

    public static IDAOPizzeria getInstance() {
        if (dao == null) {
            dao = new DAOPizzeria();
        }
        return dao;
    }

    @Override
    public boolean insertarUsuario(Usuario u) {
        boolean insertado = true;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getEmail().equals(u.getEmail())) {
                insertado = false;
                i = listaUsuarios.size();
            }
        }
        if (insertado) {
            String orden = "INSERT INTO dbo.Usuarios VALUES (" +
                    "'"+u.getPizzasFav()+"'," +
                    "'"+u.getEmail()+"'," +
                    "'"+u.getPassword()+"'," +
                    "'"+u.getNombre()+"'," +
                    "'"+u.getApellidos()+"'," +
                    "'"+u.getEmailConfirm()+"');";
            try {
                PreparedStatement stmt = connection.prepareStatement(orden);
                stmt.executeUpdate();
                listaUsuarios.add(u);
            } catch (SQLException ex) {
                System.out.println("No se ha podido registrar al usuario.");
            }
        }
        return insertado;
    }

    @Override
    public boolean modificarUsuario(Usuario u) {
        boolean insertado = true;
        String orden
                = "UPDATE dbo.Usuarios "
                + "SET nombre=?, modelo=?, matricula=? "
                + "WHERE email = '" + listaUsuarios.get(listaUsuarios.indexOf(u)).getEmail() + "';";
        try {
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (listaUsuarios.get(i).getEmail().equals(u.getEmail()) && !listaUsuarios.get(i).equals(u)) {
                    insertado = false;
                    i = listaUsuarios.size();
                }
            }
            if (insertado) {
                PreparedStatement stmt = connection.prepareStatement(orden);
                /*stmt.setString(1, u.getMarca());
                stmt.setString(2, u.getModelo());
                stmt.setString(3, u.getMatricula());
                stmt.executeUpdate();
                listaUsuarios.set(listaUsuarios.indexOf(u), u);*/
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido modificar el usuario.");
            System.out.println(ex);
        }

        return insertado;
    }

    @Override
    public Usuario sacarUsuario(String email) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios(){
        return listaUsuarios;
    }

    @Override
    public Pizza sacarPizza(int idPizza) {
        return null;
    }

    @Override
    public List<Pizza> listarPizzas() {
        return listaPizzas;
    }

    private List<Object> parseStringPizzasToList(String listaPizzasCadena){
        List<Object> listaPizasFav = new ArrayList<>();



        return listaPizasFav;
    }
}

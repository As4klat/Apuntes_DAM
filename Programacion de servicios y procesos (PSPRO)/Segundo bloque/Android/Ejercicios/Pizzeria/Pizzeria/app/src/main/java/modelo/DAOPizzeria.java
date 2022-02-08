package modelo;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

import androidx.annotation.RequiresApi;

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
    private String ip = "asklat.asuscomm.com";
    private String db = "Pizzeria";
    private String usuario = "ra";
    private String contraseña = "admin";

    @SuppressLint("NewApi")
    public DAOPizzeria(){
        super();
        this.listaPizzas = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        String conexionBD;

        ResultSet resultSet = null;

        connection = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conexionBD = "jdbc:jtds:sqlserver://"+ip+";" +
                    "databaseName=" + db + ";" +
                    "user=" + usuario + ";" +
                    "password=" + contraseña + ";";
            connection = DriverManager.getConnection(conexionBD);
            System.out.println("Conexion buena");
            Statement statement = connection.createStatement();

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
            }
        } catch (Exception e){
            Log.e("Error ", e.getMessage());
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
            String orden = "INSERT INTO dbo.Usuarios VALUES (?, ?, ?, ?, ?, ?);";
            try {
                PreparedStatement stmt = connection.prepareStatement(orden);
                stmt.setString(1, null);
                stmt.setString(2, u.getEmail());
                stmt.setString(3, u.getPassword());
                stmt.setString(4, u.getNombre());
                stmt.setString(5, u.getApellidos());
                stmt.setInt(6, u.getEmailConfirm());
                stmt.executeUpdate();
                listaUsuarios.add(u);
            } catch (SQLException ex) {
                insertado = false;
                System.out.println("No se ha podido registrar al usuario.");
            }
        }
        return insertado;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public int modificarUsuario(Usuario user) {
        int erroTipo = 0;
        String orden
                = "UPDATE dbo.Usuarios "
                + "SET pizzas_fav=?, email=?, contraseña=?, nombre=?, Apellidos=?, email_confirm=? "
                + "WHERE email = '" + listaUsuarios.get(listaUsuarios.indexOf(user)).getEmail() + "';";
        try {
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (listaUsuarios.get(i).getEmail().equals(user.getEmail()) && !listaUsuarios.get(i).equals(user)) {
                    erroTipo = 2;
                    i = listaUsuarios.size();
                }
            }
            if(erroTipo==0){
                PreparedStatement stmt = connection.prepareStatement(orden);
                stmt.setString(1, null);
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getNombre());
                stmt.setString(5, user.getApellidos());
                stmt.setInt(6, user.getEmailConfirm());
                stmt.executeUpdate();
                listaUsuarios.set(listaUsuarios.indexOf(user), user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            erroTipo = 1;
        }
        return erroTipo;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Usuario sacarUsuario(String email) {
        Usuario u = listaUsuarios.stream().filter(x -> x.getEmail().equals(email)).findFirst().get();
        return u;
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
}

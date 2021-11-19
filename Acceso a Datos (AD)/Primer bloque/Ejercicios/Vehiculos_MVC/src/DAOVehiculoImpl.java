
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOVehiculoImpl implements IDAOVehiculo {

    private List<Vehiculo> falsaBD;
    private static IDAOVehiculo dao = null;
    private Connection connection;

    private DAOVehiculoImpl() {
        super();
        this.falsaBD = new ArrayList<Vehiculo>();
        String connectionUrl
                = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=db.vehiculos;user=ra; password=admin;";

        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * FROM dbo.vehiculo;";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                falsaBD.add(new Vehiculo(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }

        } catch (SQLException e) {
            connection = null;
            System.out.println(e);
        }
    }

    @Override
    public int insertarVehiculo(Vehiculo vehiculo) {
        int insertado = 1;
        for (int i = 0; i < falsaBD.size(); i++) {
            if (falsaBD.get(i).getMatricula().equals(vehiculo.getMatricula())) {
                insertado = 0;
                i = falsaBD.size();
            }
        }
        if (insertado == 1) {
            String orden = "INSERT INTO dbo.vehiculo VALUES ('" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getMatricula() + "');";
            try {
                PreparedStatement stmt = connection.prepareStatement(orden);
                stmt.executeUpdate();
                falsaBD.add(vehiculo);
            } catch (SQLException ex) {
                System.out.println("No se ha podido registrar el coche.");
            }
        }
        return insertado;
    }

    @Override
    public int eliminarVehiculo(String matricula) {
        String orden = "DELETE FROM dbo.vehiculo WHERE matricula = '" + matricula + "';";
        try {
            PreparedStatement stmt = connection.prepareStatement(orden);
            stmt.executeUpdate(orden);
            for (int i = 0; i < falsaBD.size(); i++) {
                if (falsaBD.get(i).getMatricula().equals(matricula)) {
                    falsaBD.remove(falsaBD.get(i));
                    i = falsaBD.size();
                }
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido Eliminar el coche.");
        }
        return 1;
    }

    @Override
    public int eliminarVehiculos(List<Vehiculo> lstVehiculos) {
        for (Vehiculo v : falsaBD) {
            for (Vehiculo vh : lstVehiculos) {
                if (v.equals(vh)) {
                    falsaBD.remove(v);
                }
            }
        }
        return 1;
    }

    @Override
    public Vehiculo getVehiculo(String matricula) {
        Vehiculo vh = null;
        for (Vehiculo v : falsaBD) {
            if (v.getMatricula().equals(matricula)) {
                vh = v;
            }
        }
        return vh;
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        // TODO Auto-generated method stub
        return this.falsaBD;
    }

    public static IDAOVehiculo getInstance() {
        if (dao == null) {
            dao = new DAOVehiculoImpl();
        }

        return dao;
    }

    @Override
    public int eliminarVehiculo(Vehiculo vehiculo) {
        String orden = "DELETE FROM dbo.vehiculo WHERE matricula = '" + vehiculo.getMatricula() + "';";
        try {
            PreparedStatement stmt = connection.prepareStatement(orden);
            stmt.executeUpdate();
            falsaBD.remove(vehiculo);
        } catch (SQLException ex) {
            System.out.println("No se ha podido Eliminar el coche.");
        }
        return 1;
    }

    @Override
    public int modificarVehiculo(Vehiculo vehiculo) {
        int insertado = 1;
        String orden
                = "UPDATE dbo.vehiculo "
                + "SET nombre=?, modelo=?, matricula=? "
                + "WHERE matricula = '" + falsaBD.get(falsaBD.indexOf(vehiculo)).getMatricula() + "';";
        try {
            for (int i = 0; i < falsaBD.size(); i++) {
                if (falsaBD.get(i).getMatricula().equals(vehiculo.getMatricula()) && !falsaBD.get(i).equals(vehiculo)) {
                    insertado = 0;
                    i = falsaBD.size();
                }
            }
            if (insertado == 1) {
                PreparedStatement stmt = connection.prepareStatement(orden);
                stmt.setString(1, vehiculo.getMarca());
                stmt.setString(2, vehiculo.getModelo());
                stmt.setString(3, vehiculo.getMatricula());
                stmt.executeUpdate();
                falsaBD.set(falsaBD.indexOf(vehiculo), vehiculo);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido Modificar el coche.");
            System.out.println(ex);
        }

        return insertado;
    }

}

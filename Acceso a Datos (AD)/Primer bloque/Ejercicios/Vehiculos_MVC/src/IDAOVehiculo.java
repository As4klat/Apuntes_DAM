

import java.util.List;



	public interface IDAOVehiculo 
	{ 
          public int insertarVehiculo(Vehiculo vehiculo);
	  public int eliminarVehiculo(Vehiculo vehiculo);
	  public int eliminarVehiculo(String matricula);
	  public int eliminarVehiculos(List<Vehiculo> lstVehiculos);
	  public Vehiculo getVehiculo(String matricula);
	  public  List<Vehiculo> getVehiculos();
          public int modificarVehiculo(Vehiculo vehiculo);
        }

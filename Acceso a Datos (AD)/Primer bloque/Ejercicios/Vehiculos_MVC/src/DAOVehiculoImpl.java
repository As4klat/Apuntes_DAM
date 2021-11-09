

import java.util.ArrayList;
import java.util.List;



public class DAOVehiculoImpl implements IDAOVehiculo {
	
	private List<Vehiculo> falsaBD;
	private static IDAOVehiculo dao=null; 

	private DAOVehiculoImpl() {
		super();
		this.falsaBD = new ArrayList<Vehiculo>();
		falsaBD.add(new Vehiculo("Renault","Zoe","2345FDF"));
		falsaBD.add(new Vehiculo("Renault","Fluence","0000FTL"));
		falsaBD.add(new Vehiculo("Tesla","3","2422FHT"));
		falsaBD.add(new Vehiculo("Tesla","X","1221FDF"));
	}

	@Override
	public int insertarVehiculo(Vehiculo vehiculo) {
            int insertado = 1;
            for(int i = 0; i < falsaBD.size(); i++){
                if(falsaBD.get(i).getMatricula().equals(vehiculo.getMatricula())){
                    insertado = 0;
                    i = falsaBD.size();
                }
            }
            if(insertado==1){
                falsaBD.add(vehiculo);
            }
            return insertado;
	}
        
	@Override
	public int eliminarVehiculo(String matricula) {
		for(int i = 0; i < falsaBD.size(); i++){
                    if(falsaBD.get(i).getMatricula().equals(matricula)){
                        falsaBD.remove(falsaBD.get(i));
                        i = falsaBD.size();
                    }
                }
		return 1;
	}

	@Override
	public int eliminarVehiculos(List<Vehiculo> lstVehiculos) {
		for (Vehiculo v: falsaBD){
                    for(Vehiculo vh: lstVehiculos){
                        if(v.equals(vh)){
                            falsaBD.remove(v);
                        }
                    }
                }
		return 1;
	}

	@Override
	public Vehiculo getVehiculo(String matricula) {
            Vehiculo vh = null;
            for (Vehiculo v: falsaBD) 
            {
                if(v.getMatricula().equals(matricula)){
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
	  if (dao== null) dao =new DAOVehiculoImpl();
	  
		return dao;
	}

	@Override
	public int eliminarVehiculo(Vehiculo vehiculo) {
		falsaBD.remove(vehiculo);
		return 1;
	}
        
        @Override
        public int modificarVehiculo(Vehiculo vehiculo){
            int insertado = 1;
            for(int i = 0; i < falsaBD.size(); i++){
                if(falsaBD.get(i).getMatricula().equals(vehiculo.getMatricula()) && !falsaBD.get(i).equals(vehiculo)){
                    insertado = 0;
                    i = falsaBD.size();
                }
            }
            if(insertado==1){
                falsaBD.set(falsaBD.indexOf(vehiculo), vehiculo);
            }
            return insertado;
        }

}

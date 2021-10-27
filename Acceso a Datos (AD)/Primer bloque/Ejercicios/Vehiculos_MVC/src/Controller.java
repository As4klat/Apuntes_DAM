

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;





public class Controller
{
	
	
	public static void cargarTabla( JTable tablaVehiculos)
	{ //DefaultTableModel modeloDeDatosTabla = (DefaultTableModel) tablaVehiculos.getModel();
		List<Vehiculo> lstVehiculos = DAOVehiculoImpl.getInstance().getVehiculos();
		
		DefaultTableModel modelo=new DefaultTableModel();
	 
	 
	 modelo.addColumn("Marca");

	 modelo.addColumn("Modelo");

	 modelo.addColumn("Matricula");

	
    
   
	 Object[] registroLeido = new Object [3];
	 
	 for(Vehiculo vehiculo:lstVehiculos)

	 {	 

			registroLeido[0]= vehiculo.getMarca();

			registroLeido[1]= vehiculo.getModelo();

			registroLeido[2]=  vehiculo.getMatricula();
	 



		 modelo.addRow(registroLeido);

	 }
	 
	 tablaVehiculos.setModel(modelo);
	}
	
	
	public static boolean insertarVehiculo( PanelCRUD frmVehiculo, JTable tablaVehiculos)
	{ 
        boolean insertado=false;
	Vehiculo vehiculo=new Vehiculo();
	 
	 
	 
	 vehiculo.setMarca(frmVehiculo.getTxtMarca().getText());

	 vehiculo.setModelo(frmVehiculo.getTxtModelo().getText());

	 vehiculo.setMatricula(frmVehiculo.getTxtMatricula().getText());
	 
		if (DAOVehiculoImpl.getInstance().insertarVehiculo(vehiculo)!=0)
		{insertado=true;
		cargarTabla( tablaVehiculos);
		}
          return insertado;		
	}
        
        public static void leerVehiculo(PanelCRUD frmVehiculo, JTable tablaVehiculos){
            TableModel selecion = tablaVehiculos.getModel();
            
            String marca = selecion.getValueAt(tablaVehiculos.getSelectedRows()[0],0).toString();
            String modelo = selecion.getValueAt(tablaVehiculos.getSelectedRows()[0],1).toString();
            String matricula = selecion.getValueAt(tablaVehiculos.getSelectedRows()[0],2).toString();
            frmVehiculo.getTxtMarca().setText(marca);
            frmVehiculo.getTxtMatricula().setText(matricula);
            frmVehiculo.getTxtModelo().setText(modelo);
       }
        
       public static boolean eliminarVehiculo(PanelCRUD frmVehiculo, JTable tablaVehiculos){
           
           TableModel selecion = tablaVehiculos.getModel();
           Vehiculo vh = DAOVehiculoImpl.getInstance().getVehiculo(selecion.getValueAt(tablaVehiculos.getSelectedRows()[0],2).toString());
           boolean eliminado=false;
           
           if (DAOVehiculoImpl.getInstance().eliminarVehiculo(vh) == 1)
            {
                eliminado=true;
                cargarTabla(tablaVehiculos);
            }
           return eliminado;
       }
       
       public static boolean modificarVehiculo(PanelCRUD frmVehiculo, JTable tablaVehiculos){
           boolean modificado = false;
           TableModel selecion = tablaVehiculos.getModel();
           Vehiculo vh = DAOVehiculoImpl.getInstance().getVehiculo(selecion.getValueAt(tablaVehiculos.getSelectedRows()[0],2).toString());
           
           vh.setMarca(frmVehiculo.getTxtMarca().getText());
           vh.setModelo(frmVehiculo.getTxtModelo().getText());
           vh.setMatricula(frmVehiculo.getTxtMatricula().getText());
           
           if(DAOVehiculoImpl.getInstance().modificarVehiculo(vh) == 1){
               modificado=true;
               cargarTabla(tablaVehiculos);
           }
           
           return modificado;
       }
}

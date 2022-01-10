
using Jardineria.Clases;
using System;
using System.Collections.Generic;

namespace Jardineria
{
    internal class Controlador
    {
        private static ConexionBD instanciaBD;

        public static void IniciarConexion()
        {
            instanciaBD = ConexionBD.TomarInstancia();
        }

        public static void PararConexion()
        {
            instanciaBD.CerrarConexion();
        }

        public static void CrearProducto(Producto p)
        {
            instanciaBD.AgregarProducto(p);
        }

        public static List<Producto> ListaProductos()
        {
            return instanciaBD.DevolverProductos();
        }

        public static List<Gama> ListaGamas()
        {
            return instanciaBD.DevolverGamas();
        }

        public static void EliminarGama(string gama)
        {
            instanciaBD.EliminarGama(gama);
        }

        public static List<Pedido> ListaPedidosFiltro(DateTime fecha)
        {
            return instanciaBD.DevolverPedidosFiltro(fecha);
        }

        public static List<Empleado> ListaEmpleadosPorJefe(int codigo_jefe)
        {
            return instanciaBD.DevolverEmpleadosPorJefe(codigo_jefe);
        }
        public static List<string> ListaCodigoJefes()
        {
            return instanciaBD.DevolverCodigoJefes();
        }

        public static List<Cliente> ListaClientesNoPagan()
        {
            return instanciaBD.DevolverClientesNoPagan();
        }

        public static List<Producto> ListaProductoMasMenosCaro()
        {
            return instanciaBD.DevolverProductoMasMenosCaro();
        }
    }
}

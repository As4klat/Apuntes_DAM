using Jardineria.Clases;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;

namespace Jardineria
{
    internal class ConexionBD
    {

        private static ConexionBD conexionBD = null;
        private SqlConnection conectarbd;

        public ConexionBD():base()
        {
            string cadena = "data source = DESKTOP-4MUCRB0; initial catalog = jardineria; user id = ra; password = ra12345";
            conectarbd = new SqlConnection();
            conectarbd.ConnectionString = cadena;
            try
            {
                conectarbd.Open();
                Console.WriteLine("Conexion abierta.");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error al abrir la BD: " + ex.Message);
            }
        }

        public static ConexionBD TomarInstancia()
        {
            if (conexionBD == null)
            {
                conexionBD = new ConexionBD();
            }
            return conexionBD;
        }

        public void CerrarConexion()
        {
            conectarbd.Close();
        }

        // Acciones en BBDD
        // Relacion con gama
        public List<Gama> DevolverGamas()
        {
            List<Gama> listaGamas = new List<Gama>();
            string sqlcmd = "SELECT * FROM gama_producto;";
            SqlCommand cmd = new SqlCommand(sqlcmd, conectarbd);
            SqlDataReader registros = cmd.ExecuteReader();
            while (registros.Read())
            {
                Gama g = new Gama(
                    registros["gama"].ToString(),
                    registros["descripcion_texto"].ToString(),
                    registros["descripcion_html"].ToString(),
                    registros["imagen"].ToString()
                    );
                listaGamas.Add(g);
            }
            registros.Close();
            return listaGamas;
        }

        public void EliminarGama(string gama)
        {
            try
            {
                SqlCommand cmd = conectarbd.CreateCommand();
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = string.Format($"DELETE detalle_pedido FROM detalle_pedido dp INNER JOIN producto p ON dp.codigo_producto=p.codigo_producto WHERE p.gama='{gama}';");
                cmd.ExecuteNonQuery();
                cmd.CommandText = string.Format($"DELETE FROM producto WHERE gama = '{gama}';");
                cmd.ExecuteNonQuery();
                cmd.CommandText = string.Format($"DELETE FROM gama_producto WHERE gama = '{gama}';");
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error en la ejecucion: " + ex.Message);
            }
        }


        // Relacion con productos
        public List<Producto> DevolverProductos()
        {
            List<Producto> listaProductos = new List<Producto>();
            string sqlcmd = "SELECT * FROM producto;";
            SqlCommand cmd = new SqlCommand(sqlcmd, conectarbd);
            SqlDataReader registros = cmd.ExecuteReader();
            while (registros.Read())
            {
                Producto p = new Producto(
                    registros["codigo_producto"].ToString(),
                    registros["nombre"].ToString(),
                    registros["gama"].ToString(),
                    registros["dimensiones"].ToString(),
                    registros["proveedor"].ToString(),
                    registros["descripcion"].ToString(),
                    registros["cantidad_en_stock"].ToString(),
                    registros["precio_venta"].ToString(),
                    registros["precio_proveedor"].ToString()
                    ); 
                listaProductos.Add(p);
            }
            registros.Close();
            return listaProductos;
        } 

        public void AgregarProducto(Producto p)
        {
            try
            {
                SqlCommand cmd = conectarbd.CreateCommand();
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = string.Format($"INSERT INTO producto VALUES (" +
                    $"'{p.Codigo_producto}'," +
                    $"'{p.Nombre}'," +
                    $"'{p.Gama}'," +
                    $"'{p.Dimensiones}'," +
                    $"'{p.Proveedor}'," +
                    $"'{p.Descripcion}'," +
                    $"{p.Cantidad_en_stock}," +
                    $"{p.Precio_venta}," +
                    $"{p.Precio_proveedor});");
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error en la ejecucion: " + ex.Message);
            }
            
        }

        // Relacion con pedidos
        public List<Pedido> DevolverPedidosFiltro(DateTime fecha)
        {
            List<Pedido> listaPedidosFiltro = new List<Pedido>();
            try
            {
                string sqlcmd = $"SELECT * FROM pedido WHERE MONTH(fecha_entrega) = {fecha.Month} AND YEAR(fecha_entrega) = {fecha.Year} AND estado = 'Entregado'";
                SqlCommand cmd = new SqlCommand(sqlcmd, conectarbd);
                SqlDataReader registros = cmd.ExecuteReader();
                while (registros.Read())
                {
                    Pedido p = new Pedido(
                        registros["codigo_pedido"].ToString(),
                        Convert.ToDateTime(registros["fecha_pedido"]),
                        Convert.ToDateTime(registros["fecha_esperada"]),
                        Convert.ToDateTime(registros["fecha_entrega"]),
                        registros["estado"].ToString(),
                        registros["comentarios"].ToString(),
                        Convert.ToInt32(registros["codigo_cliente"]));
                    listaPedidosFiltro.Add(p);
                }
                registros.Close();
            }
            catch (Exception ex) 
            {
                Console.WriteLine("Error: " + ex);
            }
            return listaPedidosFiltro;
        }

        // Relacion con empleados - jefe
        public List<Empleado> DevolverEmpleadosPorJefe(int codigo_jefe)
        {
            List<Empleado> listaEmpleadosjefe = new List<Empleado>();
            try
            {
                string sqlcmd = $"SELECT nombre, apellido1, apellido2, email FROM empleado WHERE codigo_jefe = {codigo_jefe};";
                SqlCommand cmd = new SqlCommand(sqlcmd, conectarbd);
                SqlDataReader registros = cmd.ExecuteReader();
                while (registros.Read())
                {
                    Empleado e = new Empleado(
                        registros["nombre"].ToString(),
                        registros["apellido1"].ToString(),
                        registros["apellido2"].ToString(),
                        registros["email"].ToString()
                        );
                    listaEmpleadosjefe.Add(e);
                }
                registros.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex);
            }
            return listaEmpleadosjefe;
        }

        public List<string> DevolverCodigoJefes()
        {
            List<string> listaCodigoJefes = new List<string>();
            try
            {
                string sqlcmd = $"SELECT DISTINCT codigo_jefe FROM empleado;";
                SqlCommand cmd = new SqlCommand(sqlcmd, conectarbd);
                SqlDataReader registros = cmd.ExecuteReader();
                while (registros.Read())
                {
                    if (!registros["codigo_jefe"].ToString().Equals(""))
                    {
                        listaCodigoJefes.Add(registros["codigo_jefe"].ToString());
                    }
                }
                registros.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex);
            }
            return listaCodigoJefes;
        }

        // Relacion Clientes que pagan
        public List<Cliente> DevolverClientesNoPagan()
        {
            List<Cliente> listaCodigoJefes = new List<Cliente>();
            try
            {
                string sqlcmd = $"SELECT * FROM cliente " +
                    $"WHERE (SELECT COUNT(*) FROM pedido WHERE cliente.codigo_cliente = pedido.codigo_cliente) > " +
                    $"(SELECT COUNT(*) FROM pago WHERE cliente.codigo_cliente = pago.codigo_cliente);";
                SqlCommand cmd = new SqlCommand(sqlcmd, conectarbd);
                SqlDataReader registros = cmd.ExecuteReader();
                while (registros.Read())
                {
                    Cliente c = new Cliente(
                        Convert.ToInt32(registros["codigo_cliente"]),
                        registros["nombre_cliente"].ToString(),
                        registros["nombre_contacto"].ToString(),
                        registros["apellido_contacto"].ToString(),
                        registros["telefono"].ToString(),
                        registros["fax"].ToString(),
                        registros["linea_direccion1"].ToString(),
                        registros["linea_direccion2"].ToString(),
                        registros["ciudad"].ToString(),
                        registros["region"].ToString(),
                        registros["pais"].ToString(),
                        registros["codigo_postal"].ToString(),
                        Convert.ToInt32(registros["codigo_empleado_rep_ventas"]),
                        Convert.ToDouble(registros["limite_credito"]));
                    listaCodigoJefes.Add(c);
                }
                registros.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex);
            }
            return listaCodigoJefes;
        }

        // Relacion Producto Mas Menos Caro
        public List<Producto> DevolverProductoMasMenosCaro()
        {
            List<Producto> listaProductosMasMenosCaro = new List<Producto>();
            try
            {
                string sqlcmd = $"SELECT * FROM producto WHERE precio_venta = (SELECT MIN(precio_venta) FROM producto) OR precio_venta = (SELECT MAX(precio_venta) FROM producto);";
                SqlCommand cmd = new SqlCommand(sqlcmd, conectarbd);
                SqlDataReader registros = cmd.ExecuteReader();
                while (registros.Read())
                {
                    Producto p = new Producto(
                        registros["codigo_producto"].ToString(),
                        registros["nombre"].ToString(),
                        registros["gama"].ToString(),
                        registros["dimensiones"].ToString(),
                        registros["proveedor"].ToString(),
                        registros["descripcion"].ToString(),
                        registros["cantidad_en_stock"].ToString(),
                        registros["precio_venta"].ToString(),
                        registros["precio_proveedor"].ToString()
                        );
                    listaProductosMasMenosCaro.Add(p);
                }
                registros.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex);
            }
            return listaProductosMasMenosCaro;
        }
    }
}

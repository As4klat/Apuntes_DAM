using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminIES.DLL
{
    class Conexion
    {
        private string cadenaConexion = "Data Source="+ Environment.MachineName + "; Initial Catalog=db.Sistema; Integrated Security = True";
        SqlConnection sqlConnection;

        public SqlConnection EstablecerConexion()
        {
            sqlConnection = new SqlConnection(cadenaConexion);
            return sqlConnection;
        }

        public bool EjecutarComandoSinRetornarDatos(string strComando)
        {
            try
            {
                SqlCommand sqlConmand = new SqlCommand();
                sqlConmand.CommandText = strComando;
                sqlConmand.Connection = EstablecerConexion();
                sqlConnection.Open();
                sqlConmand.ExecuteNonQuery();
                sqlConnection.Close();
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        
        public SqlDataAdapter EjecutarComandoRetornarDatos(string strComando)
        {
            SqlDataAdapter adaptador = new SqlDataAdapter(strComando, cadenaConexion);
            return adaptador;
        }
    }
}

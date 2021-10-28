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
        private string cadenaConexion = "Data Source=ALEJANDROLAP; Initial Catalog=db.Sistema; Integrated Security = True";
        SqlConnection sqlConnection;

        public SqlConnection EstablecerConexion()
        {
            this.sqlConnection = new SqlConnection(this.cadenaConexion);
            return this.sqlConnection;
        }

        public bool EjecutarComandoSinRetornarDatos(string strComando)
        {
            try
            {
                SqlCommand sqlConmand = new SqlCommand();
                sqlConmand.CommandText = strComando;
                sqlConmand.Connection = this.EstablecerConexion();
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
    }
}

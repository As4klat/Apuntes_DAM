using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Prueba_final.DLL
{
    class Conexion
    {
        private string cadenaConexion = "Data Source=" + Environment.MachineName + "; Initial Catalog=db.Sistema; Integrated Security = True";
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
            catch (Exception e)
            {
                return false;
            }
        }

        public SqlDataAdapter EjecutarComandoRetornarDatos(string strComando)
        {
            SqlDataAdapter adaptador = new SqlDataAdapter(strComando, cadenaConexion);
            return adaptador;
        }

        public DataSet EjecutarSentencia(SqlCommand sqlComando)
        {
            DataSet ds = new DataSet();
            SqlDataAdapter adapter = new SqlDataAdapter();
            try
            {
                SqlCommand sqlConmand = new SqlCommand();
                sqlConmand = sqlComando;
                sqlConmand.Connection = EstablecerConexion();
                adapter.SelectCommand = sqlComando;
                sqlConnection.Open();
                adapter.Fill(ds);
                sqlConnection.Close();
                return ds;
            }
            catch (Exception e)
            {
                return ds;
            }
        }
    }
}
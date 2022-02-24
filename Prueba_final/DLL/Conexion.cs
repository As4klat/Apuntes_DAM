using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;

namespace Prueba_final.DLL
{
    class Conexion
    {
        private string cadenaConexion = "Data Source=" + Environment.MachineName + "; Initial Catalog=gw2gg; Integrated Security = True";
        SqlConnection sqlConnection;

        public SqlConnection EstablecerConexion()
        {
            sqlConnection = new SqlConnection(cadenaConexion);
            return sqlConnection;
        }

        public void EjecutarComandoSinRetornarDatos(string strComando)
        {
            SqlCommand sqlConmand = new SqlCommand();
            sqlConmand.CommandText = strComando;
            sqlConmand.Connection = EstablecerConexion();
            sqlConnection.Open();
            sqlConmand.ExecuteNonQuery();
            sqlConnection.Close();
        }

        public IDictionary EjecutarComandoRetornarDatos(string strComando)
        {
            IDictionary<string, object> usuario = new Dictionary<string, object>();
            usuario.Add("status","ok");
            usuario.Add("id", "");
            usuario.Add("nombre", "");
            usuario.Add("email", "");
            usuario.Add("password", "");
            usuario.Add("fecha_creado", "");
            usuario.Add("fecha_borrado", "");
            usuario.Add("api_key", "");
            SqlCommand sqlConmand = new SqlCommand();
            sqlConmand.CommandText = strComando;
            sqlConmand.Connection = EstablecerConexion();
            sqlConnection.Open();
            SqlDataReader reader = sqlConmand.ExecuteReader();
            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    usuario["id"] = reader.GetSqlValue(0);
                    usuario["nombre"]= reader.GetSqlValue(1);
                    usuario["email"] = reader.GetSqlValue(2);
                    usuario["password"] = reader.GetSqlValue(3);
                    usuario["fecha_creado"] = reader.GetSqlValue(4);
                    usuario["fecha_borrado"] = reader.GetSqlValue(5);
                    usuario["api_key"] = reader.GetSqlValue(6);
                }
            }
            else
            {
                usuario["status"] = "No se ha encontrado usuario o la contraseña es invalida.";
            }
            reader.Close();
            sqlConnection.Close();
            return (IDictionary)usuario;
        }
    }
}
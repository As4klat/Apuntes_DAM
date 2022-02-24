using Prueba_final.Clases;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data.SqlTypes;

namespace Prueba_final.DLL
{
    class DaoDLL
    {
        IDictionary<string, string> estado = new Dictionary<string, string>();
        Conexion conexion;

        public DaoDLL()
        {
            estado.Add("status", "");
            estado.Add("mensaje", "");
            conexion = new Conexion();
        }

        public IDictionary AgregarUsuario(Usuario usuario)
        {
            try
            {
                conexion.EjecutarComandoSinRetornarDatos($"INSERT INTO Usuarios (nombre,email,password,fecha_creado,fecha_borrado) VALUES (" +
                    $"NULL," +
                    $"'{usuario.Email}'," +
                    $"'{usuario.Password}'," +
                    $"GETDATE()," +
                    $"NULL);");
                estado["status"] = "ok";
                estado["mensaje"] = "Registro satifactorio.";
                return (IDictionary)estado;
            }
            catch (SqlException ex)
            {
                if (ex.Number == 2627)
                {
                    estado["status"] = "error";
                    estado["mensaje"] = "El correo introducido ya existe.";
                }
                else
                {
                    estado["status"] = "error";
                    estado["mensaje"] = "Error en la conexión.";
                }
                return (IDictionary)estado;
            }
        }

        public IDictionary DevolverUsuario(string email, string password)
        {
            return conexion.EjecutarComandoRetornarDatos($"SELECT * FROM Usuarios " +
                $"WHERE email = '{email}' AND password = '{password}';");
        }

        public IDictionary ActualizarUsuario(Usuario usuario)
        {
            try
            {
                conexion.EjecutarComandoSinRetornarDatos($"UPDATE Usuarios SET " +
                    $"email = '{usuario.Email}'," +
                    $"password = '{usuario.Password}'," +
                    $"api_key = '{usuario.Apikey}'" +
                    $"WHERE id = {usuario.Id};");
                estado["status"] = "ok";
                estado["mensaje"] = "Actualización satifactorio.";
                return (IDictionary)estado;
            }
            catch (SqlException ex)
            {
                estado["status"] = "error";
                estado["mensaje"] = ex.Message;
                return (IDictionary)estado;
            }
        }

    }
}
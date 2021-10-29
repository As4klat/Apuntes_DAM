using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminIES.DLL
{
    class EstudianteDLL
    {
        Conexion conexion;

        public EstudianteDLL()
        {
            conexion = new Conexion();
        }

        public bool Agregar(string nombreAlumno, string primerApellido, string segundoApellido, string email, string foto, string ciclo)
        {
            return conexion.EjecutarComandoSinRetornarDatos("INSERT INTO Estudiante (nombre, primerApellido, segundoApellido, email, foto)" +
                $"values ('{nombreAlumno}', '{primerApellido}', '{segundoApellido}', '{email}', NULL)");
        }

        public bool Modificar(int id, string nombreAlumno, string primerApellido, string segundoApellido, string email, string foto)
        {
            return conexion.EjecutarComandoSinRetornarDatos("update Estudiante set " +
                "nombre= '" + nombreAlumno + "' " +
                "primerApellido= '" + primerApellido + "' " +
                "segundoApellido= '" + segundoApellido + "' " +
                "nombre= '" + email + "' " +
                "where id= " + id);
        }

        public bool Borrar(int id)
        {
            return conexion.EjecutarComandoSinRetornarDatos("delete from Estudiante where id=" + id);
        }

        public DataSet CargarDatos()
        {
            SqlCommand consulta = new SqlCommand("Select id, nombre, primerApellido, segundoApellido, email from Estudiante");
            return conexion.EjecutarSentencia(consulta);
        }
    }

    
}

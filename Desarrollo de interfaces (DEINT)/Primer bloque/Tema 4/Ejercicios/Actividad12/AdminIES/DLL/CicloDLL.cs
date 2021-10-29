using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminIES.DLL
{
    class CicloDLL
    {
        Conexion conexion;

        public CicloDLL()
        {
            conexion = new Conexion();
        }

        public bool Agregar(string nombreCiclo)
        {
            return conexion.EjecutarComandoSinRetornarDatos("Insert into Ciclo(nombre) values('" + nombreCiclo + "')");
        }

        public bool Modificar(int id, string nombreCiclo)
        {
            return conexion.EjecutarComandoSinRetornarDatos("update Ciclo set nombre= '" + nombreCiclo + "' where id= " + id);
        }

        public bool Borrar(int id)
        {
            return conexion.EjecutarComandoSinRetornarDatos("delete from Ciclo where id=" + id);
        }

        public DataSet CargarDatos()
        {
            SqlCommand consulta = new SqlCommand("Select * from Ciclo");
            return conexion.EjecutarSentencia(consulta);
        }

    }
}

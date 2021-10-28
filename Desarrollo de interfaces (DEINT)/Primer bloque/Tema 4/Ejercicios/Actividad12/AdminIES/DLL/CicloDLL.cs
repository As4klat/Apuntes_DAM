using System;
using System.Collections.Generic;
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

        public bool Modificar(string nombreCiclo, int id)
        {
            return conexion.EjecutarComandoSinRetornarDatos("update Ciclo set nombre='" + nombreCiclo + "', where id=" + id);
        }
    }
}

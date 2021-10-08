using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad8.Part1
{
    class Empleado
    {
        public string nombre;
        
        public Empleado(string nombre)
        {
            SetNombre(nombre);
        }

        /*
         *  Getters
         */
        public void SetNombre(string nombre)
        {
            this.nombre = nombre;
        }

        public string GetNombre()
        {
            return this.nombre;
        }

        /*
         *  Métodos
         */

        override
        public string ToString()
        {
            return "\nEmpleado: " + this.nombre;
        }
    }
}

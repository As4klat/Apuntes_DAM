using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad8.Part1
{
    class Operario:Empleado
    {
        public Operario(string nombre) : base(nombre)
        {

        }

        override
        public string ToString()
        {
            return " " + base.ToString() + " -> Operario";
        }
    }
}

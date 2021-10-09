using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7.Persona
{
    class Empresario:Persona
    {
        private double sueldo;

        public Empresario(string nombre, int edad, double sueldo) : base(nombre, edad)
        {
            this.sueldo = sueldo;
        }

        override
        public string ToString()
        {
            return base.ToString() + "\nSueldo: " + sueldo;
        }
    }
}

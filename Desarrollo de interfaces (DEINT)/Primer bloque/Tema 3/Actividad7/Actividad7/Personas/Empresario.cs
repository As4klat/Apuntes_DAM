using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7.Personas
{
    class Empresario : Persona
    {
        private double sueldo;

        public Empresario(string nombre, int edad, double sueldo ) : base(nombre, edad)
        {
            this.sueldo = sueldo;
        }

        /*
         *  Getters
         */
        public double GetSueldo()
        {
            return this.sueldo;
        }

        /*
         *  Métodos
         */
        override
        public string ToString()
        {
            return "El sueldo es de: " + this.sueldo;
        }
    }
}

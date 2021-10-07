using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7.Persona
{
    class Persona
    {
        private string nombre;
        private int edad;

        public Persona()
        {

        }

        public Persona(string nombre, int edad)
        {
            this.nombre = nombre;
            this.edad = edad;
        }

        /*
         *  Getters
         */
        public string GetNombre()
        {
            return this.nombre;
        }
        public int GetEdad()
        {
            return this.edad;
        }
        /*
         *  Métodos
         */

        override
        public string ToString()
        {
            return "Nombre: " + this.nombre +
                   "\nEdad: " + this.edad;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad17.Clases
{
    class Cliente
    {
        private string dni;
        private string nombre;
        private string direccion;
        private int edad;
        private int telefono;
        private long numeroCuentaCorriente;

        public Cliente(string dni, string nombre, string direccion, int edad, int telefono, long numeroCuentaCorriente)
        {
            this.dni = dni ?? throw new ArgumentNullException(nameof(dni));
            this.nombre = nombre ?? throw new ArgumentNullException(nameof(nombre));
            this.direccion = direccion ?? throw new ArgumentNullException(nameof(direccion));
            this.edad = edad;
            this.telefono = telefono;
            this.numeroCuentaCorriente = numeroCuentaCorriente;
        }

        public string Dni
        {
            get { return dni; }
            set { dni = value; }
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public string Direccion
        {
            get { return direccion; }
            set { direccion = value; }
        }

        public int Edad
        {
            get { return edad; }
            set { edad = value; }
        }

        public int Telefono
        {
            get { return telefono; }
            set { telefono = value; }
        }

        public long NumeroCuentaCorriente
        {
            get { return numeroCuentaCorriente; }
            set { numeroCuentaCorriente = value; }
        }
    }
}

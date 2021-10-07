using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7.Clientes
{
    class Cliente
    {
        private string dni;
        private string nombre;
        private double ahorros;

        public Cliente()
        {

        }
        public Cliente(string dni, string nombre, double ahorros)
        {
            this.dni = dni;
            this.nombre = nombre;
            this.ahorros = Helper.decimales2(ahorros);
        }

        /*
         *  Getters
         */
        public string GetDni()
        {
            return this.dni;
        }
        public string GetNombre()
        {
            return this.nombre;
        }

        /*
         *  Métodos
         */
        public void Ingresar(double ahorros)
        {
            this.ahorros = ahorros + this.ahorros;
        }
        public void Extraer(double ahorros)
        {
            this.ahorros = this.ahorros - ahorros;
        }
        public double Saldo()
        {
            return this.ahorros;
        }
    }
}

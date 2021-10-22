using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7.Clientes
{
    class Banco
    {
        private Cliente[] clientes;

        public Banco()
        {
            this.clientes = new Cliente[3];
        }
        public Banco(Cliente[] clientes)
        {
            SetClientes(clientes);
        }
        /*
         *  Setter
         */ 
        private void SetClientes(Cliente[] clientes)
        {
            this.clientes = clientes.Clone() as Cliente[];
        }
        /*
         *  Métodos
         */
        public void Operar(string dni, int opcion, double cantidad)
        {
            Cliente c = (from cliente in clientes where cliente.GetDni().Equals(dni) select cliente).First();
            //o-1. Extraer o-2.Ingresar
            switch (opcion)
            {
                case 1:
                    c.Extraer(cantidad);
                    break;
                case 2:
                    c.Ingresar(cantidad);
                    break;
            }
        }

        public string MostrarOpetacion(string dni)
        {
            Cliente c = (from cliente in clientes where cliente.GetDni().Equals(dni) select cliente).First();
            return Convert.ToString(c.Saldo());
        }

        public string MostrarClientes()
        {
            string cadena = "\n++++++++++++++++++++++++++++++++++++++++++++" + 
                            "\n++++++++++  Clientes del banco  ++++++++++++" +
                            "\n++++++++++++++++++++++++++++++++++++++++++++";

            for (int i = 0; i<clientes.Length; i++)
            {
                cadena += "\n----------------------------------------------";
                cadena += "\nCliente numero " + (i+1) +
                          "\nNombre: " + clientes[i].GetNombre() +
                          "\nDni: " + clientes[i].GetDni() + 
                          "\nAhorros en el banco: " + clientes[i].Saldo();
                cadena += "\n----------------------------------------------";
                if (i == clientes.Length-1)
                {
                    cadena += "\n++++++++++++++++++++++++++++++++++++++++++++";
                }
            }
            return cadena;
        }

        /*
         *  Generar Datos
         */
        public void GenerarDatos()
        {
            string[] dnis = { "32075476K", "13425132J", "29857454F" };
            string[] nombres = { "Alejandro", "Mario", "Elena" };
            double[] ahorros = {1567.41, 321.23, 2000};
            Cliente[] clientes = new Cliente[3];
            for (int i = 0; i < this.clientes.Length; i++)
            {
                Cliente c = new(dnis[i],nombres[i],ahorros[i]);
                clientes[i] = c;
            }
            SetClientes(clientes);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jardineria.Clases
{
    internal class Cliente
    {
        private int codigo_cliente;
        private string nombre_cliente;
        private string nombre_contacto;
        private string apellido_contacto;
        private string telefono;
        private string fax;
        private string linea_direccion1;
        private string linea_direccion2;
        private string ciudad;
        private string region;
        private string pais;
        private string codigo_postal;
        private int codigo_empleado_rep_ventas;
        private double limite_credito;

        public Cliente(
            int codigo_cliente, 
            string nombre_cliente, 
            string nombre_contacto, 
            string apellido_contacto, 
            string telefono, 
            string fax, 
            string linea_direccion1, 
            string linea_direccion2, 
            string ciudad, 
            string region, 
            string pais, 
            string codigo_postal, 
            int codigo_empleado_rep_ventas, 
            double limite_credito)
        {
            Codigo_cliente = codigo_cliente;
            Nombre_cliente = nombre_cliente;
            Nombre_contacto = nombre_contacto;
            Apellido_contacto = apellido_contacto;
            Telefono = telefono;
            Fax = fax;
            Linea_direccion1 = linea_direccion1;
            Linea_direccion2 = linea_direccion2;
            Ciudad = ciudad;
            Region = region;
            Pais = pais;
            Codigo_postal = codigo_postal;
            Codigo_empleado_rep_ventas = codigo_empleado_rep_ventas;
            Limite_credito = limite_credito;
        }

        public int Codigo_cliente { get => codigo_cliente; set => codigo_cliente = value; }
        public string Nombre_cliente { get => nombre_cliente; set => nombre_cliente = value; }
        public string Nombre_contacto { get => nombre_contacto; set => nombre_contacto = value; }
        public string Apellido_contacto { get => apellido_contacto; set => apellido_contacto = value; }
        public string Telefono { get => telefono; set => telefono = value; }
        public string Fax { get => fax; set => fax = value; }
        public string Linea_direccion1 { get => linea_direccion1; set => linea_direccion1 = value; }
        public string Linea_direccion2 { get => linea_direccion2; set => linea_direccion2 = value; }
        public string Ciudad { get => ciudad; set => ciudad = value; }
        public string Region { get => region; set => region = value; }
        public string Pais { get => pais; set => pais = value; }
        public string Codigo_postal { get => codigo_postal; set => codigo_postal = value; }
        public int Codigo_empleado_rep_ventas { get => codigo_empleado_rep_ventas; set => codigo_empleado_rep_ventas = value; }
        public double Limite_credito { get => limite_credito; set => limite_credito = value; }
    }
}

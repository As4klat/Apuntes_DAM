using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace Actividad17.Clases
{
    [XmlRoot("Banco", Namespace = "www.banco.es", IsNullable = false)]
    class Banco
    {
        private List<Cliente> listaClientes;

        public Banco()
        {
            listaClientes = new List<Cliente>();
        }

        public Banco(List<Cliente> listaClientes)
        {
            this.listaClientes = listaClientes;
        }

        public List<Cliente> ListaClientes
        {
            get { return listaClientes; }
            set { listaClientes = value; }
        }

        public void AddCliente(Cliente clienteNuevo)
        {
            listaClientes.Add(clienteNuevo);
        }

        public void RemoveCliente(string dniCliente)
        {
            listaClientes.Remove(listaClientes.Where(x => x.Dni == dniCliente).First());
        }

        public void ModCliente(string dniClienteMod, Cliente clienteMod)
        {
            Cliente clienteAMod = listaClientes.Where(x => x.Dni == dniClienteMod).First();
            clienteAMod.Dni = clienteMod.Dni;
            clienteAMod.Nombre = clienteMod.Nombre;
            clienteAMod.Direccion = clienteMod.Direccion;
            clienteAMod.Edad = clienteMod.Edad;
            clienteAMod.Telefono = clienteMod.Telefono;
            clienteAMod.NumeroCuentaCorriente = clienteMod.NumeroCuentaCorriente;
            clienteMod = null;
        }
    }
}

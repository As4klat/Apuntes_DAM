using System;
using System.Collections.Generic;
using System.Linq;

namespace Actividad17.Clases
{
    public class Banco
    {
        public List<Cliente> listaClientes { get; set; }

        public Banco() { }

        public Banco(List<Cliente> lista) {
            listaClientes = lista;
        }

        public void AddCliente(Cliente clienteNuevo)
        {
            listaClientes.Add(clienteNuevo);
        }

        public void RemoveCliente(string dniCliente)
        {
            listaClientes.Remove(listaClientes.Where(x => x.dni == dniCliente).First());
        }

        public void ModCliente(string dniClienteMod, Cliente clienteMod)
        {
            Cliente clienteAMod = listaClientes.Where(x => x.dni == dniClienteMod).First();
            clienteAMod.dni = clienteMod.dni;
            clienteAMod.nombre = clienteMod.nombre;
            clienteAMod.direccion = clienteMod.direccion;
            clienteAMod.edad = clienteMod.edad;
            clienteAMod.telefono = clienteMod.telefono;
            clienteAMod.numeroCuentaCorriente = clienteMod.numeroCuentaCorriente;
            clienteMod = null;
        }

        public bool DniNoRepe(string dniCliente)
        {
            bool noRepe = false;
            try
            {
                Cliente c = listaClientes.Where(x => x.dni == dniCliente).First();
            }
            catch (Exception e)
            {
                noRepe = true;
            }
            return noRepe;
        }
    }
}

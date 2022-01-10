using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jardineria.Clases
{
    internal class Empleado
    {
        private string nombre;
        private string apellido1;
        private string apellido2;
        private string email;

        public Empleado(string nombre, string apellido1, string apellido2, string email)
        {
            Nombre = nombre;
            Apellido1 = apellido1;
            Apellido2 = apellido2;
            Email = email;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public string Apellido1 { get => apellido1; set => apellido1 = value; }
        public string Apellido2 { get => apellido2; set => apellido2 = value; }
        public string Email { get => email; set => email = value; }
    }
}

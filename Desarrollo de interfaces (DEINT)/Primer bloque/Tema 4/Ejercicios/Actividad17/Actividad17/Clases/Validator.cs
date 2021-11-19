using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Actividad17.Clases
{
    class Validator
    {
        public static bool DniValido(string dni)
        {
            Regex rgx = new Regex(@"^[0-9]{8}[A-Z]{1}$");
            return rgx.IsMatch(dni);
        }

        public static bool NombreValido(string nombre)
        {
            Regex rgx = new Regex(@"^\w");
            return rgx.IsMatch(nombre);
        }

        public static bool TelefonoValido(string telefono)
        {
            Regex rgx = new Regex(@"^[0-9]{9}$");
            return rgx.IsMatch(telefono);
        }

        public static bool NumeroBancoValido(string numeroCuenta)
        {
            Regex rgx = new Regex(@"^[0-9]{12}$");
            return rgx.IsMatch(numeroCuenta);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7.Dados
{
    class Dado
    {
        private int valor;

        public Dado()
        {
        }

        /*
         * Método
         */
        public void Tirar()
        {
            Random rn = new();
            valor = rn.Next(1, 6);
        }
        public string ToCadena()
        {
            return Convert.ToString(valor);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploHerencia
{
   class Resta : Operacion
    {
        public int operar()
        {
            return valor1 - valor2;
        }
    }
}

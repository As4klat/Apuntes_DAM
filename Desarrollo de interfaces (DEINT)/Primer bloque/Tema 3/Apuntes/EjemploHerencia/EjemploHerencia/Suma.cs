using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploHerencia
{
    public class Suma : Operacion
    {
        public int operar()
        {
            return resultado = valor1 + valor2;
        }
    }
}

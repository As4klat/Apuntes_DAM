using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormularioE2
{
    class ContarChar : Operacion
    {
        public int Contar(string cadena, char caracter)
        {
            int cont = 0;
            this.cadena = cadena;
            for (int i = 0; i < this.cadena.Length; i++)
            {
                if (this.cadena[i].Equals(caracter))
                {
                    cont++;
                }
            }
            return resultado = cont;
        }
    }
}

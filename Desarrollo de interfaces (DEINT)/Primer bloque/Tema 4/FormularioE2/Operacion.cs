using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormularioE2
{
    class Operacion
    {
        protected string cadena;
        protected int resultado;
        
        public string Cadena
        {
            get { return cadena; }
            set { cadena = value; }
        }
        public int Resultado
        {
            get { return resultado; }
            set { resultado = value; }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormulariosE3
{
    class TablaMultiplicar
    {
        public string Tabla(int n, int orden)
        {
            string cadena = "";
            switch (orden)
            {
                case 1:
                    for (int i = 0; i <= 10; i++)
                    {
                        cadena += $"{n} x {i} = {n * i}\n";
                    }
                    break;
                case 2:
                    for (int i = 10; i >= 0; i--)
                    {
                        cadena += $"{n} x {i} = {n * i}\n";
                    }
                    break;
                default:
                    cadena = "ERROR";
                    break;
            }
            return cadena;
        }
    }
}

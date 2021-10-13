using System;
using System.Collections.Generic;
using System.Linq;

namespace Actividad06
{
    public class Linq
    {
        static void Main(string[] args)
        {
        }
        public static int sumar()
        {
            var valores = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            var suma = 0;
            foreach (var valor in valores)
            {
                suma += valor;
            }
            return suma;
        }

        public static List<int> numerosPares()
        {
            var valores = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            var pares = new List<int>();
            foreach (var valor in valores)
            {
                if (valor % 2 == 0)
                {
                    pares.Add(valor);
                }
            }
            return pares;
        }

        public static int sumaLinq(List<int> valores)
        {
            //https://docs.microsoft.com/es-es/dotnet/api/system.linq?view=net-5.0
            int suma = valores.Sum();
            return suma;
        }
        public static List<int> numerosParesLinq(List<int> valores)
        {
            List<int> pares = (from valor in valores where valor % 2 == 0 select valor).ToList();
            //List<int> pares = valores.Where(x => x % 2 == 0).ToList();
            return pares;
        }
    }
}

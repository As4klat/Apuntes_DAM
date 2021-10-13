using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploHerencia
{
    public class Ejemplo
    {
        static void Main(string[] args)
        {
            Suma suma1 = new Suma();
            suma1.valor1 = 10;
            suma1.valor2 = 7;
            suma1.operar();
            Console.WriteLine("La suma de " + suma1.valor1 + " y " +
                suma1.valor2 + " es " + suma1.resultado);
            Resta resta1 = new Resta();
            resta1.valor1 = 8;
            resta1.valor2 = 4;
            resta1.operar();
            Console.WriteLine("La diferencia de " + resta1.valor1 +
                " y " + resta1.valor2 + " es " + resta1.resultado);
            Console.ReadKey();
        }
    }
}

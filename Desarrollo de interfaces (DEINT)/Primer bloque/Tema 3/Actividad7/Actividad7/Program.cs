using Actividad7.Dados;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Selecionar ejercicio: ");
            int opcion = Convert.ToInt32(Console.ReadLine());

            switch (opcion)
            {
                case 1:
                    Console.WriteLine("Es un triangulo isóceles por lo cual tiene dos lados iguales y uno diferente.");

                    Console.Write("Lados iguales(cm) " + "\n-> ");
                    double ladosIguales = Convert.ToDouble(Console.ReadLine());
                    Console.Write("Lado desigual(cm) " + "\n-> ");
                    double ladoDesigual = Convert.ToDouble(Console.ReadLine());
                    Console.Write("Altura(cm) " + "\n-> ");
                    double altura = Convert.ToDouble(Console.ReadLine());

                    Triangulo t = new(ladosIguales, ladoDesigual, altura);

                    Console.WriteLine("Lado 1 -> " + t.getLadosIguales() / 2 + " Lado 2 -> " + t.getLadosIguales() / 2 + " Lado 3 -> " + t.getLadoDiferente());
                    Console.WriteLine("Area de tu triangulo: " + t.area());
                    Console.WriteLine("Perímetro de tu triangulo: " + t.perimetro());

                    break;
                case 2:
                    Juego j = new();
                    Console.WriteLine(j.Jugar());
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}

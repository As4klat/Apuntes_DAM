using System;

namespace media.cs
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 1;
            int suma = 0;
            Console.WriteLine("Introduzca 4 numeros");
            while (i <= 4)
            {
                Console.Write("Numero " + i + " : ");
                int n = Convert.ToInt32(Console.ReadLine());
                suma = suma + n;
                i++;
            }
            Console.WriteLine("La media de los números introducidos es: " + suma/4);
        }
    }
}

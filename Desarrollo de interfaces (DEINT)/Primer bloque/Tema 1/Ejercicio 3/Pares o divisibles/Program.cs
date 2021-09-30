using System;

namespace Pares_o_divisibles
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = 1;
            Console.WriteLine("Numeros pares y divisibles entre 3");
            while (n <= 50)
            {
                if (n % 2 == 0 || n % 3 == 0)
                {
                    Console.WriteLine(n);
                }
                n++;
            }
        }
    }
}

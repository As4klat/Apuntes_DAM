using System;

namespace _10primerosPrimos
{
    class Program
    {
        static void Main(string[] args)
        {
            int numero=1;
            int i = 1;
            while (i <= 5)
            {
                int cont = 0;
                for (int j = 1; j <= numero; j++)
                {
                    if (numero % j == 0)
                    {
                        cont++;  
                    }
                }
                if (cont==2)
                {
                    Console.WriteLine(numero);
                    i++;
                }
                numero++;
                
            }
        }
    }
}

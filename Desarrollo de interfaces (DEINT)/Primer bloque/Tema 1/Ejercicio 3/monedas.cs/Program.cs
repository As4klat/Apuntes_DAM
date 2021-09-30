using System;

namespace monedas.cs
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("¿Cuantos productos imaginarios quieres? coste/producto: 45 cent");
            Console.Write("-> ");
            double productos = Convert.ToDouble(Console.ReadLine());
            
            double total = Math.Round(productos * 0.45,2);
            double coste = total;
            int[] cambio = {0,0,0,0,0,0};
            double[] valor = {2,1,0.50,0.20,0.10,0.05};
            int i = 0;
            while (coste != 0)
            {
                if (!(coste - valor[i] < 0) || (coste - valor[i] == 0))
                {
                    cambio[i] = cambio[i] + 1;
                    coste = Math.Round(coste - valor[i],2);
                }
                else
                {
                    if (i < 5)
                    {
                        i++;
                    }
                }
            }
            string[] cadenaMoneda = {"2 Euros.", "1 Euro.", "50 centimos.", "20 centimos.", "10 centimos", "5 centimos"};
            Console.WriteLine("Cambio de " + total);
            for (i=0;i<cambio.Length;i++)
            {
                if (cambio[i] != 0)
                {
                    Console.WriteLine(cambio[i] + " moneda de " + cadenaMoneda[i]);
                }
            }
        }
    }
}

using System;

namespace ExamenT3
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("-------------- Matrices ------------");

            Console.WriteLine("Introducir numero de filas: ");
            int filas = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Introducir numero de columnas: ");
            int columnas = Convert.ToInt32(Console.ReadLine());

            Matriz m = new Matriz(filas,columnas);

            m.RellenarMatriz();

            Console.WriteLine("Tu matriz: ");
            Console.WriteLine("\n" + m.ToString());

            if (m.PuntoDeSilla() == -1)
            {
                Console.WriteLine("No hay punto de silla");
            }
            else
            {
                Console.WriteLine("Hay punto de silla y es: " + m.PuntoDeSilla());
            }
        }
    }
}

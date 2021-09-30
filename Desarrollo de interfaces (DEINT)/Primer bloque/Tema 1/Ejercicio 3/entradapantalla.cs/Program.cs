using System;

namespace entradapantalla.cs
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Introduzca un numero: ");
            Console.Write("-> ");
            int n = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Has introducido el siguiente número: " + "("+n+")");
        }
    }
}

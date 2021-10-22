using Actividad7.Personas;
using Actividad7.Clientes;
using Actividad7.Dados;
using System;

namespace Actividad7
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("-------- Menu Ejercicio 7 -------" +
                              "\n   [A] Triangulo isóceles" +
                              "\n   [B] Juego de dados" +
                              "\n   [C] Banco" + 
                              "\n   [D] Persona y empresario");
            Console.WriteLine("Selecionar ejercicio: ");
            ConsoleKeyInfo op = Console.ReadKey(true);
            switch (op.Key)
            {
                case ConsoleKey.A:
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

                case ConsoleKey.B:
                    Juego j = new();
                    Console.WriteLine(j.Jugar());
                    break;

                case ConsoleKey.C:
                    Banco b = new();
                    b.GenerarDatos();
                    Console.WriteLine(b.MostrarClientes());
                    Console.WriteLine("");
                    Console.Write("Introduzca dni: " + "\n-> ");
                    string dni = Console.ReadLine();
                    Console.WriteLine("\nTipo de gestion:" + "\n[A] Sacar dinero      [B] Ingresar");
                    ConsoleKeyInfo gestion = Console.ReadKey(true);
                    int opcion;
                    switch (gestion.Key)
                    {
                        case ConsoleKey.A:
                            opcion = 1;
                            break;

                        case ConsoleKey.B:
                            opcion = 2;
                            break;

                        default:
                            Console.WriteLine("Error en selecionar opcion");
                            opcion = 3;
                            break;
                    }
                    Console.Write("Cantidad a introducir" + "\n-> ");
                    double cantidad = Convert.ToDouble(Console.ReadLine());
                    b.Operar(dni, opcion, cantidad);
                    Console.WriteLine("");
                    Console.WriteLine(b.MostrarOpetacion(dni));
                    break;

                case ConsoleKey.D:
                    Persona p = new("Luis Ganaza", 25);
                    Empresario e = new("Alejandro Gamaza Martínez", 23, 3123.23);
                    Console.WriteLine(p.ToString());
                    Console.WriteLine("----------------------------------------");
                    Console.WriteLine(e.ToString());
                    break;

                default:
                    Console.WriteLine("Tu opcion no es valida");
                    break;
            }
        }
    }
}

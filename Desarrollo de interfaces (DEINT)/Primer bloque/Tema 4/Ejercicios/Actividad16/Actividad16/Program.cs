using System;
using System.Threading;

namespace Actividad16
{
    class Program
    {
        static void Main(string[] args)
        {
            bool finalizar = false;
            int opcion;


            while (!finalizar)
            {

                Console.WriteLine("\n-------------- Menu ------------");
                for (int i = 1; i <= 5; i++)
                {
                    Console.WriteLine(i + ". Ejercicio " + i);
                }
                Console.WriteLine("6. Salir");
                try
                {
                    Console.WriteLine("\nSelecion: ");
                    opcion = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("");
                    switch (opcion)
                    {
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:
                            finalizar = true;
                            Console.WriteLine("\nFinalizando tarea.");
                            break;
                        default:
                            Console.WriteLine("\nSolo números de 1 a 8.");
                            break;
                    }
                    if (!finalizar)
                    {
                        finalizar = PreguntarVolver();
                    }
                    
                }
                catch (FormatException e)
                {
                    Console.WriteLine("\nDebes insertar números.");
                }
                try
                {
                    Thread.Sleep(800);
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
        }

        /*
        *    Métodos ayudas
        */

        /*                                      Intento fallido
        public static bool PreguntarVolver()
        {
            string respuesta;
            bool finalizar = false;

            Console.WriteLine("\n¿Quieres volver al menu? y/n");
            respuesta = Console.ReadLine();

            if (respuesta.Equals("y") || respuesta.Equals("n"))
            {
                if (respuesta.Equals("n"))
                {
                    finalizar = true;
                }
            }
            else
            {
                Console.WriteLine("\nValor introducido erroneo.");
                PreguntarVolver();
            }
            return finalizar;
        }*/

        public static bool PreguntarVolver()
        {
            string respuesta;
            bool error = true;
            bool finalizar=false;

            while (error)
            {
                Console.WriteLine("\n¿Quieres volver al menu? y/n");
                respuesta = Console.ReadLine();

                if (respuesta.Equals("y") || respuesta.Equals("n"))
                {
                    if (respuesta.Equals("n"))
                    {
                        finalizar = true;
                    }
                    error = false;
                }
                else
                {
                    Console.WriteLine("\nValor introducido erroneo.");
                }
            }
            return finalizar;
        }
    }
}

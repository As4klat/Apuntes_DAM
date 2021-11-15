using System;
using System.IO;
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
                    string ruta;
                    FileInfo[] archivos;
                    FileInfo ultimoAceso;
                    switch (opcion)
                    {
                        case 1:
                            Console.WriteLine("Introducir ruta del directorio: ");
                            Console.Write("-> ");
                            ruta = Console.ReadLine();

                            if (Directory.Exists(ruta))
                            {
                                DirectoryInfo di = new DirectoryInfo(ruta);
                                archivos = di.GetFiles();
                                if (archivos.Length != 0)
                                {
                                    ultimoAceso = archivos[0];   
                                    for (int i = 0; i < archivos.Length; i++)
                                    {
                                        Console.WriteLine(archivos[i].FullName + " Fecha de acceso ultimo: " + archivos[i].LastAccessTime);
                                        if (archivos[i].LastAccessTime >= ultimoAceso.LastAccessTime)
                                        {
                                            ultimoAceso = archivos[i];
                                        }
                                    }
                                    Console.WriteLine("Ultimo archivo leido: " + ultimoAceso.FullName);
                                }
                                else
                                {
                                    Console.WriteLine("El directorio selecionado no contiene ningun archivo.");
                                }
                            }
                            else
                            {
                                Console.WriteLine("No se ha encontrado el directorio.");
                            }
                            break;
                        case 2:
                            string filtro;

                            Console.WriteLine("Introducir ruta del directorio: ");
                            Console.Write("-> ");
                            ruta = Console.ReadLine();

                            if (Directory.Exists(ruta))
                            {
                                DirectoryInfo di = new DirectoryInfo(ruta);
                                archivos = di.GetFiles();
                                if (archivos.Length != 0)
                                {
                                    Console.WriteLine("Introducir extension de archivos deseados. Ej.: 'txt', 'bat'.");
                                    Console.Write("-> ");
                                    filtro = Console.ReadLine();
                                    archivos = di.GetFiles("*."+filtro);
                                    if (archivos.Length != 0)
                                    {
                                        for (int i = 0; i < archivos.Length; i++)
                                        {
                                            Console.WriteLine(archivos[i].FullName);
                                        }
                                    }
                                    else {
                                        Console.WriteLine("No existen ficheros con esa extension.");
                                    }
                                }
                                else
                                {
                                    Console.WriteLine("El directorio selecionado no contiene ningun archivo.");
                                }
                            }
                            else
                            {
                                Console.WriteLine("No se ha encontrado el directorio.");
                            }
                            break;
                        case 3:
                            Console.WriteLine("Introducir ruta del directorio: ");
                            Console.Write("-> ");
                            ruta = Console.ReadLine();

                            if (Directory.Exists(ruta))
                            {
                                Console.WriteLine("Introducir ruta del directorio: ");
                                Console.Write("-> ");
                                string subdirectorioName = Console.ReadLine();

                                Directory.CreateDirectory(ruta+"\\"+subdirectorioName);
                            }
                            else
                            {
                                Console.WriteLine("No se ha encontrado el directorio.");
                            }
                            break;
                        case 4:
                            Console.WriteLine("Introducir extension: Ej.: 'txt', 'odt', 'pdf'.");
                            Console.Write("-> ");
                            string extension = Console.ReadLine();

                            Console.WriteLine("Introducir ruta del directorio: ");
                            Console.Write("-> ");
                            ruta = Console.ReadLine();

                            if (Directory.Exists(ruta))
                            {
                                DirectoryInfo di = new DirectoryInfo(ruta);
                                archivos = di.GetFiles();
                                if (archivos.Length != 0)
                                {
                                    archivos = di.GetFiles("*." + extension);
                                    if (archivos.Length != 0)
                                    {
                                        for (int i = 0; i < archivos.Length; i++)
                                        {
                                            Console.WriteLine(archivos[i].FullName);
                                        }
                                        Console.WriteLine("Deseas eliminar estos archivos? y/n");
                                        Console.Write("-> ");
                                        string respuesta = Console.ReadLine();
                                        if (respuesta.Equals("y"))
                                        {
                                            for (int i = 0; i < archivos.Length; i++)
                                            {
                                                archivos[i].Delete();
                                            }
                                            archivos = di.GetFiles();
                                            for (int i = 0; i < archivos.Length; i++)
                                            {
                                                Console.WriteLine(archivos[i].Name);
                                            }
                                        }
                                    }
                                    else
                                    {
                                        Console.WriteLine("No existen ficheros con esa extension.");
                                    }
                                }
                                else
                                {
                                    Console.WriteLine("El directorio selecionado no contiene ningun archivo.");
                                }
                            }
                            else
                            {
                                Console.WriteLine("No se ha encontrado el directorio.");
                            }
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

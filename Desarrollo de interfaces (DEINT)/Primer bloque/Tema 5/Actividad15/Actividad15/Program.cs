using System;
using System.Collections.Generic;
using System.IO;
using System.Threading;

namespace Actividad15
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
                for (int i = 1; i <= 6; i++)
                {
                    Console.WriteLine(i + ". Ejercicio " + i);
                }
                Console.WriteLine("7. Salir");
                try
                {
                    Console.WriteLine("\nSelecion: ");
                    opcion = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("");
                    switch (opcion)
                    {
                        case 1:
                            Console.WriteLine("Copia de ficheros [Ruta/nombre_origen] -c [Ruta/nombre_destino]");
                            Console.Write("-> ");
                            string nombreFicheros = Console.ReadLine();
                            string[] nombreFicherosArray = nombreFicheros.Trim().Split(" -c ");
                            List<string> contenido = new List<string>();
                            try
                            {
                                foreach (string line in File.ReadLines($@"{nombreFicherosArray[0]}"))
                                {
                                    contenido.Add(line);
                                }
                                try
                                {
                                    File.WriteAllLines($@"{nombreFicherosArray[1]}", contenido);
                                }
                                catch (FileNotFoundException e)
                                {
                                    Console.WriteLine("No se ha encontrado su fichero de salida.");
                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                Console.WriteLine("No se ha encontrado su fichero de entrada.");
                            }

                            finalizar = preguntarVolver();
                            break;
                        case 2:
                            Console.WriteLine("Busqueda dentro de archivo [Ruta/nombre_origen] -s [Frase a buscar]");
                            Console.Write("-> ");
                            nombreFicheros = Console.ReadLine();
                            nombreFicherosArray = nombreFicheros.Trim().Split(" -s ");
                            try
                            {
                                int contLine = 0;
                                foreach (string line in File.ReadLines($@"{nombreFicherosArray[0]}"))
                                {
                                    contLine++;
                                    if (line.Contains(nombreFicherosArray[1]))
                                    {
                                        Console.WriteLine("Linea: " + contLine + " " + line);
                                    }
                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                Console.WriteLine("No se ha encontrado su fichero.");
                            }

                            finalizar = preguntarVolver();
                            break;
                        case 3:
                            Console.WriteLine("Copia de ficheros [Ruta/nombre_origen] -c [Ruta/nombre_destino]");
                            Console.Write("-> ");
                            nombreFicheros = Console.ReadLine();
                            nombreFicherosArray = nombreFicheros.Trim().Split(" -c ");
                            contenido = new List<string>();
                            try
                            {
                                foreach (string line in File.ReadLines($@"{nombreFicherosArray[0]}"))
                                {
                                    contenido.Add(line);
                                }
                                try
                                {
                                    File.WriteAllLines($@"{nombreFicherosArray[1]}", contenido);
                                }
                                catch (FileNotFoundException e)
                                {
                                    Console.WriteLine("No se ha encontrado su fichero de salida.");
                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                Console.WriteLine("No se ha encontrado su fichero de entrada.");
                            }

                            finalizar = preguntarVolver();
                            break;
                        case 4:

                            Console.WriteLine("Notas de alumno [Ruta/nombre_origen] -n [Ruta/nombre_destino]");
                            Console.Write("-> ");
                            string nombreFichero = Console.ReadLine();
                            nombreFicherosArray = nombreFichero.Trim().Split(" -n ");
                            List<Alumno> listaAlumnos = new List<Alumno>();
                            string[] datos;
                            int notaMedia = 0;
                            int notaMasAlta = 0;
                            string notaMediaAlumno = "";
                            try
                            {
                                string[] cadenaArray = File.ReadAllLines($@"{nombreFicherosArray[0]}");
                                for (int i = 1; i < cadenaArray.Length; i++)
                                {
                                    datos = cadenaArray[i].Split(" ");
                                    string nombre = datos[0];
                                    int notaMates = Convert.ToInt32(datos[1]);
                                    int notaInformatica = Convert.ToInt32(datos[2]);
                                    listaAlumnos.Add(new Alumno(nombre, notaMates, notaInformatica));
                                }
                                foreach (Alumno var in listaAlumnos)
                                {
                                    if (notaMasAlta < var.NotaInfor)
                                    {
                                        notaMasAlta = var.NotaInfor;
                                        notaMediaAlumno = var.Nombre + " " + notaMasAlta;
                                    }
                                    notaMedia += var.NotaMates;
                                }
                                notaMedia = notaMedia / listaAlumnos.Count;
                                string[] contenidofila = { "Nota media: " + notaMedia + "\nNota mas alta: " + notaMediaAlumno };
                                try
                                {
                                    File.WriteAllLines($@"{nombreFicherosArray[1]}", contenidofila);
                                }
                                catch (FileNotFoundException e)
                                {
                                    Console.WriteLine("No se ha encontrado su fichero de salida.");
                                }
                            }
                            catch (FileNotFoundException e)
                            {
                                Console.WriteLine("No se ha encontrado su fichero.");
                            }
                            finalizar = preguntarVolver();
                            break;
                        case 5:

                            Console.WriteLine("Fusión de ficheros [Ruta/nombre_origen] -f [Ruta/nombre_destino]");
                            Console.Write("-> ");
                            nombreFicheros = Console.ReadLine();
                            nombreFicherosArray = nombreFicheros.Trim().Split(" -f ");
                            List<string> contenidoF1 = new List<string>();
                            List<string> contenidoF2 = new List<string>();
                            contenido = new List<string>();
                            int leng;
                            bool alternar = true;
                            int contador1 = 0;
                            int contador2 = 0;
                            try
                            {
                                foreach (string line in File.ReadLines($@"{nombreFicherosArray[0]}"))
                                {
                                    contenidoF1.Add(line);
                                }
                                foreach (string line in File.ReadLines($@"{nombreFicherosArray[1]}"))
                                {
                                    contenidoF2.Add(line);
                                }

                                if (contenidoF1.Count > contenidoF2.Count)
                                {
                                    for (int i = 0; i < contenidoF1.Count + contenidoF2.Count; i++)
                                    {
                                        if (alternar)
                                        {
                                            contenido.Add(contenidoF1[contador1]);
                                            contador1++;
                                            if (contador2 != contenidoF2.Count)
                                            {
                                                alternar = false;
                                            }
                                        }
                                        else
                                        {
                                            contenido.Add(contenidoF2[contador2]);
                                            contador2++;
                                            alternar = true;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int i = 0; i < contenidoF1.Count + contenidoF2.Count; i++)
                                    {
                                        if (alternar)
                                        {
                                            contenido.Add(contenidoF2[contador2]);
                                            contador2++;
                                            if (contador1 != contenidoF1.Count)
                                            {
                                                alternar = false;
                                            }
                                        }
                                        else
                                        {
                                            contenido.Add(contenidoF1[contador1]);
                                            contador1++;
                                            alternar = true;
                                        }
                                    }
                                }

                                Console.WriteLine("Ruta del nuevo fichero");
                                Console.Write("-> ");
                                string ruta = Console.ReadLine();

                                File.WriteAllLines($@"{ruta}\union.txt", contenido);
                            }
                            catch (FileNotFoundException e)
                            {
                                Console.WriteLine("No se ha encontrado su fichero.");
                            }

                            finalizar = preguntarVolver();
                            break;
                        case 6:

                            Console.WriteLine("Fichero de enteros [Ruta/nombre_origen]");
                            Console.Write("-> ");
                            nombreFichero = Console.ReadLine();
                            contenido = new List<string>();
                            
                            try
                            {
                                foreach (string line in File.ReadLines($@"{nombreFichero}"))
                                {
                                    contenido.Add(line);
                                }

                                string[] contenidoSplit = contenido[0].Split(",");
                                int suma = 0;
                                foreach (string var in contenidoSplit)
                                {
                                    Console.Write(var + " ");
                                    suma += Convert.ToInt32(var);
                                }
                                Console.WriteLine("Suma: " + suma);
                            }
                            catch (FileNotFoundException e)
                            {
                                Console.WriteLine("No se ha encontrado su fichero.");
                            }


                            finalizar = preguntarVolver();
                            break;
                        case 7:
                            finalizar = true;
                            Console.WriteLine("\nFinalizando tarea.");
                            break;
                        default:
                            Console.WriteLine("\nSolo números de 1 a 8.");
                            break;
                    }
                }
                catch (FormatException e)
                {
                    Console.WriteLine(e);
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
        public static bool preguntarVolver()
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
                preguntarVolver();
            }
            return finalizar;
        }
    }
}

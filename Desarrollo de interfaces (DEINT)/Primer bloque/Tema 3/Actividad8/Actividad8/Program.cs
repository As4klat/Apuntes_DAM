using Actividad8.Part1;
using Actividad8.Part2;
using Actividad8.Part3;
using System;

namespace Actividad8
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Empleados");
            Empleado e = new Empleado("Alendro");
            Operario o = new Operario("Juan");
            Directivo d = new Directivo("Pepe");
            Oficial of = new Oficial("Ana");
            Tecnico t = new Tecnico("Antonia");

            Console.WriteLine(e.ToString() + o.ToString() + d.ToString() + of.ToString() + t.ToString());

            Console.WriteLine("\nElectrodomésticos");
            Electrodomestico[] listaElec = {
                new Electrodomestico(),
                new Lavadora(),
                new Television(),
                new Electrodomestico(245, 32),
                new Electrodomestico(245, 90),
                new Lavadora(400, 15),
                new Lavadora(40),
                new Television(120, 20),
                new Television(130, true)
                };

            for (int i = 0; i < listaElec.Length; i++)
            {
                Console.WriteLine("Precio: " + listaElec[i].PrecioFinal());
            }

            Console.WriteLine("\nSeries y videojuegos");
            Serie[] series =
            {
                new Serie(),
                new Serie("Silicon Valley", 6, "Comedia", "Mike Judge"),
                new Serie("Doraemon","Fujiko F. Fujio"),
                new Serie("Shin-chan","Yoshito Usui"),
                new Serie("Juego de tronos", 8, "Fanasia", "David Benioff")
            };
            Videojuego[] videojuegos =
            {
                new Videojuego(),
                new Videojuego("Guild Wars 2", 12, "MMORPG", "ArenaNet"),
                new Videojuego("Dark Souls", 2, "RPG", "From Software"),
                new Videojuego("The Elder Scroll V: Skrim", 8),
                new Videojuego("Scape From Tarkov", 1)
            };

            int contEntregados=0;
            int contDevueltos = 0;
            series[4].Entregar();
            series[2].Entregar();
            videojuegos[1].Entregar();
            videojuegos[3].Entregar();
            videojuegos[4].Entregar();

            for (int i=0; i < series.Length; i++)
            {
                Console.WriteLine(series[i].ToString());
                if (series[i].IsEntregado())
                {
                    contEntregados++;
                }
                else
                {
                    contDevueltos++;
                    series[i].Devolver();
                }
            }
            for (int i = 0; i < videojuegos.Length; i++)
            {
                Console.WriteLine(videojuegos[i].ToString());
                if (videojuegos[i].IsEntregado())
                {
                    contEntregados++;
                }
                else
                {
                    contDevueltos++;
                    videojuegos[i].Devolver();
                }
            }

            Console.WriteLine("Series y videojuegos entregadas: " + contEntregados +
                              "\nSeries y videojuegos devueltas: " + contDevueltos);

        }
    }
}

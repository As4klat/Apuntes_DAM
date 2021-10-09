﻿using Actividad8.Part1;
using Actividad8.Part2;
using System;

namespace Actividad8
{
    class Program
    {
        static void Main(string[] args)
        {
            Empleado e = new Empleado("Alendro");
            Operario o = new Operario("Juan");
            Directivo d = new Directivo("Pepe");
            Oficial of = new Oficial("Ana");
            Tecnico t = new Tecnico("Antonia");

            Console.WriteLine(e.ToString() + o.ToString() + d.ToString() + of.ToString() + t.ToString());
            Console.WriteLine("");

            Electrodomestico ele = new Electrodomestico();
            Console.Write(ele.PrecioFinal());
        }
    }
}
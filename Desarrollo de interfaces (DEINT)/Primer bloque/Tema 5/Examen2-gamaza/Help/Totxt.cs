using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Examen2_gamaza.Help
{
    class Totxt
    {
        public static void generarlog(List<string> usuario)
        {
            usuario.Add(" ");
            File.WriteAllLines("../../operaciones.log", usuario.ToArray());
        }

        public static void actualizarlog(List<string> usuario)
        {
            usuario.Add(" ");
            File.AppendAllLines("../../operaciones.log", usuario.ToArray());
        }

        public static bool comprobarLog()
        {
            return File.Exists("../../operaciones.log");
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace Actividad21_2.Clases
{
    internal class Habilidad : TextBlock
    {
        private int id;
        public Habilidad(int id, string nombre, TextWrapping w)
        {
            Text = nombre;
            TextWrapping =  w;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jardineria.Clases
{
    internal class Gama
    {
        private string nombre;
        private string descripcion;
        private string descripcionHtml;
        private string imagen;

        public Gama(string nombre, string descripcion, string descripcionHtml, string imagen)
        {
            Nombre = nombre;
            Descripcion = descripcion;
            DescripcionHtml = descripcionHtml;
            Imagen = imagen;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public string DescripcionHtml { get => descripcionHtml; set => descripcionHtml = value; }
        public string Imagen { get => imagen; set => imagen = value; }
    }
}

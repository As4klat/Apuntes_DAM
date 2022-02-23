using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Prueba_final.Clases
{
    public class Usuario
    {
        private string nombre;
        private string email;
        private string password;
        private string fecha_creado;
        private string fecha_borrado;
        private string apikey;

        public Usuario(string email, string password)
        {
            Nombre = null;
            Email = email;
            Password = password;
            Fecha_creado = DateTime.Now.ToString();
            Fecha_borrado = null;
            Apikey = null;
        }

        public Usuario(string nombre, string email, string password, string fecha_creado, string fecha_borrado, string apikey)
        {
            Nombre = nombre;
            Email = email;
            Password = password;
            Fecha_creado = fecha_creado;
            Fecha_borrado = fecha_borrado;
            Apikey = apikey;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public string Email { get => email; set => email = value; }
        public string Password { get => password; set => password = value; }
        public string Fecha_creado { get => fecha_creado; set => fecha_creado = value; }
        public string Fecha_borrado { get => fecha_borrado; set => fecha_borrado = value; }
        public string Apikey { get => apikey; set => apikey = value; }
    }
}
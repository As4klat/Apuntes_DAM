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
        private DateTime fecha_creado;
        private DateTime fecha_borrado;
        private Apikey apikey;

        public Usuario(string email, string password)
        {
            Nombre = null;
            Email = email;
            Password = password;
            Fecha_creado = DateTime.Now;
            Apikey = null;
        }

        public Usuario(string nombre, string email, string password, DateTime fecha_creado, DateTime fecha_borrado)
        {
            Nombre = nombre;
            Email = email;
            Password = password;
            Fecha_creado = fecha_creado;
            Fecha_borrado = fecha_borrado;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public string Email { get => email; set => email = value; }
        public string Password { get => password; set => password = value; }
        public DateTime Fecha_creado { get => fecha_creado; set => fecha_creado = value; }
        public DateTime Fecha_borrado { get => fecha_borrado; set => fecha_borrado = value; }
        public Apikey Apikey { get => apikey; set => apikey = value; }
    }
}
using Prueba_final.Clases;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Prueba_final.Controlador
{
    public class LoginStatus
    {
        private static Usuario usuario = null;

        public static void InsertarUsuario(Usuario usuario) => _ = usuario;
        public static Usuario GetUsuario() => usuario;
        public static bool Logeado()
        {
            bool logeado = false;
            if (usuario != null)
            {
                logeado = true;
            }
            return logeado;
        }
    }
}
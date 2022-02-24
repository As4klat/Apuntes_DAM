
using Prueba_final.Clases;
using Prueba_final.DLL;
using System;
using System.Collections;
using System.Linq;

namespace Prueba_final.Controladores
{
    public class Controlador { 

        private static DaoDLL dao = new DaoDLL();

        public static void Registrarse(string email, string password)
        {
            Usuario usuario = new Usuario(email, Encriptar(password));
            IDictionary estado = dao.AgregarUsuario(usuario);
            if (!estado["status"].ToString().Equals("ok"))
            {
                throw new Exception(estado["mensaje"].ToString());
            }
            LoginStatus.InsertarUsuario(usuario);
        }

        public static void IniciarSesion(string email, string password)
        {
            IDictionary estado = dao.DevolverUsuario(email, Encriptar(password));
            if (!estado["status"].ToString().Equals("ok"))
            {
                throw new Exception(estado["status"].ToString());
            }

            string nombre;
            if (estado["nombre"].ToString().Equals("Null"))
            {
                nombre = null;
            }
            else
            {
                nombre = estado["nombre"].ToString();
            }

            string fecha_borrado;
            if (estado["fecha_borrado"].ToString().Equals("Null"))
            {
                fecha_borrado = null;
            }
            else
            {
                fecha_borrado = estado["fecha_borrado"].ToString();
            }

            string api_key;
            if (estado["api_key"].ToString().Equals("Null"))
            {
                api_key = null;
            }
            else
            {
                api_key = estado["api_key"].ToString();
            }

            LoginStatus.InsertarUsuario(new Usuario(
                    Convert.ToInt32(estado["id"].ToString()),
                    nombre,
                    estado["email"].ToString(),
                    DesEncriptar(estado["password"].ToString()),
                    estado["fecha_creado"].ToString(),
                    fecha_borrado,
                    api_key
                ));
        }

        public static void CerrarSesion()
        {
            LoginStatus.InsertarUsuario(null);
        }

        private static string Encriptar(string password)
        {
            string result = string.Empty;
            byte[] encryted =
            System.Text.Encoding.Unicode.GetBytes(password);
            result = Convert.ToBase64String(encryted);
            return result;
        }

        public static string DesEncriptar(string password)
        {
            string result = string.Empty;
            byte[] decryted = Convert.FromBase64String(password);
            System.Text.Encoding.Unicode.GetString(decryted, 0, decryted.ToArray().Length);
            result = System.Text.Encoding.Unicode.GetString(decryted);
            return result;
        }

    }
}
using System;
using System.Text.RegularExpressions;

namespace Actividad09
{
    public class Actividad9
    {
        static void Main(string[] args)
        {
        }

        public static bool cadenaContenedora(string cadena, string valor)
        {
            bool comp = false;
            string patron = "["+valor+"]";
            Regex rgx = new Regex(patron);
            if (rgx.Match(cadena).Success)
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }

        public static bool numeroEntero(string v)
        {
            bool comp = false;
            string patron =  @"^-?\d+$";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(v))
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }

        public static bool isSpanish(string telefono)
        {
            bool comp = false;
            string patron = @"(\+34|0034|34)?[-]*(6|7|9)[-]*(\d[-]*){8}";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(telefono))
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }

        public static bool isCorrectEmail(string email)
        {
            bool comp = false;
            string patron = @"^[^\s@]+@[^\s@]+\.[^\s@]+$";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(email))
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }

        public static bool numeroPositivo(string v)
        {
            bool comp = false;
            string patron = @"^\d+$";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(v))
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }

        public static bool isOctal(string v)
        {
            bool comp = false;
            string patron = @"^[0-8]+$";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(v))
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }

        public static bool dni(string v)
        {
            bool comp = false;
            string patron = @"^\d{8}[A-Z]{1}";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(v))
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }

        public static bool fechaFormat(string v)
        {
            bool comp = false;
            string patron = @"\d{2}[/]\d{2}[/]\d{4}";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(v))
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }

        public static bool isBinario(string v)
        {
            bool comp = false;
            string patron = @"^[0-1]+$";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(v))
            {
                comp = true;
            }
            return comp;
            throw new NotImplementedException();
        }
    }
}

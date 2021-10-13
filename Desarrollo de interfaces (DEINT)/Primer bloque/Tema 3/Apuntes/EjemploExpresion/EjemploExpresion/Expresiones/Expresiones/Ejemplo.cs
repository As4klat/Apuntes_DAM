using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace Expresiones
{
    public class Ejemplo
    {
        static void Main(string[] args)
        {
            //https://docs.microsoft.com/es-es/dotnet/standard/base-types/regular-expression-language-quick-reference
            //Ejemplo 1
            string frase = "A developer lives like olive oil – Always adding good taste to what they do.";
            string patron = "[A]";

            Regex regex = new Regex(patron);
            MatchCollection match = regex.Matches(frase);
            int total = match.Count();

            //Ejemplo 2
            string frase2 = "Aquí tienes mi número de telefono (+34)666-66-66-66";
            string patron2 = @"\d{3}";
            Regex regex2 = new Regex(patron2);
            MatchCollection match2 = regex2.Matches(frase2);
            int total2 = match2.Count();
        }
        

    }
}

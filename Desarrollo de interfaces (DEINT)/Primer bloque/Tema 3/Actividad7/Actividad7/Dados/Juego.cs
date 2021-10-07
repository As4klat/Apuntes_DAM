using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7.Dados
{
    class Juego
    {
        private Dado[] dados;

        public Juego()
        {
            dados = new Dado[3];
        }

        /*
         * Métodos
         */
        public string Jugar()
        {
            string cadena = "\nHas sacado:\n";
            for (int i=0; i < dados.Length; i++)
            {
                dados[i] = new Dado();
                dados[i].Tirar();
                cadena += dados[i].ToCadena() + " ";
            }

            return Ganador(cadena);
        }
        private string Ganador(string cadena)
        {
            if (Iguales())
            {
                cadena += "\nMuy buena has ganado!";
            }
            else
            {
                cadena += "\nHas perdido, prueba otra vez";
            }
            return cadena;
        }
        private bool Iguales()
        {
            bool iguales = false;
            if (dados[0].Equals(dados[1]) && dados[0].Equals(dados[2]))
            {
                iguales = true;
            }
            return iguales;
        }
    }
}

using System;
using System.Linq;

namespace Actividad5
{
    public class Actividad5
    {
        static void Main(string[] args)
        {
        }

        public static string devolverString(string[] vs)
        {
            string cadena = "";
            for (int i = 0; i < vs.Length; i++)
            {
                cadena += vs[i];
            }
            return cadena;
            throw new NotImplementedException();
        }

        public static string devolverStringOrdenado(string[] vs)
        {
            Array.Sort(vs);
            string cadena = "";
            for (int i = 0; i < vs.Length; i++)
            {
                cadena += vs[i];
            }
            return cadena;
            throw new NotImplementedException();
        }

        public static int contarCaracter(string[] vs, char v)
        {
            int cont = 0;
            for (int i = 0; i < vs.Length; i++)
            {
                for (int j=0; j < vs[i].Length; j++)
                {
                    if (v.Equals(vs[i][j]))
                    {
                        cont++;
                    }
                }
            }
            return cont;
            throw new NotImplementedException();
        }

        public static int[] sumarArrays(int[] vs1, int[] vs2)
        {
            int[] arraySumas = new int[vs1.Length];
            for (int i = 0; i < vs1.Length; i++)
            {
                arraySumas[i] = vs1[i] + vs2[i];
            }
            return arraySumas;
            throw new NotImplementedException();
        }

        public static int[] multiplicarArrays(int[] vs1, int[] vs2)
        {
            int[] arrayMultiplicacion = new int[vs1.Length];
            for (int i = 0; i < vs1.Length; i++)
            {
                arrayMultiplicacion[i] = vs1[i] * vs2[i];
            }
            return arrayMultiplicacion;
            throw new NotImplementedException();
        }

        public static bool isPalindromo(string entrada)
        {
            entrada = entrada.Trim().ToLower().Replace(" ", "");
            char[] stringArray = entrada.ToCharArray();
            Array.Reverse(stringArray);
            string entradaInvertida = String.Join("", stringArray);
            bool palindromo = false;
            
            if (entrada.Equals(entradaInvertida))
            {
                palindromo = true;
            }
            return palindromo;
            throw new NotImplementedException();
        }

        public static int contarPalabras(string entrada)
        {
            int cont;
            if (!entrada.Equals(""))
            {
                entrada = entrada.Trim();
                string[] array = entrada.Split(" ");
                cont = array.Length;
            }
            else
            {
                cont = 0;
            }
            
            return cont;
            throw new NotImplementedException();
        }

        public static int contarCaracteres(string entrada)
        {
            int cont=0;
            char[] charArray = entrada.ToCharArray();
            for (int i = 0; i< charArray.Length; i++){
                if (!charArray[i].Equals(" "))
                {
                    cont++;
                }
            }
            return cont;
            throw new NotImplementedException();
        }
    }
}

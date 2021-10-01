using System;

namespace Actividad4
{
    public class Arrays
    {
        static void Main(string[] args)
        {
        }

        public static int minValorArray(int[] array)
        {
            int menor = array[0];

            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] <= menor)
                {
                    menor = array[i];
                }
            }

            return menor;
            throw new NotImplementedException();
        }

        public static int minValorArrayVacio(int[] array)
        {
            int vacio = 1; // 1 = no vacio
            if (array.Length == 0)
            {
                vacio = 0;
            }
            return vacio;
            throw new NotImplementedException();
        }

        public static int[] invertirArray(int[] array)
        {
            int[] arrayAux = new int[array.Length];
            int j=0;
            for (int i = array.Length-1; i >= 0; i--)
            {
                arrayAux[j] = array[i];
                j++;
            }
            return arrayAux;
            throw new NotImplementedException();

        }

        public static int comprobarValorEnArray(int[] array, int valor)
        {
            //TODO
            throw new NotImplementedException();
        }

        public static int calcularModa(int[] entrada)
        {
            //TODO
            throw new NotImplementedException();
        }
    }
}

using System;

namespace Actividad4
{
    public class Arrays
    {
        static void Main(string[] args)
        {
            int[] array = new int[] { 3,4,5,6,1,3 };
            int[] array1 = menorMayorArray(array);
            for (int i = 0; i < array1.Length; i++)
            {
                Console.Write(array1[i] + " ");
            }
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
            int resultado=-1;
            if (array.Length == 0)
            {
                resultado = -1;
            }
            else
            {
                for (int i = 0; i < array.Length; i++)
                {
                    if (array[i] == valor)
                    {
                        resultado = i;
                        i = array.Length;
                    }
                    else
                    {
                        resultado = -1;
                    }
                }
            }
            return resultado;
            throw new NotImplementedException();
        }

        public static int calcularModa(int[] array)
        {
            
            throw new NotImplementedException();
        }

        public static int[] menorMayorArray(int[] array)
        {
            int aux;
            for (int i = 0; i < array.Length; i++)
            {
                if (array.Length-2 == i)
                {
                    if (array[i] > array[i + 1])
                    {
                        aux = array[i + 1];
                        array[i + 1] = array[i];
                        array[i] = aux;
                    }
                }
            }
            return array;
        }
    }
}

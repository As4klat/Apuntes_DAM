using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamenT3
{
    class Matriz
    {
        private int filas;
        private int columnas;
        private int[,] matriz;

        public Matriz(int filas, int columnas)
        {
            this.filas = filas;
            this.columnas = columnas;
            matriz = new int[filas,columnas];
        }

        /*
         *  Métodos
         */
        public void RellenarMatriz()
        {
            for (int i = 0; i < this.filas; i++)
            { 
                for(int j = 0; j < this.columnas; j++)
                {
                    Console.WriteLine("Introducir valor: ");
                    int n = Convert.ToInt32(Console.ReadLine());
                    matriz[i, j] = n;
                }
            } 
        }

        public int PuntoDeSilla()
        {
            int punto = -1;
            int aux = matriz[0,0];
            for (int i = 0; i < this.filas; i++)
            {
                for (int j = 0; j < this.columnas; j++)
                {
                    if (aux > matriz[i,j])
                    {
                        if (aux < matriz[i, j])
                        {
                            punto = aux;
                        }
                    }
                }
            }
            return punto;
        }
        override
        public string ToString()
        {
            string cadena = "";
            for (int i = 0; i < this.filas; i++)
            {
                cadena += "\n";
                for (int j = 0; j < this.columnas; j++)
                {
                    cadena += matriz[i, j] + " ";
                }
            }
            return cadena;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad8.Part3
{
    class Videojuego : Entregable
    {
        private string titulo;
        private int horas_estimadas;
        private bool entregado;
        private string genero;
        private string compania;

        public Videojuego()
        {
            this.titulo = "Titulo-genérico";
            this.horas_estimadas = 10;
            this.entregado = false;
            this.genero = "rol";
            this.compania = "NcSoft";
        }
        public Videojuego(string titulo, int horas_estimadas)
        {
            this.titulo = titulo;
            this.horas_estimadas = horas_estimadas;
            this.entregado = false;
            this.genero = "rol";
            this.compania = "NcSoft";
        }
        public Videojuego(string titulo, int horas_estimadas, string genero, string compania)
        {
            this.titulo = titulo;
            this.horas_estimadas = horas_estimadas;
            this.entregado = false;
            this.genero = genero;
            this.compania = compania;
        }

        /*
         *  Métodos
         */
        override
        public string ToString()
        {
            return "\n------- Videojuego ------" +
                   "\nTítulo: " + this.titulo +
                   "\nNumero de horas para completar: " + this.horas_estimadas +
                   "\nEntregado: " + this.entregado +
                   "\nGenero: " + this.genero +
                   "\nCompalia desarrolladora: " + this.compania;
        }

        public void Devolver()
        {
            this.entregado = false;
        }

        public void Entregar()
        {
            this.entregado = true;
        }

        public bool IsEntregado()
        {
            return this.entregado;
        }
    }
}

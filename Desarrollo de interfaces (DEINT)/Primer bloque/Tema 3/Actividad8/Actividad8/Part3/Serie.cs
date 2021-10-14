using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad8.Part3
{
    class Serie : Entregable
    {
        private string titulo;
        private int numero_temporadas;
        private bool entregado;
        private string genero;
        private string creador;

        public Serie(){
            this.titulo = "titulo-predeterminado";
            this.numero_temporadas = 3;
            this.entregado = false;
            this.genero = "accion";
            this.creador = "Alejadnro Gamaza Martínez";
        }
        public Serie(string titulo, string creador)
        {
            this.titulo = titulo;
            this.numero_temporadas = 3;
            this.entregado = false;
            this.genero = "accion";
            this.creador = creador;
        }
        public Serie(string titulo, int numero_temporadas, string genero, string creador)
        {
            this.titulo = titulo;
            this.numero_temporadas = numero_temporadas;
            this.entregado = false;
            this.genero = genero;
            this.creador = creador;
        }

        /*
         *  Métodos
         */
        override
        public string ToString()
        {
            return "\n------- Serie ------" +
                   "\nTítulo: " + this.titulo +
                   "\nNumero de temporadas: " + this.numero_temporadas +
                   "\nEntregado: " + this.entregado +
                   "\nGenero: " + this.genero +
                   "\nCreador: " + this.creador;
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

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad7
{
    class Triangulo
    {
        private double ladosIguales;
        private double ladoDiferente;
        private double altura;

        public Triangulo(double ladosIguales, double ladoDiferente, double altura)
        {
            this.ladosIguales = Helper.decimales2(ladosIguales);
            this.ladoDiferente = Helper.decimales2(ladoDiferente);
            this.altura = Helper.decimales2(altura);
        }

        /*
         *  Metodos Getters
         */
        public double getLadosIguales()
        {
            return ladosIguales;
        }
        public double getLadoDiferente()
        {
            return ladoDiferente;
        }
        public double getAltura()
        {
            return altura;
        }

        /*
         * Métodos
         */
        public double perimetro()
        {
            return Helper.decimales2(ladosIguales*2 + ladoDiferente);
        }
        public double area()
        {
            return Helper.decimales2((ladoDiferente * altura) / 2);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad8.Part2
{
    enum Color {BLANCO, NEGRO, ROJO, AZUL, GRIS };
    enum Consumo : int { A = 100 , B = 80, C = 60, D = 50, E = 30, F = 10};
    class Electrodomestico
    {
        private double precio_base;
        private Color color;
        private Consumo consumo;
        private double peso;

        public Electrodomestico()
        {
            this.precio_base = 100;
            this.color = Color.BLANCO;
            this.consumo = Consumo.F;
            this.peso = 5;
        }

        public Electrodomestico(double precio_base, double peso)
        {
            this.precio_base = precio_base;
            this.peso = peso;
            this.color = Color.BLANCO;
            this.consumo = Consumo.F;
        }

        public Electrodomestico(double precio_base, double peso, Color color, Consumo consumo)
        {
            this.precio_base = precio_base;
            this.peso = peso;
            this.color = color;
            this.consumo = consumo;
        }

        /*
         *  Métodos
         */
        public void CompruebaLetra(Consumo consumo)
        {
            if (Enum.IsDefined(typeof(Consumo),consumo))
            {
                this.consumo = consumo;
            }
            else
            {
                this.consumo = Consumo.F;
            }
        }

        public void ComprobarColor(Color color)
        {
            if (Enum.IsDefined(typeof(Color), color))
            {
                this.color = color;
            }
            else
            {
                this.color = Color.BLANCO;
            }
        }

        public string PrecioFinal()
        {
            this.precio_base = this.precio_base + ((double)this.consumo);
            CalcularPeso();
            return Convert.ToString(this.precio_base);
        }

        /*
         *  Helper
         */
        private void CalcularPeso()
        {
            int precio_suma;
            if (peso >= 0 && peso <= 19) precio_suma = 10;
            else if (peso >= 20 && peso <= 49) precio_suma = 50;
            else if (peso >= 50 && peso <= 79) precio_suma = 80;
            else precio_suma = 100;

            this.precio_base += precio_suma;
        }
    }
}

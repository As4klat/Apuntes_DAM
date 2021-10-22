using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad8.Part2
{
    class Television : Electrodomestico
    {
        private double pulgadas;
        private bool tdt;

        public Television() : base()
        {
            this.pulgadas = 20;
            this.tdt = false;
        }
        public Television(double precio, double peso) : base(precio, peso)
        {
            this.pulgadas = 20;
            this.tdt = false;
        }
        public Television(double pulgadas, bool tdt) : base()
        {
            this.pulgadas = pulgadas;
            this.tdt = tdt;
        }

        /*
         *  Métodos
         */ 
        public double PrecioFinal()
        {
            double precio_final = base.PrecioFinal();
            if (pulgadas > 40)
            {
                precio_final += precio_final*(30 / 100);
            }
            if (tdt)
            {
                precio_final += 50;
            }
            return precio_final;
        }
    }
}

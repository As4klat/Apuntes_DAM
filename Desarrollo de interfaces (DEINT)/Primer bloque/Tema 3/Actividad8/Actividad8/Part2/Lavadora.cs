using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad8.Part2
{
    class Lavadora : Electrodomestico
    {
        private double carga;

        public Lavadora() : base()
        {
            this.carga = 5;
        }
        public Lavadora(double precio_base, double peso) : base(precio_base, peso)
        {
            this.carga = 5;
        }
    }
}

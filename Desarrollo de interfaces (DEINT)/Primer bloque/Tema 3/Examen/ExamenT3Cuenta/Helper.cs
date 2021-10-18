using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamenT3Cuenta
{
    class Helper
    {
        public static double decimales2(double n)
        {
            return Math.Truncate(n * 100) / 100;
        }
    }
}

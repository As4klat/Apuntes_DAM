using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Actividad15
{
    class Alumno
    {
        string nombre;
        int notaMates;
        int notaInfor;

        public Alumno(string nombre, int notaMates, int notaInfor)
        {
            this.nombre = nombre;
            this.notaMates = notaMates;
            this.notaInfor = notaInfor;
        }

        public string Nombre
        {
            get => nombre;
            set => nombre = value;
        }

        public int NotaMates
        {
            get => notaMates;
            set => notaMates = value;
        }

        public int NotaInfor
        {
            get => notaInfor;
            set => notaInfor = value;
        }
    }
}

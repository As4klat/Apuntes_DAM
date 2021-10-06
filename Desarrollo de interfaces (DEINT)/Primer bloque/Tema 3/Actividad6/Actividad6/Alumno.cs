using System;
using System.Collections.Generic;
using System.Linq;

namespace Actividad6
{
    public class Alumno
    {
        static void Main(string[] args)
        {
        }

        public string Nombre { get; set; }
        public int Nota { get; set; }

        public static List<string> getNombres(List<Alumno> alumnos)
        {
            return (from alumno in alumnos select alumno.Nombre).ToList();
            throw new NotImplementedException();
        }

        public static Alumno getListadoNota(List<Alumno> alumnos, int nota)
        {
            return (from alumno in alumnos where alumno.Nota == nota select alumno).First();
            throw new NotImplementedException();
        }

        public static Alumno getPrimerAlumno(List<Alumno> alumnos)
        {
            return (from alumno in alumnos select alumno).First();
            throw new NotImplementedException();
        }

        public static Alumno getUltimoAlumno(List<Alumno> alumnos)
        {
            return (from alumno in alumnos select alumno).Last();
            throw new NotImplementedException();
        }

        public static int getSumaNota(List<Alumno> alumnos)
        {
            return alumnos.Sum(x => x.Nota);
            throw new NotImplementedException();
        }

        public static int getNotaMaxima(List<Alumno> alumnos)
        {
            return alumnos.Max(x => x.Nota);
            throw new NotImplementedException();
        }

        public static int getNotaMinima(List<Alumno> alumnos)
        {
            return alumnos.Min(x => x.Nota);
            throw new NotImplementedException();
        }

        public static int getNotaPorNombre(List<Alumno> alumnos, string v)
        {
            return (from alumno in alumnos where alumno.Nombre.Equals(v) select alumno.Nota).First();
            throw new NotImplementedException();
        }

        public static double getNotaMedia(List<Alumno> alumnos)
        {
            return alumnos.Average(x=>x.Nota);
            throw new NotImplementedException();
        }
    }
}

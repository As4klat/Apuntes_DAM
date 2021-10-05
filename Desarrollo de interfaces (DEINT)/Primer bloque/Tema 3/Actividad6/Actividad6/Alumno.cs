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
            List<string> listaNombres = from alumno in alumnos select alumno.Nombre;
            throw new NotImplementedException();
        }

        public static Alumno getListadoNota(List<Alumno> alumnos, int nota)
        {
            throw new NotImplementedException();
        }

        public static Alumno getPrimerAlumno(List<Alumno> alumnos)
        {
            throw new NotImplementedException();
        }

        public static Alumno getUltimoAlumno(List<Alumno> alumnos)
        {
            throw new NotImplementedException();
        }

        public static int getSumaNota(List<Alumno> alumnos)
        {
            throw new NotImplementedException();
        }

        public static int getNotaMaxima(List<Alumno> alumnos)
        {
            throw new NotImplementedException();
        }

        public static int getNotaMinima(List<Alumno> alumnos)
        {
            throw new NotImplementedException();
        }

        public static int getNotaPorNombre(List<Alumno> alumnos, string v)
        {
            throw new NotImplementedException();
        }

        public static double getNotaMedia(List<Alumno> alumnos)
        {
            throw new NotImplementedException();
        }
    }
}

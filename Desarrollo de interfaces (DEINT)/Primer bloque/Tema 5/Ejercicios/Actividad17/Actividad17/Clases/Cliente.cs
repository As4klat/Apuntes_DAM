using System;

namespace Actividad17.Clases
{
    public class Cliente
    {
        public string dni { get; set; }
        public string nombre { get; set; }
        public string direccion { get; set; }
        public int edad { get; set; }
        public int telefono { get; set; }
        public long numeroCuentaCorriente { get; set; }

        public Cliente() { }

        public Cliente(string dni, string nombre, string direccion, int edad, int telefono, long numeroCuentaCorriente)
        {
            this.dni = dni ?? throw new ArgumentNullException(nameof(dni));
            this.nombre = nombre ?? throw new ArgumentNullException(nameof(nombre));
            this.direccion = direccion ?? throw new ArgumentNullException(nameof(direccion));
            this.edad = edad;
            this.telefono = telefono;
            this.numeroCuentaCorriente = numeroCuentaCorriente;
        }
    }
}

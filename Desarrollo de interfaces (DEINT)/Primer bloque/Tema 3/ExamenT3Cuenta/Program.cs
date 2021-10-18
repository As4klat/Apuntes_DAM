using System;

namespace ExamenT3Cuenta
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("------------ Cuentas -------------");
            
            Console.WriteLine("Introducir datos de cuenta 1");
            Console.WriteLine("Nombre: ");
            string nombre = Console.ReadLine();
            Console.WriteLine("DNI: ");
            string dni = Console.ReadLine();
            Console.WriteLine("Numero de cuneta: ");
            string nCuenta = Console.ReadLine();
            Console.WriteLine("Tipo de interes: ");
            double tipoInteres = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Saldo: ");
            double saldo = Convert.ToDouble(Console.ReadLine());

            Cuenta c1 = new Cuenta(nombre,dni,nCuenta,tipoInteres,saldo);

            Console.WriteLine("Introducir datos de cuenta 2");
            Console.WriteLine("Nombre: ");
            nombre = Console.ReadLine();
            Console.WriteLine("DNI: ");
            dni = Console.ReadLine();
            Console.WriteLine("Numero de cuneta: ");
            nCuenta = Console.ReadLine();
            Console.WriteLine("Tipo de interes: ");
            tipoInteres = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Saldo: ");
            saldo = Convert.ToDouble(Console.ReadLine());

            Cuenta c2 = new Cuenta(nombre, dni, nCuenta, tipoInteres, saldo);

            if (!c1.ingreso(100))
            {
                Console.WriteLine("No se ha podido ingresar el dinero.");
            }
            if (!c2.reintegro(50))
            {
                Console.WriteLine("No se ha podido sacar dinero");
            }
 
            Console.WriteLine("\nSe ha pasado: " + c1.Transferencia(c2, 100)+"$");
            
        }
    }
}

using System;
using System.Text.RegularExpressions;
using static ExamenT3Cuenta.Helper;

namespace ExamenT3Cuenta
{
    class Cuenta
    {
        private string nombre;
        private string dni;
        private string nCuenta;
        private double tipoInteres;
        private double saldo;

        public Cuenta()
        {

        }
        public Cuenta(string nombre, string dni, string nCuenta, double tipoInteres, double saldo)
        {
            this.nombre = nombre;
            this.dni = dni;
            if (CompruebaCuenta(nCuenta))
            {
                this.nCuenta = nCuenta;
            }
            else
            {
                this.nCuenta = "No se dispone de numero de cuenta";
            }
            //this.nCuenta = 
            this.tipoInteres = tipoInteres;
            this.saldo = saldo;
        }
        /*
         *  Métodos
         */
        public bool ingreso(double cantidad)
        {
            bool operacion = false;
            if (CompruebaPositivo(cantidad))
            {
                this.saldo += decimales2(cantidad);
                operacion = true;
            }
            else
            {
                Console.WriteLine("No se ha podido realizar su operación");
            }
            return operacion;
        }
        public bool reintegro(double cantidad)
        {
            bool operacion = false;
            if (CompruebaPositivo(cantidad))
            {
                if (this.saldo > cantidad)
                {
                    this.saldo -= decimales2(cantidad);
                    operacion = true;
                }
            }
            else
            {
                Console.WriteLine("No se ha podido realizar su operación");
            }
            return operacion;
        }
        public double Transferencia(Cuenta cDestino, double saldo)
        {
            this.reintegro(saldo);
            cDestino.ingreso(saldo);
            return cDestino.GetSaldo();
        }
        private bool CompruebaCuenta(string nCuenta)
        {
            bool comp = false;
            string patron = @"^[A-Z]{2}\d{22}";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(nCuenta))
            {
                comp = true;
            }
            return comp;
        }
        private bool CompruebaPositivo(double cantidad)
        {
            bool comp = false;
            if (cantidad > 0)
            {
                comp = true;
            }
            /*
            string patron = @"^[.]?[0-9]+[.]?[0-9]+$";
            Regex rgx = new Regex(patron);
            if (rgx.IsMatch(Convert.ToString(cantidad)))
            {
                comp = true;
            }
            */
            return comp;
        }
        private double GetSaldo()
        {
            return this.saldo;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Jardineria.Clases
{
    internal class ProductoValidacion
    {
        private static List<string> errorTexts = new List<string>();

        public static bool Validar(Producto producto)
        {
            bool valido = false;

            Validarcodigo_producto(producto.Codigo_producto);
            Validarnombre(producto.Nombre);
            Validargama(producto.Gama);
            Validardimensiones(producto.Dimensiones);
            Validarproveedor(producto.Proveedor);
            Validardescripcion(producto.Descripcion);
            Validarcantidad_en_stock(producto.Cantidad_en_stock);
            Validarprecio_venta(producto.Precio_venta);
            Validarprecio_proveedor(producto.Precio_proveedor);

            if (!errorTexts.Any())
            {
                valido = true;
            }
            return valido;
        }

        public static List<string> ListaErrores()
        {
            return errorTexts;
        }

        public static void Reiniciar()
        {
            errorTexts.Clear();
        }

        private static void Validarcodigo_producto(string codigo_producto)
        {

            Regex rgx = new Regex(@"^$");
            if (rgx.IsMatch(codigo_producto))
            {
                errorTexts.Add("El código del producto no puede estar vacia.");
            }
            else
            {
                rgx = new Regex(@"^(?!\s{1,15}$).+");
                if (!rgx.IsMatch(codigo_producto))
                {
                    errorTexts.Add("El código del producto debe contener 1-15 caracteres.");
                }
                else
                {
                    if (Controlador.ListaProductos().Where(x => x.Codigo_producto == codigo_producto).Any())
                    {
                        errorTexts.Add("El código del producto está repetido.");
                    }
                }
            }    
        }

        private static void Validarnombre(string nombre)
        {
            Regex rgx = new Regex(@"^$");
            if (rgx.IsMatch(nombre))
            {
                errorTexts.Add("El nombre del producto no puede estar vacia.");
            }
            else
            {
                rgx = new Regex(@"^(?!\s{1,70}$).+");
                if (!rgx.IsMatch(nombre))
                {
                    errorTexts.Add("El nombre del producto debe contener 1-70 caracteres.");
                }
            }
        }

        private static void Validargama(string gama)
        {
            if (!Controlador.ListaGamas().Where(x => x.Nombre == gama).Any())
            {
                errorTexts.Add("La gama no existe.");
            }
        }

        private static void Validardimensiones(string dimensiones)
        {
            Regex rgx = new Regex(@"^$");
            if (rgx.IsMatch(dimensiones))
            {
                errorTexts.Add("Las dimensiones del producto no puede estar vacia.");
            }
            else
            {
                rgx = new Regex(@"^(?!\s{1,25}$).+");
                if (!rgx.IsMatch(dimensiones))
                {
                    errorTexts.Add("Las dimensiones del producto debe contener 1-25 caracteres.");
                }
            }
        }

        private static void Validarproveedor(string proveedor)
        {
            Regex rgx = new Regex(@"^$");
            if (rgx.IsMatch(proveedor))
            {
                errorTexts.Add("El proveedor del producto no puede estar vacia.");
            }
            else
            {
                rgx = new Regex(@"^(?!\s{1,50}$).+");
                if (!rgx.IsMatch(proveedor))
                {
                    errorTexts.Add("El proveedor del producto debe contener 1-50 caracteres.");
                }
            }
        }

        private static void Validardescripcion(string descripcion)
        {
            Regex rgx = new Regex(@"^$");
            if (rgx.IsMatch(descripcion))
            {
                errorTexts.Add("La descripcion del producto no puede estar vacia.");
            }
            else
            {
                rgx = new Regex(@"^(?!\s{1,50}$).+");
                if (!rgx.IsMatch(descripcion))
                {
                    errorTexts.Add("La descripcion del producto debe contener 1-50 caracteres.");
                }
            }
        }

        private static void Validarcantidad_en_stock(string cantidad_en_stock)
        {
            Regex rgx = new Regex(@"^$");
            if (rgx.IsMatch(cantidad_en_stock))
            {
                errorTexts.Add("La cantidad de stock no puede estar vacia.");
            }
            else
            {
                rgx = new Regex(@"^\d+$");
                if (!rgx.IsMatch(cantidad_en_stock))
                {
                    errorTexts.Add("La cantidad de stock solo pueden ser numeros enteros.");
                }
                else 
                {
                    rgx = new Regex(@"^\d{1,6}$");
                    if (!rgx.IsMatch(cantidad_en_stock))
                    {
                        errorTexts.Add("El limite de stock es (1-999999)");
                    }
                }
            }
        }

        private static void Validarprecio_venta(string precio_venta)
        {
            Regex rgx = new Regex(@"^$");
            if (rgx.IsMatch(precio_venta))
            {
                errorTexts.Add("El precio de venta no puede estar vacia.");
            }
            else
            {
                rgx = new Regex(@"^[0-9]{1,15}(?:[,][0-9]{1,2})?$");
                if (!rgx.IsMatch(precio_venta))
                {
                    errorTexts.Add("El precio de venta solo pueden ser numeros decimales separados por ','. 15,2");
                }
            }
        }

        private static void Validarprecio_proveedor(string precio_proveedor)
        {
            Regex rgx = new Regex(@"^$");
            if (rgx.IsMatch(precio_proveedor))
            {
                errorTexts.Add("El precio del proveedor no puede estar vacia.");
            }
            else
            {
                rgx = new Regex(@"^[0-9]{1,15}(?:[,][0-9]{1,2})?$");
                if (!rgx.IsMatch(precio_proveedor))
                {
                    errorTexts.Add("El precio del proveedor solo pueden ser numeros decimales separados por ','. 15,2");
                }
            }
        }
        
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jardineria.Clases
{
    internal class Producto
    {
        private string codigo_producto;
        private string nombre;
        private string gama;
        private string dimensiones;
        private string proveedor;
        private string descripcion;
        private string cantidad_en_stock;
        private string precio_venta;
        private string precio_proveedor;

        public Producto(
            string codigo_producto,
            string nombre,
            string gama,
            string dimensiones,
            string proveedor, 
            string descripcion,
            string cantidad_en_stock,
            string precio_venta,
            string precio_proveedor)
        {
            Codigo_producto = codigo_producto;
            Nombre = nombre;
            Gama = gama;
            Dimensiones = dimensiones;
            Proveedor = proveedor;
            Descripcion = descripcion;
            Cantidad_en_stock = cantidad_en_stock;
            Precio_venta = precio_venta;
            Precio_proveedor = precio_proveedor;
        }

        public string Codigo_producto { get => codigo_producto; set => codigo_producto = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Gama { get => gama; set => gama = value; }
        public string Dimensiones { get => dimensiones; set => dimensiones = value; }
        public string Proveedor { get => proveedor; set => proveedor = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public string Cantidad_en_stock { get => cantidad_en_stock; set => cantidad_en_stock = value; }
        public string Precio_venta { get => precio_venta; set => precio_venta = value; }
        public string Precio_proveedor { get => precio_proveedor; set => precio_proveedor = value; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jardineria.Clases
{
    internal class Pedido
    {
        private string codigo_pedido;
        private DateTime fecha_pedido;
        private DateTime fecha_esperada;
        private DateTime fecha_entrega;
        private string estado;
        private string comentarios;
        private int codigo_cliente;

        public Pedido(string codigo_pedido,
            DateTime fecha_pedido,
            DateTime fecha_esperada,
            DateTime fecha_entrega,
            string estado,
            string comentarios,
            int codigo_cliente)
        {
            Codigo_pedido = codigo_pedido;
            Fecha_pedido = fecha_pedido;
            Fecha_esperada = fecha_esperada;
            Fecha_entrega = fecha_entrega;
            Estado = estado;
            Comentarios = comentarios;
            Codigo_cliente = codigo_cliente;
        }

        public string Codigo_pedido { get => codigo_pedido; set => codigo_pedido = value; }
        public DateTime Fecha_pedido { get => fecha_pedido; set => fecha_pedido = value; }
        public DateTime Fecha_esperada { get => fecha_esperada; set => fecha_esperada = value; }
        public DateTime Fecha_entrega { get => fecha_entrega; set => fecha_entrega = value; }
        public string Estado { get => estado; set => estado = value; }
        public string Comentarios { get => comentarios; set => comentarios = value; }
        public int Codigo_cliente { get => codigo_cliente; set => codigo_cliente = value; }
    }
}

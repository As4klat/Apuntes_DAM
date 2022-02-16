using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Actividad22
{
    public partial class Cadenas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void contarVeces(object sender, EventArgs e)
        {
            string texto = tb1.Text;
            char letra = Convert.ToChar(tb2.Text);
            int contador = 0;
            for(int i = 0; i < texto.Length; i++)
            {
                if (texto[i] == letra)
                {
                    contador++;
                }
            }
            lbResultado.Text = contador.ToString();
        }
        protected void eliminar(object sender, EventArgs e)
        {
            string texto = tb1.Text;
            char letra = Convert.ToChar(tb2.Text);

            lbResultado.Text = texto.Replace(letra,' ');
        }
    }
}
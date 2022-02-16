using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Actividad22
{
    public partial class calculadora : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        
        protected void Calcular_Suma(object sender, EventArgs e)
        {
            resultado.Text = (Int32.Parse(numero1.Text) + Int32.Parse(numero2.Text)).ToString();
        }
        protected void Calcular_Resta(object sender, EventArgs e)
        {
            resultado.Text = (Int32.Parse(numero1.Text) - Int32.Parse(numero2.Text)).ToString();
        }
        protected void Calcular_Multiplicacion(object sender, EventArgs e)
        {
            resultado.Text = (Int32.Parse(numero1.Text) * Int32.Parse(numero2.Text)).ToString();
        }
        protected void Calcular_Division(object sender, EventArgs e)
        {
            resultado.Text = (Int32.Parse(numero1.Text) / Int32.Parse(numero2.Text)).ToString();
        }
    }
}
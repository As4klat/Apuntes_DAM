using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Ejercicio2_web_form
{
    public partial class Area : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void calcularTriangulo_Click(object sender, EventArgs e)
        {
            double alturaTriangulo = Convert.ToDouble(alturat.Text);
            double baseTriangulo = Convert.ToDouble(baset.Text);

            double resultadoTriangulo = Math.Round((baseTriangulo * alturaTriangulo) / 2, 2);

            resultadot.Text = resultadoTriangulo.ToString();
        }

        protected void calcularCuadrado_Click(object sender, EventArgs e)
        {
            double ladoCuadrado = Convert.ToDouble(ladoc.Text);

            double resultadoCuadrado = Math.Round(ladoCuadrado * ladoCuadrado, 2);

            resultadoc.Text = resultadoCuadrado.ToString();
        }
    }
}
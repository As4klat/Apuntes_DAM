using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Ejercicio2_web_form
{
    public partial class Volumen : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void calcularCubo_Click(object sender, EventArgs e)
        {
            double aristaCubo = Convert.ToDouble(aristac.Text);

            double resultadoCubo = Math.Round(Math.Pow(aristaCubo, 3), 2);

            resultadocubo.Text = resultadoCubo.ToString();
        }

        protected void calcularCono_Click(object sender, EventArgs e)
        {
            double radioCono = Convert.ToDouble(radioc.Text);
            double alturaCono = Convert.ToDouble(alturac.Text);

            double resultadoCono = Math.Round((3.14 * Math.Pow(radioCono,2) * alturaCono) / 3, 2);

            resultadocono.Text = resultadoCono.ToString();
        }
    }
}
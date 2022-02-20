using System;
using System.Web.UI;

namespace Ejercicio2_web_form
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Response.Redirect("Area", true);
        }
    }
}
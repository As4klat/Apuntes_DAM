
using Prueba_final.Controladores;
using System;
using System.Web.UI;

namespace Prueba_final
{
    public partial class SiteMaster : MasterPage
    {
        protected bool _Logeado;
        protected void Page_Load(object sender, EventArgs e)
        {
            _Logeado = LoginStatus.Logeado();
        }

        protected void Desconectarse_Click(object sender, EventArgs e)
        {
            Controlador.CerrarSesion();
            Response.Redirect("Default");
        }
    }
}
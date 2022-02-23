using Prueba_final.Clases;
using Prueba_final.Controladores;
using Prueba_final.DLL;
using System;

namespace Prueba_final.Paginas
{
    public partial class Login : System.Web.UI.Page
    {
        protected bool _Error;
        protected void Page_Load(object sender, EventArgs e)
        {
            _Error = false;
        }

        protected void Iniciar_sesion(object sender, EventArgs e)
        {
            if (emailValidator.IsValid &&
                emailRequired.IsValid &&
                passwordRequerido.IsValid)
            {
                try
                {
                    Controlador.IniciarSesion(email.Text, password.Text);
                    Response.Redirect("../../Default");
                }
                catch (Exception ex)
                {
                    _Error = true;
                    ErrorLabel.Text = ex.Message;
                }
                email.Text = "";
                password.Text = "";
            }
        }
    }
}
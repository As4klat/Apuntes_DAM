using System;
using Prueba_final.Controladores;

namespace Prueba_final.Paginas.Sesion
{
    public partial class Register : System.Web.UI.Page
    {
        protected bool _Error;

        protected void Page_Load(object sender, EventArgs e)
        {
            _Error = false;
        }

        protected void RegistrarUsuario(object sender, EventArgs e)
        {
            if (emailValidator.IsValid &&
                emailRequired.IsValid &&
                passwordRequerido.IsValid &&
                confirmPasswordRequerido.IsValid &&
                comparePassword.IsValid)
            {
                try
                {
                    Controlador.Registrarse(email.Text, password.Text);
                    Response.Redirect("../../Default");
                }
                catch (Exception ex)
                {
                    _Error = true;
                    ErrorLabel.Text = ex.Message;
                }
                email.Text = "";
                password.Text = "";
                confirmPassword.Text = "";
            }
        }
    }
}
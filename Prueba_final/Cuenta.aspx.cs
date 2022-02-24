using System;
using System.Text.RegularExpressions;
using System.Web.UI;
using Prueba_final.Clases;
using Prueba_final.Controladores;

namespace Prueba_final
{
    public partial class Contact : Page
    {
        protected bool _contraseñasIguales = false;
        protected bool _contraseñaCompareRequerida = false;
        protected bool _contraseñaRequerida = false;
        protected bool _emailValidator = false;
        protected bool _emailRequired = false;
        protected bool _Error = false;
        protected bool _ErrorApi = false;

        protected void Page_Init(object sender, EventArgs e)
        {
            actualizarEntradas();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!LoginStatus.Logeado())
            {
                Response.Redirect("./Paginas/Sesion/Login", true);
            }
        }

        protected void btnActualizarContraseña_Click(object sender, EventArgs e)
        {
            ValidarContraseña();
            if (!_contraseñasIguales &&
                !_contraseñaCompareRequerida &&
                !_contraseñaRequerida && actualPassword.Text.Equals(LoginStatus.GetUsuario().Password))
            {
                try
                {
                    Usuario u = LoginStatus.GetUsuario();
                    u.Password = password.Text;
                    Controlador.ActualizarUsuario(u);
                    resetearValidaciones();
                }
                catch (Exception ex)
                {
                    _Error = true;
                    ErrorLabel.Text = ex.Message;
                }
                actualPassword.Text = "";
                password.Text = "";
                confirmPassword.Text = "";
            }
        }

        protected void btnActualizarEmail_Click(object sender, EventArgs e)
        {
            ValidarEmail();
            if (!_emailValidator &&
                !_emailRequired)
            {
                try
                {
                    Usuario usuario = LoginStatus.GetUsuario();
                    usuario.Email = email.Text;
                    Controlador.ActualizarUsuario(usuario);
                    resetearValidaciones();
                }
                catch (Exception ex)
                {
                    _Error = true;
                    ErrorLabel.Text = ex.Message;
                }
                actualizarEntradas();
            }
            
        }

        protected void btnGuardarApi_Click(object sender, EventArgs e)
        {
            ValidarApi();
            if (!_ErrorApi)
            {
                try
                {
                    Usuario usuario = LoginStatus.GetUsuario();
                    usuario.Apikey = userapikey.Text;
                    Controlador.ActualizarUsuario(usuario);
                    userapikey.Text = "";
                    resetearValidaciones();
                }
                catch (Exception ex) {}
            }
            actualizarEntradas();
        }

        private void actualizarEntradas()
        {
            email.Text = LoginStatus.GetUsuario().Email;
            claveApiNueva.Text = LoginStatus.GetUsuario().Apikey;
        }

        private void ValidarContraseña()
        {
            if (password.Text.Equals(""))
            {
                _contraseñaRequerida = true;
            }
            if (confirmPassword.Text.Equals(""))
            {
                _contraseñaCompareRequerida = true;

            }
            if (!confirmPassword.Text.Equals(password.Text) && !(_contraseñaRequerida || _contraseñaCompareRequerida))
            {
                _contraseñasIguales = true;
            }
        }

        private void ValidarEmail()
        {
            if (email.Text.Equals(""))
            {
                _emailRequired = true;
            }
            string patron = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

            if (!Regex.IsMatch(email.Text, patron) && !_emailRequired)
            {
                _emailValidator = true;
            }
        }
        private void ValidarApi()
        {
            if (userapikey.Text.Equals(""))
            {
                _ErrorApi = true;
            }
            if (userapikey.Text.Length != 72)
            {
                _ErrorApi = true;
            }
        }

        private void resetearValidaciones()
        {
            _contraseñasIguales = false;
            _contraseñaCompareRequerida = false;
            _contraseñaRequerida = false;
            _emailValidator = false;
            _emailRequired = false;
            _Error = false;
            _ErrorApi = false;
        }
    }
}
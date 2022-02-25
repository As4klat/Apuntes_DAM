using System;
using System.Web.UI;
using Prueba_final.Clases;
using Prueba_final.Controladores;

namespace Prueba_final
{
    public partial class _Default : Page
    {
        protected DataUser dataUser;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!LoginStatus.Logeado())
            {
                Response.Redirect("./Paginas/Sesion/Login", true);
            }
            dataUser = Gw2Api.api();
            if (dataUser !=null)
            {
                nombreJugador.Text = dataUser.Name;
                tiempoJuego.Text += CalcularTiempo(dataUser.Age);
                servidorOrigen.Text += dataUser.World;
                nivelFractales.Text += dataUser.Fractal_level.ToString();
                nivelMcM.Text += dataUser.Wvw_rank.ToString();
            }
            
        }

        private string CalcularTiempo(int tsegundos)
        {
            int horas = tsegundos / 3600;
            int minutos = (tsegundos - horas * 3600) / 60;
            int segundos = tsegundos - (horas * 3600 + minutos * 60);
            return horas.ToString() + ":" + minutos.ToString() + ":" + segundos.ToString();
        }
    }
}
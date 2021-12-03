using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Examen2_gamaza.Help;

namespace Examen2_gamaza
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private bool validacion()
        {
            bool valido = true;
            if (textNombre.Equals("") || textSueldoHora.Equals("") ||
                textHorasTrabajadas.Equals("") || textHorasExtras.Equals(""))
            {
                valido = false;
            }
            return valido;
        }

        private void btnCalcular_Click(object sender, EventArgs e)
        {
            double suelodHora = Convert.ToDouble(textSueldoHora.Text);
            double horasTrabajadas = Convert.ToDouble(textHorasTrabajadas.Text);
            double horasExtras = Convert.ToDouble(textHorasExtras.Text);

            if (validacion())
            {
                double sueldoBase = suelodHora * horasTrabajadas + suelodHora * 2 * horasExtras;
                textSueldo.Text = Convert.ToString(Formateo.decimales2(sueldoBase));
                double impuesto = sueldoBase * 0.15;
                textImpuesto.Text = Convert.ToString(Formateo.decimales2(impuesto));
                textSueldoNeto.Text = Convert.ToString(Formateo.decimales2(sueldoBase - impuesto));

                List<String> log = new List<string>();
                log.Add(textNombre.Text);
                log.Add(textSueldoHora.Text);
                log.Add(textHorasTrabajadas.Text);
                log.Add(textHorasExtras.Text);
                log.Add(textSueldo.Text);
                log.Add(textImpuesto.Text);
                log.Add(textSueldoNeto.Text);

                if (Totxt.comprobarLog())
                {
                    Totxt.actualizarlog(log);
                    Console.WriteLine("Se ha actualizado el log");
                }
                else {
                    Totxt.generarlog(log);

                    Console.WriteLine("Se ha creado el log");
                }
                
            }
            else
            {
                MessageBox.Show("Error en los campos. Comprueba que todos están rellenos y validos");
            }
        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            textNombre.Text = "";
            textSueldoHora.Text = "";
            textHorasTrabajadas.Text = "";
            textHorasExtras.Text = "";
            textSueldo.Text = "";
            textImpuesto.Text = "";
            textSueldoNeto.Text = "";
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}

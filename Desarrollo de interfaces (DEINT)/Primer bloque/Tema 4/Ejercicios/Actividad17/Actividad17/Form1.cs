using Actividad17.Clases;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Actividad17
{
    public partial class Form1 : Form
    {
        private bool modificando;
        private Banco banco;

        public Form1()
        {
            InitializeComponent();
            banco = new Banco();
            modificando = false;
        }

        private bool validar()
        {
            bool valido = false;
            if (!textDni.Text.Equals("") && !textNombre.Text.Equals("") && !textDireccion.Text.Equals("") &&
                (Convert.ToInt32(textEdad.Text) > 0 && Convert.ToInt32(textEdad.Text) <= 130) &&  telefonoValido() && numeroBancoValido())
            {
                valido = true;
            }
            return valido;
        }

        private bool telefonoValido()
        {
            Regex rgx = new Regex(@"^[0-9]{9}$");
            return rgx.IsMatch(Convert.ToString(textTelefono.Text));
        }

        private bool numeroBancoValido()
        {
            Regex rgx = new Regex(@"^[0-9]{12}$");
            return rgx.IsMatch(Convert.ToString(textNumeroCuenta.Text));
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (validar())
            {
                banco.AddCliente(new Cliente(textDni.Text, textNombre.Text, textDireccion.Text
                , Convert.ToInt32(textEdad.Text), Convert.ToInt32(textTelefono.Text), Convert.ToInt64(textNumeroCuenta.Text)));
            }
            else
            {
                MessageBox.Show("Mal escrito.");
            }
        }
    }
}

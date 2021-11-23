using Actividad17.Clases;
using System;
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

        private string validar()
        {
            string valido = "";
            valido = Validator.DniValido(textDni.Text);
            return valido;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (validar().Equals("true"))
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

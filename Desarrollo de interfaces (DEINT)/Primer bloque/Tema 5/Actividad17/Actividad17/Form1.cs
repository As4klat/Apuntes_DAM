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

        private bool validar()
        {
            bool valido = false;
            if (
                Validator.DniValido(textDni.Text) &&
                Validator.CadenaNoVacia(textNombre.Text) &&
                Validator.CadenaNoVacia(textDireccion.Text) &&
                Validator.EdadValido(textEdad.Text) &&
                Validator.TelefonoValido(textTelefono.Text) &&
                Validator.NumeroBancoValido(textNumeroCuenta.Text)
                )
            {
                valido = true;
            }
            return valido;
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
                MessageBox.Show("Error en el registro, revise el formulario.");
            }
        }
    }
}

using Actividad17.Clases;
using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Windows.Forms;
using System.Xml.Serialization;

namespace Actividad17
{
    public partial class Form1 : Form
    {
        private bool modificando;
        public Banco banco;
        private string dniMod;

        public Form1()
        {
            InitializeComponent();
            banco = new Banco(new List<Cliente>());
            modificando = false;
            try
            {
                XmlSerializer serializer = new XmlSerializer(typeof(Banco));
                FileStream fs = new FileStream("datosClientes.xml", FileMode.Open);
                banco = (Banco)serializer.Deserialize(fs);
                datosClientes.DataSource = banco.listaClientes;
                fs.Close();
            }
            catch(Exception e) { }
        }

        private bool validar()
        {
            bool valido = false;
            if (modificando)
            {
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
            }
            else
            {
                if (
                Validator.DniValido(textDni.Text) &&
                Validator.CadenaNoVacia(textNombre.Text) &&
                Validator.CadenaNoVacia(textDireccion.Text) &&
                Validator.EdadValido(textEdad.Text) &&
                Validator.TelefonoValido(textTelefono.Text) &&
                Validator.NumeroBancoValido(textNumeroCuenta.Text) &&
                banco.DniNoRepe(textDni.Text)
                )
                {
                    valido = true;
                }
            }
            return valido;
        }

        private void RefresacarGrid()
        {
            datosClientes.DataSource = null;
            datosClientes.DataSource = banco.listaClientes;
        }

        private void Reset()
        {
            modificando = false;
            dniMod = "";
            textDni.Text = "";
            textNombre.Text = "";
            textDireccion.Text = "";
            textEdad.Text = "";
            textTelefono.Text = "";
            textNumeroCuenta.Text = "";
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (validar())
            {
                if (modificando)
                {
                    banco.ModCliente(dniMod, new Cliente(textDni.Text, textNombre.Text, textDireccion.Text
                , Convert.ToInt32(textEdad.Text), Convert.ToInt32(textTelefono.Text), Convert.ToInt64(textNumeroCuenta.Text)));
                    modificando = false;
                }
                else
                {
                    banco.AddCliente(new Cliente(textDni.Text, textNombre.Text, textDireccion.Text
                , Convert.ToInt32(textEdad.Text), Convert.ToInt32(textTelefono.Text), Convert.ToInt64(textNumeroCuenta.Text)));
                }
                Reset();
                RefresacarGrid();
            }
            else
            {
                MessageBox.Show("Error en el registro, revise el formulario.");
            }
        }

        private void btnRemove_Click(object sender, EventArgs e)
        {
            try
            {
                string dni = datosClientes.SelectedRows[0].Cells[0].Value.ToString();
                banco.RemoveCliente(dni);
                RefresacarGrid();
            }
            catch (Exception ex){
                MessageBox.Show("No se ha podido eliminar el cliente, selecione la fila.");
            }    
        }

        private void btnMod_Click(object sender, EventArgs e)
        {
            modificando = true;
            dniMod = datosClientes.SelectedRows[0].Cells[0].Value.ToString();
            textDni.Text = datosClientes.SelectedRows[0].Cells[0].Value.ToString();
            textNombre.Text = datosClientes.SelectedRows[0].Cells[1].Value.ToString();
            textDireccion.Text = datosClientes.SelectedRows[0].Cells[2].Value.ToString();
            textEdad.Text = datosClientes.SelectedRows[0].Cells[3].Value.ToString();
            textTelefono.Text = datosClientes.SelectedRows[0].Cells[4].Value.ToString();
            textNumeroCuenta.Text = datosClientes.SelectedRows[0].Cells[5].Value.ToString();
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            Reset();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(Banco));
            TextWriter writer = new StreamWriter("datosClientes.xml");
            serializer.Serialize(writer, banco);
            writer.Close();
        }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Actividad14
{
    public partial class Form1 : Form
    {
        string nombreArchivo="";
        bool guardado = false;
        
        public Form1()
        {
            InitializeComponent();
        }

        private void guardarArchivoNuevo()
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            sfd.RestoreDirectory = true;
            if (sfd.ShowDialog() == DialogResult.OK)
            {
                File.WriteAllText(sfd.FileName, cuadroTexto.Text);
            }
        }

        private void guardarArchivo()
        {
            File.WriteAllText(nombreArchivo, cuadroTexto.Text);
            guardado = true;
        }

        private void abrirArchivo()
        {
            guardado = true;
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            ofd.RestoreDirectory = true;
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    nombreArchivo = ofd.FileName;
                    StreamReader archivoEnLectura = new StreamReader(ofd.FileName);
                    cuadroTexto.Text = archivoEnLectura.ReadToEnd();
                    archivoEnLectura.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al cargar el archivo");
                }
            }
        }
        private void nuevoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (!cuadroTexto.Text.Equals(""))
            {
                if (MessageBox.Show("¿Deseas guardar los cambios?", "Guardar", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    if (nombreArchivo.Equals(""))
                    {
                        guardarArchivoNuevo();
                        cuadroTexto.Text = "";
                    }
                    else
                    {
                        guardarArchivo();
                        cuadroTexto.Text = "";
                    }
                }
                else
                {
                    cuadroTexto.Text = "";
                }
            }
        }

        private void abrirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (!cuadroTexto.Text.Equals("") && !guardado)
            {
                if (MessageBox.Show("Se van a perder los cambios, ¿Deseas continuar?", "Aviso", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    abrirArchivo();
                }
            }
            else
            {
                abrirArchivo();
            }
            
        }

        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (!guardado)
            {
                guardarArchivo();
            }
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (true)
            {
                Environment.Exit(0);
            }
            
        }

        private void cuadroTexto_TextChanged(object sender, EventArgs e)
        {
            guardado = false;
        }
    }
}

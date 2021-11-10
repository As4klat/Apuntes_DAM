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

        // Metodos de ayuda

        private void GuardarArchivoNuevo()
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            sfd.RestoreDirectory = true;
            if (sfd.ShowDialog() == DialogResult.OK)
            {
                File.WriteAllText(sfd.FileName, cuadroTexto.Text);
            }
        }

        private void GuardarArchivo()
        {
            File.WriteAllText(nombreArchivo, cuadroTexto.Text);
            guardado = true;
        }

        private void AbrirArchivo()
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

        // Herramientas

        private void NuevoArchivoTool()
        {
            if (!cuadroTexto.Text.Equals(""))
            {
                if (MessageBox.Show("¿Deseas guardar los cambios?", "Guardar", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    if (nombreArchivo.Equals(""))
                    {
                        GuardarArchivoNuevo();
                        cuadroTexto.Text = "";
                    }
                    else
                    {
                        GuardarArchivo();
                        cuadroTexto.Text = "";
                    }
                }
                else
                {
                    cuadroTexto.Text = "";
                    nombreArchivo = "";
                }
            }
        }

        private void AbrirArchivoTool()
        {
            if (!cuadroTexto.Text.Equals("") && !guardado)
            {
                if (MessageBox.Show("Se van a perder los cambios, ¿Deseas continuar?", "Aviso", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    AbrirArchivo();
                }
            }
            else
            {
                AbrirArchivo();
            }
        }

        private void GuardarTool()
        {
            if (!nombreArchivo.Equals(""))
            {
                GuardarArchivo();
            }
            else
            {
                GuardarArchivoNuevo();
            }
        }

        private void SalitTool()
        {
            Environment.Exit(0);
        }

        private void CortarTool()
        {
            cuadroTexto.Cut();
        }

        private void CopiarTool()
        {
            cuadroTexto.Copy();
        }

        private void PegarTool()
        {
            cuadroTexto.Paste();
        }
        
        private void ChangeFontAndColorTool()
        {
            FontDialog fd = new FontDialog();
            fd.ShowColor = true;
            if (fd.ShowDialog() == DialogResult.OK)
            {
                cuadroTexto.Font = fd.Font;
                cuadroTexto.ForeColor = fd.Color;
            }
        }

        // Menu Botones

        private void nuevoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            NuevoArchivoTool();
        }

        private void abrirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AbrirArchivoTool();
        }

        private void guardarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            GuardarTool();
        }
       
        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SalitTool();
        }

        private void cuadroTexto_TextChanged(object sender, EventArgs e)
        {
            guardado = false;
        }

        private void cortarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CortarTool();
        }

        private void copiarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CopiarTool();
        }

        private void pegarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PegarTool();
        }

        private void fuenteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ChangeFontAndColorTool();
        }

        // Barra de herramientas

        private void nuevoToolStripButton_Click_1(object sender, EventArgs e)
        {
            NuevoArchivoTool();
        }

        private void abrirToolStripButton_Click(object sender, EventArgs e)
        {
            AbrirArchivoTool();
        }

        private void guardarToolStripButton_Click(object sender, EventArgs e)
        {
            GuardarTool();
        }

        private void cortarToolStripButton_Click(object sender, EventArgs e)
        {
            CortarTool();
        }

        private void copiarToolStripButton_Click(object sender, EventArgs e)
        {
            CopiarTool();
        }

        private void pegarToolStripButton_Click(object sender, EventArgs e)
        {
            PegarTool();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            ChangeFontAndColorTool();
        }
    }
}

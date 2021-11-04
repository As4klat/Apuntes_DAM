using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Actividad14
{
    public partial class Form1 : Form
    {
        
        public Form1()
        {
            InitializeComponent();
        }

        private void nuevoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (cuadroTexto.Text.Equals(""))
            {
                cuadroTexto.Text = "";
            }
            else
            {
                if (MessageBox.Show("¿Deseas guardar los cambios?","Guardar",MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    SaveFileDialog sfd = new SaveFileDialog();
                    sfd.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
                    sfd.RestoreDirectory = true;
                    if (sfd.ShowDialog()==DialogResult.OK)
                    {
                        
                    }
                }
                else
                {
                    cuadroTexto.Text = "";
                }
            }
        }
    }
}

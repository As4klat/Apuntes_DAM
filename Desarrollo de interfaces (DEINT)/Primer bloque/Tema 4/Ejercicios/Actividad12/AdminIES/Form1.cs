using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AdminIES
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Cerrar()
        {
            this.Close();
        }

        private void btnEstudiantes_Click(object sender, EventArgs e)
        {
            Form frm = new Form();
            frm.Show();
            Cerrar();
        }

        private void btnCiclos_Click(object sender, EventArgs e)
        {
            Cerrar();
        }
    }
}

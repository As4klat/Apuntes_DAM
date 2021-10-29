using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using AdminIES.frm;

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
            this.Hide();
        }

        private void btnEstudiantes_Click(object sender, EventArgs e)
        {
            frmEstudiantes formEstdiantes = new frmEstudiantes(this);
            formEstdiantes.Show();
            Cerrar();
        }

        private void btnCiclos_Click(object sender, EventArgs e)
        {
            frmCiclo formCiclo = new frmCiclo(this);
            formCiclo.Show();
            Cerrar();
        }
    }
}

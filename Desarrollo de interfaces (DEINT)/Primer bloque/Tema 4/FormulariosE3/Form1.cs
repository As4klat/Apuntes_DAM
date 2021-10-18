using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FormulariosE3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void numero_ValueChanged(object sender, EventArgs e)
        {
            if (rbAscent.Checked)
            {
                TablaMultiplicar t = new TablaMultiplicar();
                areaTexto.Text = t.Tabla(Convert.ToInt32(numero.Value), 1);
            }
            if (rbDescent.Checked)
            {
                TablaMultiplicar t = new TablaMultiplicar();
                areaTexto.Text = t.Tabla(Convert.ToInt32(numero.Value), 2);
            }
        }

        private void rbAscent_CheckedChanged(object sender, EventArgs e)
        {
            if (rbAscent.Checked)
            {
                TablaMultiplicar t = new TablaMultiplicar();
                areaTexto.Text = t.Tabla(Convert.ToInt32(numero.Value), 1);
            }
        }

        private void rbDescent_CheckedChanged(object sender, EventArgs e)
        {
            if (rbDescent.Checked)
            {
                TablaMultiplicar t = new TablaMultiplicar();
                areaTexto.Text = t.Tabla(Convert.ToInt32(numero.Value), 2);
            }
        }
    }
}

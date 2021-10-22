using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FormulariosE1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnSuma_Click(object sender, EventArgs e)
        {
            Sumar s = new Sumar();
            textSol.Text = s.Operar(int.Parse(textValor1.Text), int.Parse(textValor2.Text)).ToString();
        }

        private void btnRestar_Click(object sender, EventArgs e)
        {
            Restar r = new Restar();
            textSol.Text = r.Operar(int.Parse(textValor1.Text), int.Parse(textValor2.Text)).ToString();
        }

        private void btnMultiplicar_Click(object sender, EventArgs e)
        {
            Multiplicar m = new Multiplicar();
            textSol.Text = m.Operar(int.Parse(textValor1.Text), int.Parse(textValor2.Text)).ToString();
        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            textValor1.Clear();
            textValor2.Clear();
            textSol.Clear();
        }
    }
}

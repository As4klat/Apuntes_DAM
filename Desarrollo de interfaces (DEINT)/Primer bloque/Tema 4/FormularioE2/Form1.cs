using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FormularioE2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnContar_Click(object sender, EventArgs e)
        {
            if (textCadena.Text.Equals(""))
            {
                textResultado.Text = "No hay cadena";
            }
            else
            {
                ContarChar ch = new ContarChar();
                int nCaracteres = ch.Contar(textCadena.Text, Convert.ToChar(boxCaracteres.Text));
                if (nCaracteres == 0)
                {
                    textResultado.Text = "No se ha encontrado coincidencia";
                }
                else
                {
                    textResultado.Text = Convert.ToString(nCaracteres);
                }
            }
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            textCadena.Clear();
            boxCaracteres.Text = "";
            textResultado.Clear();
        }
    }
}

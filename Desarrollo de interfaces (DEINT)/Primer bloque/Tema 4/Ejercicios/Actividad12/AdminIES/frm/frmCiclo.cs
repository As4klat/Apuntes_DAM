using AdminIES.DLL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AdminIES.frm
{
    public partial class frmCiclo : Form
    {
        private int idSelecionado;
        private string nombreSlecionado;

        public frmCiclo()
        {
            InitializeComponent();
        }

        private void LoadDatos()
        {   CicloDLL cicloDLL = new CicloDLL();
            DataTable dt = new DataTable();
            cicloDLL.CargarDatos().Fill(dt);
            dataGridView.DataSource = dt;
            if (dataGridView.Rows.Count != 1)
            {
                idSelecionado = Convert.ToInt32(dataGridView.Rows[0].Cells[0].Value);
                nombreSlecionado = dataGridView.Rows[0].Cells[1].Value.ToString();
            }
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            CicloDLL cicloDLL = new CicloDLL();
            if (textNombreCiclo.Text != "")
            {
                cicloDLL.Agregar(textNombreCiclo.Text);
                LoadDatos();
                textNombreCiclo.Text = "";
            }
        }

        private void btnModificar_Click(object sender, EventArgs e)
        {
            CicloDLL cicloDLL = new CicloDLL();
            if (textNombreCiclo.Text != "")
            {
                cicloDLL.Modificar(textNombreCiclo.Text, Convert.ToInt32(textID.Text));
                LoadDatos();
                textNombreCiclo.Text = "";
                textID.Text = "";
            }
            
        }

        private void btnBorrar_Click(object sender, EventArgs e)
        {
            CicloDLL cicloDLL = new CicloDLL();
            cicloDLL.Borrar(idSelecionado);
            LoadDatos();
            textNombreCiclo.Text = "";
            textID.Text = "";
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {

        }

        private void frmCiclo_Load(object sender, EventArgs e)
        {
            LoadDatos();
        }

        private void dataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            this.idSelecionado = Convert.ToInt32(dataGridView.Rows[e.RowIndex].Cells[0].Value.ToString());
            this.nombreSlecionado = dataGridView.Rows[e.RowIndex].Cells[1].Value.ToString();
            textID.Text = e.RowIndex.ToString();
            textNombreCiclo.Text = e.RowIndex.ToString();
        }
    }
}

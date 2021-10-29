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
    public partial class frmEstudiantes : Form
    {
        private Form formPadre;
        private EstudianteDLL estudianteDLL;
        private int idSelecionado;
        private string nombreSlecionado;
        private string lastFname;
        private string lastSname;
        private string email;

        public frmEstudiantes(Form formPadre)
        {
            this.formPadre = formPadre;
            estudianteDLL = new EstudianteDLL();
            InitializeComponent();
            LoadDatos();
        }

        private void LoadDatos()
        {
            ciclosBox.DataSource = new CicloDLL().CargarDatos().Tables[0];
            dataGridView.DataSource = estudianteDLL.CargarDatos().Tables[0];
        }

        private void vaciarDatos()
        {
            textClave.Text = "";
            textName.Text = "";
            textLastFname.Text = "";
            textLastSname.Text = "";
            textCorreo.Text = "";
        }

        private void dataGridView_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (!dataGridView.Rows[e.RowIndex].Cells[0].Value.ToString().Equals(""))
            {
                idSelecionado = Convert.ToInt32(dataGridView.Rows[e.RowIndex].Cells[0].Value.ToString());
                nombreSlecionado = dataGridView.Rows[e.RowIndex].Cells[1].Value.ToString();
                lastFname = dataGridView.Rows[e.RowIndex].Cells[2].Value.ToString();
                lastSname = dataGridView.Rows[e.RowIndex].Cells[3].Value.ToString();
                email = dataGridView.Rows[e.RowIndex].Cells[4].Value.ToString();
                textClave.Text = idSelecionado.ToString();
                textName.Text = nombreSlecionado;
                textLastFname.Text = lastFname;
                textLastSname.Text = lastSname;
                textCorreo.Text = email;
            }
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            if (!textName.Text.Equals("") && !textLastFname.Text.Equals("") && !textLastFname.Text.Equals("") && !textLastSname.Text.Equals("") && !textCorreo.Text.Equals(""))
            {
                estudianteDLL.Agregar(textName.Text, textLastFname.Text, textLastSname.Text, textCorreo.Text, "", "");
                LoadDatos();
            }
        }

        private void frmEstudiantes_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void btnBorrar_Click(object sender, EventArgs e)
        {
            estudianteDLL.Borrar(idSelecionado);
            LoadDatos();
            vaciarDatos();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            vaciarDatos();
            Hide();
            formPadre.Show();
        }

        private void btnModificar_Click(object sender, EventArgs e)
        {

        }
    }
}

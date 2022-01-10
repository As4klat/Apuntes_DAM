using System;
using System.Windows.Forms;
using System.Runtime.InteropServices;
using System.Collections.Generic;
using System.Drawing;
using Jardineria.Clases;
using System.Linq;
using System.Data;

namespace Jardineria
{
    public partial class Jardineria : Form
    {
        private List<Panel> listaPaneles;
        private List<Button> listaBotones;
        List<string> listaNombreGamas = new List<string>();

        public Jardineria()
        {
            InitializeComponent();
            Controlador.IniciarConexion();

            comboGama.DropDownStyle = ComboBoxStyle.DropDownList;
            comboGamas.DropDownStyle = ComboBoxStyle.DropDownList;
            comboCodigoJefe.DropDownStyle = ComboBoxStyle.DropDownList;

            dateTimerPedidosNoEntregados.Format = DateTimePickerFormat.Custom;
            dateTimerPedidosNoEntregados.CustomFormat = "yyyy-MM";
            dateTimerPedidosNoEntregados.ShowUpDown = true;

            dataJefeEmpleados.AutoResizeColumns(DataGridViewAutoSizeColumnsMode.Fill);

            comboCodigoJefe.DataSource = Controlador.ListaCodigoJefes();
            try
            {
                comboCodigoJefe.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                comboCodigoJefe.DataSource = null;
                comboCodigoJefe.Items.Add("No existen jefes");
                comboCodigoJefe.SelectedIndex = 0;
            }

            listaPaneles = new List<Panel>();
            listaPaneles.Add(panelInicio);
            listaPaneles.Add(panelCreaProducto);
            listaPaneles.Add(panelEliminarGama);
            listaPaneles.Add(panelPedidosEntregados);
            listaPaneles.Add(panelJefeEmpleados);
            listaPaneles.Add(panelPedidosNoPagados);
            listaPaneles.Add(panelProductosCarosBaratos);

            listaBotones = new List<Button>();
            listaBotones.Add(btnMenuCrearProducto);
            listaBotones.Add(btnMenuEliminarGama);
            listaBotones.Add(btnMenuPedidosEntregados);
            listaBotones.Add(btnMenuJefeEmpleados);
            listaBotones.Add(btnMenuPedidosNoPagados);
            listaBotones.Add(btnMenuProductosCarosBaratos);
        }

        //  Panel +- Caro

        private void ActualizarProductoMasMenosCaro()
        {
            string precioCaro = Controlador.ListaProductoMasMenosCaro().Max(x => x.Precio_venta);
            Producto pCaro = Controlador.ListaProductoMasMenosCaro().Where(x => x.Precio_venta == precioCaro).First();
            labelProductoMasCaroP.Text = pCaro.Codigo_producto + " " + pCaro.Nombre + " " + pCaro.Precio_venta;

            string precioBarato = Controlador.ListaProductoMasMenosCaro().Min(x => x.Precio_venta);
            Producto pBarato = Controlador.ListaProductoMasMenosCaro().Where(x => x.Precio_venta == precioBarato).First();
            labelProductoMasBaratoP.Text = pBarato.Codigo_producto + " " + pBarato.Nombre + " " + pBarato.Precio_venta;
        }

        //  Panel Clientes sin pagar

        private void ActualizarDataClientesNoPagan()
        {
            dataClientesNoPagan.DataSource = null;
            dataClientesNoPagan.DataSource = Controlador.ListaClientesNoPagan();
        }

        //  Panel Jefe - Empleados

        private void ActualizarTablaEmpleadosJefe()
        {
            dataJefeEmpleados.DataSource = null;
            dataJefeEmpleados.DataSource = Controlador.ListaEmpleadosPorJefe(Convert.ToInt32(comboCodigoJefe.SelectedItem));
        }

        private void comboCodigoJefe_SelectedIndexChanged(object sender, EventArgs e)
        {
            ActualizarTablaEmpleadosJefe();
        }


        //  Panel Consultar Entregados

        private void btnBuscarPedidosEntregados_Click(object sender, EventArgs e)
        {
            DateTime fecha = dateTimerPedidosNoEntregados.Value;
            dataPedidosEntregados.DataSource = null;
            dataPedidosEntregados.DataSource = Controlador.ListaPedidosFiltro(fecha);
            if(!Controlador.ListaPedidosFiltro(fecha).Any()) {
                MessageBox.Show($"No existe ningun pedido con la fecha {fecha.Year}-{fecha.Month}.", "No existen pedidos", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        //  Panel Eliminar Gamas

        private void btnEliminarGama_Click_1(object sender, EventArgs e)
        {
            if (!comboGamas.SelectedItem.ToString().Equals("No existen gamas"))
            {
                if (MessageBox.Show($"¿Desea Eliminar la gama '{comboGamas.SelectedItem.ToString()}' permanentemente?", "Eliminar gama", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    MessageBox.Show("Gama eliminada satifactoriamente.");
                    Controlador.EliminarGama(comboGamas.SelectedItem.ToString());
                }
                else
                {
                    MessageBox.Show("No se ha realizado ninguna operación.");
                }
                ActualizarGamasPanelEliminar();
                ActualizarDataProductosPorGama(comboGamas.SelectedItem.ToString());
            }
            else
            {
                MessageBox.Show("No existe ninguna gama actualmente.", "No existen gamas", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void comboGamas_SelectedIndexChanged(object sender, EventArgs e)
        {
            ActualizarDataProductosPorGama(comboGamas.SelectedItem.ToString());
        }

        private void ActualizarGamasPanelEliminar()
        {
            ActualizarGamas();
            comboGamas.DataSource = listaNombreGamas;
            try
            {
                comboGamas.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                comboGamas.DataSource = null;
                comboGamas.Items.Add("No existen gamas");
                comboGamas.SelectedIndex = 0;
            }
        }

        private void ActualizarDataProductosPorGama(string gama)
        {
            List<Producto> listaProductosPorGama = new List<Producto>();
            listaProductosPorGama = Controlador.ListaProductos().Where(x => x.Gama == gama).ToList();
            dataProductosPorGama.DataSource = null;
            dataProductosPorGama.DataSource = listaProductosPorGama;
        }

        //  Panel Crear Producto

        private void btnCrearProducto_Click_1(object sender, EventArgs e)
        {
            Producto p = new Producto(
                textCodigoProducto.Text,
                textNombreProducto.Text,
                comboGama.SelectedValue.ToString(),
                textDimensiones.Text,
                textProveedor.Text,
                textDescripcion.Text,
                textStock.Text,
                textPrecioVenta.Text,
                textPrecioProveedor.Text
                );
            
            if (ProductoValidacion.Validar(p))
            {
                Controlador.CrearProducto(p);
                ActualizarDataGridProductos();
                LimpiarEntradasProducto();
            }
            else
            {
                string msgErr = "";
                foreach (string err in ProductoValidacion.ListaErrores()) { msgErr += err+"\n"; }
                MessageBox.Show(msgErr,"Errores de entrada", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
            ProductoValidacion.Reiniciar();
        }

        private void btnLimpiarProducto_Click(object sender, EventArgs e)
        {
            LimpiarEntradasProducto();
        }

        private void LimpiarEntradasProducto()
        {
            textCodigoProducto.Text = "";
            textNombreProducto.Text = "";
            textDimensiones.Text = "";
            textPrecioProveedor.Text = "";
            textPrecioVenta.Text = "";
            textProveedor.Text = "";
            textStock.Text = "";
            textDescripcion.Text = "";
            try
            {
                comboGama.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                comboGama.DataSource = null;
                comboGama.Items.Add("No existen gamas");
            }
        }

        private void ActualizarGamasPanelProductos()
        {
            ActualizarGamas();
            comboGama.DataSource = listaNombreGamas;
            try
            {
                comboGama.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                comboGama.DataSource = null;
                comboGama.Items.Add("No existen gamas");
            }
        }

        private void ActualizarDataGridProductos()
        {
            dataGridProductos.DataSource = null;
            dataGridProductos.DataSource = Controlador.ListaProductos();
        }

        // Menu de navegacion.

        private void ActualizarGamas()
        {
            listaNombreGamas = new List<string>();
            foreach (Gama g in Controlador.ListaGamas()) { listaNombreGamas.Add(g.Nombre); }
        }

        private void ocultarPaneles()
        {
            foreach (Panel p in listaPaneles) { p.Visible = false; }
        }

        private void reiniciarBtnNavegacion()
        {
            foreach (Button b in listaBotones) { b.BackColor = Color.DarkSlateGray; }
        }

        private void label1_Click(object sender, EventArgs e)
        {
            reiniciarBtnNavegacion();
            ocultarPaneles();
            panelInicio.Visible = true;
        }

        private void btnCrearProducto_Click(object sender, EventArgs e)
        {
            reiniciarBtnNavegacion();
            ocultarPaneles();
            btnMenuCrearProducto.BackColor = Color.LightSeaGreen;
            panelCreaProducto.Visible = true;
            ActualizarGamasPanelProductos();
            ActualizarDataGridProductos();
            LimpiarEntradasProducto();
        }

        private void btnEliminarGama_Click(object sender, EventArgs e)
        {
            reiniciarBtnNavegacion();
            ocultarPaneles();
            btnMenuEliminarGama.BackColor = Color.LightSeaGreen;
            panelEliminarGama.Visible = true;
            ActualizarGamasPanelEliminar();
        }

        private void btnPedidosEntregados_Click(object sender, EventArgs e)
        {
            reiniciarBtnNavegacion();
            ocultarPaneles();
            btnMenuPedidosEntregados.BackColor = Color.LightSeaGreen;
            panelPedidosEntregados.Visible = true;
        }

        private void btnJefeEmpleados_Click(object sender, EventArgs e)
        {
            reiniciarBtnNavegacion();
            ocultarPaneles();
            btnMenuJefeEmpleados.BackColor = Color.LightSeaGreen;
            panelJefeEmpleados.Visible = true;
            ActualizarTablaEmpleadosJefe();
        }

        private void btnPedidosNoPagados_Click(object sender, EventArgs e)
        {
            reiniciarBtnNavegacion();
            ocultarPaneles();
            btnMenuPedidosNoPagados.BackColor = Color.LightSeaGreen;
            panelPedidosNoPagados.Visible = true;
            ActualizarDataClientesNoPagan();
        }

        private void btnProductosCarosBaratos_Click(object sender, EventArgs e)
        {
            reiniciarBtnNavegacion();
            ocultarPaneles();
            btnMenuProductosCarosBaratos.BackColor = Color.LightSeaGreen;
            panelProductosCarosBaratos.Visible = true;
            ActualizarProductoMasMenosCaro();
        }

        // Mover la ventana

        [DllImport("user32.dll", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.dll", EntryPoint = "SendMessage")]
        private extern static void SendMessage(IntPtr hWnd, int wMsg, int wParam, int lParam);

        private void PanelTitulo_MouseDown(object sender, MouseEventArgs e)
        {
            btnMinimizar.Visible = false;
            btnMaximizar.Visible = true;
            ReleaseCapture();
            SendMessage(this.Handle, 0x112, 0xf012, 0);
        }

        // Controles de ventana

        private void btnCerrar_Click(object sender, EventArgs e)
        {
            Controlador.PararConexion();
            Application.Exit();
        }

        private void btnMaximizar_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Maximized;
            toggleVisibleBtnsWindows();
        }

        private void btnEsconder_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void btnMinimizar_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Normal;
            toggleVisibleBtnsWindows();
        }

        private void toggleVisibleBtnsWindows()
        {
            btnMinimizar.Visible = !btnMinimizar.Visible;
            btnMaximizar.Visible = !btnMaximizar.Visible;
        }
    }
}
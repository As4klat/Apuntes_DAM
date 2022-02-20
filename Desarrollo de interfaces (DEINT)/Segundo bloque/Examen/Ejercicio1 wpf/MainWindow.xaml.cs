using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;

namespace Ejercicio1_wpf
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        List<TextBox> listTextBox = new List<TextBox>();
        List<Label> listaPrecios = new List<Label>();

        public object Application { get; private set; }

        public MainWindow()
        {
            InitializeComponent();
            listTextBox.Add(textCantidad1);
            listTextBox.Add(textCantidad2);
            listTextBox.Add(textCantidad3);
            listTextBox.Add(textCantidad4);
            listTextBox.ForEach(textBox => textBox.IsEnabled = false);

            listaPrecios.Add(precioBigMac);
            listaPrecios.Add(precioCheeseburger);
            listaPrecios.Add(precioMcPollo);
            listaPrecios.Add(precioCBO);
        }

        private void btnAceptar_Click(object sender, RoutedEventArgs e)
        {
            double subtotal = 0;
            for (int i = 0; i < listTextBox.Count; i++)
            {
                if (listTextBox[i].IsEnabled)
                {
                    subtotal = (Convert.ToDouble(listTextBox[i].Text) * Convert.ToDouble(listaPrecios[i].Content.ToString())) + subtotal;
                }
            }
            subtotal = Math.Round(subtotal, 2);

            double conIva = Math.Round(subtotal - (subtotal / 1.21),2);
            
            double total;

            if (textCodigo.Text.Equals("#APRUEBODIU"))
            {
                total = (conIva + subtotal) - (conIva + subtotal)*0.2;
            }
            else
            {
                total = conIva+subtotal;
            }


            listTextBox.ForEach(textBox => textBox.Text = "");
            textSubtotal.Text = subtotal.ToString();
            textIva.Text = conIva.ToString();
            textAPagar.Text = total.ToString();
        }

        private void btnNuevaCompra_Click(object sender, RoutedEventArgs e)
        {
            listTextBox.ForEach(textBox => textBox.Text = "");
            listTextBox.ForEach(textBox => textBox.IsEnabled = false);

            checkBigMac.IsChecked = false;
            checkCBO.IsChecked = false;
            checkCheeseburger.IsChecked = false;
            checkMcPollo.IsChecked = false;

            textSubtotal.Text = "";
            textIva.Text = "";
            textAPagar.Text = "";
        }

        private void btnSalir_Click(object sender, RoutedEventArgs e)
        {
            App.Current.Shutdown();
        }

        private void checkBigMac_Checked(object sender, RoutedEventArgs e)
        {
            textCantidad1.IsEnabled = true;
        }

        private void checkBigMac_Unchecked(object sender, RoutedEventArgs e)
        {
            textCantidad1.IsEnabled = false;
        }

        private void checkCheeseburger_Checked(object sender, RoutedEventArgs e)
        {
            textCantidad2.IsEnabled = true;
        }

        private void checkCheeseburger_Unchecked(object sender, RoutedEventArgs e)
        {
            textCantidad2.IsEnabled = false;
        }

        private void checkMcPollo_Checked(object sender, RoutedEventArgs e)
        {
            textCantidad3.IsEnabled = true;
        }
        private void checkMcPollo_Unchecked(object sender, RoutedEventArgs e)
        {
            textCantidad3.IsEnabled = false;
        }

        private void checkCBO_Checked(object sender, RoutedEventArgs e)
        {
            textCantidad4.IsEnabled = true;
        }
        private void checkCBO_Unchecked(object sender, RoutedEventArgs e)
        {
            textCantidad4.IsEnabled = false;
        }
    }
}

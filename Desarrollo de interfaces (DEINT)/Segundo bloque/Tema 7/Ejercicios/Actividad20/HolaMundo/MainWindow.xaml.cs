using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace HolaMundo
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnGirar_Click(object sender, RoutedEventArgs e)
        {
            string angulo = textAngulo.Text;
            Regex rgx = new Regex(@"^[0-9]+$");
            if (rgx.IsMatch(angulo) && (Convert.ToInt32(angulo) >= 0 && Convert.ToInt32(angulo) <= 360))
            {
                rectMov.RenderTransform = new RotateTransform(Convert.ToInt32(angulo), 50, 50);
            }
            else
            {
                MessageBox.Show("Solo se permiten angulos enteros del 0 al 360.");
            }
        }

        private void textAngulo_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Enter)
            {
                btnGirar_Click(sender, e);
            }
        }
    }
}

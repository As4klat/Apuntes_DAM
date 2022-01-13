using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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

namespace Actividad21_2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            /*
             * 120
             * 2 - 1 - 1 - 1 - 2
             * 
             */
        }

        // Boton del menu 'Combat Skills'
        private void menuCombatSkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuCombatSkills.Foreground = new SolidColorBrush(Colors.White);
        }
        private void menuCombatSkills_MouseLeave(object sender, MouseEventArgs e)
        {
            Color color = (Color)ColorConverter.ConvertFromString("#FFFF4949");
            menuCombatSkills.Foreground = new SolidColorBrush(color);
        }

        // Boton del menu 'Signs Skills'
        private void menuSignsSkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuSignsSkills.Foreground = new SolidColorBrush(Colors.White);
        }

        private void menuSignsSkills_MouseLeave(object sender, MouseEventArgs e)
        {
            Color color = (Color)ColorConverter.ConvertFromString("#FF5C55B1");
            menuSignsSkills.Foreground = new SolidColorBrush(color);
        }

        // Boton del menu 'Alchemy Skills'
        private void menuAlchemySkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuAlchemySkills.Foreground = new SolidColorBrush(Colors.White);
        }

        private void menuAlchemySkills_MouseLeave(object sender, MouseEventArgs e)
        {
            Color color = (Color)ColorConverter.ConvertFromString("#FF52725B");
            menuAlchemySkills.Foreground = new SolidColorBrush(color);
        }

        // Boton del menu 'General Skills'
        private void menuGeneralSkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuGeneralSkills.Foreground = new SolidColorBrush(Colors.White);
        }

        private void menuGeneralSkills_MouseLeave(object sender, MouseEventArgs e)
        {
            Color color = (Color)ColorConverter.ConvertFromString("#FFAC8C66");
            menuGeneralSkills.Foreground = new SolidColorBrush(color);
        }

        // Boton del menu 'Mutagens'
        private void menuMutagens_MouseEnter(object sender, MouseEventArgs e)
        {
            menuMutagens.Foreground = new SolidColorBrush(Colors.White);
        }

        private void menuMutagens_MouseLeave(object sender, MouseEventArgs e)
        {
            Color color = (Color)ColorConverter.ConvertFromString("#FF6D859D");
            menuMutagens.Foreground = new SolidColorBrush(color);
        }

        // Boton del menu 'Mutations'
        private void menuMutations_MouseEnter(object sender, MouseEventArgs e)
        {
            menuMutations.Foreground = new SolidColorBrush(Colors.White);
        }
        private void menuMutations_MouseLeave(object sender, MouseEventArgs e)
        {
            Color color = (Color)ColorConverter.ConvertFromString("#FF948464");
            menuMutations.Foreground = new SolidColorBrush(color);
        }
    }
}

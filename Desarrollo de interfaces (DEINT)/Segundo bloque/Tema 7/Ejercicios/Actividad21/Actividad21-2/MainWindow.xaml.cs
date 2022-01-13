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
        }

        // Boton del menu 'Combat Skills'
        private void menuCombatSkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuCombatSkills.Foreground.Opacity = 1.0;
        }
        private void menuCombatSkills_MouseLeave(object sender, MouseEventArgs e)
        {
            menuCombatSkills.Foreground.Opacity = 0.2;
        }

        // Boton del menu 'Signs Skills'
        private void menuSignsSkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuSignsSkills.Foreground.Opacity = 1.0;
        }

        private void menuSignsSkills_MouseLeave(object sender, MouseEventArgs e)
        {
            menuSignsSkills.Foreground.Opacity = 0.2;
        }

        // Boton del menu 'Alchemy Skills'
        private void menuAlchemySkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuAlchemySkills.Foreground.Opacity = 1.0;
        }

        private void menuAlchemySkills_MouseLeave(object sender, MouseEventArgs e)
        {
            menuAlchemySkills.Foreground.Opacity = 0.2;
        }

        // Boton del menu 'General Skills'
        private void menuGeneralSkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuGeneralSkills.Foreground.Opacity = 1.0;
        }

        private void menuGeneralSkills_MouseLeave(object sender, MouseEventArgs e)
        {
            menuGeneralSkills.Foreground.Opacity = 0.2;
        }

        // Boton del menu 'Mutagens'
        private void menuMutagens_MouseEnter(object sender, MouseEventArgs e)
        {
            menuMutagens.Foreground.Opacity = 1.0;
        }

        private void menuMutagens_MouseLeave(object sender, MouseEventArgs e)
        {
            menuMutagens.Foreground.Opacity = 0.2;
        }

        // Boton del menu 'Mutations'
        private void menuMutations_MouseEnter(object sender, MouseEventArgs e)
        {
            menuMutations.Foreground.Opacity = 1.0;
        }
        private void menuMutations_MouseLeave(object sender, MouseEventArgs e)
        {
            menuMutations.Foreground.Opacity = 0.2;
        }
    }
}

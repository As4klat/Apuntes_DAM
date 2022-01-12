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

        private void menuCombatSkills_MouseEnter(object sender, MouseEventArgs e)
        {
            menuCombatSkills.Foreground = new SolidColorBrush(Colors.White);
        }
        private void menuCombatSkills_MouseLeave(object sender, MouseEventArgs e)
        {
            menuCombatSkills.Foreground = new SolidColorBrush(Color.FromRgb(255, 73, 73));
        }

        private void menuSignsSkills_MouseEnter(object sender, MouseEventArgs e)
        {

        }

        private void menuAlchemySkills_MouseEnter(object sender, MouseEventArgs e)
        {

        }

        private void menuGeneralSkills_MouseEnter(object sender, MouseEventArgs e)
        {

        }

        private void menuMutagens_MouseEnter(object sender, MouseEventArgs e)
        {

        }

        private void menuMutations_MouseEnter(object sender, MouseEventArgs e)
        {

        }

        
    }
}

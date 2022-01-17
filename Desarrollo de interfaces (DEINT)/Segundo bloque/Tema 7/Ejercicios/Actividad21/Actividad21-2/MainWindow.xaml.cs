using Actividad21_2.Componentes;
using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Input;

namespace Actividad21_2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private List<object> list;
        public MainWindow()
        {
            InitializeComponent();
            list = new List<object>();
            
            for (int i = 1; i <= 6; i++)
            {
                list.Add(new PanelHabilidades(i));
            }
            ContenedorHabilidades.Children.Add((UIElement)list[0]);
        }

        private void menuBottons_MouseDown(object sender, MouseButtonEventArgs e)
        {
            ContenedorHabilidades.Children.Clear();
            if (sender.Equals(menuCombatSkills))
            {
                ContenedorHabilidades.Children.Add((UIElement)list[0]);
            }
            else if (sender.Equals(menuSignsSkills))
            {
                ContenedorHabilidades.Children.Add((UIElement)list[1]);
            }
            else if (sender.Equals(menuAlchemySkills))
            {
                ContenedorHabilidades.Children.Add((UIElement)list[2]);
            }
            else if (sender.Equals(menuGeneralSkills))
            {
                ContenedorHabilidades.Children.Add((UIElement)list[3]);
            }
            else if (sender.Equals(menuMutagens))
            {
                ContenedorHabilidades.Children.Add((UIElement)list[4]);
            }
            else if (sender.Equals(menuMutations))
            {
                ContenedorHabilidades.Children.Add((UIElement)list[5]);
            }
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

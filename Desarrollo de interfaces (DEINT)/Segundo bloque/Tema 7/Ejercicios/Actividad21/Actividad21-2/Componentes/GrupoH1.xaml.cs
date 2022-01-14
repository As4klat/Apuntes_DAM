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

namespace Actividad21_2.Componentes
{
    /// <summary>
    /// Lógica de interacción para GrupoH1.xaml
    /// </summary>
    public partial class GrupoH1 : UserControl
    {
        public GrupoH1()
        {
            InitializeComponent();
            List<StackPanel> grupoHabilidades = new List<StackPanel>();
            grupoHabilidades.Add(GrupoHabilidadesT1);
            grupoHabilidades.Add(GrupoHabilidadesT2);
            grupoHabilidades.Add(GrupoHabilidadesT3);
            grupoHabilidades.Add(GrupoHabilidadesT4);

            foreach (StackPanel gr in grupoHabilidades)
            {
                for (int i=0; i < 5;i++)
                {
                    
                x: Name = "h1" TextWrapping = "Wrap" Text = "TextBlock" />
                     
                }
            }
        }
    }
}

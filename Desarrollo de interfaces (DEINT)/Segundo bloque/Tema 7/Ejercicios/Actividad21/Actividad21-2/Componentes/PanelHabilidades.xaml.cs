using Actividad21_2.Clases;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Actividad21_2.Componentes
{
    /// <summary>
    /// Lógica de interacción para PanelHabilidades.xaml
    /// </summary>
    public partial class PanelHabilidades : UserControl
    {
        private int id;
        private JToken s;
        private string[] habilidades;
        private Label[] listaHabilidaes;

        public PanelHabilidades(int id)
        {
            listaHabilidaes = new Label[20];
            this.id = id;
            CargarJson();
            InitializeComponent();
            CrearHabilidades();
            GenerarCabecera();
        }

        private void CargarJson()
        {
            JObject json = null;
            try
            {
                StreamReader r = new StreamReader("../../Recursos/Habilidades.json");
                string jsonString = r.ReadToEnd();
                json = JObject.Parse(jsonString);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            switch (id)
            {
                case 1:
                    s = json["1"];
                    break;
                case 2:
                    s = json["2"];
                    break;
                case 3:
                    s = json["3"];
                    break;
                case 4:
                    s = json["4"];
                    break;
                case 5:
                    s = json["5"];
                    break;
                case 6:
                    s = json["6"];
                    break;
            }
        }

        private void GenerarCabecera()
        {
            borderCabecera.BorderBrush = new SolidColorBrush((Color)ColorConverter.ConvertFromString((string) s["colores"]["border"]));
            CabeceraTitulo.Background = new LinearGradientBrush(
                (Color)ColorConverter.ConvertFromString((string)s["colores"]["principal"]),
                (Color)ColorConverter.ConvertFromString((string)s["colores"]["secundario"]),
                new Point(0.5, 0),
                new Point(1, 1));
            CabeceraCategorias.Background = new SolidColorBrush((Color)ColorConverter.ConvertFromString((string)s["colores"]["principal"]));

            tituloCabecera.Content = s["titulo"];
            if (id == 5)
            {
                PuntosEnRama.Visibility = Visibility.Collapsed;
            }
            if (id == 6)
            {
                PuntosEnRama.Content = "Research cost total:";
            }
            if (id >= 4)
            {
                CabeceraCategorias.Visibility = Visibility.Collapsed;
            }
            if (id >= 1 && id < 4)
            {
                for (int i = 0; i < 5; i++)
                {
                    TextBlock t = new TextBlock();
                    t.Text = (string) s["cabecera"].ElementAt(i);
                    t.FontSize = 14;
                    t.TextAlignment = TextAlignment.Center;
                    t.TextWrapping = TextWrapping.WrapWithOverflow;
                    Label c = (Label)CabeceraCategorias.FindName("CabezeraHabilidad" + (i + 1));
                    c.Content = t;
                }
            }
            
        }

        private void CrearHabilidades()
        {
            
            if (id >= 1 && id <= 4)
            {
                HabilidadesP1234();
            }
            if(id == 5)
            {
                HabilidadesP5();
            }
            if (id == 6)
            {
                HabilidadesP6();
            }

        }

        private void HabilidadesP1234()
        {
            List<StackPanel> grupoHabilidades = new List<StackPanel>();
            grupoHabilidades.Add(GrupoHabilidadesT1);
            grupoHabilidades.Add(GrupoHabilidadesT2);
            grupoHabilidades.Add(GrupoHabilidadesT3);
            grupoHabilidades.Add(GrupoHabilidadesT4);


            int j = 0;
            foreach (StackPanel gr in grupoHabilidades)
            {
                SolidColorBrush sc = new SolidColorBrush((Color)ColorConverter.ConvertFromString((string)s["colores"]["secundario"]));
                sc.Opacity = 0.9;
                gr.Background = sc;

                for (int i = 0; i < 5; i++)
                {
                    Border b = new Border();
                    b.BorderBrush = new SolidColorBrush((Color)ColorConverter.ConvertFromString((string)s["colores"]["border"]));
                    b.BorderThickness = new Thickness(2, 2, 2, 2);
                    b.Width = 90;
                    b.Height = 90;
                    b.Margin = new Thickness(24, 5, 0, 5);

                    TextBlock t = new TextBlock();
                    t.Text = (string)s["habilidades"].ElementAt(j);
                    t.TextAlignment = TextAlignment.Center;
                    t.TextWrapping = TextWrapping.Wrap;
                    Label lbl = new Label();
                    lbl.Name = "H" + i;
                    lbl.Content = t;
                    lbl.FontSize = 14;
                    lbl.FontWeight = FontWeights.Bold;
                    lbl.FontFamily = new FontFamily("Segoe UI");
                    lbl.Foreground = new SolidColorBrush(Colors.White);
                    lbl.VerticalContentAlignment = VerticalAlignment.Center;
                    lbl.HorizontalAlignment = HorizontalAlignment.Center;
                    lbl.Cursor = Cursors.Hand;
                    lbl.MouseMove += new MouseEventHandler(Drag_MouseMove);

                    DropShadowEffect te = new DropShadowEffect();
                    te.ShadowDepth = 3;
                    te.Direction = 330;
                    te.Color = Colors.Black;
                    te.BlurRadius = 1;

                    lbl.Effect = te;
                    b.Child = lbl;
                    gr.Children.Add(b);
                    j++;
                    listaHabilidaes.Append(lbl);
                }
            }
        }

        private void HabilidadesP5()
        {
            List<StackPanel> grupoMutagenos = new List<StackPanel>();
            grupoMutagenos.Add(GrupoHabilidadesT1);
            grupoMutagenos.Add(GrupoHabilidadesT2);
            grupoMutagenos.Add(GrupoHabilidadesT3);

            Brush[] colores = new Brush[6];
            colores[0] = Brushes.Red;
            colores[1] = Brushes.Blue;
            colores[2] = Brushes.Green;
            colores[3] = Brushes.DarkRed;
            colores[4] = Brushes.DarkBlue;
            colores[5] = Brushes.DarkGreen;
            int cont = 0;
            int j = 0;
            foreach (StackPanel gm in grupoMutagenos)
            {
                gm.Background = null;
                
                for (int i = 0; i < 3; i++)
                {
                    Border r = new Border();
                    r.Background = colores[cont + 3];
                    r.BorderBrush = colores[cont];
                    r.BorderThickness = new Thickness(2, 2, 2, 2);
                    r.Width = 100;
                    r.Height = 100;
                    r.Margin = new Thickness(75,30,0,30);
                    r.RenderTransform = new RotateTransform(45, 50, 50);
                    r.Cursor = Cursors.Hand;
                    r.MouseMove += new MouseEventHandler(Drag_MouseMove);

                    TextBlock t = new TextBlock();
                    t.Text = (string)s["habilidades"].ElementAt(j);
                    t.TextAlignment = TextAlignment.Center;
                    t.RenderTransform = new RotateTransform(0, 0, 0);
                    Panel.SetZIndex(t,1);
                    Label lbl = new Label();
                    lbl.Name = "H" + i;
                    lbl.Content = t;
                    lbl.FontSize = 14;
                    lbl.FontWeight = FontWeights.Bold;
                    lbl.FontFamily = new FontFamily("Segoe UI");
                    lbl.Foreground = new SolidColorBrush(Colors.White);
                    lbl.VerticalContentAlignment = VerticalAlignment.Center;
                    lbl.HorizontalAlignment = HorizontalAlignment.Center;
                    lbl.Cursor = Cursors.Hand;
                    lbl.MouseMove += new MouseEventHandler(Drag_MouseMove);

                    r.Child = lbl;
                    gm.Children.Add(r);
                    j++;
                }
                cont++;
            }
        }

        private void HabilidadesP6()
        {

        }

        private void Drag_MouseMove(object sender, MouseEventArgs e)
        {
            if (e.LeftButton == MouseButtonState.Pressed)
            {
                DragDrop.DoDragDrop((DependencyObject)sender, sender, DragDropEffects.Move);
            }
        }
    }
}

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

        public PanelHabilidades(int id)
        {
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
                    b.Cursor = Cursors.Hand;
                    b.MouseMove += new MouseEventHandler(Drag_MouseMove);

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

                    DropShadowEffect te = new DropShadowEffect();
                    te.ShadowDepth = 3;
                    te.Direction = 330;
                    te.Color = Colors.Black;
                    te.BlurRadius = 1;

                    lbl.Effect = te;
                    b.Child = lbl;
                    gr.Children.Add(b);
                    j++;
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

                    r.Child = lbl;
                    gm.Children.Add(r);
                    j++;
                }
                cont++;
            }
        }

        private void HabilidadesP6()
        {
            List<StackPanel> grupoMutagenos = new List<StackPanel>();
            grupoMutagenos.Add(GrupoHabilidadesT1);
            grupoMutagenos.Add(GrupoHabilidadesT2);
            grupoMutagenos.Add(GrupoHabilidadesT3);
            grupoMutagenos.Add(GrupoHabilidadesT4);

            int j = 0;
            int cont = 0;
            int[] vueltas = {3,2,5,3};
            foreach (StackPanel gm in grupoMutagenos)
            {
                gm.HorizontalAlignment = HorizontalAlignment.Center;
                gm.Background = null;

                for (int i = 0; i < vueltas[cont]; i++)
                {
                    Border r = new Border();
                    r.Background = PaletaColor(cont, i)[0];
                    r.BorderBrush = PaletaColor(cont, i)[1];
                    r.BorderThickness = new Thickness(4);
                    r.Width = 100;
                    r.Height = 100;
                    if (cont == 0)
                    {
                        r.Margin = new Thickness(40,10,40,10);
                    }
                    else
                    {
                        if (cont == 3)
                        {
                            r.Margin = new Thickness(70, 10, 70, 10);
                        }
                        else
                        {
                            r.Margin = new Thickness(10);
                        }
                    }
                    r.CornerRadius = new CornerRadius(50);
                    r.Cursor = Cursors.Hand;
                    r.MouseMove += new MouseEventHandler(Drag_MouseMove);

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

                    r.Child = lbl;
                    gm.Children.Add(r);
                    j++;
                }
                cont++;
            }
        }

        private Brush[] PaletaColor(int grupo, int vuelta)
        {
            Brush[] r = new Brush[2];

            switch (grupo)
            {
                case 0:
                    if (vuelta == 1)
                    {
                        r[0] = Brushes.DarkRed;
                        r[1] = Brushes.Red;
                    }
                    else
                    {
                        r[0] = Brushes.Gray;
                        r[1] = Brushes.White;
                    }
                    
                    break;
                case 1:
                    if (vuelta == 0)
                    {
                        r[0] = Brushes.DarkViolet;
                        r[1] = Brushes.Violet;
                    }
                    else
                    {
                        r[0] = Brushes.YellowGreen;
                        r[1] = Brushes.Yellow;
                    }
                    break;
                case 2:
                    if (vuelta < 2)
                    {
                        r[0] = Brushes.DarkBlue;
                        r[1] = Brushes.Blue;
                    }
                    if(vuelta == 2)
                    {
                        r[0] = Brushes.DarkRed;
                        r[1] = Brushes.Red;
                    }
                    if (vuelta > 2)
                    {
                        r[0] = Brushes.DarkGreen;
                        r[1] = Brushes.Green;
                    }
                    break;
                case 3:
                    if (vuelta == 0)
                    {
                        r[0] = Brushes.DarkViolet;
                        r[1] = Brushes.Violet;
                    }
                    if (vuelta == 1)
                    {
                        r[0] = Brushes.Gray;
                        r[1] = Brushes.White;
                    }
                    if (vuelta == 2)
                    {
                        r[0] = Brushes.YellowGreen;
                        r[1] = Brushes.Yellow;
                    }
                    break;
            }
            return r;
        }

        private void Drag_MouseMove(object sender, MouseEventArgs e)
        {
            
            if (e.LeftButton == MouseButtonState.Pressed)
            {
                DragDrop.DoDragDrop((Border)sender, sender, DragDropEffects.Copy);
            }
        }
    }
}

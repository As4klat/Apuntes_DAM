using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.Win32;

namespace Actividad13
{
    public partial class Form1 : Form
    {
        DialogResult resultFileAdjunto;
        string ruta;

        public Form1()
        {
            InitializeComponent();
        }

        private void btnEnviar_Click(object sender, EventArgs e)
        {
            try
            {
                MailMessage _Correo = new MailMessage();
                _Correo.From = new MailAddress(textDe.Text);

                _Correo.To.Add(textPara.Text);
                _Correo.Subject = textAsunto.Text;
                _Correo.Body = textContenido.Text;
                _Correo.IsBodyHtml = false;
                _Correo.Priority = MailPriority.Normal;
                if (!labelArchivo.Text.Equals(""))
                {
                    Attachment file = new Attachment(ruta);
                    _Correo.Attachments.Add(file);
                }

                SmtpClient smtp = new SmtpClient();
                smtp.Credentials = new NetworkCredential(textDe.Text, textPasswd.Text);

                smtp.Host = "smtp.gmail.com";
                smtp.Port = 587;
                smtp.EnableSsl = true;

                MessageBox.Show("El mensaje se ha enviado saticfactoriamente.");
            }
            catch(Exception a)
            {
                MessageBox.Show("Error" + a.Message);
            }
        }

        private void btnArchivo_Click(object sender, EventArgs e)
        {
            OpenFileDialog dlg = new OpenFileDialog();
            dlg.DefaultExt = ".*";
            dlg.Filter = "Archivos (.*)|*.*";

            resultFileAdjunto = dlg.ShowDialog();

            if (resultFileAdjunto == DialogResult.OK)
            {
                ruta = dlg.FileName;
                labelArchivo.Text = ruta;
            }
        }
    }
}

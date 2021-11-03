
namespace Actividad13
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.textDe = new System.Windows.Forms.TextBox();
            this.textPasswd = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.textPara = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.btnArchivo = new System.Windows.Forms.Button();
            this.textAsunto = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.textContenido = new System.Windows.Forms.TextBox();
            this.labelArchivo = new System.Windows.Forms.Label();
            this.btnEnviar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(50, 46);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(30, 17);
            this.label1.TabIndex = 0;
            this.label1.Text = "De:";
            // 
            // textDe
            // 
            this.textDe.Location = new System.Drawing.Point(169, 41);
            this.textDe.Name = "textDe";
            this.textDe.Size = new System.Drawing.Size(242, 22);
            this.textDe.TabIndex = 1;
            // 
            // textPasswd
            // 
            this.textPasswd.Location = new System.Drawing.Point(169, 78);
            this.textPasswd.Name = "textPasswd";
            this.textPasswd.Size = new System.Drawing.Size(242, 22);
            this.textPasswd.TabIndex = 3;
            this.textPasswd.UseSystemPasswordChar = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(50, 83);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(85, 17);
            this.label2.TabIndex = 2;
            this.label2.Text = "Contraseña:";
            // 
            // textPara
            // 
            this.textPara.Location = new System.Drawing.Point(169, 118);
            this.textPara.Name = "textPara";
            this.textPara.Size = new System.Drawing.Size(564, 22);
            this.textPara.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(50, 123);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(42, 17);
            this.label3.TabIndex = 4;
            this.label3.Text = "Para:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(50, 163);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(56, 17);
            this.label4.TabIndex = 6;
            this.label4.Text = "Asunto:";
            // 
            // btnArchivo
            // 
            this.btnArchivo.Location = new System.Drawing.Point(169, 157);
            this.btnArchivo.Name = "btnArchivo";
            this.btnArchivo.Size = new System.Drawing.Size(148, 23);
            this.btnArchivo.TabIndex = 7;
            this.btnArchivo.Text = "Archivo Adjunto";
            this.btnArchivo.UseVisualStyleBackColor = true;
            this.btnArchivo.Click += new System.EventHandler(this.btnArchivo_Click);
            // 
            // textAsunto
            // 
            this.textAsunto.Location = new System.Drawing.Point(53, 186);
            this.textAsunto.Name = "textAsunto";
            this.textAsunto.Size = new System.Drawing.Size(680, 22);
            this.textAsunto.TabIndex = 8;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(50, 221);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(76, 17);
            this.label5.TabIndex = 9;
            this.label5.Text = "Contenido:";
            // 
            // textContenido
            // 
            this.textContenido.Location = new System.Drawing.Point(53, 252);
            this.textContenido.Multiline = true;
            this.textContenido.Name = "textContenido";
            this.textContenido.Size = new System.Drawing.Size(680, 186);
            this.textContenido.TabIndex = 10;
            // 
            // labelArchivo
            // 
            this.labelArchivo.AutoSize = true;
            this.labelArchivo.Location = new System.Drawing.Point(341, 160);
            this.labelArchivo.Name = "labelArchivo";
            this.labelArchivo.Size = new System.Drawing.Size(0, 17);
            this.labelArchivo.TabIndex = 11;
            // 
            // btnEnviar
            // 
            this.btnEnviar.Location = new System.Drawing.Point(628, 451);
            this.btnEnviar.Name = "btnEnviar";
            this.btnEnviar.Size = new System.Drawing.Size(105, 35);
            this.btnEnviar.TabIndex = 12;
            this.btnEnviar.Text = "Enviar";
            this.btnEnviar.UseVisualStyleBackColor = true;
            this.btnEnviar.Click += new System.EventHandler(this.btnEnviar_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 498);
            this.Controls.Add(this.btnEnviar);
            this.Controls.Add(this.labelArchivo);
            this.Controls.Add(this.textContenido);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.textAsunto);
            this.Controls.Add(this.btnArchivo);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.textPara);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.textPasswd);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.textDe);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textDe;
        private System.Windows.Forms.TextBox textPasswd;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textPara;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button btnArchivo;
        private System.Windows.Forms.TextBox textAsunto;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textContenido;
        private System.Windows.Forms.Label labelArchivo;
        private System.Windows.Forms.Button btnEnviar;
    }
}


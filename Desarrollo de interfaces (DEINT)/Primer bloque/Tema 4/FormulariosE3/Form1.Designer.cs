
namespace FormulariosE3
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
            this.rbAscent = new System.Windows.Forms.RadioButton();
            this.rbDescent = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.numero = new System.Windows.Forms.NumericUpDown();
            this.label2 = new System.Windows.Forms.Label();
            this.areaTexto = new System.Windows.Forms.RichTextBox();
            ((System.ComponentModel.ISupportInitialize)(this.numero)).BeginInit();
            this.SuspendLayout();
            // 
            // rbAscent
            // 
            this.rbAscent.AutoSize = true;
            this.rbAscent.Location = new System.Drawing.Point(42, 89);
            this.rbAscent.Margin = new System.Windows.Forms.Padding(2);
            this.rbAscent.Name = "rbAscent";
            this.rbAscent.Size = new System.Drawing.Size(82, 17);
            this.rbAscent.TabIndex = 0;
            this.rbAscent.TabStop = true;
            this.rbAscent.Text = "Ascendente";
            this.rbAscent.UseVisualStyleBackColor = true;
            this.rbAscent.CheckedChanged += new System.EventHandler(this.rbAscent_CheckedChanged);
            // 
            // rbDescent
            // 
            this.rbDescent.AutoSize = true;
            this.rbDescent.Location = new System.Drawing.Point(164, 89);
            this.rbDescent.Margin = new System.Windows.Forms.Padding(2);
            this.rbDescent.Name = "rbDescent";
            this.rbDescent.Size = new System.Drawing.Size(89, 17);
            this.rbDescent.TabIndex = 1;
            this.rbDescent.TabStop = true;
            this.rbDescent.Text = "Descendente";
            this.rbDescent.UseVisualStyleBackColor = true;
            this.rbDescent.CheckedChanged += new System.EventHandler(this.rbDescent_CheckedChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(40, 47);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(55, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "NUMERO";
            // 
            // numero
            // 
            this.numero.Location = new System.Drawing.Point(157, 43);
            this.numero.Margin = new System.Windows.Forms.Padding(2);
            this.numero.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numero.Name = "numero";
            this.numero.Size = new System.Drawing.Size(90, 20);
            this.numero.TabIndex = 3;
            this.numero.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numero.ValueChanged += new System.EventHandler(this.numero_ValueChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(40, 137);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(133, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "TABLA DE MULTIPLICAR";
            // 
            // areaTexto
            // 
            this.areaTexto.Location = new System.Drawing.Point(43, 172);
            this.areaTexto.Name = "areaTexto";
            this.areaTexto.Size = new System.Drawing.Size(204, 214);
            this.areaTexto.TabIndex = 5;
            this.areaTexto.Text = "";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(288, 398);
            this.Controls.Add(this.areaTexto);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.numero);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.rbDescent);
            this.Controls.Add(this.rbAscent);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.numero)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton rbAscent;
        private System.Windows.Forms.RadioButton rbDescent;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.NumericUpDown numero;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.RichTextBox areaTexto;
    }
}



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
            this.textBox1 = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.numero)).BeginInit();
            this.SuspendLayout();
            // 
            // rbAscent
            // 
            this.rbAscent.AutoSize = true;
            this.rbAscent.Location = new System.Drawing.Point(56, 109);
            this.rbAscent.Name = "rbAscent";
            this.rbAscent.Size = new System.Drawing.Size(104, 21);
            this.rbAscent.TabIndex = 0;
            this.rbAscent.TabStop = true;
            this.rbAscent.Text = "Ascendente";
            this.rbAscent.UseVisualStyleBackColor = true;
            // 
            // rbDescent
            // 
            this.rbDescent.AutoSize = true;
            this.rbDescent.Location = new System.Drawing.Point(219, 109);
            this.rbDescent.Name = "rbDescent";
            this.rbDescent.Size = new System.Drawing.Size(113, 21);
            this.rbDescent.TabIndex = 1;
            this.rbDescent.TabStop = true;
            this.rbDescent.Text = "Descendente";
            this.rbDescent.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(53, 58);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(69, 17);
            this.label1.TabIndex = 2;
            this.label1.Text = "NUMERO";
            // 
            // numero
            // 
            this.numero.Location = new System.Drawing.Point(209, 53);
            this.numero.Name = "numero";
            this.numero.Size = new System.Drawing.Size(120, 22);
            this.numero.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(53, 169);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(168, 17);
            this.label2.TabIndex = 4;
            this.label2.Text = "TABLA DE MULTIPLICAR";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(89, 207);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(231, 236);
            this.textBox1.TabIndex = 5;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(421, 455);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.numero);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.rbDescent);
            this.Controls.Add(this.rbAscent);
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
        private System.Windows.Forms.TextBox textBox1;
    }
}



namespace Examen2_gamaza
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
            this.textNombre = new System.Windows.Forms.TextBox();
            this.textSueldoHora = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.textHorasTrabajadas = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.textHorasExtras = new System.Windows.Forms.TextBox();
            this.groupResultado = new System.Windows.Forms.GroupBox();
            this.btnSalir = new System.Windows.Forms.Button();
            this.btnLimpiar = new System.Windows.Forms.Button();
            this.btnCalcular = new System.Windows.Forms.Button();
            this.textSueldoNeto = new System.Windows.Forms.TextBox();
            this.textImpuesto = new System.Windows.Forms.TextBox();
            this.textSueldo = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.groupDatos = new System.Windows.Forms.GroupBox();
            this.groupResultado.SuspendLayout();
            this.groupDatos.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 40);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(62, 17);
            this.label1.TabIndex = 0;
            this.label1.Text = "Nombre:";
            // 
            // textNombre
            // 
            this.textNombre.Location = new System.Drawing.Point(111, 37);
            this.textNombre.Name = "textNombre";
            this.textNombre.Size = new System.Drawing.Size(392, 22);
            this.textNombre.TabIndex = 1;
            // 
            // textSueldoHora
            // 
            this.textSueldoHora.Location = new System.Drawing.Point(111, 73);
            this.textSueldoHora.Name = "textSueldoHora";
            this.textSueldoHora.Size = new System.Drawing.Size(122, 22);
            this.textSueldoHora.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 76);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(99, 17);
            this.label2.TabIndex = 2;
            this.label2.Text = "Sueldo x hora:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 115);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(179, 17);
            this.label3.TabIndex = 4;
            this.label3.Text = "Cantidad horas trabajadas:";
            // 
            // textHorasTrabajadas
            // 
            this.textHorasTrabajadas.Location = new System.Drawing.Point(191, 112);
            this.textHorasTrabajadas.Name = "textHorasTrabajadas";
            this.textHorasTrabajadas.Size = new System.Drawing.Size(122, 22);
            this.textHorasTrabajadas.TabIndex = 5;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(6, 154);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(151, 17);
            this.label4.TabIndex = 6;
            this.label4.Text = "Cantidad horas Extras:";
            // 
            // textHorasExtras
            // 
            this.textHorasExtras.Location = new System.Drawing.Point(191, 151);
            this.textHorasExtras.Name = "textHorasExtras";
            this.textHorasExtras.Size = new System.Drawing.Size(122, 22);
            this.textHorasExtras.TabIndex = 7;
            // 
            // groupResultado
            // 
            this.groupResultado.BackColor = System.Drawing.SystemColors.Control;
            this.groupResultado.Controls.Add(this.btnSalir);
            this.groupResultado.Controls.Add(this.btnLimpiar);
            this.groupResultado.Controls.Add(this.btnCalcular);
            this.groupResultado.Controls.Add(this.textSueldoNeto);
            this.groupResultado.Controls.Add(this.textImpuesto);
            this.groupResultado.Controls.Add(this.textSueldo);
            this.groupResultado.Controls.Add(this.label7);
            this.groupResultado.Controls.Add(this.label6);
            this.groupResultado.Controls.Add(this.label5);
            this.groupResultado.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.groupResultado.Location = new System.Drawing.Point(12, 239);
            this.groupResultado.Name = "groupResultado";
            this.groupResultado.Size = new System.Drawing.Size(535, 248);
            this.groupResultado.TabIndex = 1;
            this.groupResultado.TabStop = false;
            this.groupResultado.Text = "Resultado";
            // 
            // btnSalir
            // 
            this.btnSalir.Location = new System.Drawing.Point(351, 160);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(114, 45);
            this.btnSalir.TabIndex = 16;
            this.btnSalir.Text = "Salir";
            this.btnSalir.UseVisualStyleBackColor = true;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // btnLimpiar
            // 
            this.btnLimpiar.Location = new System.Drawing.Point(351, 102);
            this.btnLimpiar.Name = "btnLimpiar";
            this.btnLimpiar.Size = new System.Drawing.Size(114, 45);
            this.btnLimpiar.TabIndex = 15;
            this.btnLimpiar.Text = "Limpiar";
            this.btnLimpiar.UseVisualStyleBackColor = true;
            this.btnLimpiar.Click += new System.EventHandler(this.btnLimpiar_Click);
            // 
            // btnCalcular
            // 
            this.btnCalcular.Location = new System.Drawing.Point(351, 44);
            this.btnCalcular.Name = "btnCalcular";
            this.btnCalcular.Size = new System.Drawing.Size(114, 45);
            this.btnCalcular.TabIndex = 14;
            this.btnCalcular.Text = "Calcular";
            this.btnCalcular.UseVisualStyleBackColor = true;
            this.btnCalcular.Click += new System.EventHandler(this.btnCalcular_Click);
            // 
            // textSueldoNeto
            // 
            this.textSueldoNeto.Enabled = false;
            this.textSueldoNeto.Location = new System.Drawing.Point(135, 130);
            this.textSueldoNeto.Name = "textSueldoNeto";
            this.textSueldoNeto.Size = new System.Drawing.Size(157, 22);
            this.textSueldoNeto.TabIndex = 13;
            // 
            // textImpuesto
            // 
            this.textImpuesto.Enabled = false;
            this.textImpuesto.Location = new System.Drawing.Point(135, 99);
            this.textImpuesto.Name = "textImpuesto";
            this.textImpuesto.Size = new System.Drawing.Size(157, 22);
            this.textImpuesto.TabIndex = 12;
            // 
            // textSueldo
            // 
            this.textSueldo.Enabled = false;
            this.textSueldo.Location = new System.Drawing.Point(135, 68);
            this.textSueldo.Name = "textSueldo";
            this.textSueldo.Size = new System.Drawing.Size(157, 22);
            this.textSueldo.TabIndex = 11;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(15, 133);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(90, 17);
            this.label7.TabIndex = 10;
            this.label7.Text = "Sueldo Neto:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(15, 102);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(69, 17);
            this.label6.TabIndex = 9;
            this.label6.Text = "Impuesto:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(15, 71);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(56, 17);
            this.label5.TabIndex = 8;
            this.label5.Text = "Sueldo:";
            // 
            // groupDatos
            // 
            this.groupDatos.Controls.Add(this.textHorasExtras);
            this.groupDatos.Controls.Add(this.label1);
            this.groupDatos.Controls.Add(this.textSueldoHora);
            this.groupDatos.Controls.Add(this.label4);
            this.groupDatos.Controls.Add(this.label3);
            this.groupDatos.Controls.Add(this.textNombre);
            this.groupDatos.Controls.Add(this.label2);
            this.groupDatos.Controls.Add(this.textHorasTrabajadas);
            this.groupDatos.Location = new System.Drawing.Point(12, 13);
            this.groupDatos.Name = "groupDatos";
            this.groupDatos.Size = new System.Drawing.Size(535, 209);
            this.groupDatos.TabIndex = 2;
            this.groupDatos.TabStop = false;
            this.groupDatos.Text = "Datos";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(559, 499);
            this.Controls.Add(this.groupDatos);
            this.Controls.Add(this.groupResultado);
            this.Name = "Form1";
            this.Text = "Calculo del sueldo";
            this.groupResultado.ResumeLayout(false);
            this.groupResultado.PerformLayout();
            this.groupDatos.ResumeLayout(false);
            this.groupDatos.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.TextBox textSueldoHora;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textNombre;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textHorasExtras;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textHorasTrabajadas;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.GroupBox groupResultado;
        private System.Windows.Forms.GroupBox groupDatos;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textSueldoNeto;
        private System.Windows.Forms.TextBox textImpuesto;
        private System.Windows.Forms.TextBox textSueldo;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.Button btnLimpiar;
        private System.Windows.Forms.Button btnCalcular;
    }
}


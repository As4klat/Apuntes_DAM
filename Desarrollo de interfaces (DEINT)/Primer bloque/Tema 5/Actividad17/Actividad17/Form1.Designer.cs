
namespace Actividad17
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
            this.pInputsCliente = new System.Windows.Forms.Panel();
            this.textDireccion = new System.Windows.Forms.TextBox();
            this.textNombre = new System.Windows.Forms.TextBox();
            this.textDni = new System.Windows.Forms.TextBox();
            this.lNumeroCuenta = new System.Windows.Forms.Label();
            this.lTelefono = new System.Windows.Forms.Label();
            this.lEdad = new System.Windows.Forms.Label();
            this.lDireccion = new System.Windows.Forms.Label();
            this.lNombre = new System.Windows.Forms.Label();
            this.lDni = new System.Windows.Forms.Label();
            this.pCrud = new System.Windows.Forms.Panel();
            this.btnReset = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.btnRemove = new System.Windows.Forms.Button();
            this.btnMod = new System.Windows.Forms.Button();
            this.datosClientes = new System.Windows.Forms.DataGridView();
            this.btnAdd = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.textEdad = new System.Windows.Forms.TextBox();
            this.textTelefono = new System.Windows.Forms.TextBox();
            this.textNumeroCuenta = new System.Windows.Forms.TextBox();
            this.pInputsCliente.SuspendLayout();
            this.pCrud.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.datosClientes)).BeginInit();
            this.SuspendLayout();
            // 
            // pInputsCliente
            // 
            this.pInputsCliente.AccessibleName = "";
            this.pInputsCliente.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.pInputsCliente.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pInputsCliente.Controls.Add(this.textNumeroCuenta);
            this.pInputsCliente.Controls.Add(this.textTelefono);
            this.pInputsCliente.Controls.Add(this.textEdad);
            this.pInputsCliente.Controls.Add(this.textDireccion);
            this.pInputsCliente.Controls.Add(this.textNombre);
            this.pInputsCliente.Controls.Add(this.textDni);
            this.pInputsCliente.Controls.Add(this.lNumeroCuenta);
            this.pInputsCliente.Controls.Add(this.lTelefono);
            this.pInputsCliente.Controls.Add(this.lEdad);
            this.pInputsCliente.Controls.Add(this.lDireccion);
            this.pInputsCliente.Controls.Add(this.lNombre);
            this.pInputsCliente.Controls.Add(this.lDni);
            this.pInputsCliente.Location = new System.Drawing.Point(12, 33);
            this.pInputsCliente.Name = "pInputsCliente";
            this.pInputsCliente.Size = new System.Drawing.Size(776, 155);
            this.pInputsCliente.TabIndex = 6;
            // 
            // textDireccion
            // 
            this.textDireccion.Location = new System.Drawing.Point(89, 51);
            this.textDireccion.Name = "textDireccion";
            this.textDireccion.Size = new System.Drawing.Size(673, 22);
            this.textDireccion.TabIndex = 14;
            // 
            // textNombre
            // 
            this.textNombre.Location = new System.Drawing.Point(314, 23);
            this.textNombre.Name = "textNombre";
            this.textNombre.Size = new System.Drawing.Size(448, 22);
            this.textNombre.TabIndex = 13;
            // 
            // textDni
            // 
            this.textDni.Location = new System.Drawing.Point(51, 23);
            this.textDni.Name = "textDni";
            this.textDni.Size = new System.Drawing.Size(189, 22);
            this.textDni.TabIndex = 12;
            // 
            // lNumeroCuenta
            // 
            this.lNumeroCuenta.AutoSize = true;
            this.lNumeroCuenta.Location = new System.Drawing.Point(12, 109);
            this.lNumeroCuenta.Name = "lNumeroCuenta";
            this.lNumeroCuenta.Size = new System.Drawing.Size(129, 17);
            this.lNumeroCuenta.TabIndex = 11;
            this.lNumeroCuenta.Text = "Número de cuenta:";
            // 
            // lTelefono
            // 
            this.lTelefono.AutoSize = true;
            this.lTelefono.Location = new System.Drawing.Point(147, 81);
            this.lTelefono.Name = "lTelefono";
            this.lTelefono.Size = new System.Drawing.Size(68, 17);
            this.lTelefono.TabIndex = 10;
            this.lTelefono.Text = "Telefono:";
            // 
            // lEdad
            // 
            this.lEdad.AutoSize = true;
            this.lEdad.Location = new System.Drawing.Point(10, 81);
            this.lEdad.Name = "lEdad";
            this.lEdad.Size = new System.Drawing.Size(45, 17);
            this.lEdad.TabIndex = 9;
            this.lEdad.Text = "Edad:";
            // 
            // lDireccion
            // 
            this.lDireccion.AutoSize = true;
            this.lDireccion.Location = new System.Drawing.Point(12, 54);
            this.lDireccion.Name = "lDireccion";
            this.lDireccion.Size = new System.Drawing.Size(71, 17);
            this.lDireccion.TabIndex = 8;
            this.lDireccion.Text = "Dirección:";
            // 
            // lNombre
            // 
            this.lNombre.AutoSize = true;
            this.lNombre.Location = new System.Drawing.Point(246, 26);
            this.lNombre.Name = "lNombre";
            this.lNombre.Size = new System.Drawing.Size(62, 17);
            this.lNombre.TabIndex = 7;
            this.lNombre.Text = "Nombre:";
            // 
            // lDni
            // 
            this.lDni.AutoSize = true;
            this.lDni.Location = new System.Drawing.Point(12, 26);
            this.lDni.Name = "lDni";
            this.lDni.Size = new System.Drawing.Size(33, 17);
            this.lDni.TabIndex = 6;
            this.lDni.Text = "Dni:";
            // 
            // pCrud
            // 
            this.pCrud.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pCrud.Controls.Add(this.btnReset);
            this.pCrud.Controls.Add(this.btnSave);
            this.pCrud.Controls.Add(this.btnRemove);
            this.pCrud.Controls.Add(this.btnMod);
            this.pCrud.Controls.Add(this.btnAdd);
            this.pCrud.Controls.Add(this.datosClientes);
            this.pCrud.Location = new System.Drawing.Point(12, 204);
            this.pCrud.Name = "pCrud";
            this.pCrud.Size = new System.Drawing.Size(776, 234);
            this.pCrud.TabIndex = 7;
            // 
            // btnReset
            // 
            this.btnReset.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.btnReset.AutoEllipsis = true;
            this.btnReset.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.btnReset.Location = new System.Drawing.Point(631, 199);
            this.btnReset.Name = "btnReset";
            this.btnReset.Size = new System.Drawing.Size(131, 30);
            this.btnReset.TabIndex = 5;
            this.btnReset.Text = "Reiniciar";
            this.btnReset.UseVisualStyleBackColor = true;
            // 
            // btnSave
            // 
            this.btnSave.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.btnSave.AutoEllipsis = true;
            this.btnSave.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.btnSave.Location = new System.Drawing.Point(631, 163);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(131, 30);
            this.btnSave.TabIndex = 4;
            this.btnSave.Text = "Guardar";
            this.btnSave.UseVisualStyleBackColor = true;
            // 
            // btnRemove
            // 
            this.btnRemove.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.btnRemove.AutoEllipsis = true;
            this.btnRemove.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.btnRemove.Location = new System.Drawing.Point(631, 93);
            this.btnRemove.Name = "btnRemove";
            this.btnRemove.Size = new System.Drawing.Size(131, 30);
            this.btnRemove.TabIndex = 3;
            this.btnRemove.Text = "Eliminar";
            this.btnRemove.UseVisualStyleBackColor = true;
            // 
            // btnMod
            // 
            this.btnMod.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.btnMod.AutoEllipsis = true;
            this.btnMod.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.btnMod.Location = new System.Drawing.Point(631, 57);
            this.btnMod.Name = "btnMod";
            this.btnMod.Size = new System.Drawing.Size(131, 30);
            this.btnMod.TabIndex = 2;
            this.btnMod.Text = "Modificar";
            this.btnMod.UseVisualStyleBackColor = true;
            // 
            // datosClientes
            // 
            this.datosClientes.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.datosClientes.Location = new System.Drawing.Point(0, 0);
            this.datosClientes.Name = "datosClientes";
            this.datosClientes.RowHeadersWidth = 51;
            this.datosClientes.RowTemplate.Height = 24;
            this.datosClientes.Size = new System.Drawing.Size(610, 226);
            this.datosClientes.TabIndex = 1;
            // 
            // btnAdd
            // 
            this.btnAdd.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.btnAdd.AutoEllipsis = true;
            this.btnAdd.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.btnAdd.Location = new System.Drawing.Point(631, 21);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(131, 30);
            this.btnAdd.TabIndex = 0;
            this.btnAdd.Text = "Añadir";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(9, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(51, 17);
            this.label1.TabIndex = 19;
            this.label1.Text = "Cliente";
            // 
            // textEdad
            // 
            this.textEdad.Location = new System.Drawing.Point(61, 78);
            this.textEdad.Name = "textEdad";
            this.textEdad.Size = new System.Drawing.Size(80, 22);
            this.textEdad.TabIndex = 15;
            // 
            // textTelefono
            // 
            this.textTelefono.Location = new System.Drawing.Point(221, 79);
            this.textTelefono.Name = "textTelefono";
            this.textTelefono.Size = new System.Drawing.Size(207, 22);
            this.textTelefono.TabIndex = 16;
            // 
            // textNumeroCuenta
            // 
            this.textNumeroCuenta.Location = new System.Drawing.Point(147, 107);
            this.textNumeroCuenta.Name = "textNumeroCuenta";
            this.textNumeroCuenta.Size = new System.Drawing.Size(615, 22);
            this.textNumeroCuenta.TabIndex = 17;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.pCrud);
            this.Controls.Add(this.pInputsCliente);
            this.Name = "Form1";
            this.Text = "Form1";
            this.pInputsCliente.ResumeLayout(false);
            this.pInputsCliente.PerformLayout();
            this.pCrud.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.datosClientes)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel pInputsCliente;
        private System.Windows.Forms.Label lNumeroCuenta;
        private System.Windows.Forms.Label lTelefono;
        private System.Windows.Forms.Label lEdad;
        private System.Windows.Forms.Label lDireccion;
        private System.Windows.Forms.Label lNombre;
        private System.Windows.Forms.Label lDni;
        private System.Windows.Forms.TextBox textNombre;
        private System.Windows.Forms.TextBox textDni;
        private System.Windows.Forms.TextBox textDireccion;
        private System.Windows.Forms.Panel pCrud;
        private System.Windows.Forms.Button btnReset;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnRemove;
        private System.Windows.Forms.Button btnMod;
        private System.Windows.Forms.DataGridView datosClientes;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textTelefono;
        private System.Windows.Forms.TextBox textEdad;
        private System.Windows.Forms.TextBox textNumeroCuenta;
    }
}


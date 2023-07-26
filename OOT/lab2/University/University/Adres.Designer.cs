namespace University
{
    partial class Adres
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.FIO = new System.Windows.Forms.Label();
            this.City = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.Index = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.House = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.Flat = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.Street = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // FIO
            // 
            this.FIO.AutoSize = true;
            this.FIO.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.FIO.Location = new System.Drawing.Point(25, 21);
            this.FIO.Name = "FIO";
            this.FIO.Size = new System.Drawing.Size(61, 19);
            this.FIO.TabIndex = 10;
            this.FIO.Text = "Город:";
            // 
            // City
            // 
            this.City.Location = new System.Drawing.Point(25, 43);
            this.City.Name = "City";
            this.City.Size = new System.Drawing.Size(204, 22);
            this.City.TabIndex = 9;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label2.Location = new System.Drawing.Point(25, 85);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(72, 19);
            this.label2.TabIndex = 12;
            this.label2.Text = "Индекс:";
            // 
            // Index
            // 
            this.Index.FormattingEnabled = true;
            this.Index.Items.AddRange(new object[] {
            "001122",
            "112233",
            "224455",
            "443312",
            "231456"});
            this.Index.Location = new System.Drawing.Point(25, 107);
            this.Index.Name = "Index";
            this.Index.Size = new System.Drawing.Size(204, 24);
            this.Index.TabIndex = 11;
            this.Index.Text = "112233";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label1.Location = new System.Drawing.Point(25, 149);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(47, 19);
            this.label1.TabIndex = 14;
            this.label1.Text = "Дом:";
            // 
            // House
            // 
            this.House.Location = new System.Drawing.Point(25, 171);
            this.House.Name = "House";
            this.House.Size = new System.Drawing.Size(204, 22);
            this.House.TabIndex = 13;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label3.Location = new System.Drawing.Point(25, 214);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(87, 19);
            this.label3.TabIndex = 16;
            this.label3.Text = "Квартира:";
            // 
            // Flat
            // 
            this.Flat.Location = new System.Drawing.Point(25, 236);
            this.Flat.Name = "Flat";
            this.Flat.Size = new System.Drawing.Size(204, 22);
            this.Flat.TabIndex = 15;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(22, 321);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(207, 30);
            this.button1.TabIndex = 17;
            this.button1.Text = "Добавить ";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label4.Location = new System.Drawing.Point(25, 270);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(62, 19);
            this.label4.TabIndex = 19;
            this.label4.Text = "Улица:";
            // 
            // Street
            // 
            this.Street.Location = new System.Drawing.Point(22, 293);
            this.Street.Name = "Street";
            this.Street.Size = new System.Drawing.Size(204, 22);
            this.Street.TabIndex = 20;
            // 
            // Adres
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(247, 425);
            this.Controls.Add(this.Street);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.Flat);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.House);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.Index);
            this.Controls.Add(this.FIO);
            this.Controls.Add(this.City);
            this.Name = "Adres";
            this.Text = "Adres";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label FIO;
        private System.Windows.Forms.TextBox City;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox Index;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox House;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox Flat;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox Street;
    }
}
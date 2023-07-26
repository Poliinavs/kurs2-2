namespace University
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.Fio_Text = new System.Windows.Forms.TextBox();
            this.FIO = new System.Windows.Forms.Label();
            this.Women = new System.Windows.Forms.RadioButton();
            this.trackBar1 = new System.Windows.Forms.TrackBar();
            this.label1 = new System.Windows.Forms.Label();
            this.Adge = new System.Windows.Forms.TextBox();
            this.specialty = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.Kurs_number = new System.Windows.Forms.Label();
            this.Group_Number = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.trackBar2 = new System.Windows.Forms.TrackBar();
            this.label5 = new System.Windows.Forms.Label();
            this.Average = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.Men = new System.Windows.Forms.RadioButton();
            this.Check = new System.Windows.Forms.Panel();
            this.Inform = new System.Windows.Forms.TextBox();
            this.Save_Inf = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.dateTimePicker1 = new System.Windows.Forms.DateTimePicker();
            this.button1 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.pictureBox7 = new System.Windows.Forms.PictureBox();
            this.pictureBox6 = new System.Windows.Forms.PictureBox();
            this.pictureBox5 = new System.Windows.Forms.PictureBox();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.Tools = new System.Windows.Forms.Panel();
            ((System.ComponentModel.ISupportInitialize)(this.trackBar1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.trackBar2)).BeginInit();
            this.Check.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox7)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.Tools.SuspendLayout();
            this.SuspendLayout();
            // 
            // Fio_Text
            // 
            this.Fio_Text.Location = new System.Drawing.Point(13, 31);
            this.Fio_Text.Name = "Fio_Text";
            this.Fio_Text.Size = new System.Drawing.Size(204, 22);
            this.Fio_Text.TabIndex = 0;
            this.Fio_Text.TextChanged += new System.EventHandler(this.Fio_Text_TextChanged);
            // 
            // FIO
            // 
            this.FIO.AutoSize = true;
            this.FIO.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.FIO.Location = new System.Drawing.Point(13, 9);
            this.FIO.Name = "FIO";
            this.FIO.Size = new System.Drawing.Size(51, 19);
            this.FIO.TabIndex = 1;
            this.FIO.Text = "ФИО:";
            this.FIO.Click += new System.EventHandler(this.label1_Click);
            // 
            // Women
            // 
            this.Women.AutoSize = true;
            this.Women.Checked = true;
            this.Women.Location = new System.Drawing.Point(1, 1);
            this.Women.Name = "Women";
            this.Women.Size = new System.Drawing.Size(87, 20);
            this.Women.TabIndex = 4;
            this.Women.TabStop = true;
            this.Women.Text = "Женский";
            this.Women.UseVisualStyleBackColor = true;
            // 
            // trackBar1
            // 
            this.trackBar1.Location = new System.Drawing.Point(12, 271);
            this.trackBar1.Maximum = 5;
            this.trackBar1.Minimum = 1;
            this.trackBar1.Name = "trackBar1";
            this.trackBar1.Size = new System.Drawing.Size(104, 56);
            this.trackBar1.TabIndex = 5;
            this.trackBar1.Value = 1;
            this.trackBar1.Scroll += new System.EventHandler(this.trackBar1_Scroll);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label1.Location = new System.Drawing.Point(12, 65);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(75, 19);
            this.label1.TabIndex = 8;
            this.label1.Text = "Возраст:";
            // 
            // Adge
            // 
            this.Adge.Location = new System.Drawing.Point(12, 87);
            this.Adge.Name = "Adge";
            this.Adge.Size = new System.Drawing.Size(204, 22);
            this.Adge.TabIndex = 7;
            this.Adge.Text = "0";
            this.Adge.Enter += new System.EventHandler(this.Adge_Enter);
            this.Adge.Leave += new System.EventHandler(this.Adge_Leave);
            // 
            // specialty
            // 
            this.specialty.FormattingEnabled = true;
            this.specialty.Items.AddRange(new object[] {
            "ПОИТ",
            "КСИС",
            "ДЭВИ",
            "ПОиБМС"});
            this.specialty.Location = new System.Drawing.Point(12, 141);
            this.specialty.Name = "specialty";
            this.specialty.Size = new System.Drawing.Size(204, 24);
            this.specialty.TabIndex = 9;
            this.specialty.Text = "ПОИТ";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label2.Location = new System.Drawing.Point(12, 119);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(134, 19);
            this.label2.TabIndex = 10;
            this.label2.Text = "Специальность:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label3.Location = new System.Drawing.Point(12, 172);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(139, 19);
            this.label3.TabIndex = 11;
            this.label3.Text = "День рождения:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label4.Location = new System.Drawing.Point(12, 249);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(50, 19);
            this.label4.TabIndex = 12;
            this.label4.Text = "Курс:";
            // 
            // Kurs_number
            // 
            this.Kurs_number.AutoSize = true;
            this.Kurs_number.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Kurs_number.Location = new System.Drawing.Point(68, 249);
            this.Kurs_number.Name = "Kurs_number";
            this.Kurs_number.Size = new System.Drawing.Size(18, 19);
            this.Kurs_number.TabIndex = 13;
            this.Kurs_number.Text = "1";
            // 
            // Group_Number
            // 
            this.Group_Number.AutoSize = true;
            this.Group_Number.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Group_Number.Location = new System.Drawing.Point(190, 250);
            this.Group_Number.Name = "Group_Number";
            this.Group_Number.Size = new System.Drawing.Size(18, 19);
            this.Group_Number.TabIndex = 16;
            this.Group_Number.Text = "1";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label6.Location = new System.Drawing.Point(117, 249);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(69, 19);
            this.label6.TabIndex = 15;
            this.label6.Text = "Группа:";
            // 
            // trackBar2
            // 
            this.trackBar2.LargeChange = 8;
            this.trackBar2.Location = new System.Drawing.Point(117, 271);
            this.trackBar2.Maximum = 8;
            this.trackBar2.Minimum = 1;
            this.trackBar2.Name = "trackBar2";
            this.trackBar2.Size = new System.Drawing.Size(104, 56);
            this.trackBar2.TabIndex = 14;
            this.trackBar2.Value = 1;
            this.trackBar2.Scroll += new System.EventHandler(this.trackBar2_Scroll);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label5.Location = new System.Drawing.Point(13, 308);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(125, 19);
            this.label5.TabIndex = 18;
            this.label5.Text = "Средний балл:";
            // 
            // Average
            // 
            this.Average.Location = new System.Drawing.Point(13, 330);
            this.Average.Name = "Average";
            this.Average.Size = new System.Drawing.Size(204, 22);
            this.Average.TabIndex = 17;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft YaHei", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label7.Location = new System.Drawing.Point(13, 361);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(45, 19);
            this.label7.TabIndex = 19;
            this.label7.Text = "Пол:";
            // 
            // Men
            // 
            this.Men.AutoSize = true;
            this.Men.CheckAlign = System.Drawing.ContentAlignment.BottomLeft;
            this.Men.Location = new System.Drawing.Point(1, 27);
            this.Men.Name = "Men";
            this.Men.Size = new System.Drawing.Size(86, 20);
            this.Men.TabIndex = 20;
            this.Men.Text = "Мужской";
            this.Men.UseVisualStyleBackColor = true;
            // 
            // Check
            // 
            this.Check.Controls.Add(this.Men);
            this.Check.Controls.Add(this.Women);
            this.Check.Location = new System.Drawing.Point(11, 382);
            this.Check.Name = "Check";
            this.Check.Size = new System.Drawing.Size(87, 60);
            this.Check.TabIndex = 21;
            // 
            // Inform
            // 
            this.Inform.Location = new System.Drawing.Point(236, 87);
            this.Inform.Multiline = true;
            this.Inform.Name = "Inform";
            this.Inform.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.Inform.Size = new System.Drawing.Size(243, 265);
            this.Inform.TabIndex = 22;
            // 
            // Save_Inf
            // 
            this.Save_Inf.Location = new System.Drawing.Point(236, 50);
            this.Save_Inf.Name = "Save_Inf";
            this.Save_Inf.Size = new System.Drawing.Size(243, 31);
            this.Save_Inf.TabIndex = 23;
            this.Save_Inf.Text = "Сохранить в XML";
            this.Save_Inf.UseVisualStyleBackColor = true;
            this.Save_Inf.Click += new System.EventHandler(this.Save_Inf_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(236, 372);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(243, 31);
            this.button2.TabIndex = 24;
            this.button2.Text = "Вывести информацию";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // dateTimePicker1
            // 
            this.dateTimePicker1.Location = new System.Drawing.Point(13, 209);
            this.dateTimePicker1.Name = "dateTimePicker1";
            this.dateTimePicker1.Size = new System.Drawing.Size(200, 22);
            this.dateTimePicker1.TabIndex = 26;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(236, 4);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(243, 31);
            this.button1.TabIndex = 27;
            this.button1.Text = "Добавить пользователя";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(113, 382);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(117, 59);
            this.button3.TabIndex = 28;
            this.button3.Text = "Добавить адрес";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(237, 411);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(243, 31);
            this.button4.TabIndex = 29;
            this.button4.Text = "Найти информацию";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // pictureBox7
            // 
            this.pictureBox7.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox7.Image = global::University.Properties.Resources._352469_arrow_up_icon;
            this.pictureBox7.Location = new System.Drawing.Point(3, 190);
            this.pictureBox7.Name = "pictureBox7";
            this.pictureBox7.Size = new System.Drawing.Size(56, 31);
            this.pictureBox7.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox7.TabIndex = 36;
            this.pictureBox7.TabStop = false;
            this.pictureBox7.Click += new System.EventHandler(this.pictureBox7_Click);
            // 
            // pictureBox6
            // 
            this.pictureBox6.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox6.Image = global::University.Properties.Resources._352466_arrow_down_icon;
            this.pictureBox6.Location = new System.Drawing.Point(4, 153);
            this.pictureBox6.Name = "pictureBox6";
            this.pictureBox6.Size = new System.Drawing.Size(56, 31);
            this.pictureBox6.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox6.TabIndex = 35;
            this.pictureBox6.TabStop = false;
            this.pictureBox6.Click += new System.EventHandler(this.pictureBox6_Click);
            // 
            // pictureBox5
            // 
            this.pictureBox5.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox5.Image = global::University.Properties.Resources._4200550_delet_delete_cut_del_eddit_icon;
            this.pictureBox5.Location = new System.Drawing.Point(3, 116);
            this.pictureBox5.Name = "pictureBox5";
            this.pictureBox5.Size = new System.Drawing.Size(56, 31);
            this.pictureBox5.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox5.TabIndex = 34;
            this.pictureBox5.TabStop = false;
            this.pictureBox5.Click += new System.EventHandler(this.pictureBox5_Click);
            // 
            // pictureBox4
            // 
            this.pictureBox4.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox4.Image = global::University.Properties.Resources._8665134_broom_clean_cleaning_icon;
            this.pictureBox4.Location = new System.Drawing.Point(3, 79);
            this.pictureBox4.Name = "pictureBox4";
            this.pictureBox4.Size = new System.Drawing.Size(56, 31);
            this.pictureBox4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox4.TabIndex = 33;
            this.pictureBox4.TabStop = false;
            this.pictureBox4.Click += new System.EventHandler(this.pictureBox4_Click);
            // 
            // pictureBox3
            // 
            this.pictureBox3.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox3.Image = global::University.Properties.Resources._8542027_filter_funnel_sort_icon;
            this.pictureBox3.Location = new System.Drawing.Point(3, 42);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(56, 31);
            this.pictureBox3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox3.TabIndex = 32;
            this.pictureBox3.TabStop = false;
            this.pictureBox3.Click += new System.EventHandler(this.pictureBox3_Click);
            // 
            // pictureBox2
            // 
            this.pictureBox2.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox2.Image = global::University.Properties.Resources._115695_magnifying_glass_zoom_find_search_icon;
            this.pictureBox2.Location = new System.Drawing.Point(4, 5);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(56, 31);
            this.pictureBox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox2.TabIndex = 31;
            this.pictureBox2.TabStop = false;
            this.pictureBox2.Click += new System.EventHandler(this.pictureBox2_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox1.Image = global::University.Properties.Resources._753919_tools_working_options_preferences_settings_icon;
            this.pictureBox1.Location = new System.Drawing.Point(485, 4);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(56, 31);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 30;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // Tools
            // 
            this.Tools.Controls.Add(this.pictureBox7);
            this.Tools.Controls.Add(this.pictureBox6);
            this.Tools.Controls.Add(this.pictureBox5);
            this.Tools.Controls.Add(this.pictureBox4);
            this.Tools.Controls.Add(this.pictureBox3);
            this.Tools.Controls.Add(this.pictureBox2);
            this.Tools.Location = new System.Drawing.Point(481, 45);
            this.Tools.Name = "Tools";
            this.Tools.Size = new System.Drawing.Size(68, 226);
            this.Tools.TabIndex = 37;
            this.Tools.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.ClientSize = new System.Drawing.Size(552, 455);
            this.Controls.Add(this.Tools);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.button4);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.dateTimePicker1);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.Save_Inf);
            this.Controls.Add(this.Inform);
            this.Controls.Add(this.Check);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.Average);
            this.Controls.Add(this.Group_Number);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.trackBar2);
            this.Controls.Add(this.Kurs_number);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.specialty);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.Adge);
            this.Controls.Add(this.trackBar1);
            this.Controls.Add(this.FIO);
            this.Controls.Add(this.Fio_Text);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.trackBar1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.trackBar2)).EndInit();
            this.Check.ResumeLayout(false);
            this.Check.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox7)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.Tools.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox Fio_Text;
        private System.Windows.Forms.Label FIO;
        private System.Windows.Forms.RadioButton Women;
        private System.Windows.Forms.TrackBar trackBar1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox Adge;
        private System.Windows.Forms.ComboBox specialty;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label Kurs_number;
        private System.Windows.Forms.Label Group_Number;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TrackBar trackBar2;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox Average;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.RadioButton Men;
        private System.Windows.Forms.Panel Check;
        private System.Windows.Forms.TextBox Inform;
        private System.Windows.Forms.Button Save_Inf;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.DateTimePicker dateTimePicker1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.PictureBox pictureBox5;
        private System.Windows.Forms.PictureBox pictureBox6;
        private System.Windows.Forms.PictureBox pictureBox7;
        private System.Windows.Forms.Panel Tools;
    }
}


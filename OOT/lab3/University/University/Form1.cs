﻿using System;
using System.Xml.Serialization;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Button;
using System.IO;
using System.ComponentModel.DataAnnotations;

namespace University
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            Kurs_number.Text = trackBar1.Value.ToString();
        }

        private void trackBar2_Scroll(object sender, EventArgs e)
        {
            Group_Number.Text = trackBar2.Value.ToString();
        }

        private void Adge_Enter(object sender, EventArgs e)
        {
            if (Adge.Text == "0")
            {
                Adge.ForeColor = Color.Black;
                Adge.Text = "";//при нажатии на поле, текст исчезает
            }
        }

        private void Adge_Leave(object sender, EventArgs e)
        {
            if (Adge.Text == "")//если ничего не ввели и покинули поле значение по умолчанию
            {
                Adge.Text = "0";
                Adge.ForeColor = Color.Gray;
            }
        }
      
        private void Save_Inf_Click(object sender, EventArgs e) //серриализуем данные
        {
            XmlSerializer xmlSerializer = new XmlSerializer(typeof(University));
            StreamWriter sw = new StreamWriter(@"University.xml", true);
           
                xmlSerializer.Serialize(sw, University.un1);
                sw.Close();
           
        }

        private void button1_Click(object sender, EventArgs e) //добавляем пользователя
        {
            Student st1 = new Student();

                st1.Fio = Fio_Text.Text;
            Fio_Text.Text = "";
                st1.Average = Convert.ToInt32(Average.Text);
            Average.Text= "";
            if (st1.Average>10 || st1.Average<0)
            {
                throw new Exception("Несуществующий средний балл");
            }
    
            st1.Specialty = specialty.Text;
            specialty.Text = "";
            if (Women.Checked == true)
            {
                st1.Gender = "Женский";
            }
            else
                st1.Gender = "Мужской";
            st1.Data = dateTimePicker1.Text;

            st1.Age = Convert.ToInt32(Adge.Text);
            Adge.Text = "0";
            st1.Course = Convert.ToInt32(Kurs_number.Text);
            Kurs_number.Text= "1";
            st1.Group = Convert.ToInt32(Group_Number.Text);
            University.un1.AddStudent(st1);

            var results = new List<ValidationResult>();
            var context = new ValidationContext(st1);
            if (!Validator.TryValidateObject(st1, context, results, true))
            {
                foreach (var error in results)
                {
                    MessageBox.Show(error.ErrorMessage);

                }
                return;
            }


        }

        private void button2_Click(object sender, EventArgs e) //дессерелизация 
        {
            XmlSerializer xmlSerializer = new XmlSerializer(typeof(University));

            // десериализуем объект
           

            using (FileStream fs = new FileStream("University.xml", FileMode.OpenOrCreate))
            {
                University un2 = xmlSerializer.Deserialize(fs) as University;
          
                foreach(var st2 in un2.Students)
                {
                    Inform.Text += st2.ToString();
                    Inform.Text += Environment.NewLine;
                    Inform.Text += "-----------------------------------";
                    Inform.Text += Environment.NewLine;
                    //MessageBox.Show(st2.ToString());
                }
                foreach (var st2 in un2.Adres)
                {
                    Inform.Text += st2.ToString();
                    Inform.Text += Environment.NewLine;
                    Inform.Text += "-----------------------------------";
                    Inform.Text += Environment.NewLine;
                    //MessageBox.Show(st2.ToString());
                }

            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
          


            this.Hide();//прячем текущее окно 
            Adres regester = new Adres();
            regester.Show();
        }

        private void button4_Click(object sender, EventArgs e) //перейти на поиск 
        {
            XmlSerializer xmlSerializer = new XmlSerializer(typeof(University));
            using (FileStream fs = new FileStream("University.xml", FileMode.OpenOrCreate))
            {
                University.un1 = xmlSerializer.Deserialize(fs) as University;
            }
            this.Hide();//прячем текущее окно 
            FInd regester = new FInd();
            regester.Show();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            if (Tools.Visible)
            Tools.Visible = false;
            else Tools.Visible = true;
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            XmlSerializer xmlSerializer = new XmlSerializer(typeof(University));
            using (FileStream fs = new FileStream("University.xml", FileMode.OpenOrCreate))
            {
                University.un1 = xmlSerializer.Deserialize(fs) as University;
            }
            this.Hide();//прячем текущее окно 
            FInd regester = new FInd();
            regester.Show();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            XmlSerializer xmlSerializer = new XmlSerializer(typeof(University));
            using (FileStream fs = new FileStream("University.xml", FileMode.OpenOrCreate))
            {
                University.un1 = xmlSerializer.Deserialize(fs) as University;
            }
            this.Hide();//прячем текущее окно 
            FInd regester = new FInd();
            regester.Show();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            Inform.Text = string.Empty;
        }

        private void pictureBox5_Click(object sender, EventArgs e)
        {
            Inform.Text = string.Empty;
            University.un1 = new University();
            StreamWriter sw = new StreamWriter(@"University.xml", true);
            sw.Write(string.Empty);
            sw.Close();
        }

        private void pictureBox6_Click(object sender, EventArgs e)
        {
            this.Hide();//прячем текущее окно 
            FInd regester = new FInd();
            regester.Show();
        }

        private void pictureBox7_Click(object sender, EventArgs e)
        {
            this.Hide();//прячем текущее окно 
            Adres regester = new Adres();
            regester.Show();
        }

        private void Fio_Text_TextChanged(object sender, EventArgs e)
        {

        }
    }
}

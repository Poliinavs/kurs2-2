using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Timers;
using System.Windows.Forms;
using System.Xml.Serialization;
using static System.Net.Mime.MediaTypeNames;
using static System.Windows.Forms.LinkLabel;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using System.Timers;
namespace University
{

    public partial class FInd : Form
    {
       public AutoCompleteStringCollection source = new AutoCompleteStringCollection();
        ToolStripLabel dateLabel;
        ToolStripLabel timeLabel;
        ToolStripLabel infoLabel;
        // private static System.Timers.Timer timer;
        static System.Windows.Forms.Timer timer = new System.Windows.Forms.Timer() { Interval = 1000 };
        public FInd()
        {
            InitializeComponent();
            infoLabel = new ToolStripLabel();
            infoLabel.Text = "Текущие дата и время:";
            /*infoLabel = new ToolStripLabel();
            infoLabel3.Text = "Текущие дата и время:";*/

            dateLabel = new ToolStripLabel();
            timeLabel = new ToolStripLabel();

            statusStrip1.Items.Add(infoLabel);
            statusStrip1.Items.Add(dateLabel);
            statusStrip1.Items.Add(timeLabel);
            //statusStrip3.StatusLabel

           // timer = new System.Timers.Timer(1000) ;
            timer.Tick += timer_Tick;
            timer.Start();

            /////////
            /*    Student st1= new Student();
                st1.Fio = "Иванов Иван Иванович";
                st1.Average = 2;
                st1.Course = 3;
                st1.Data = "12.12.1999";
                st1.Group = 4;
                st1.Specialty = "Информатика";
                University.un1.AddStudent(st1);
                Student st2 = new Student();
                st2.Fio = "Петров Петр Петрович";
                st2.Average = 8;
                st2.Course = 4;
                st2.Data = "12.12.1998";
                st2.Group = 3;
                st2.Specialty = "Информатика";
                University.un1.AddStudent(st2);
                Student st3 = new Student();
                st3.Fio = "Сидоров Сидор Сидорович";
                st3.Average = 7;
                st3.Course = 5;
                st3.Data = "12.12.1997";
                st3.Group = 5;
                st3.Specialty = "Информатика";
                University.un1.AddStudent(st3);*/
            ///////
            // Thread devthread = new Thread(() => RWDeviceState());
            // devthread.Start();
            foreach (var item in University.un1.Students)
            {
                source.Add(item.Fio);
            }
            textBox1.AutoCompleteCustomSource = source;
            label5.Text = University.un1.Students.Count().ToString();


        }
      

        private void What_Find_SelectedIndexChanged(object sender, EventArgs e) //меняется специальность
        {
            
            var t = What_Find.Text;
            toolStripStatusLabel2.Text =t;
            if (t == "ФИО")
            {
                source.Clear();
                foreach (var item in University.un1.Students)
                {
                    source.Add(item.Fio);
                }
            }
            if (t == "Специальность")
            {
                source.Clear();
                foreach (var item in University.un1.Students)
                {
                    source.Add(item.Specialty);
                }
            }
            if (t == "Курс")
            {
                source.Clear();
                foreach (var item in University.un1.Students)
                {
                    source.Add(item.Course.ToString());
                }
            }
            if (t == "Средний балл")
            {
                source.Clear();
                foreach (var item in University.un1.Students)
                {
                    source.Add(item.Average.ToString());
                }
            }
           
                textBox1.AutoCompleteCustomSource = source;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)//
        {
            toolStripStatusLabel2.Text = "Сортировка";
        }

        private void Get_Information_Click(object sender, EventArgs e)
        {
            toolStripStatusLabel2.Text = "Вывод";
            Inform.Text="";
            XmlSerializer xmlSerializer = new XmlSerializer(typeof(Student));
            StreamWriter sw = new StreamWriter(@"Sort.xml", true);

            var LinQ1 = from s in University.un1.Students
                    orderby s.Group
                    select s;
            if (Sort.Text== "Курсу") {  //сортировать по группе
                                         // University.un1.Students.OrderBy(n.Group => n);
                LinQ1 = from s in University.un1.Students
                            orderby s.Course
                            select s;

            }

            foreach(var un in LinQ1)
            {
                if (un.Fio== textBox1.Text|| un.Specialty == textBox1.Text || un.Course.ToString() == textBox1.Text )
                {
                    Inform.Text += un.ToString();
                    Inform.Text += Environment.NewLine;
                    Inform.Text += "-----------------------------------";
                    Inform.Text += Environment.NewLine;
                    xmlSerializer.Serialize(sw, un);
                }
                var numericValue=0;
                if (int.TryParse(textBox1.Text, out numericValue))
                {
                    if (numericValue < un.Average)
                    {
                        Inform.Text += un.ToString();
                        Inform.Text += Environment.NewLine;
                        Inform.Text += "-----------------------------------";
                        Inform.Text += Environment.NewLine;
                        xmlSerializer.Serialize(sw, un);
                    }

                }
            }
          

            sw.Close();
        }

        private void label3_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Авсюкевич Полина; Version 1.2");
        }
        void timer_Tick(object sender, EventArgs e)
        {
            dateLabel.Text = DateTime.Now.ToLongDateString();
            timeLabel.Text = DateTime.Now.ToLongTimeString();
        }















        /* public Timer timer = new Timer();


         //-----------------------------------------
         void timer_Tick(object sender, EventArgs e)
         {
             timer.Interval = 5000;
             timer.Enabled = true;
             timer.Tick += new EventHandler(timer_Tick);
             label6.Text = DateTime.Now.ToShortDateString() + ", " + DateTime.Now.ToLongTimeString();
         }*/

        private void label6_TextChanged(object sender, EventArgs e)
        {
            //label6.Text = DateTime.Now.ToShortDateString() + ", " + DateTime.Now.ToLongTimeString();
        

    }

        private void FInd_Load(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            toolStripStatusLabel2.Text = "Поиск";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();//прячем текущее окно 
            Form1 regester = new Form1();
            regester.Show();
        }
    }
}

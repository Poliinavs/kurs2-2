using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace calculator
{
    public partial class Form1 : Form
    {
        public string operation = null;
        public string number1 = "";
        public double? res = null;
        public bool Begin_count = false;
        public Form1()
        {
            InitializeComponent();
        }


        Point lastPoint;
        private void panel1_MouseMove_1(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                this.Left += e.X - lastPoint.X; //где находится мышь - насколько переместили
                this.Top += e.Y - lastPoint.Y;
            }
        }

        private void panel1_MouseDown_1(object sender, MouseEventArgs e)
        {
            lastPoint = new Point(e.X, e.Y);
        }

        private void button13_Click(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            if (Number_Box.Text == "0" || Begin_count)
            {
                Number_Box.Text = button.Text;
                Begin_count = false;
            }
            else
                Number_Box.Text += button.Text;
            if (operation != null)
            {
                if (res == null)
                {

                    count_result(double.Parse(number1), Number_Box.Text);
                }

                else
                    count_result(res, Number_Box.Text);
            }
        }
     
        private void button19_Click(object sender, EventArgs e)
        {
          
                if (Number_Box.Text == "0")
                {
                    throw new Exception("Поле не требует очистки");
                }
                Number_Box.Text = "0";
        }
   
        private void button_Operations(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            operation = button.Text; //запомианем операцию
            if (double.TryParse(Number_Box.Text, out var number))
                number1 = Number_Box.Text;
            else
                throw new Exception("Ввод некорректных данных");

            Begin_count = true;
          
        }
        
        private void equal_Click(object sender, EventArgs e)
        {
            Number_Box.Text = res.ToString();
            res = null;
            operation= null;
        }

        private void button18_Click(object sender, EventArgs e)
        {
            if (Number_Box.Text == "0")
            {
                throw new Exception("Поле не требует очистки");
            }
            Number_Box.Text = "0";
            res = null;
        }


    }
}

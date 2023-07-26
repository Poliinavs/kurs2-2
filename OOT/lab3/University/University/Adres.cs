using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.Remoting.Contexts;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace University
{
    public partial class Adres : Form
    {
        public Adres()
        {
            InitializeComponent();
        }

        public University un2= new University();
        private void button1_Click(object sender, EventArgs e)//добавление адреса
        {
            Adres_class adres= new Adres_class();
            adres.Index = Convert.ToInt32(Index.Text);
            adres.City = City.Text;
            adres.Street = Street.Text;
            adres.House = Convert.ToInt32(House.Text);
            adres.Flat = Convert.ToInt32(Flat.Text);
            University.un1.AddAdres(adres);

          
            var results = new List<ValidationResult>();
            var context = new ValidationContext(adres);
            if (!Validator.TryValidateObject(adres, context, results, true))
            {
                foreach (var error in results)
                {
                    MessageBox.Show(error.ErrorMessage);
                  
                }
                return;
            }



            this.Hide();//прячем текущее окно 
            Form1 regester = new Form1();
            regester.Show();
        }
    }
}

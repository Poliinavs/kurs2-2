using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Resources;
using System.Windows.Shapes;
using Application = System.Windows.Application;
using Cursor = System.Windows.Input.Cursor;

namespace laba
{
    /// <summary>
    /// Логика взаимодействия для Products.xaml
    /// </summary>
    public partial class Products : Window
    {
        public AutoCompleteStringCollection source = new AutoCompleteStringCollection();
        System.Windows.Forms.Cursor Fair;
        static Cursor C1 = new Cursor(Application.GetResourceStream(new Uri("cursor.cur", UriKind.Relative)).Stream);
        public Products()
        {
            InitializeComponent();
            Img1.Cursor = C1;
            Img2.Cursor = C1;
            Img3.Cursor = C1;
            Img4.Cursor = C1;
            Img5.Cursor = C1;
            Img6.Cursor = C1;
            Img7.Cursor = C1;
            Img9.Cursor = C1;
            Img8.Cursor = C1;


        }
        void OnComboboxTextChanged(object sender, RoutedEventArgs e)
        {
           
        }
        private void Sort(object sender, RoutedEventArgs e)
        {
            foreach (var a in main_aliments.Children.OfType<Canvas>())
            {

                if (a.Name.IndexOf("malbert") > -1)
                {
                    a.Visibility = Visibility.Visible;
                    // MessageBox.Show("Слово найдено");
                }
                else
                    a.Visibility= Visibility.Collapsed;
            }
        }

        private void scetchBook(object sender, RoutedEventArgs e)
        {
            foreach (var a in main_aliments.Children.OfType<Canvas>())
            {

                if (a.Name.IndexOf("scetch") > -1)
                {
                    a.Visibility = Visibility.Visible;
                    // MessageBox.Show("Слово найдено");
                }
                else
                    a.Visibility = Visibility.Collapsed;
            }
        }

        private void Marker(object sender, RoutedEventArgs e)
        {
            foreach (var a in main_aliments.Children.OfType<Canvas>())
            {

                if (a.Name.IndexOf("marker") > -1)
                {
                    a.Visibility = Visibility.Visible;
                    // MessageBox.Show("Слово найдено");
                }
                else
                    a.Visibility = Visibility.Collapsed;
            }
        }

        private void Brash(object sender, RoutedEventArgs e)
        {
            foreach (var a in main_aliments.Children.OfType<Canvas>())
            {

                if (a.Name.IndexOf("Brush") > -1)
                {
                    a.Visibility = Visibility.Visible;
                    // MessageBox.Show("Слово найдено");
                }
                else
                    a.Visibility = Visibility.Collapsed;
            }
        }

        private void All(object sender, RoutedEventArgs e)
        {
            foreach (var a in main_aliments.Children.OfType<Canvas>())
            {

                    a.Visibility = Visibility.Visible;
                    // MessageBox.Show("Слово найдено");
               
            }

        }

        private void Add(object sender, RoutedEventArgs e)
        {
            int a = Convert.ToInt32(Amount1.Content);
            a++; 
            Amount1.Content = a.ToString();
           
        }

        private void Del(object sender, RoutedEventArgs e)
        {
            int a = Convert.ToInt32(Amount1.Content);
            if (a == 0)
            {
                System.Windows.MessageBox.Show("Нет элементов для удаления");
            }
            else
            {
                a--;
                Amount1.Content = a.ToString();
               
            }
        }

      /*  private void Find(object sender, SelectionChangedEventArgs e)
        {
           string find= Find_prod.Text;

        }*/

        private void Find_sm(object sender, TextChangedEventArgs e)
        {
            bool b1 = false;
            string find = Find.Text;
            if (find!="Введите название")
            {
                foreach (var a in main_aliments.Children.OfType<Canvas>())
                {

                    foreach (var b in a.Children.OfType<StackPanel>())
                    {
                        foreach (var c in b.Children.OfType<TextBlock>())
                        {
                            if (c.Name.IndexOf(find) > -1)
                            {
                                a.Visibility = Visibility.Visible;
                                b1= true;
                           
                            }
                            else
                            {
                                if(!b1)
                                a.Visibility = Visibility.Collapsed; }
                            //System.Windows.MessageBox.Show(c.Name); //Kind1
                        }



                    }
                    b1 = false;
                }
            }
           

        }

        private void Find_MouseDown(object sender, MouseButtonEventArgs e)
        {
            Find.Text = "";
        }

        private void Find_MouseEnter(object sender, System.Windows.Input.MouseEventArgs e)
        {
            Find.Text = "";
        }

     

        private void Price_Sort(object sender, RoutedEventArgs e)
        {
            int[] mas= new int[9] ;
            SortedList ls = new SortedList();
            int i = 0;
            foreach (var a in main_aliments.Children.OfType<Canvas>())
            {
                
                 foreach (var c in a.Children.OfType<TextBlock>())
                      {
                    if (c.Name.IndexOf("Price") > -1)
                    {
                        if(Convert.ToInt32(c.Text)< Convert.ToInt32(Begin.Text) || Convert.ToInt32(c.Text) > Convert.ToInt32(End.Text))
                            a.Visibility = Visibility.Collapsed;

                    }
                    
                   // System.Windows.MessageBox.Show(c.Name); //Price

                }

                }
         
         
           


        }

        private void End1(object sender, System.Windows.Input.MouseEventArgs e)
        {
            End.Text = "";
        }

        private void Begin1(object sender, System.Windows.Input.MouseEventArgs e)
        {
            Begin.Text = "";
        }

        private void Enter(object sender, MouseButtonEventArgs e)
        {
            this.Hide();//прячем текущее окно 
            Personal_Product regester = new Personal_Product();
            regester.Show();
        }

        private void Curs(object sender, System.Windows.Input.MouseEventArgs e)
        {
      
        }

        private void Change(object sender, System.Windows.Input.MouseEventArgs e)
        {
            string ColorA = "#ADD8E6";
            this.Resources["buttonBackColor"] = new SolidColorBrush((Color)ColorConverter.ConvertFromString(ColorA));

        }

        private void Leave(object sender, System.Windows.Input.MouseEventArgs e)
        {
            string ColorA = "#FF88BEEE";
            this.Resources["buttonBackColor"] = new SolidColorBrush((Color)ColorConverter.ConvertFromString(ColorA));
        }
    }
}

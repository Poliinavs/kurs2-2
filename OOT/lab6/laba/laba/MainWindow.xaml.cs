using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace laba
{
    /// <summary>
    /// Логика взаимодействия для MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        
        public MainWindow()
        {
            InitializeComponent();
       
        }

        private void Add_Basket(object sender, RoutedEventArgs e)
        {
            int a = Convert.ToInt32(Amount.Content);
            a++;
            Amount.Content = a.ToString();
        }

        private void Del_Basket(object sender, RoutedEventArgs e)
        {
            int a = Convert.ToInt32(Amount.Content);
            if (a == 0)
            {
                MessageBox.Show("Нет элементов для очистки");
                return;
            }

            a--;
            Amount.Content = a.ToString();
        }
    }
}

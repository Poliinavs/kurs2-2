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
using System.Windows.Shapes;

namespace lb8
{
    /// <summary>
    /// Логика взаимодействия для Information.xaml
    /// </summary>
    public partial class Information : Window
    {
        private UserInform currentAuth = new UserInform();
        public int currentId = 0;
        public UserInformRepository repositor = new UserInformRepository();
        public Information()
        {
            InitializeComponent();
            DataContext = currentAuth;
        }
        public Information(int currentId)
        {
            InitializeComponent();
            DataContext = currentAuth;
            this.currentId= currentId;
        }
        private void BtnSave_Click(object sender, RoutedEventArgs e)
        {


            StringBuilder errors = new StringBuilder();
            if (string.IsNullOrWhiteSpace(currentAuth.nickname))
                errors.AppendLine("Укажите ваше nickname");
            if (currentAuth.inform.Length <= 0 )
                errors.AppendLine("Введите информацию");
        
            if (errors.Length > 0)
            {
                MessageBox.Show(errors.ToString());
                return;
            }

            UserInformUnitOfWorkFactory us = new UserInformUnitOfWorkFactory();
            us.CreateUnitOfWork();
            currentAuth.id = currentId;
            repositor.AddCustomer(currentAuth);

         


            try
            {
             
                MessageBox.Show("Информация умпешно сохранена");
                this.Hide();//прячем текущее окно
                MainWindow mn = new MainWindow();
                mn.Show();
            }
            catch (Exception ex)
            {

            }

        }

        private void Btn_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Информация сохранена");
          
            this.Hide();//прячем текущее окно
            MainWindow mn = new MainWindow();
            mn.Show();
        }
    }
}

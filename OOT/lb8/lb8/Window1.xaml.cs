using System;
using System.Collections;
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
    /// Логика взаимодействия для Window1.xaml
    /// </summary>
    public partial class Window1 : Window
    {
        private UserAuth currentAuth= new UserAuth();
        public int LastId=0;
        public Repository<UserAuth> repositor = new Repository<UserAuth>(OOTEntities.GetContext());
        public Window1(UserAuth usr) //UserAuth usr
        {
            InitializeComponent();
            if (usr != null)
            {
                currentAuth = usr;
            }
            DataContext = currentAuth;

            

        }
        public Window1() 
        {
            InitializeComponent();
          
            DataContext = currentAuth;
           
            
        }


        private void BtnSave_Click(object sender, RoutedEventArgs e)
        {
            UserAuth old=null;
           if (MainWindow.red)
            {
                 old= currentAuth ;
               }
             StringBuilder errors = new StringBuilder();
            if (string.IsNullOrWhiteSpace(currentAuth.name))
                errors.AppendLine("Укажите ваше имя");
            if (currentAuth.height<0 || currentAuth.height>300)
                errors.AppendLine("Укажите верный рост");
            if (currentAuth.age < 0 || currentAuth.age > 100)
                errors.AppendLine("Укажите верный возраст");
            if (currentAuth.age < 0 || currentAuth.age > 300)
                errors.AppendLine("Укажите верный вес");
            if (errors.Length>0)
            {
                MessageBox.Show(errors.ToString());
                return;
            }
            if (!MainWindow.red)
            {
                var a = OOTEntities.GetContext().UserAuth.ToList();
                int currentId = 1;
                bool takeId = false;
                foreach (var b in a)
                {
                    if (currentId != b.id)
                    {
                        currentAuth.id = currentId;
                        takeId = true;
                    }
                    currentId++;
                }
                if (!takeId)
                {
                    currentAuth.id = currentId++;
                }
               
            }
            else
            {
                repositor.Del(old);
              /*  OOTEntities.GetContext().UserAuth.Remove(old);
                OOTEntities.GetContext().SaveChanges();*/
                
             
                MainWindow.red = false;
            }
            // OOTEntities.GetContext().UserAuth.Add(currentAuth);
            repositor.Add(currentAuth);
            try {
              //  OOTEntities.GetContext().SaveChanges();
                MessageBox.Show("Информация уcпешно сохранена");
                this.Hide();//прячем текущее окно
                MainWindow mn = new MainWindow();
                mn.Show();
            }
            catch (Exception ex)
            {

            }
           
        }

        private void BtnReg_Click(object sender, RoutedEventArgs e)
        {
            int id = currentAuth.id;
            this.Hide();//прячем текущее окно
            Information mn = new Information(id);
            mn.Show();

        }
    }
}

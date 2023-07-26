using lb8;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace lb8
{
    /// <summary>
    /// Логика взаимодействия для MainWindow.xaml
    public partial class MainWindow : Window
    {
        public static bool red = false;
        public Repository<UserAuth> repositor;
        public MainWindow()
        {
            InitializeComponent();
            DGridAuth.ItemsSource = OOTEntities.GetContext().UserAuth.ToList();
            //
        
            repositor = new Repository<UserAuth>(OOTEntities.GetContext());
           

        }

        private void BtnAdd_Click(object sender, RoutedEventArgs e)
        {

            this.Hide();//прячем текущее окно
            Window1 mn = new Window1();
            mn.Show();

        }
        private void Page_IsVisibleChanged(object sender, DependencyPropertyChangedEventArgs e)
        {
            if (Visibility == Visibility.Visible)
            {
                OOTEntities.GetContext().ChangeTracker.Entries().ToList().ForEach(p => p.Reload());
                DGridAuth.ItemsSource = OOTEntities.GetContext().UserAuth.ToList();
            }

        }

        private void BtnDel_Click(object sender, RoutedEventArgs e)
        {
            var UserRemove = DGridAuth.SelectedItems.Cast<UserAuth>().ToList();
            MessageBox.Show("Данные удалены");
            DGridAuth.ItemsSource = repositor.Delete(UserRemove);
        }

        private void BtnEdit_Click(object sender, RoutedEventArgs e)
        {
            red = true;
            this.Hide();//прячем текущее окно
            Window1 mn = new Window1((sender as Button).DataContext as UserAuth);
            mn.Show();

        }

        private void Sort_Click(object sender, RoutedEventArgs e)
        {
         
            DGridAuth.ItemsSource = repositor.Sort();
          

        }

        private void Btn1_Click(object sender, RoutedEventArgs e)
        {

            repositor.GetById(1);
            MessageBox.Show(repositor.GetById(1).name);
        }

        private void tranzact(object sender, RoutedEventArgs e)
        {
            SqlConnection connection = new SqlConnection("Data Source=WIN11-MSSQL\\SQLEXPRESS;Initial Catalog=OOT;Integrated Security=True");
            connection.Open();
            SqlTransaction transaction = connection.BeginTransaction();

            SqlCommand command = connection.CreateCommand();
            command.Transaction = transaction;

            try
            {
                // выполняем две отдельные команды
                command.CommandText = "INSERT INTO UserAuth (name, age, weight, height, id) VALUES('Tim', 34, 60, 180,10)";
                command.ExecuteNonQuery();
                command.CommandText = "INSERT INTO UserAuth (name, age, weight, height, id) VALUES('Dima', 34, 70, 180,11)";
                command.ExecuteNonQuery();

                transaction.Commit();
                Console.WriteLine("Данные добавлены в базу данных");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                transaction.Rollback();
            }
            Console.WriteLine("Данные добавлены в базу данных");
            OOTEntities.GetContext().ChangeTracker.Entries().ToList().ForEach(p => p.Reload());
            DGridAuth.ItemsSource = OOTEntities.GetContext().UserAuth.ToList();
            connection.Close();
        }
    }
    //public partial class MainWindow : Window
    //{
    //    public static bool red=false;
    //    public MainWindow()
    //    {
    //        InitializeComponent();
    //         DGridAuth.ItemsSource = OOTEntities.GetContext().UserAuth.ToList();
    //    }

    //    private void BtnAdd_Click(object sender, RoutedEventArgs e)
    //    {

    //        this.Hide();//прячем текущее окно
    //        Window1 mn = new Window1();
    //        mn.Show();

    //    }
    //    private void Page_IsVisibleChanged(object sender, DependencyPropertyChangedEventArgs e)
    //    {
    //        if (Visibility==Visibility.Visible)
    //        {
    //            OOTEntities.GetContext().ChangeTracker.Entries().ToList().ForEach(p => p.Reload());
    //            DGridAuth.ItemsSource= OOTEntities.GetContext().UserAuth.ToList();
    //        }

    //    }

    //    private void BtnDel_Click(object sender, RoutedEventArgs e)
    //    {
    //        var UserRemove = DGridAuth.SelectedItems.Cast<UserAuth>().ToList();
    //        OOTEntities.GetContext().UserAuth.RemoveRange(UserRemove);
    //        OOTEntities.GetContext().SaveChanges();
    //        MessageBox.Show("Данные удалены");
    //        DGridAuth.ItemsSource = OOTEntities.GetContext().UserAuth.ToList();
    //    }

    //    private void BtnEdit_Click(object sender, RoutedEventArgs e)
    //    {
    //        red = true;
    //        this.Hide();//прячем текущее окно
    //        Window1 mn = new Window1((sender as Button).DataContext as UserAuth);
    //        mn.Show();

    //    }

    //    private void Sort_Click(object sender, RoutedEventArgs e)
    //    {
    //       var obj= OOTEntities.GetContext().UserAuth.ToList();


    //        var sortedPeople1 = from p in obj
    //                            orderby p.name
    //                            select p;
    //        DGridAuth.ItemsSource= sortedPeople1;
    //        OOTEntities.GetContext().SaveChanges();

    //    }

    //    private void Btn1_Click(object sender, RoutedEventArgs e)
    //    {
    //        SqlConnection connection = new SqlConnection("Data Source=WIN11-MSSQL\\SQLEXPRESS;Initial Catalog=OOT;Integrated Security=True");
    //        //  string query = "SELECT id FROM UserAuth WHERE height > 100";
    //        string query = "SELECT id FROM UserAuth WHERE name = @name";
    //        SqlCommand command = new SqlCommand(query, connection);
    //        command.Parameters.Add(new SqlParameter("@name", "Daria"));
    //        connection.Open();
    //        SqlDataReader reader = command.ExecuteReader();
    //        while (reader.Read())
    //        {
    //            // MessageBox.Show(reader);
    //            int id = (int)reader["id"];
    //            MessageBox.Show(id.ToString());
    //        }

    //        reader.Close();
    //        connection.Close();

    //    }

    //    private void tranzact(object sender, RoutedEventArgs e)
    //    {
    //        SqlConnection connection = new SqlConnection("Data Source=WIN11-MSSQL\\SQLEXPRESS;Initial Catalog=OOT;Integrated Security=True");
    //        connection.Open();
    //        SqlTransaction transaction = connection.BeginTransaction();

    //        SqlCommand command = connection.CreateCommand();
    //        command.Transaction = transaction;

    //        try
    //        {
    //            // выполняем две отдельные команды
    //            command.CommandText = "INSERT INTO UserAuth (name, age, weight, height, id) VALUES('Tim', 34, 60, 180,10)";
    //            command.ExecuteNonQuery();
    //            command.CommandText = "INSERT INTO UserAuth (name, age, weight, height, id) VALUES('Dima', 34, 70, 180,11)";
    //            command.ExecuteNonQuery();

    //            transaction.Commit();
    //            Console.WriteLine("Данные добавлены в базу данных");
    //        }
    //        catch (Exception ex)
    //        {
    //            Console.WriteLine(ex.Message);
    //            transaction.Rollback();
    //        }
    //        Console.WriteLine("Данные добавлены в базу данных");
    //        OOTEntities.GetContext().ChangeTracker.Entries().ToList().ForEach(p => p.Reload());
    //        DGridAuth.ItemsSource = OOTEntities.GetContext().UserAuth.ToList();
    //        connection.Close();
    //    }
    //}
}

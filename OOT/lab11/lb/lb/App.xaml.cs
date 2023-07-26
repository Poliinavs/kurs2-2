using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Windows;

using lb.ViewModels;



namespace lb
{
    /// <summary>
    /// Логика взаимодействия для App.xaml
    /// </summary>
    public partial class App : Application
    {
        public static MainWindow view;
        private void OnStartup(object sender, StartupEventArgs e)
        {


            view = new MainWindow(); // создали View
            MainViewModel viewModel = new ViewModels.MainViewModel(MEDEntities1.GetContext().Doctor.ToList()); // Создали ViewModel
         
            view.DataContext = viewModel; // положили ViewModel во View в качестве DataContext
            view.Show();
            // MainWindow view = new MainWindow(); // создали View
            //  view.Show();
            // MainViewModel viewModel = new ViewModels.MainViewModel(MEDEntities.GetContext().Doctor.ToList()); // Создали ViewModel
            /* view.ItemsSource = viewModel; // положили ViewModel во View в качестве DataContext
             view.Show();*/
        }
    }
}

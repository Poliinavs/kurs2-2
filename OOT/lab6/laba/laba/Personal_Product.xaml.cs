using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
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
using TranslateApp;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace laba
{
    /// <summary>
    /// Логика взаимодействия для Personal_Product.xaml
    /// </summary>
    /// 
    public partial class Personal_Product : System.Windows.Window
    {
        private List<Locale> locales;
        //Текущий язык
        private Locale currentLocale;
        //Путь к файлу с языками
        private string localesPath = "C:\\instit\\kurs2-2\\OOT\\lab4 — копия\\laba\\laba\\local.json";
        public Personal_Product()
        {
            InitializeComponent();
            Color_prod.SelectedIndex = 0;
            locales = new List<Locale>();
            GetLocales();
        }
      
        
        /// ////////////////////////////
       
        private void GetLocales()
        {
            //Получаем данные из файла
            string json = File.ReadAllText(localesPath);

            //Конвертируем данные в объект с динамическими полями
            dynamic data = JsonConvert.DeserializeObject(json);

            //Проходимся по языкам из файла
            foreach (var item in data.locales)
            {
                //Создаём словарь
                Dictionary<string, string> values = new Dictionary<string, string>();

                //Помещаем все значения из файла в словарь
                foreach (var val in item.values)
                {
                    values.Add(val.name.ToString(), val.value.ToString());
                }

                //Добавляем в список новый язык
                locales.Add(new Locale(item.name.ToString(), values));
            }

            //Обновляем кнопки

        }

        private void LocaleButton_Click(object sender, RoutedEventArgs e)
        {
            //Получаем кнопку, которая была нажата
            Label btn = (Label)sender;

            //Ищем язык по названию
            foreach (Locale locale in locales)
            {
                if (btn.Content.ToString() == locale.Name)
                {
                    //Меняем текущий язык
                    currentLocale = locale;
                    break;
                }
            }

            //Обновляем надписи в приложении
            UpdateLocale();
        }

        private void UpdateLocale()
        {
            //Проверяем все записи в словаре текущего языка
            foreach (string key in currentLocale.Values.Keys)
            {
                //Ищем элемент, имя которого совпадает с ключом из словаря
                object elem = FindName(key);

                //Пробуем определить, какого типа может быть элемент, и прописываем различную логику
                //Вы можете сделать этот код более универсальным, но в данном приложении всего два типа элементов - кнопки и текстовые блоки
                try
                {
                    Label btn = (Label)elem;

                    if (btn != null)
                    {
                        btn.Content = currentLocale.Values[key];
                    }
                }
                catch (Exception e) { }

                try
                {
                    TextBlock text = (TextBlock)elem;
                    if (text != null)
                    {
                        text.Text = currentLocale.Values[key];
                    }
                }
                catch (Exception e) { }
            }
        }


       
        /// //////////////////////
      

        private void Home_page(object sender, MouseButtonEventArgs e)
        {

            this.Hide();//прячем текущее окно 
            Products regester = new Products();
            regester.Show();

          
        }

        private void New_main(object sender, MouseButtonEventArgs e)
        {
          
            var img = sender as Image;
            Canvas.SetLeft(img, 100);
            img.SetValue(Grid.ColumnProperty, 1);
            /*Main_Img.Visibility= Visibility.Collapsed;
            var img = sender as Image;
            img.Width = 100;
            Grid.SetRow(img, 2);
            Grid.SetColumn(img, 1);*/

            /* img.SetValue(Grid.RowProperty, 2);
             img.SetValue(Grid.ColumnProperty, 1);*/
            // img.SetValue(Grid.RowProperty, 2);
            // img.Grid.Column = 1;
            //sender.Grid.Column = 1;

        }

        private void Minus(object sender, MouseButtonEventArgs e)
        {
            int a =Convert.ToInt32(Amount1.Content);
            if (a==0)
            {
                MessageBox.Show("Нет элементов для удаления");
            }
            else {
                a--;
                Amount1.Content = a.ToString();
                int b = Convert.ToInt32(Amount2.Content);
                b--;
                Amount2.Content = b.ToString();
            }
        }

        private void Add(object sender, MouseButtonEventArgs e)
        {
            int a = Convert.ToInt32(Amount1.Content);
            int b = Convert.ToInt32(Amount2.Content);
            a++; b++;
            Amount1.Content = a.ToString();
            Amount2.Content = b.ToString();
        }
    }
}

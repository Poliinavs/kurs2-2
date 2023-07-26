using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace lb.ViewModels
{
    class MainViewModel : ViewModelBase
    {
        public static ObservableCollection<DoctorViewsModel> DoctorssList { get; set; }

        #region Constructor

        private string _filterText;
        public MainViewModel(List<Doctor> doctor)
        {
            DoctorssList = new ObservableCollection<DoctorViewsModel>(doctor.Select(b => new DoctorViewsModel(b)));
        }
        public string FilterText
        {
            get => _filterText;
            set
            {
                _filterText = value;
                
                ApplyFilter();
                OnPropertyChanged(nameof(FilterText));
            }
        }

        private void ApplyFilter()
        {
         
            List<Doctor> dk2 = new List<Doctor>();

            foreach (

              var item in MEDEntities1.GetContext().Doctor.ToList())
            {
                if (item.name.Contains(FilterText)) {
                 
                    dk2.Add(item); }
               
            }
            MainViewModel viewModel = new ViewModels.MainViewModel(dk2);
            App.view.DataContext = viewModel;



           /* view.DataContext = dk1; */// положили ViewModel во View в качестве DataContext
          /*  view.Show();*/

        }


        #endregion
    }
}

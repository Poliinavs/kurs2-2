using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;
using GalaSoft.MvvmLight.Command;
using lb.Commands;

namespace lb.ViewModels
{

    public class DoctorViewsModel : ViewModelBase
    {
        public Doctor Doctor;
      
        // private string FilterText;
        public RelayCommand FilterCommand { get; private set; }
     


        public DoctorViewsModel(Doctor Doctor)
        {
            this.Doctor = Doctor;
        }

        public string name
        {
            get { return Doctor.name; }
            set
            {
                Doctor.name = value;
                OnPropertyChanged("name");
            }
        }
      /*  public string _filterText
        {
            get { return Doctor.name; }
            set
            {
                Doctor.name = value;
               
            }
        }*/



        public string speciality
        {
            get { return Doctor.speciality; }
            set
            {
                Doctor.speciality = value;
                OnPropertyChanged("speciality");
            }
        }

        public int id
        {
            get { return Doctor.id; }
            set
            {
                Doctor.id = value;
                OnPropertyChanged("Count");
            }
        }
        public string category
        {
            get { return Doctor.category; }
            set
            {
                Doctor.category = value;
                OnPropertyChanged("category");
            }
        }

        public int? amount
        {
            get { return Doctor.amount; }
            set
            {
                Doctor.amount = value;
                OnPropertyChanged("amount");
            }
        }

        #region Commands

        #region Забрать

        private DelegateCommand getItemCommand;

        public ICommand GetItemCommand
        {
            get
            {
                if (getItemCommand == null)
                {
                    getItemCommand = new DelegateCommand(GetItem);
                }
                return getItemCommand;
            }
        }

        private void GetItem()
        {
            amount++;
        }

        #endregion

        #region Выдать

        private DelegateCommand giveItemCommand;

        public ICommand GiveItemCommand
        {
            get
            {
                if (giveItemCommand == null)
                {
                    giveItemCommand = new DelegateCommand(GiveItem, CanGiveItem);
                }
                return giveItemCommand;
            }
        }

   /*     public string Octor { get => octor; set => octor = value; }*/

        private void GiveItem()
        {
            amount--;
        }

        private bool CanGiveItem()
        {
            return amount > 0;
        }
       /* private DelegateCommand IfilterText;
        public ICommand IFilterText
        {
            get
            {
                if (IfilterText == null)
                {
                    IfilterText = new DelegateCommand(ApplyFilter);
                }
                return IfilterText;
            }
        }
    *//*    public string _filterText
        {
            get => FilterText;
            set
            {
                FilterText = value;
                MessageBox.Show("Work");
                ApplyFilter();
                OnPropertyChanged("FilterText");
               
            }
        }

        private void ApplyFilter()
        {
            List<Doctor> dk = new List<Doctor>();
            dk = MEDEntities.GetContext().Doctor.ToList();
            MessageBox.Show("Work");
            MainViewModel.DoctorssList = new ObservableCollection<DoctorViewsModel>((List<DoctorViewsModel>)dk
                .Where(item => item.name.Contains(FilterText)));
        }*/
      /*  private void ApplyFilter()
        {
            // Применяем фильтр на основе значения FilterText 
            //  DoctorssList = new ObservableCollection<DoctorViewsModel>(doctor.Select(b => new DoctorViewsModel(b)));
            // и обновляем коллекцию данных, которая отображается в представлении (View)
            List<Doctor> dk= new List<Doctor>();
            dk = MEDEntities.GetContext().Doctor.ToList();
            MessageBox.Show("Work");
            MainViewModel.DoctorssList = new ObservableCollection<DoctorViewsModel>((List<DoctorViewsModel>)dk
                .Where(item => item.name.Contains(FilterText)));
        }*/

        #endregion

        #endregion


    }
}

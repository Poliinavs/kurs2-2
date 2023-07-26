using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace University
{
    public class Adres_class
    {
        [Index]
        public int Index { get; set; }
      //  [RegularExpression(@"[А-я]$", ErrorMessage = "Данные Города введены не корректно")]
        [Required(AllowEmptyStrings = false, ErrorMessage = "Поле города обязательно к заполнению")]
        public string City { get; set; }
        [Required(AllowEmptyStrings = false, ErrorMessage = "Поле улицы обязательно к заполнению")]
        public string Street { get; set; }
        [Range(1, 30, ErrorMessage = "Введен не корректный номер дома") ]
        public int House { get; set; }
        [Range(1, 300, ErrorMessage = "Введен не корректный номер квартиры")]
        public int Flat { get; set; }
        public override string ToString()
        {
            return "Индекс: " + Index + " Город: " + City + " Улица: " + Street + " Дом: " + House + " Квартира: " + Flat;
        }
    }

    public class IndexAttribute : ValidationAttribute
    {
        public override bool IsValid(object value)
        {
        
            int numericValue;
            if (value.ToString().Length == 6)
            {

                if ((int)value > 999999 || (int)value < 0)    // если имя не равно admin
                { ErrorMessage = "Некорректный index";
                    return false;
                }
                else
                    return true;

            }
            else
            {
                ErrorMessage = "Некорректный index";
                return false;
            }
           
        }
    }


}

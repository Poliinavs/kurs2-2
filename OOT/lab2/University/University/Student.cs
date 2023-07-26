using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace University
{
    public class Student
    {
        
        public string Fio { get; set; }
        public string Specialty { get; set; }
        public string Gender { get; set; }
        public string Data { get; set; }
        public int Age { get; set; }
        public int Course { get; set; }
        public int Group { get; set; }
        public int Average { get; set; }
        public override string ToString()
        {
            return "ФИО: "+ Fio+" Специальность: "+ Specialty+ " Пол: "+ Gender+ " Возраст: "+ Age+" Дата рождения: "+ Data+ " Курс: "+ Course+ " Группа: "+ Group+" Средний балл:"+ Average;
        }

    }
}

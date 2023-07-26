using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace University
{
    public class Student
    {
        // [RegularExpression(@"^[а-яА-ЯёЁ]+(-[а-яА-ЯёЁ]+)?\s+[а-яА-ЯёЁ]+(-[а-яА-ЯёЁ]+)?$", ErrorMessage = "Данные Фио введены не корректно")]
        [RegularExpression(@"^([А-Я]{1}[а-яё]{1,23}\s[А-Я]{1}[а-яё]{1,23}\s[А-Я]{1}[а-яё]{1,23})$", ErrorMessage = "Данные Фио введены не корректно")]
        public string Fio { get; set; }
        public string Specialty { get; set; }
        public string Gender { get; set; }
        public string Data { get; set; }
        [Range(1, 100, ErrorMessage = "Возраст введен не корректно")]
        public int Age { get; set; }
        [Range(1, 5, ErrorMessage = "Курс введен не корректно")]
        public int Course { get; set; }
        [Range(1, 10, ErrorMessage = "Группа введена не корректно")]
        public int Group { get; set; }
        [Range(1, 10, ErrorMessage = "Средняя оценка введена не корректно")]
        public int Average { get; set; }
        public override string ToString()
        {
            return "ФИО: "+ Fio+" Специальность: "+ Specialty+ " Пол: "+ Gender+ " Возраст: "+ Age+" Дата рождения: "+ Data+ " Курс: "+ Course+ " Группа: "+ Group+" Средний балл:"+ Average;
        }

    }
}

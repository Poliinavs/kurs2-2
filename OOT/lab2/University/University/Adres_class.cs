using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace University
{
    public class Adres_class
    {
        public int Index { get; set; }
        public string City { get; set; }
        public string Street { get; set; }
        public int House { get; set; }
        public int Flat { get; set; }
        public override string ToString()
        {
            return "Индекс: " + Index + " Город: " + City + " Улица: " + Street + " Дом: " + House + " Квартира: " + Flat;
        }
    }
}

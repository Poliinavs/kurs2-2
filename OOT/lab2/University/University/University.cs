using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace University
{
    public class University
    {
        public List<Student> Students { get; set; }
        public List<Adres_class> Adres { get; set; }
       public static University un1 = new University();
        public University()
        {
            Students = new List<Student>();
            Adres = new List<Adres_class>();
        }
        public void AddStudent(Student student)
        {
            Students.Add(student);
        }
        public void AddAdres(Adres_class student)
        {
            Adres.Add(student);
        }
    }
}

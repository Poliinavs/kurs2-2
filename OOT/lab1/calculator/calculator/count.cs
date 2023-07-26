using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace calculator
{
    public partial class Form1 : Form
    {
        public void count_result(double? dn1, string n2)
        {
            double  dn2;
            
            dn2 = double.Parse(n2);
            switch (operation)
            {
                case "+":
                    res = (dn1 + dn2);
                    break;
                case "-":
                    res = (dn1 - dn2);
                    break;
                case "*":
                    res = dn1 * dn2;
                    break;
                case "/":
                    res = dn1 / dn2;
                    break;
                case "%":
                    res = dn1 % dn2;
                    break;
                case "WH":
                    res = (dn1 - (dn1 % dn2)) / dn2;
                    break;

            }
            Begin_count = true;

        }
    }
}

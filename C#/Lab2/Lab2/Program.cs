using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab2
{
    class Program
    {
        public static Decimal InputDecimal()
        {
            Console.WriteLine("Input name + ' ' + decimal number");
            string temp = Console.ReadLine();
            string name = temp.Substring(0, temp.IndexOf(' '));
            temp = temp.Substring(temp.IndexOf(' ') + 1);
            return new Decimal(name, temp);
        }
        public static Binary InputBinary()
        {
            Console.WriteLine("Input name + ' ' + binary number");
            string temp = Console.ReadLine();
            string name = temp.Substring(0, temp.IndexOf(' '));
            temp = temp.Substring(temp.IndexOf(' ') + 1);
            return new Binary (name, temp);
        }
        public static void TestDecimal()
        {
            Decimal a = InputDecimal();
            Decimal b = InputDecimal();
            a.sum(b).Display();
            a.sub(b).Display();
            a.mul(b).Display();
            a.div(b).Display();

        }
        public static void TestBinary()
        {
            Binary a1 = InputBinary();
            Binary b1 = InputBinary();
            a1.sum(b1).Display();
            a1.sub(b1).Display();
            a1.mul(b1).Display();
            a1.div(b1).Display();
        }
        public static void TestSeries()
        {
            Series azaza = new Series();
            azaza.Add(InputDecimal());
            azaza.Add(InputDecimal());
            azaza.Add(InputDecimal());
            azaza.Add(InputDecimal());
            azaza.ShowNumbers();
            Console.WriteLine();
            azaza.ShowSum();
        }
        
        static void Main(string[] args)
        {

            TestSeries();
            Console.ReadLine();
        }
    }
}

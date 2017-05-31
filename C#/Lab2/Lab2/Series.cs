using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab2
{
    class Series: IEnumerable
    {
        List<Integer>   NumbersList = new List<Integer>();
        public Series(List<Integer> numberList)
        {
            NumbersList = numberList;
        }
        public Series() 
        {
        }

        public Integer this[int index]
        {
            get {return (Integer)NumbersList[index];}
            set { NumbersList.Insert(index, value); }
        }
        IEnumerator IEnumerable.GetEnumerator()
        {
            return NumbersList.GetEnumerator();
        }

        public void Add(Integer a)
        {
            NumbersList.Add(a);
        }
        public void ShowNumbers()
        {
            foreach (var a in NumbersList)
                a.Display();
        }
        public void ShowSum()
        {
            char[] t={'0'};
            Decimal a = new Decimal("The Sum of parametereses",t);
            foreach(Decimal b in NumbersList)
            {
                a = a + b;
            }
            a.Display();
        }
    }
}

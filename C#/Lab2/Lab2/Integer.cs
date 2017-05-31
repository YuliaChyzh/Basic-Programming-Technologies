using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab2
{
    abstract class Integer
    {
        public string name;
        public char[] number;

        public abstract Integer sum(Integer b);
        public abstract Integer sub(Integer b);
        public abstract Integer mul(Integer b);
        public abstract Integer div(Integer b);
        public Integer()
        {
            number = new char[1];
            number[0] = '0';
        }
        public Integer(string num)
        {
            number = num.Reverse().ToArray();
        }
        public Integer(int[] num)
        {
            number = new char[num.Length];
            for (int i = 0; i < num.Length; i++)
            {
                number[i] = (char)(num[i] + '0');
            }
        }
        public Integer(char[] num)
        {
            number = new char[num.Length];
            for (int i = 0; i < num.Length; i++)
            {
                number[i] = num[i];
            }
        }

        public Integer(string name, string num)
        {
            this.name = name;
            number = num.Reverse().ToArray();
        }
        public Integer(string name, int[] num)
        {
            this.name = name;
            number = new char[num.Length];
            for (int i = 0; i < num.Length; i++)
            {
                number[i] = (char)(num[i] + '0');
            }
        }
        public Integer(string name, char[] num)
        {
            this.name = name;
            number = new char[num.Length];
            for (int i = 0; i < num.Length; i++)
            {
                number[i] = num[i];
            }
        }
        public  void Display()
        {
            Console.WriteLine(name + ":\t" + new string(number.Reverse().ToArray()));
        }
           
    }

    class Decimal : Integer
    {

        public Decimal(int[] num)
            : base(num) { }
        public Decimal(char[] num)
            : base(num)
        { }
        public Decimal(string num)
            : base(num)
        { }
        public Decimal(string name,int[] num)
            : base(name,num) { }
        public Decimal(string name, char[] num)
            : base(name,num)
        { }
        public Decimal(string name, string num)
            : base(name,num)
        { }
        public Decimal()
            : base()
        { }
        public static Decimal operator +(Decimal a, Decimal b)
        {
            List<int> numbers = new List<int>();
            int overflow = 0;
            bool amax = true;
            int max = a.number.Length;
            int min = b.number.Length;
            if (min > max)
            {
                int c = max;
                max = min;
                min = c;
                amax = false;
            }
            for (int i = 0; i < max; i++)
            {
                int temp;
                if (i < min)
                    temp = a.number[i] + b.number[i] + overflow - 2 * 48;
                else if (amax)
                    temp = a.number[i] + overflow - 48;
                else
                    temp = b.number[i] + overflow - 48;
                if (temp > 9)
                {
                    overflow = temp / 10;
                    temp %= 10;
                }
                else 
                    overflow = 0;
                numbers.Add(temp);
            }
            if(overflow!=0)
            numbers.Add(overflow);
            return new Decimal(a.name,numbers.ToArray());
        }
        public static Decimal operator -(Decimal a, Decimal b)
        {
            List<char> numbers = new List<char>();
            int overflow = 0;
            bool amax = true;
            int max = a.number.Length;
            int min = b.number.Length;

            if (min > max)
            {
                int c = max;
                max = min;
                min = c;
                amax = false;
            }else
            if(min==max)
            {
                for (int i = max - 1; i >= 0 && amax; i--)
                    if (b.number[i] > a.number[i]) amax = false;
            }
            for (int i = 0; i < max; i++)
            {
                int temp;
                if (amax)
                {
                    if (i < min)
                        temp = a.number[i] - b.number[i] - overflow;
                    else
                        temp = a.number[i] - 48 - overflow;
                }
                else
                {
                    if (i < min)
                        temp = b.number[i] - a.number[i] - overflow;
                    else
                        temp = b.number[i] - 48 - overflow;
                }

                if (temp < 0)
                {
                    overflow = 1;
                    temp += 10;
                }
                numbers.Add((char)(temp + 48));
            }
            while (numbers.Last() == '0' && numbers.Count != 1)
                numbers = numbers.Take(numbers.Count - 1).ToList();
            if (!amax)
                numbers.Add('-');
            return new Decimal(a.name, numbers.ToArray());

        }
        public static Decimal operator *(Decimal a, Decimal b)
        {
            string c = new string(b.number.Reverse().ToArray());
            double dub = double.Parse(c);
            Decimal temp = new Decimal();
            temp.name = a.name;
            for (double k = 0; k < dub; k++)
            {
                temp = temp + a;
            }
            return temp;
        }
        public static Decimal operator /(Decimal a, Decimal b)
        {
            List<char> rez = new List<char>();
            while (!(a - b).number.Contains('-'))
            {
                Decimal a1 = new Decimal(a.number.Reverse().Take(b.number.Length).Reverse().ToArray());
                if ((a1 - b).number.Contains('-'))
                {
                    if (rez.Count > 0)
                    {
                        char[] cc = { '0' };
                        rez.Insert(0, cc[0]);
                    }
                    a1 = new Decimal(a.number.Reverse().Take(b.number.Length + 1).Reverse().ToArray());
                }
                char[] c = { '9' };
                Decimal temp = new Decimal(c);
                while ((a1 - b * temp).number.Contains('-'))
                {
                    c[0]--;
                    temp = new Decimal(c);
                }
                rez.Insert(0, c[0]);
                a1 = a1 - b * temp;
                int offset = a.number.Length - a1.number.Length;
                for (int i = offset; i < a.number.Length; i++)
                {
                    a.number[i] = a1.number[i-offset];
                }
                if (a.number.Last() == '0')
                    a = new Decimal(a.number.Take(a.number.Length - 1).ToArray());
            }
            return new Decimal(a.name, rez.ToArray());
        }


        public override Integer sum(Integer b) { return (Decimal)this + (Decimal)b; }
        public override Integer sub(Integer b) { return (Decimal)this - (Decimal)b; }
        public override Integer mul(Integer b) { return (Decimal)this * (Decimal)b; }
        public override Integer div(Integer b) { return (Decimal)this / (Decimal)b; }

    }

    class Binary: Integer{
        

        public Binary(int[] num)
            : base(num) { }
        public Binary(char[] num)
            : base(num)
        { }
        public Binary(string num)
            : base(num)
        { }
        
        public Binary(string name,int[] num)
            : base(name,num) { }
        public Binary(string name, char[] num)
            : base(name,num)
        { }
        public Binary(string name, string num)
            : base(name,num)
        { }
        public Binary()
            : base()
        { }
        public static Binary operator +(Binary a, Binary b)
        {
            List<int> numbers = new List<int>();
            int overflow = 0;
            bool amax = true;
            int max = a.number.Length;
            int min = b.number.Length;
            if (min > max)
            {
                int c = max;
                max = min;
                min = c;
                amax = false;
            }
            for (int i = 0; i < max; i++)
            {
                int temp;
                if (i < min)
                    temp = a.number[i] + b.number[i] + overflow - 2 * 48;
                else if (amax)
                    temp = a.number[i] + overflow - 48;
                else
                    temp = b.number[i] + overflow - 48;
                if (temp > 1)
                {
                    overflow = temp / 2;
                    temp %= 2;
                }
                else
                    overflow = 0;
                numbers.Add(temp);
            }
            if (overflow != 0)
                numbers.Add(overflow);
            return new Binary(a.name, numbers.ToArray());
        }
        public static Binary operator -(Binary a, Binary b)
        {
            List<char> numbers = new List<char>();
            int overflow = 0;
            bool amax = true;
            int max = a.number.Length;
            int min = b.number.Length;

            if (min > max)
            {
                int c = max;
                max = min;
                min = c;
                amax = false;
            }
            else
                {
                    for (int i = max - 1; i >= 0 && amax; i--)
                    {
                        int ind =i<min ? b.number[i]:0;
                        if (ind > a.number[i])
                        {
                            int c = max;
                            max = min;
                            min = c;
                            amax = false;
                        }
                    }
                }
            for (int i = 0; i < max; i++)
            {
                int temp;
                if (amax)
                {
                    if (i < min)
                        temp = a.number[i] - b.number[i] - overflow;
                    else
                        temp = a.number[i] - 48 - overflow;
                }
                else
                {
                    if (i < min)
                        temp = b.number[i] - a.number[i] - overflow;
                    else
                        temp = b.number[i] - 48 - overflow;
                }

                if (temp < 0)
                {
                    overflow = 1;
                    temp+=2;
                }
                numbers.Add((char)(temp + 48));
            }
            while (numbers.Last() == '0'&& numbers.Count!=1)
                numbers = numbers.Take(numbers.Count - 1).ToList();
            if (!amax)
                numbers.Add('1');
            else
                numbers.Add('0');
            return new Binary(a.name, numbers.ToArray());

        }
        public static Binary operator *(Binary a, Binary b)
        {
            double dub = 0;
            for (int i = 0; i < b.number.Length; i++)
                dub += (b.number[i] - 48) * Math.Pow(2, i);
            Binary temp = new Binary();
            temp.name = a.name;
            for (double k = 0; k < dub; k++)
            {
                temp = temp + a;
            }
            return temp;
        }
        public static Binary operator /(Binary a, Binary b)
        {
            List<char> rez = new List<char>();
            while ((a-b).number.Last()=='0')
            {
                var a2 = (a - b);
                Binary a1 = new Binary(a.number.Reverse().Take(b.number.Length).Reverse().ToArray());
                int overtake = 0;
                while ((a1 - b).number.Last() == '1')
                {
                    overtake++;
                    a1 = new Binary(a.number.Reverse().Take(b.number.Length+overtake).Reverse().ToArray());
                    if (rez.Count > 0)
                    {
                        char[] cc = { '0' };
                        rez.Insert(0, cc[0]);
                    }
                }
                char[] c = { '1' };
                Binary temp = new Binary(c);
                int offset = a.number.Length - a1.number.Length;
                a1 = (a1 - b * temp);
                a1 = new Binary(a.number.Take(a1.number.Length - 1).ToArray());
                rez.Insert(0,c[0]);
                for (int i = offset; i < a.number.Length-1; i++)
                {
                    a.number[i] =i-offset<a1.number.Length ? a1.number[i - offset] : '0';
                }
                a = new Binary(a.number.Take(a.number.Length - 1).ToArray());
                
            }
            return new Binary(a.name, rez.ToArray());
        }


        public override Integer sum(Integer  b) { return (Binary)this + (Binary)b; }
        public override Integer sub(Integer  b) { return (Binary)this - (Binary)b; }
        public override Integer mul(Integer  b) { return (Binary)this * (Binary)b; }
        public override Integer div(Integer  b) { return (Binary)this / (Binary)b; }
    }


   
}

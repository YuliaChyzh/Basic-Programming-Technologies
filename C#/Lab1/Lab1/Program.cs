using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab1
{
    class Program
    {
        List<string> paths = new List<string>();
        static int [][] leaves;
        static int N;
        static void Initialize()
        {
            Console.Write("Enter N: ");
            N = Int32.Parse(Console.ReadLine());
            Console.Write("Enter K: ");
            int K = Int32.Parse(Console.ReadLine());
            leaves = new int[N][];
            for (int i = 0; i < N; i++)
                leaves[i] = new int[N];
            string temp = "";
            Console.WriteLine("Connections are writen as vector of features: \n '1' for friend; '2' for enemy ; 0 for no connection\n");
            
            #region random
            /*
            Console.Write("Randomise connections? (y-n): ");
            bool randomise = Console.ReadLine() == "y";
            if (randomise)
            {
                Random r = new Random();
                int[] friends = new int[N];
                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < N; j++)
                    {
                        if (j >= N / 2 + friends[j] || i >= N / 2 + friends[i])
                        {
                            leaves[i][j] = 1;
                            leaves[j][i] = 1;
                            friends[i]++;
                            friends[j]++;
                        }
                        else if (j >= N - friends[j] || i >= N - friends[i])
                        {
                            if(leaves[j][i]!=0 || leaves[i][j]!=0)
                            {
                                leaves[i][j] = 1;
                                leaves[j][i] = 1;
                            }
                        }
                        else
                        {
                            leaves[i][j] = r.Next(0, 2);
                            leaves[j][i] = leaves[i][j];
                            if (leaves[i][j] == 1)
                            {

                                friends[i]++;
                                friends[j]++;
                            }
                        }

                    }
                }
                Console.WriteLine("Matrix of connections:\n\n");
                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < N; j++)
                        Console.Write(leaves[i][j]);
                    Console.WriteLine();
                }
                return;
            }
            */
            #endregion

            for (int i=0;i<N;i++)
            {
                Console.Write("Write connections for "  + i+ " leave: \t");
                temp = Console.ReadLine();
                for(int j=0;j<N;j++)
                {
                    leaves[i][j] = temp[j]-48;
                }
            } 
        }


        static string firstRecursion(int leave,string path)
        {
            string p=path+leave.ToString();
            for(int i=0;i<N;i++)
            {
                if (leaves[leave][i] == 1)
                {
                    if (!p.Contains(i.ToString()))
                        return firstRecursion(i, p);
                    else if (p.Length == N && i == 0)
                        return p + i.ToString();
                }
            }
            return p;
        
        }


        static void Main(string[] args)
        {
            Initialize();
            Console.WriteLine(firstRecursion(0, ""));
            Console.ReadLine();
        }
    }
}

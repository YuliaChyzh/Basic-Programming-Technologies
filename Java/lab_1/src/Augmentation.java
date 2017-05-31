import java.io.*;
import java.util.Scanner;

/* c2=0; c3=2; c5=0; c7=2
   +       2    *    int */
public class Augmentation {
    static int n, m;
    static float s=0;
    static int c=2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("n = ");
        n=in.nextInt();
        System.out.print("m = ");
        m=in.nextInt();
        float sum=suma(n,m);
        System.out.print("s = "+sum);
    }

    public static float suma(int n, int m) {
        /* i>0, j>0 always -> i-c!=0 never */
        for(int i=0; i<=n; i++)
            for(int j=0; j<=m; j++) {
                s=s+((float)(i*j))/(i+c);
            }
        return s;
    }
}
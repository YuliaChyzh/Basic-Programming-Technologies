import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.*;
import java.util.InputMismatchException;

// 0 2 8
public class Matrix {
    static int n, m;
    static float a;
    static short[][] M=new short[25][25];
   // static float[][] M1=new float[25][25];
    static float[] A=new float[25];

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        System.out.print("n = ");
        n = s.nextInt();
        System.out.print("m = ");
        m = s.nextInt();
        System.out.print("a = ");
        a = s.nextInt();

        OutputMatrix(M);
        MatrixA(M, a);
        Ser(M, A);
        OutputArray(A);
    }

    public static void OutputMatrix(short[][] M) {
        Random r= new Random();
        System.out.println("M:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                M[i][j] = (short)r.nextInt(100);
                System.out.printf("%3d  ", M[i][j]);
                }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void MatrixA(short[][] M, float a) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                M[i][j]*=a;
        System.out.println("M1:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                System.out.printf("%3d  ", M[i][j]);
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void Ser(short[][] M, float[] A) {
        int s;
        for (int i = 0; i < n; i++) {
            s = 0;
            for (int j = 0; j < m; j++)
                s += M[i][j];
            A[i] = s / m;
        }
    }

    public static void OutputArray(float[] A){
        System.out.println("Array of averages:");
        for(int i=0;i<n;i++) {
            System.out.printf("%.2f ", A[i]);
        }
    }

}

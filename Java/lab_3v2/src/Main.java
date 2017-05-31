import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1 14
public class Main {

    public static void main(String[] args) throws IOException {
        String str = Input(); // starting line
        String str1=Delete(str); // ending line
        Output(str1);
    }
    public static String Input() throws IOException
    {
        System.out.println("Enter string:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer(reader.readLine());
        return str.toString();
    }

    public static String Delete(String str) throws IOException {
        char sym='#'; //first letter
        String str1="";
        int i=0;
        try {
            while ((sym=='#')) {
                if (Character.isLetterOrDigit(str.charAt(i))) sym=str.charAt(i);
                i++;
            }
            for (i=0;i<str.length();i++) {
                if (str.charAt(i)!=sym) str1+=str.charAt(i);
            }
        }catch (Exception e) {
            System.out.println("error");
        }
        return str1;
    }

    public static void Output(String str1) throws IOException {
        System.out.println("Result string:");
        System.out.println(str1);
    }

}

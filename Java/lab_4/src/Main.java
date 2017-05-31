import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input text string : ");
            StringBuffer str = new StringBuffer(scanner.nextLine());
            StringBuffer result = new StringBuffer();
            Text text = new Text(str.toString());
            text.Calculate_Result();
            result.append(text);
            System.out.println("Result string text :\n" + result);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1 14
public class Lab {

    public static void main(String[] args) throws IOException {
       Delete();
    }

    public static String Input() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer();
        str.append(reader.readLine());
        return str.toString();
    }
    public static void Delete() throws IOException
    {
		/*try
		{*/
        System.out.println("Enter string");
        String str = Input();
        char l;
        int k=0;
        char[] let = new char[500];
        for(int i=0;i<str.length();i++)
        {
            let[i] = str.charAt(i);
        }
        for(int i=0;i<let.length;i++)
        {
            if(i == 0 || (Character.isLetterOrDigit(let[i]) && Character.isSpaceChar(let[i-1])))
            {
                l = let[i];
                k=i+1;
                while(Character.isLetterOrDigit(let[k]))
                {
                    if(let[k] == let[i]) let[k] = '#';
                    k++;
                }
            }
            i+=k;
        }

        System.out.println("Result string:");

        for(int i=0;i<let.length;i++)
        {
            if(let[i]!='#') System.out.print(let[i]);
        }
		/*}
		catch(Exception e)
		{
			System.out.println("error");
			Delete();
		}*/
    }
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1 14
public class Main {

    public static void main(String[] args) throws IOException {
        StringBuffer str = Input(); //starting line
        Output(Delete(str)); //ending line
    }

    public static StringBuffer Input() throws IOException
    {
        System.out.println("Enter string:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer(reader.readLine());
        return str;
    }
    public static String Delete(StringBuffer str)
    {
        ArrayList<StringBuffer> words=new ArrayList<StringBuffer>();
        StringTokenizer tokenizer=new StringTokenizer(str.toString()," .,!?:;()-");
        while (tokenizer.hasMoreTokens()) {
            StringBuffer token = new StringBuffer(tokenizer.nextToken());
            words.add(token);
        }

        ArrayList<StringBuffer> words1=new ArrayList<StringBuffer>(words);
        for (int i = 0; i <words1.size() ; i++) {
            char sym=words1.get(i).toString().charAt(0);
            for (int j = i; j < words1.size(); j++) {
                words1.set(j,new StringBuffer(words1.get(j).toString().replaceAll(String.valueOf(sym),"")));
            }
        }

        String str1=str.toString();
        for (int i = 0; i <words.size() ; i++) {
            str1=str1.replaceAll(words.get(i).toString(),words1.get(i).toString());
        }

        return str1;

    }

    public static void Output(String str1)  {
        System.out.println("Result string:");
        System.out.println(str1);
    }
}



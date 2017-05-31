import java.util.*;
public class Text {
    private ArrayList<Syntax> text = new ArrayList<Syntax>();
    public Text(String str)
    {
        str = str.replaceAll("(?<!\\S+)\\s", "");
        String delim = ".?!";
        String s = new String("");
        for(int i = 0;i < str.length();i++) {
            boolean flagIsDelim = false;
            for(int j = 0;j < delim.length();j++)
            {
                if((delim.charAt(j) + "").equals(str.charAt(i) + ""))
                {
                    flagIsDelim = true;
                    break;
                }
            }
            if(!flagIsDelim) {
                s += str.charAt(i) + "";
                if(s.length() == 1 && " ".equals(s))
                    s = s.replace(" ","");
            }
            else
            {
                s += " " + str.charAt(i);
                text.add(new Syntax(s));
                s = new String("");
            }
        }

    }
    public void Calculate_Result()
    {
        for(int i = 0;i < text.size();i++) {
            text.get(i).Calculate_Syntax_Task();
        }

    }
    @Override
    public String toString()
    {
        String str = new String();
        for(int i = 0;i < text.size();i++)
            str += text.get(i)+"";
        return str;
    }
}

import java.util.*;
public class Syntax
{
    private ArrayList<SyntaxMem> syntax = new ArrayList<SyntaxMem>();
    public Syntax(String str)
    {
        str = str.replace(","," , ");
        str = str.replace("("," ( ");
        str = str.replace(")"," ) ");
        str = str.replace(":"," : ");
        str = str.replace("-"," - ");
        str = str.replace("."," . ");
        String[] masWords = str.split(" ");
        for(int i = 0;i < masWords.length;i++) {
            if(masWords[i].length() != 0) {
                if (masWords[i] == "," || masWords[i] == "-" || masWords[i] == "(" || masWords[i] == ")" || masWords[i] == ":" || masWords[i] == ".")
                    syntax.add(new SyntaxMem(new Delimiter(masWords[i])));
                else
                    syntax.add(new SyntaxMem(new Word(masWords[i])));
            }
        }
    }
    public void Calculate_Syntax_Task()
    {
        for(int i = 0;i < syntax.size();i++) {
            syntax.get(i).Calculate_SyntaxMem_Result();
        }
    }
    @Override
    public String toString()
    {
        String str = new String();
        for(int i = 0;i < syntax.size();i++)
            str += syntax.get(i)+" ";
        return str;
    }
}

import java.util.*;
public class SyntaxMem
{
    private Word word;
    Delimiter delimiter;

    public SyntaxMem(Word word) {
        this.word = word;
    }
    public SyntaxMem(Delimiter delimiter) {
        this.delimiter = delimiter;
    }
    public Object getMember() {
        return ((word == null) ? delimiter : word);
    }
    public boolean isDelimiter() {
        return ((word == null) ? true : false);
    }
    public void Calculate_SyntaxMem_Result() {
        if(!isDelimiter())word.Calculate_Word_Task();
    }
    @Override
    public String toString()
    {
        if(word == null)
            return delimiter.toString();
        else
            return word.toString();
    }
}


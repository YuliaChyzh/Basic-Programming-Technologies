import java.util.*;
public class Word {
    private ArrayList<Letter> word = new ArrayList<Letter>();
    public Word(String wrd)
    {
        for(int i = 0;i < wrd.length();i++)
            word.add(new Letter(wrd.charAt(i)));
    }

    public ArrayList<Letter> getLetter() {
        return word;
    }
    public void display()
    {
        for(int i = 0;i < word.size();i++)
            System.out.print(word.get(i).getLetter());
    }
    public void Calculate_Word_Task()
    {
        Letter firstLetter = new Letter(word.get(0).getLetter());
        for(int i = 1;i < word.size();i++)
        {
            if((firstLetter.getLetter() + "").equalsIgnoreCase(word.get(i).getLetter() + "")) {
                word.remove(i);
                i = 0;
            }
        }
    }
    @Override
    public String toString()
    {
        String str = new String();
        for(int i = 0;i < word.size();i++)
            str += word.get(i)+"";
        return str;
    }
}

public class Delimiter
{
    private char delimiter;
    public Delimiter(String delimiter)
    {this.delimiter = delimiter.charAt(0);}
    @Override
    public String toString()
    {
        String str = new String(delimiter +"");
        return str;
    }
}


public class Letter
{
    private char c;
    public Letter(char c) {
        this.c = c;
    }
    public char getLetter() {
        return c;
    }
    public void display() {
        System.out.print(c);
    }
    @Override
    public String toString()
    {
        String str = new String(c+"");
        return str;
    }
}

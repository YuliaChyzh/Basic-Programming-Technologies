/**
 * Created by Юля on 24.04.2017.
 */
public class Delimiter {
    private static final char[] punctuations = {',','.','-','!','?',';',':'};
    private char punctuation;

    public Delimiter(char punctuation) {
        this.punctuation = punctuation;
    }

    public char[] toCharArray() {
        return new char[]{punctuation};
    }

    public static boolean isPunctuation(char element){
        for (int i = 0; i <punctuations.length ; i++) {
            if(element==punctuations[i]) return true;
        }
        return false;
    }
}

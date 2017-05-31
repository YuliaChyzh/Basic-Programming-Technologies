/**
 * Created by Юля on 24.04.2017.
 */
public class Word {
    private Letter[] letters;

    public Word(char[] word) {
        letters = new Letter[word.length];
        for (int i = 0; i < word.length; i++) {
            letters[i]=new Letter(word[i]);
        }
    }

    public char[] toCharArray() {
        char[] array = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            array[i]=letters[i].getLetter();
        }
        return array;
    }
}

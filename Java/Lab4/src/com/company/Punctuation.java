package com.company;

/**
 * Created by Mark Hychka on 21.04.2017.
 */
public class Punctuation implements SentencePart {
    private static final char[] punctuations = {',','.','-','!','?',';',':'};
    private char punctuation;

    public Punctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    @Override
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

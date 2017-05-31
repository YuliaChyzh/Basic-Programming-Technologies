package com.company;

public class Word extends WordOrPunctuation {
    private Letter[] lets;

    public Word(char[] word) {
        lets = new Letter[word.length];
        for (int i = 0; i < word.length; i++) {
            lets[i]=new Letter(word[i]);
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < lets.length; i++) {
            s += lets[i].getLetter();
        }
        return s;
    }
}

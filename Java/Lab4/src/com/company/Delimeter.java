package com.company;

public class Delimeter extends WordOrPunctuation {
    private static final String p = ".!?,-;:()";
    private char punctuation;

    public Delimeter(char punctuation) {
        this.punctuation = punctuation;
    }

    public String toString() {
        return String.valueOf(punctuation);
    }

    public static boolean isPunctuation(char element){
        return p.contains(String.valueOf(element));
    }
}

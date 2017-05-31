package com.company;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Text {
    private String text = "";
    private int size = 0;
    private Sentence[] sentences = new Sentence[5];

    public void add(Sentence sentence) {
        if (sentences.length == size)
            expand(size + 1);
        sentences[size++] = sentence;
        text += sentence.toString() + " ";
    }

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < size; i++) {
            text += sentences[i] + "\n";
        }
        return text;
    }

    private void expand(int n) {
        Sentence[] temporary = sentences;
        sentences = new Sentence[n];
        for (int i = 0; i < size; i++) {
            sentences[i] = temporary[i];
        }
    }

    public String Delete() {
        String str = this.text;
        ArrayList<String> words = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " .,!?:;()-");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            words.add(token);
        }

        ArrayList<String> words1 = new ArrayList<>(words);
        for (int i = 0; i < words1.size(); i++) {
            char sym = words1.get(i).charAt(0);
            for (int j = i; j < words1.size(); j++) {
                words1.set(j, words1.get(j).replaceAll(String.valueOf(sym), ""));
            }
        }

        String str1 = str;
        for (int i = 0; i < words.size(); i++) {
            str1 = str1.replaceAll(words.get(i), words1.get(i));
        }

        return str1;
    }
}

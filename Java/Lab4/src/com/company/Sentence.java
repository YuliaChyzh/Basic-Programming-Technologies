package com.company;

public class Sentence {
    private WordOrPunctuation[] sentenceParts = new WordOrPunctuation[16];
    private int size = 0; // індекс

    public Sentence(String string) {
        // парсить в масив WordOrPunctuation слова або роздільники в певній послідовності
        if(!string.equals("")) {
            char[] str = string.toCharArray();
            char start = str[0];
            int index = 0;
            if(str.length!=1) {
                for (int i = 1; i < str.length; i++) {
                    if (Delimeter.isPunctuation(start)) {
                        sentenceParts[size] = new Delimeter(start);
                        size++;
                        start = str[i];
                        index = i;
                    } else {
                        if (start == ' ') {
                            if (str[i] != ' ') {
                                sentenceParts[size] = new Delimeter(' ');
                                size++;
                                start = str[i];
                                index = i;
                            }
                        } else {
                            if (Delimeter.isPunctuation(str[i]) || str[i] == ' ') {
                                char[] word = new char[i - index];
                                for (int j = index; j < i; j++) {
                                    word[j - index] = str[j];
                                }
                                sentenceParts[size] = new Word(word);
                                size++;
                                start = str[i];
                                index = i;
                            }
                        }
                    }
                    if (size == sentenceParts.length)
                        clarify();
                    if (i == str.length - 1) {
                        if (Delimeter.isPunctuation(str[i])) {
                            sentenceParts[size] = new Delimeter(str[i]);
                            size++;
                        } else {
                            if (str[i] != ' ') {
                                if (i == index) {
                                    sentenceParts[size] = new Word(new char[]{str[i]});
                                    size++;
                                } else {
                                    char[] word = new char[i - index + 1];
                                    for (int j = index; j <= i; j++) {
                                        word[j - index] = str[j];
                                    }
                                    sentenceParts[size] = new Word(word);
                                    size++;
                                }
                            }
                        }
                    }
                }
            }
            else{
                if(!Delimeter.isPunctuation(start) && start!=' '){
                    sentenceParts[size] = new Word(new char[]{start});
                    size++;
                }
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) str= str + sentenceParts[i].toString();
        return str;
    }
    private void clarify(){
        WordOrPunctuation[] temporary = sentenceParts;
        sentenceParts = new WordOrPunctuation[++size];
        for (int i = 0; i < size; i++) {
            sentenceParts[i]=temporary[i];
        }
    }
}

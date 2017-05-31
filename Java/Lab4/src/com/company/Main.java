package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Text text = new Text();
        Sentence line;
        System.out.println("Введіть речення або нічого для завершення: ");
        while (!(line = new Sentence(reader.readLine())).toString().equals("")) {
            text.add(line);
        }
        System.out.println(text.Delete());
    }
}

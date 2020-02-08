package com.epam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        char[] letters;
        StringBuilder builder;
        System.out.println("Введите требуемый текст: ");
        BufferedReader reader = null;
        String text;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            text = reader.readLine();
            for (int shift = 0; shift < alphabet.length(); shift++) {
                char[] symbols = text.toCharArray();
                builder = new StringBuilder();
                for (int i = 0; i < symbols.length; i++) {
                    for (int j = 0; j < alphabet.length(); j++) {
                        letters = alphabet.toCharArray();
                        if (Character.isLowerCase(symbols[i])) {
                            letters = alphabet.toLowerCase().toCharArray();
                        }
                        if (symbols[i] == letters[j]) {
                            if ((j + shift) < letters.length) {
                                symbols[i] = letters[j + shift];
                                break;
                            } else {
                                symbols[i] = letters[j + shift - letters.length];
                                break;
                            }
                        }
                    }
                    builder.append(symbols[i]);
                }
                System.out.println(builder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

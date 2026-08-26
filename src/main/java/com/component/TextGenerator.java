package com.component;

import java.util.Random;

public class TextGenerator {
    private static final String letters = "ABCDEFGHIGCLMNPQRSTUVWXYZabcdefghigclmnpqrstuvwxyz";
    private static final Random random = new Random();

    public static String generateText(int minWordNumber, int maxWordNumber) {
        int wordNumber = random.nextInt(maxWordNumber-minWordNumber+1) + minWordNumber;
        StringBuilder text = new StringBuilder();

        while (wordNumber>0) {
            text.append(generateWord()+" ");
            wordNumber--;
        }
        text.delete(text.length()-1,text.length());
        return text.toString();
    }

    private static StringBuilder generateWord(){
        int size = random.nextInt(15)+1;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < size; i++) {
            word.append(letters.charAt(random.nextInt(letters.length())));
        }
        return word;
    }

}

package ua.javarush.cipher;

import java.util.List;

public class CaeserCipher {
    private List<Character> alphabet;

    public CaeserCipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public void encode(String text, int key) {
        char[] textArr = text.toCharArray();
        int alphabetSize = alphabet.size();
        System.out.println(alphabetSize);
        System.out.println(key);
        if (key > alphabetSize) {
            key = key % alphabetSize;
            System.out.println(key);
        }
        for (int i = 0; i < textArr.length; i++) {
            if (alphabet.contains(textArr[i])) {

                int letterIndex = alphabet.indexOf((char)textArr[i]) + key;
                System.out.println("letter index1:" + letterIndex);
                if (letterIndex > alphabetSize) {
                    letterIndex = letterIndex % alphabetSize;
                    System.out.println("letter index2:" + alphabet.get(letterIndex));
                }else {
                    System.out.println("letter index3:" + alphabet.get(letterIndex));
                }
            }
        }
    }
    public void cipher(){}
    public void decode(String text, int key){}
}

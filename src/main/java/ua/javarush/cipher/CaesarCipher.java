package ua.javarush.cipher;

import java.util.List;

public class CaesarCipher {
    public List<Character> getAlphabet() {
        return alphabet;
    }

    private List<Character> alphabet;

    public CaesarCipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    //TODO:refactor to receive char parameter instead String
    public char[] caesarCipherCode(char[] text, int key) {
        char[] resultCharArray = new char[text.length];
        int alphabetSize = alphabet.size();
        if (Math.abs(key) > alphabetSize) {
            key = key % alphabetSize;
        }
        for (int i = 0; i < text.length; i++) {
            if (alphabet.contains(text[i])) {
                int letterIndex = alphabet.indexOf((char) text[i]) + key;

                if (letterIndex < 0) {
                    letterIndex = letterIndex + alphabetSize;
                }
                if (letterIndex >= alphabetSize) {
                    letterIndex = letterIndex % alphabetSize;
                    resultCharArray[i] = alphabet.get(letterIndex);
                } else {
                    resultCharArray[i] = alphabet.get(letterIndex);
                }
            } else {
                resultCharArray[i] = text[i];
            }
        }
        return resultCharArray;
    }
}

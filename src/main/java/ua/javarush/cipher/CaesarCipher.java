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
        System.out.println();
        System.out.println(alphabetSize);
        System.out.println(key);
        if (Math.abs(key) > alphabetSize) {
            key = key % alphabetSize;
            System.out.println(key);
        }
        for (int i = 0; i < text.length; i++) {
            if (alphabet.contains(text[i])) {
                int letterIndex = alphabet.indexOf((char)text[i]) + key;

                if(letterIndex < 0){
                    letterIndex = letterIndex + alphabetSize;
                }

                //System.out.println("letter index1:" + letterIndex);
                if (letterIndex >= alphabetSize) {
                    letterIndex = letterIndex % alphabetSize;
                    //System.out.println("letter index2:" + alphabet.get(letterIndex));
                    System.out.print(alphabet.get(letterIndex));
                    resultCharArray[i] = alphabet.get(letterIndex);
                }else {
                    //System.out.println("letter index3:" + alphabet.get(letterIndex));
                    System.out.print(alphabet.get(letterIndex));
                    resultCharArray[i] = alphabet.get(letterIndex);
                }
            } else {
                System.out.print(text[i]);
                resultCharArray[i] = text[i];
            }
        }
        return resultCharArray;
    }
}

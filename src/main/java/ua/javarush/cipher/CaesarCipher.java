package ua.javarush.cipher;

import java.util.List;

public class CaesarCipher {
    private List<Character> alphabet;

    public CaesarCipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

   //TODO:refactor to receive char parameter instead String
    public char[] caesarCipherCode(String text, int key) {
        char[] textArr = text.toCharArray();
        char[] resultCharArray = new char[textArr.length];
        int alphabetSize = alphabet.size();
        System.out.println();
        System.out.println(alphabetSize);
        System.out.println(key);
        if (Math.abs(key) > alphabetSize) {
            key = key % alphabetSize;
            System.out.println(key);
        }
        for (int i = 0; i < textArr.length; i++) {
            if (alphabet.contains(textArr[i])) {
                int letterIndex = alphabet.indexOf((char)textArr[i]) + key;

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
                System.out.print(textArr[i]);
                resultCharArray[i] = textArr[i];
            }
        }
        return resultCharArray;
    }
}

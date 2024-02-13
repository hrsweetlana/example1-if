package ua.javarush;

import ua.javarush.cipher.CaesarCipher;
import ua.javarush.constants.EnglishAlphabet;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //new ApplicationController(new FileService(32)).runApplication();
        new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).caesarCipherCode("abaabcddzzzz&&&????  ", 3);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).caesarCipherCode("abaabcddzz????    " +
                "", 67);
        System.out.println();
        System.out.println("==============================================================================");
        new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).caesarCipherCode("deddefgg««««&&&BBBBCC", -3);
        new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).caesarCipherCode("fgffghii\"\"DDDDEEEE", -67);
    }
}
package ua.javarush;

import ua.javarush.Controller.ApplicationController;
import ua.javarush.cipher.CaeserCipher;
import ua.javarush.constants.EnglishAlphabet;
import ua.javarush.io.FileService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //new ApplicationController(new FileService(32)).runApplication();
        new CaeserCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).encode("abaabcddzzzz&&&????  ", 3);
        System.out.println("==============================================================================");
        new CaeserCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).encode("abaabcddzz????    " +
                "", 67);
    }
}
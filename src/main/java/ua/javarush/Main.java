package ua.javarush;

import ua.javarush.cipher.CaesarCipher;
import ua.javarush.constants.EnglishAlphabet;
import ua.javarush.controller.ApplicationController;
import ua.javarush.io.FileCrypter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println(new FileService().createTargetFileName(Path.of("c:\\study\\source\\a.txt"), Option.ENCRYPT));
        //System.out.println(new FileService().createTargetFileName(Path.of("c:\\study\\source\\a.txt_ENCRYPT"), Option.DECRYPT));
        new ApplicationController(new FileCrypter(32,"c:\\study\\source\\a.txt_ENCRYPT",new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)), "DECRYPT",3)).runApplication();
        //new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).caesarCipherCode("abaabcddzzzz&&&????  ", 3);
//        System.out.println();
//        System.out.println("------------------------------------------------------------------------------");
//        new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).caesarCipherCode("abaabcddzz????    " +
//                "", 67);
//        System.out.println();
//        System.out.println("==============================================================================");
//        new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).caesarCipherCode("deddefgg««««&&&BBBBCC", -3);
//        new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)).caesarCipherCode("fgffghii\"\"DDDDEEEE", -67);
    }
}
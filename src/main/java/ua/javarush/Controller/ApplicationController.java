package ua.javarush.controller;

import ua.javarush.cipher.CaesarCipher;
import ua.javarush.cli.CLI;
import ua.javarush.constants.EnglishAlphabet;
import ua.javarush.io.FileCrypter;

import java.util.Arrays;

public class ApplicationController {
    private final FileCrypter fileCrypter;
    public static final int BUFFER_CAPACITY = 1024;

    public ApplicationController(FileCrypter fileCrypter) {
        this.fileCrypter = fileCrypter;
    }

    public void runApplication() {

        fileCrypter.identifyOption(fileCrypter.getOption());
    }

    public static void main(String[] args) {
        if (args.length == 3) {
            new ApplicationController(new FileCrypter(BUFFER_CAPACITY, args[0], new CaesarCipher(Arrays.asList(EnglishAlphabet.ENGLISH_ALPHABET)), args[1], args[2])).runApplication();
        } else if (args.length == 2 && args[0].equals("BRUTE_FORCE")) {
            new ApplicationController(new FileCrypter(BUFFER_CAPACITY, args[0], new CaesarCipher(Arrays.asList(EnglishAlphabet.ENGLISH_ALPHABET)), args[1])).runApplication();
        } else if ((args.length == 2 && args[0].equals("DECRYPT")) ||(args.length == 2 && args[0].equals("ENCRYPT"))) {
            throw new IllegalArgumentException("You must type a key for ENCRYPT/DECRYPT option");
        } else {
            new ApplicationController(CLI.readParameters()).runApplication();
            //new ApplicationController(new FileCrypter(32, "c:\\study\\source\\a.txt", new CaesarCipher(Arrays.asList(EnglishAlphabet.ENGLISH_ALPHABET)), "ENCRYPT", 3)).runApplication();
        }
    }
}

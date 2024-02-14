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
        if (args.length > 0) {
            new ApplicationController(new FileCrypter(BUFFER_CAPACITY, args[0], new CaesarCipher(Arrays.asList(EnglishAlphabet.ENGLISH_ALPHABET)), args[1], Integer.parseInt(args[2]))).runApplication();
        } else {
            new ApplicationController(CLI.readParameters()).runApplication();
            //new ApplicationController(new FileCrypter(32, "c:\\study\\source\\a.txt", new CaesarCipher(Arrays.asList(EnglishAlphabet.ENGLISH_ALPHABET)), "ENCRYPT", 3)).runApplication();
        }
    }
}

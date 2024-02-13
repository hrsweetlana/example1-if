package ua.javarush.controller;

import ua.javarush.cipher.CaesarCipher;
import ua.javarush.constants.EnglishAlphabet;
import ua.javarush.io.FileService;
import ua.javarush.options.Option;

import java.util.Arrays;

public class ApplicationController {
    private  final FileService fileService;
    private Option option;
    private int passedKey;
    private String filePath;



    public ApplicationController(FileService fileService) {
        this.fileService = fileService;
        //this.caesarCipher = caesarCipher;
    }

    public void runApplication(){
        //caesarCipher.caesarCipherCode("abaabcddzzzz&&&????  ", 3);
        fileService.copyFromSourceToTarget( );
    }

    public static void main(String[] args) {
        if (args.length > 0) {

        }else { //TODO runCLI()
            new ApplicationController(new FileService(32,"c:\\study\\source\\a.txt",new CaesarCipher(Arrays.asList( EnglishAlphabet.ENGLISH_ALPHABET)), Option.ENCRYPT,3)).runApplication();
        }
    }
}

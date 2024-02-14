package ua.javarush.io;

import ua.javarush.cipher.CaesarCipher;
import ua.javarush.options.Option;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCrypter {

    public static final int DEFAULT_BUFFER_CAPACITY = 32;
    private int bufferCapacity;
    private String sourceFileName;
    private CaesarCipher caesarCipher;
    private Option option;
    private int key;

    public FileCrypter(int bufferCapacity, String sourceFileName, CaesarCipher caesarCipher, String option) {
        if (bufferCapacity < 0) {
            throw new IllegalArgumentException("Buffer capacity should be positive value, current value: " + bufferCapacity);
        }
        if (!(isFilePathCorrect(sourceFileName))) {
            throw new IllegalArgumentException("File path is wrong, current value: " + sourceFileName);
        }
        this.bufferCapacity = Math.max(DEFAULT_BUFFER_CAPACITY, bufferCapacity);
        this.sourceFileName = sourceFileName;
        this.caesarCipher = caesarCipher;
        this.key = 0;
        this.option = Option.valueOf(option);
    }
    public FileCrypter(int bufferCapacity, String sourceFileName, CaesarCipher caesarCipher, String option, int key) {
        if (bufferCapacity < 0) {
            throw new IllegalArgumentException("Buffer capacity should be positive value, current value: " + bufferCapacity);
        }
        if (!(isFilePathCorrect(sourceFileName))) {
            throw new IllegalArgumentException("File path is wrong, current value: " + sourceFileName);
        }
        this.bufferCapacity = Math.max(DEFAULT_BUFFER_CAPACITY, bufferCapacity);
        this.sourceFileName = sourceFileName;
        this.caesarCipher = caesarCipher;
        this.key = key;
        this.option = Option.valueOf(option);
    }

    public Option getOption() {
        return option;
    }

    public void identifyOption(Option option){
        if (option == null) {
            //TODO call brute force method

        }
        if(option.equals(Option.DECRYPT)){
            key = -key;
            copyFromSourceToTarget();
        }else if(option.equals(Option.ENCRYPT)){
            copyFromSourceToTarget();
        }
    }
    //TODO refactor with char parameters caesarCipherCode
    private void copyFromSourceToTarget() {
        String targetFileName = createTargetFileName(Path.of(sourceFileName), option);
        try (FileReader inputStream = new FileReader(sourceFileName);
             FileWriter outputStream = new FileWriter(targetFileName)) {
            int numberOfBytes;
            char[] buffer = new char[bufferCapacity];
            while ((numberOfBytes = inputStream.read(buffer)) != -1) {

                System.out.println(new String(buffer, 0, numberOfBytes));
                String text = new String(buffer, 0, numberOfBytes);
                buffer = caesarCipher.caesarCipherCode(text, key);
                outputStream.write(buffer, 0, numberOfBytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isFilePathCorrect(String sourceFileName) {
        System.out.println(sourceFileName);
        return Files.isRegularFile(Path.of(sourceFileName));
    }

    //TODO: at the moment works incorrectly a.txt_ENCRYPT
    private String createTargetFileName(Path path, Option option) {
        return path + "_" + option.name();
        /*      1) "c:\\study\\source\\a.txt" ENCODE      ---> c:\\study\\source\\a_ENCRYPT.txt
                2) "c:\\study\\source\\a.txt" DECODE      ---> c:\\study\\source\\a_DECRYPT.txt
                3) "c:\\study\\source\\a.txt" BRUTE_FORCE ---> c:\\study\\source\\a_BRUTE_FORCE.txt
        */
    }
}

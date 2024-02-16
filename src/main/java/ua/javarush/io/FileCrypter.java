package ua.javarush.io;

import ua.javarush.BruteForce.BruteForceDecription;
import ua.javarush.cipher.CaesarCipher;
import ua.javarush.constants.EnglishAlphabet;
import ua.javarush.constants.EnglishLetterFrequency;
import ua.javarush.options.Option;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileCrypter {

    public static final int DEFAULT_BUFFER_CAPACITY = 32;
    private int bufferCapacity;
    private String sourceFileName;
    private CaesarCipher caesarCipher;
    private BruteForceDecription bruteForceDecription = null;
    private Option option;
    private Map<Character, Double> countedFrequency = new HashMap<>();
    private int key;

    //TODO:refactor constructor not to dublicate code
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
        this.option = Option.valueOf(option);
        this.key = 0;
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
        this.option = Option.valueOf(option);
        this.key = key;

    }

    public Option getOption() {
        return option;
    }

    public void identifyOption(Option option) {
        if (option.equals(Option.BRUTE_FORCE)) {
            //TODO: call brute force method
            System.out.println("BRUTE_FORCE is running......");
            bruteForceDecription = new BruteForceDecription(EnglishLetterFrequency.frequencyMap, countedFrequency, caesarCipher);
            System.out.println(countSourceLetterFrequency());
            System.out.println(countedFrequency);
            System.out.println(bruteForceDecription.findKey());
        }
        if (option.equals(Option.DECRYPT)) {
            key = -key;
            copyFromSourceToTarget();
        } else if (option.equals(Option.ENCRYPT)) {
            copyFromSourceToTarget();
        }
    }



    /*TODO: refactor? is there a sense to create a buffer or use Arrays copy methods
       to avoid crypting null bytes in array
    */
    private void copyFromSourceToTarget() {
        String targetFileName = createTargetFileName(Path.of(sourceFileName), option);
        System.out.println(targetFileName);
        try (FileReader inputStream = new FileReader(sourceFileName);
             FileWriter outputStream = new FileWriter(targetFileName)) {
            int numberOfBytes;
            char[] buffer = new char[bufferCapacity];
            while ((numberOfBytes = inputStream.read(buffer)) != -1) {
                //System.out.println(new String(buffer, 0, numberOfBytes));
                buffer = caesarCipher.caesarCipherCode(buffer, key);
                outputStream.write(buffer, 0, numberOfBytes);
                //System.out.println(new String(buffer, 0, numberOfBytes));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Map countSourceLetterFrequency(){
        try(FileReader fileReader = new FileReader(sourceFileName)){
            int numberOfBytes;
            char[] buffer = new char[DEFAULT_BUFFER_CAPACITY];
            while((numberOfBytes = fileReader.read(buffer))!= -1){
                countedFrequency = bruteForceDecription.countLetterFrequency(buffer);
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return countedFrequency;
    }

    private boolean isFilePathCorrect(String sourceFileName) {
        return Files.isRegularFile(Path.of(sourceFileName));
    }

    /*      1) "c:\\study\\source\\a.txt" ENCODE      ---> c:\\study\\source\\a_ENCRYPT.txt
            2) "c:\\study\\source\\a.txt" DECODE      ---> c:\\study\\source\\a_DECRYPT.txt
            3) "c:\\study\\source\\a.txt" BRUTE_FORCE ---> c:\\study\\source\\a_BRUTE_FORCE.txt
    */
    private String createTargetFileName(Path path, Option option) {
        String folderPath = path.getParent().toString();
        String fileName = path.getFileName().toString();
        int i = fileName.lastIndexOf('.');

        return folderPath + "\\"+ fileName.substring(0, i) + "_" + option + fileName.substring(i, fileName.length());
    }
}

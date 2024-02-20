package ua.javarush.cli;

import ua.javarush.cipher.CaesarCipher;
import ua.javarush.constants.EnglishAlphabet;
import ua.javarush.io.FileCrypter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CLI {
    private static final int BUFFER_CAPACITY = 1024;

    private static String filePath = "";
    private static String option = "";
    private static int key = 0;

    private static FileCrypter fileCrypter;

    public static FileCrypter readParameters() {

        try (BufferedReader buffereReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Choose the desired option for procceding the text:\n [e]ncrypt  [d]ecrypt  [b]rute force");
            option = buffereReader.readLine();
            System.out.println("Type the path to file that has to be crypted:");
            filePath = buffereReader.readLine();
            if (!(option.equals("b")) && !(option.equals("e")) && !(option.equals("d"))) {
                System.out.println("Misspetl. Choose the option once again");
                option = buffereReader.readLine();
            } else if (option.equals("b")) {
                option = "BRUTE_FORCE";
            } else {
                if (option.equals("e")) {
                    option = "ENCRYPT";
                } else if (option.equals("d")) {
                    option = "DECRYPT";
                }
                System.out.println("Type key:");
                key = Integer.parseInt(buffereReader.readLine());
            }
            fileCrypter = new FileCrypter(BUFFER_CAPACITY, option.toString(), new CaesarCipher(Arrays.asList(EnglishAlphabet.ENGLISH_ALPHABET)), filePath, key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileCrypter;
    }
}

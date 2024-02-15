package ua.javarush.BruteForce;

import java.util.*;

public class BruteForceDecription {
    Map letterFrequency;
    List alphabet;
    private Map<Character, Integer> countedFrequency;

    public BruteForceDecription(Map letterFrequency, List alphabet, Map countedFrequency) {
        this.letterFrequency = letterFrequency;
        this.alphabet = alphabet;
        this.countedFrequency = countedFrequency;
    }

    public Map countLetterFrequency(char[] text) {
        //ArrayList alphabet = new ArrayList(Arrays.asList('a', 'b' ,'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p'));

        Character key;
        for (int i = 0; i < text.length; i++) {
            if (alphabet.contains(text[i])) {
                char symbol = Character.toLowerCase(text[i]);
                System.out.println(symbol);
                if (countedFrequency.containsKey(symbol)) {
                    Integer value = countedFrequency.get(symbol);
                    System.out.println("contains value: " + value);
                    countedFrequency.put(symbol, ++value);
                    System.out.println("contains value++: " + countedFrequency.get(symbol));
                } else {
                    Integer value = 0;
                    System.out.println("!contains: " + value);
                    countedFrequency.put(symbol, ++value);
                    System.out.println(countedFrequency);
                    System.out.println("!contains: " + value);
                }
            }
        }
        System.out.println(countedFrequency);
        return countedFrequency;
    }
}

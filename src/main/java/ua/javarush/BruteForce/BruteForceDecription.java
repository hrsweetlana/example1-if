package ua.javarush.BruteForce;

import java.util.*;

public class BruteForceDecription {
    Map letterFrequency;
    List alphabet;
    private static Map sortedLetterFrequency;
    private Map<Character, Integer> countedFrequency;
    private Map<Character, Integer> countedFrequencySearch;

    public BruteForceDecription(Map letterFrequency, List alphabet, Map countedFrequency) {
        this.letterFrequency = letterFrequency;
        this.alphabet = alphabet;
        this.countedFrequency = countedFrequency;
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortLetterFrequency(Map<K, V> map) {

        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list = list.reversed();

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        System.out.println("sortedLetterFrequency:" + result);
        sortedLetterFrequency = result;
        return result;
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
        sortLetterFrequency(countedFrequency);
        System.out.println("sortedMap:" + sortedLetterFrequency);
        return countedFrequency;
    }

    private char findMaxFrequencyLetter(Map<Character, Integer> map){
        countedFrequencySearch = map;
        int max = Collections.max(map.values());
        for(){}
    }

    //private int findKey(){}
    public void checkBruteForceRezult(){}
}

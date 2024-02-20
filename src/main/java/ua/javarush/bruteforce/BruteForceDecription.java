package ua.javarush.bruteforce;

import ua.javarush.cipher.CaesarCipher;
import ua.javarush.constants.EnglishLetterFrequency;

import java.util.*;

public class BruteForceDecription {
    CaesarCipher caesarCipher;
    Map letterFrequency;
    List<Character> alphabet;
    private static Map sortedLetterFrequency;
    private HashMap<Character, Integer> countedFrequency;
    private HashMap<Character, Double> frequencyPercentage = new HashMap<>();
    private HashMap<Character, Double> countedFrequencySearch;

    public BruteForceDecription(HashMap letterFrequency, HashMap countedFrequency, CaesarCipher caesarCipher) {
        this.letterFrequency = letterFrequency;
        this.countedFrequency = countedFrequency;
        this.caesarCipher = caesarCipher;
    }

    //was used while testing to analise letter frequency
    private static <K, V extends Comparable<? super V>> Map<K, V> sortLetterFrequency(Map<K, V> map) {

        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list = list.reversed();

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        sortedLetterFrequency = result;
        return result;
    }

    public Map countLetterFrequency(char[] text) {

        alphabet = caesarCipher.getAlphabet();
        Character key;
        for (int i = 0; i < text.length; i++) {
            if (alphabet.contains(text[i])) {
                char symbol = text[i];
                if (countedFrequency.containsKey(symbol)) {
                    Integer value = countedFrequency.get(symbol);
                    countedFrequency.put(symbol, ++value);
                } else {
                    Integer value = 0;
                    countedFrequency.put(symbol, ++value);
                }
            }
        }
        countedFrequencySearch = letterFrequencyPercentage(countedFrequency);
        return countedFrequency;
    }

    private HashMap<Character, Double> letterFrequencyPercentage(Map<Character, Integer> countedFrequency) {
        for (Map.Entry<Character, Integer> map : countedFrequency.entrySet()) {
            frequencyPercentage.put(map.getKey(), (double) map.getValue() * 100 / countedFrequency.size());
        }
        return frequencyPercentage;
    }

    private char findMaxFrequencyLetter(HashMap<Character, Double> map) {
        countedFrequencySearch = map;
        char c = ' ';
        double max = Collections.max(map.values());
        for (Character key : map.keySet()) {
            Double value = map.get(key);
            if (value.equals(max)) {
                c = key;
            }
        }
        return c;
    }

    private Map<Character, Double> deleteUsedSymbol(HashMap<Character, Double> map, char c) {
        countedFrequencySearch = map;
        countedFrequencySearch.remove(c);
        return countedFrequencySearch;
    }

    public int findKey() {
        char searchedSymbol = findMaxFrequencyLetter(countedFrequencySearch);
        deleteUsedSymbol(countedFrequencySearch, searchedSymbol);
        char ethalonSymbol = findMaxFrequencyLetter((HashMap<Character, Double>) EnglishLetterFrequency.frequencyMap);
        int originalLetterIndex = alphabet.indexOf(searchedSymbol) + 1;
        int etalonLetterIndex = alphabet.indexOf(ethalonSymbol) + 1;
        int key = etalonLetterIndex + originalLetterIndex;
        return key;
    }

    //TODO: implement method for checking if brute_force results were successful, else try with next symbol from statistic map
    public void checkBruteForceResult() {
        throw new UnsupportedOperationException();
    }
}
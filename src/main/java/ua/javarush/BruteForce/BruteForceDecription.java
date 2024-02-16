package ua.javarush.BruteForce;

import ua.javarush.cipher.CaesarCipher;
import ua.javarush.constants.EnglishLetterFrequency;

import java.util.*;

public class BruteForceDecription {
    CaesarCipher caesarCipher;
    Map letterFrequency;
    List<Character> alphabet;
    private static Map sortedLetterFrequency;
    private HashMap<Character, Double> countedFrequency;
    private HashMap<Character, Double> countedFrequencySearch;

    public BruteForceDecription(HashMap letterFrequency, HashMap countedFrequency, CaesarCipher caesarCipher) {
        this.letterFrequency = letterFrequency;
        this.countedFrequency = countedFrequency;
        this.caesarCipher = caesarCipher;
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
        alphabet = caesarCipher.getAlphabet();
        Character key;
        for (int i = 0; i < text.length; i++) {
            if (alphabet.contains(text[i])) {
                char symbol = Character.toLowerCase(text[i]);
                System.out.println(symbol);
                if (countedFrequency.containsKey(symbol)) {
                    Double value = countedFrequency.get(symbol);
                    System.out.println("contains value: " + value);
                    countedFrequency.put(symbol, ++value);
                    System.out.println("contains value++: " + countedFrequency.get(symbol));
                } else {
                    Double value = 0d;
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
        countedFrequencySearch = countedFrequency;
        return countedFrequency;
    }

    private char findMaxFrequencyLetter(HashMap<Character, Double> map) {
        countedFrequencySearch = map;
        char c = ' ';
        double max = Collections.max(map.values());
        for (Character key : map.keySet()) {
            Double value = map.get(key);
            if(value.equals(max)){
                c = key;
                //countedFrequencySearch.remove(key);
            }
        }
        return c;
    }
    private Map<Character, Double> deleteUsedSymbol(HashMap<Character, Double> map, char c){
        countedFrequencySearch = map;
        countedFrequencySearch.remove(c);
        return  countedFrequencySearch;
    }
    public int findKey(){
        char searchedSymbol = findMaxFrequencyLetter(countedFrequencySearch);
        System.out.println("Searched symbol:" + searchedSymbol);
        deleteUsedSymbol(countedFrequencySearch, searchedSymbol);
        char  ethalonSymbol = findMaxFrequencyLetter((HashMap<Character, Double>) EnglishLetterFrequency.frequencyMap);
        System.out.println("Ethalon symbol:" + ethalonSymbol);
        //int	indexOf(Object o)
        int key = searchedSymbol - ethalonSymbol;
        System.out.println("key:" + key);
        return key;
    }
    public void checkBruteForceResult() {

    }
}

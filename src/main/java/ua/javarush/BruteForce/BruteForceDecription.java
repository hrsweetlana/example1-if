package ua.javarush.BruteForce;

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
    private static int countAllLetters=0;

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

        alphabet = caesarCipher.getAlphabet();
        Character key;
        for (int i = 0; i < text.length; i++) {
            if (alphabet.contains(text[i])) {
                char symbol = text[i];
                System.out.println(symbol);
                if (countedFrequency.containsKey(symbol)) {
                    Integer value = countedFrequency.get(symbol);
                    System.out.println("contains value: " + value);
                    countedFrequency.put(symbol, ++value );
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

        countedFrequencySearch = letterFrequencyPercentage(countedFrequency);
        System.out.println("Sorted persantage map: " + sortLetterFrequency(countedFrequencySearch));

        return countedFrequency;
    }

    private HashMap<Character, Double> letterFrequencyPercentage(Map<Character, Integer> countedFrequency){
        for(Map.Entry<Character, Integer> map: countedFrequency.entrySet()){
            frequencyPercentage.put(map.getKey(), (double)map.getValue() * 100 /countedFrequency.size());
        }
        return frequencyPercentage;
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
        System.out.println("Ethalon symbol:" + ethalonSymbol +"!");
        int originalLetterIndex = alphabet.indexOf(searchedSymbol) + 1;
        System.out.println("Original  Letter: "+originalLetterIndex);
        int etalonLetterIndex = alphabet.indexOf(ethalonSymbol) + 1;
        System.out.println("Etalon lLetter: "+etalonLetterIndex);
        int key = etalonLetterIndex + originalLetterIndex;
        System.out.println("key:" + key);
        return key;
    }
    //TODO: implement method for checking if brute_force results were successful, else try with next symbol from statistic map
    public void checkBruteForceResult() {
        throw new UnsupportedOperationException();
    }
}

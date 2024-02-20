package ua.javarush.constants;

import java.util.HashMap;
import java.util.Map;

public class EnglishLetterFrequency {
    public static final Map<Character, Double> frequencyMap = (new HashMap<>() {{
        put(' ', 15.0);
        put('e', 11.1607);
        put('a', 8.4966);
        put('r', 7.5809);
        put('i', 7.5448);
        put('o', 7.1635);
        put('t', 6.9509);
        put('n', 6.6544);
        put('s', 5.7351);
        put('l', 5.4893);
        put('c', 4.5388);
        put('u', 3.6308);
        put('d', 3.3844);
        put('p', 3.1671);
        put('m', 3.0129);
        put('h', 3.0034);
        put('g', 2.4705);
        put('b', 2.0720);
        put('f', 1.8121);
        put('y', 1.7779);
        put('w', 1.2899);
        put('k', 1.1016);
        put('v', 1.0074);
        put('x', 0.2902);
        put('z', 0.2722);
        put('j', 0.1965);
        put('q', 0.1962);
    }});
}


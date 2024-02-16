package ua.javarush.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EnglishLetterFrequency {
    public static final Map<Character, Double> frequencyMap = Collections.unmodifiableMap(new HashMap<>() {{
        put(' ', 15.0);
        put('E', 11.1607);
        put('A', 8.4966);
        put('R', 7.5809);
        put('I', 7.5448);
        put('O', 7.1635);
        put('T', 6.9509);
        put('N', 6.6544);
        put('S', 5.7351);
        put('L', 5.4893);
        put('C', 4.5388);
        put('U', 3.6308);
        put('D', 3.3844);
        put('P', 3.1671);
        put('M', 3.0129);
        put('H', 3.0034);
        put('G', 2.4705);
        put('B', 2.0720);
        put('F', 1.8121);
        put('Y', 1.7779);
        put('W', 1.2899);
        put('K', 1.1016);
        put('V', 1.0074);
        put('X', 0.2902);
        put('Z', 0.2722);
        put('J', 0.1965);
        put('Q', 0.1962);
    }});
}


import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    private static final Map<String, Integer> romanToArabicMap = new HashMap<>();
    private static final Map<Integer, String> arabicToRomanMap = new HashMap<>();

    static {
        romanToArabicMap.put("I", 1);
        romanToArabicMap.put("II", 2);
        romanToArabicMap.put("III", 3);
        romanToArabicMap.put("IV", 4);
        romanToArabicMap.put("V", 5);
        romanToArabicMap.put("VI", 6);
        romanToArabicMap.put("VII", 7);
        romanToArabicMap.put("VIII", 8);
        romanToArabicMap.put("IX", 9);
        romanToArabicMap.put("X", 10);

        arabicToRomanMap.put(1, "I");
        arabicToRomanMap.put(4, "IV");
        arabicToRomanMap.put(5, "V");
        arabicToRomanMap.put(9, "IX");
        arabicToRomanMap.put(10, "X");
    }

    public static boolean isRoman(String value) {
        return romanToArabicMap.containsKey(value);
    }

    public static int romanToArabic(String roman) {
        return romanToArabicMap.get(roman);
    }

    public static String arabicToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {10, 9, 5, 4, 1};
        String[] symbols = {"X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}

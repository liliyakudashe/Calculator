import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static String calc(String input) throws Exception {
        String sanitizedInput = sanitizeInput(input);
        String[] parts = parseInput(sanitizedInput);
        if (parts.length != 3) {
            throw new Exception("Некорректный формат ввода");
        }

        String operand1 = parts[0];
        String operator = parts[1];
        String operand2 = parts[2];

        boolean isRoman = RomanNumerals.isRoman(operand1) && RomanNumerals.isRoman(operand2);
        boolean isArabic = isArabic(operand1) && isArabic(operand2);

        if (!isRoman && !isArabic) {
            throw new Exception("Используются одновременно разные системы счисления");
        }

        int num1;
        int num2;
        if (isRoman) {
            num1 = RomanNumerals.romanToArabic(operand1);
            num2 = RomanNumerals.romanToArabic(operand2);
        } else {
            num1 = Integer.parseInt(operand1);
            num2 = Integer.parseInt(operand2);
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно");
        }

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new Exception("Деление на ноль");
                }
                result = num1 / num2;
                break;
            default:
                throw new Exception("Некорректный оператор");
        }

        if (isRoman) {
            if (result < 1) {
                throw new Exception("Результат римских чисел должен быть положительным");
            }
            return RomanNumerals.arabicToRoman(result);
        } else {
            return Integer.toString(result);
        }
    }

    private static boolean isArabic(String value) {
        try {
            int num = Integer.parseInt(value);
            return num >= 1 && num <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String sanitizeInput(String input) {
        return input.replaceAll("\\s+", "");
    }

    private static String[] parseInput(String input) {
        Pattern pattern = Pattern.compile("(\\d+|[IVXLCDM]+)([+\\-*/])(\\d+|[IVXLCDM]+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return new String[]{matcher.group(1), matcher.group(2), matcher.group(3)};
        } else {
            throw new IllegalArgumentException("Некорректный формат ввода");
        }
    }
}

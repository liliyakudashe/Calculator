import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение (или 'q' для выхода):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Выход из программы.");
                break;
            }
            try {
                String result = Calculator.calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("throws Exception");
            }
            System.out.println("Введите следующее математическое выражение (или 'q' для выхода):");
        }
        scanner.close();
    }
}

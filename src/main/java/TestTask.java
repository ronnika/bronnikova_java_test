import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTask {
    void run() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите номер задания (1-4) или 0 для выхода");
            chooseOption(scan.next());
        }
    }

    private void chooseOption(String option) {
        switch (option) {
            case "1":
                task1();
                break;
            case "2":
                task2();
                break;
            case "3":
                task3();
                break;
            case "4":
                task4();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Неправильная опция");
        }
    }

    private void task1() {
        System.out.println("Task 1. Введите номер");
        Scanner scan = new Scanner(System.in);
        try {
            if (scan.nextInt() > 7) {
                System.out.println("Привет");
            }
        } catch (InputMismatchException e) {
            wrongFormat();
        }
    }

    private void task2() {
        System.out.println("Task 2. Введите имя");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine().strip();
        String correctName = "Вячеслав";
        if (name.equalsIgnoreCase(correctName)) {
            System.out.println("Привет, " + correctName);
        } else {
            System.out.println("Нет такого имени");
        }
    }

    private void task3()  {
        System.out.println("Task 3. Введите массив целых чисел через запятую");
        Scanner scan = new Scanner(System.in);
        String lines = scan.nextLine()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll("\\{", "")
                .replaceAll("}", "");
        try {
            Arrays.stream(lines.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .filter(i -> i % 3 == 0)
                    .forEach(x -> System.out.printf("%s ", x));
        } catch (NumberFormatException e) {
            wrongFormat();
        }
    }

    private void task4() {
        System.out.println("Task 4. \n[((())()(())]] " +
                            "Можно ли считать эту последовательность правильной?");
        System.out.println("Нет, она нарушает формальное определение ПСП, " +
                            "правильной бы была последовательность [((())()(()))] или [[(())()(())]]");
    }

    private static void wrongFormat() {
        System.out.println("Неверный формат числа");
    }
}

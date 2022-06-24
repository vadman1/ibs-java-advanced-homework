package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите номер задания: (1 - калькулятор, 2 - массив строк)");
            switch (reader.readLine()) {
                case "1" -> calculate();
                case "2" -> findLongestWordInArray();
                default -> System.out.println("Номер задания указан некорректно");
            }
        }
    }

    public static void calculate() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Введите первое число: ");
            double num1 = Double.parseDouble(reader.readLine().replace(",", "."));

            System.out.println("Введите второе число: ");
            double num2 = Double.parseDouble(reader.readLine().replace(",", "."));

            System.out.println("Укажите операцию: ");
            String operation = reader.readLine();

            if (operation.equals("/") && num2 == 0) {
                throw new IllegalArgumentException("Деление на ноль не предусмотрено");
            }

            String resultMsg = "Результат вычисления: %.4f";
            switch (operation) {
                case "+" -> System.out.printf(resultMsg, (num1 + num2));
                case "-" -> System.out.printf(resultMsg, (num1 - num2));
                case "*" -> System.out.printf(resultMsg, (num1 * num2));
                case "/" -> System.out.printf(resultMsg, (num1 / num2));
                default -> throw new IllegalArgumentException(String.format("%nОперация указана некорректно: %s" +
                        "%nДопустимые значения: +, -, *, /", operation));
            }
        } catch (NumberFormatException e) {
            System.out.println("Необходимо ввести число");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void findLongestWordInArray() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int arrSize;
            System.out.println("Введите размер массива:");
            while (true) {
                try {
                    arrSize = Integer.parseInt(reader.readLine());
                    if (arrSize <= 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введите число больше нуля");
                }
            }

            String[] words = new String[arrSize];
            int[] countCharsInWord = new int[arrSize];

            System.out.println("Введите слова:");
            for (int i = 0; i < arrSize; i++) {
                words[i] = reader.readLine();
                countCharsInWord[i] = words[i].length();
            }

            int max = 0;
            for (int i = 0; i < arrSize; i++) {
                if(countCharsInWord[i] > max) {
                    max = countCharsInWord[i];
                }
            }

            for (int i = 0; i < arrSize; i++) {
                if (countCharsInWord[i] == max) {
                    System.out.println("Самое длинное слово в массиве: " + words[i]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

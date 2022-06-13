package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс Calculator предназначен для сложения, вычитания, деления, умножения дробных чисел.
 *
 * @author Вадим Самусенко
 */
public class Calculator {

    /**
     * Метод для считывания двух дробных чисел и символа операции.
     * Результат вычисления округляется до 4-х знаков после запятой и выводится в консоль.
     * @throws IllegalArgumentException если второе число равно нулю и выбрана операция деления
     * @throws IllegalArgumentException если операция указана некорректно
     */
    public static void main(String[] args) {
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
}

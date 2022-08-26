package Task4and6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        double num1;
        double num2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите первое число: ");
            num1 = Double.parseDouble(reader.readLine().replace(",", "."));

            System.out.println("Введите второе число: ");
            num2 = Double.parseDouble(reader.readLine().replace(",", "."));

            System.out.println("Укажите операцию: ");
            String operation = reader.readLine();

            Double result = calculator.performCalculations(num1, num2, operation);

            System.out.println("Результат вычисления: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Введено не число!");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Введён некорректный знак!");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка при делении на ноль!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

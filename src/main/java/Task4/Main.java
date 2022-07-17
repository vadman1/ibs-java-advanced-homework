package Task4;

public class Main {

    public static void main(String[] args) {
        double num1 = 2;
        double num2 = 3;

        Calculator calculator = new Calculator();
        // вывод незаполенных полей
        calculator.getFirstNumber();
        calculator.getSecondNumber();
        calculator.printResult();

        System.out.println(calculator.performCalculations(num1, num2, "+"));
        System.out.println(calculator.getFirstNumber());
        System.out.println(calculator.getSecondNumber());
        calculator.printResult();
        calculator.performCalculations(num1, num2, "-");
        calculator.printResult();
        calculator.performCalculations(num1, num2, "*");
        calculator.printResult();
        calculator.performCalculations(num1, num2, "/");
        calculator.printResult();

        num2 = 0;
        calculator.performCalculations(num1, num2, "=");
        calculator.printResult();

        num2 = 0;
        calculator.performCalculations(num1, num2, "/");
        calculator.printResult();
    }
}

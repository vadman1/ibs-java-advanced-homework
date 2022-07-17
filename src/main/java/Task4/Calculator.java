package Task4;

public class Calculator implements CalculatorInterface {

    protected Double firstNumber = null;
    protected Double secondNumber = null;
    protected String operation = null;
    protected Double result = null;
    protected String errorMessage = "Значение не заполнено";

    public Double getFirstNumber() {
        if (firstNumber == null)
            System.out.println(errorMessage);
        return firstNumber;
    }

    public Double getSecondNumber() {
        if (secondNumber == null)
            System.out.println(errorMessage);
        return secondNumber;
    }

    public String getOperation() {
        if (operation == null)
            System.out.println(errorMessage);
        return operation;
    }

    @Override
    public Double performCalculations(Double firstNumber, Double secondNumber, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;

        switch (operation) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber == 0)
                    throw new ArithmeticException("Деление на ноль недоступно");
                result = firstNumber / secondNumber;
            }
            default -> throw new IllegalArgumentException("Введена некорректная операция вычисления");
        }

        return result;
    }

    @Override
    public void printResult() {
        if (result == null) {
            System.out.println(errorMessage);
        } else {
            System.out.println("Результат вычисления: " + result);
        }
    }
}

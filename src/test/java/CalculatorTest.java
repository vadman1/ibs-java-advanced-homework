import Task4and6.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private static Calculator calculator;
    private final Double firstNumber = 10.0;
    private final Double secondNumber = 4.0;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    void performCalculations() {
        Assertions.assertAll(
                () -> assertEquals(firstNumber + secondNumber, calculator.performCalculations(firstNumber, secondNumber, "+"), "Некорректная операция сложения"),
                () -> assertEquals(firstNumber * secondNumber, calculator.performCalculations(firstNumber, secondNumber, "*"), "Некорректная операция умножения"),
                () -> assertEquals(firstNumber - secondNumber, calculator.performCalculations(firstNumber, secondNumber, "-"), "Некорректная операция вычитания"),
                () -> assertEquals(firstNumber / secondNumber, calculator.performCalculations(firstNumber, secondNumber, "/"), "Некорректная операция деления")
        );
    }

    @Test
    void checkForExceptions() {
        Assertions.assertAll(
                () -> assertThrows(ArithmeticException.class, () -> calculator.performCalculations(firstNumber, 0.0, "/")),
                () -> assertThrows(IllegalArgumentException.class, () -> calculator.performCalculations(firstNumber, secondNumber, "="))
        );
    }

}

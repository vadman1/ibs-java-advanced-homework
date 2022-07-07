package Task3.one;

import java.util.Arrays;
import java.util.Random;

public class Task3_1 {

    public static void main(String[] args) {

        int[] array = new Random().ints(20, -10, 11).toArray();
        System.out.println("Массив:");
        System.out.println(Arrays.toString(array));

        int maxNegativeNumber = Arrays.stream(array).filter(i -> i < 0).max().orElseThrow();
        int minPositiveNumber = Arrays.stream(array).filter(i -> i > 0).min().orElseThrow();

        System.out.println("Максимальный отрицательный элемент: " + maxNegativeNumber);
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxNegativeNumber) {
                index = i;
                array[i] = minPositiveNumber;
                break;
            }
        }
        System.out.println("Замена первого максимального отрицательного элемента на минимальный положительный:");
        System.out.println(Arrays.toString(array));

        System.out.println("Минимальный положительный элемент: " + minPositiveNumber);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == minPositiveNumber && i != index) {
                array[i] = maxNegativeNumber;
                break;
            }
        }
        System.out.println("Замена первого минимального положительного элемента на максимальный отрицательный:");
        System.out.println(Arrays.toString(array));
    }
}

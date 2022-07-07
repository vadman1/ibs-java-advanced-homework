package Task3.two;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Candy candy = new Candy("candy", 1.0, 63.0, "apple");
        Jellybean jellybean = new Jellybean("jellybean",0.8, 100.0, "strawberry");

        AbstractSweet[] sweets = {candy, jellybean};

        System.out.println("Общий вес подарка : " + Arrays.stream(sweets).mapToDouble(AbstractSweet::getWeight).sum());
        System.out.println("Общая стоимость подарка : " + Arrays.stream(sweets).mapToDouble(AbstractSweet::getPrice).sum());
        System.out.println(Arrays.toString(sweets));
    }
}

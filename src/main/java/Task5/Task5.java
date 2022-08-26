package Task5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        Map<String, Integer> words = new TreeMap<>();

        try(Stream<String> stream = Files.lines(Paths.get("src/main/java/Task5/text.txt"), StandardCharsets.UTF_8)) {
            stream.forEach(line -> Arrays.asList(line.toLowerCase(Locale.ROOT).split(" "))
                    .forEach(word -> words.merge(word, 1, Integer::sum)));

            words.forEach((k,v) -> System.out.println("Слово '" + k + "' встречается в файле в таком количестве: " + v));

            String wordMaxRepeat = Collections.max(words.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            System.out.println("\nСлово с максимальным количеством повторений : " + wordMaxRepeat + "\nКоличество повторений: "+ words.get(wordMaxRepeat));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

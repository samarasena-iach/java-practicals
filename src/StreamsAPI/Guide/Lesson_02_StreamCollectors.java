package StreamsAPI.Guide;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson_02_StreamCollectors {

    /**
     * After performing the intermediate operations on elements in the stream, we can collect the
     * processed elements again into a Collection using the stream Collector methods.
     */

    public static void main(String[] args) {
        Collect_Stream_Elements_To_A_List();
        Collect_Stream_Elements_To_An_Array();
    }

    static void Collect_Stream_Elements_To_A_List() {
        // In the given example, first, we create a stream on integers 1 to 10.
        // Then we process the stream elements to find all even numbers.
        // At last, we are collecting all even numbers into a List.

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream();

        List<Integer> evenNumbersList = stream
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.print(evenNumbersList);
    }

    static void Collect_Stream_Elements_To_An_Array() {
        // The given example is similar to the first example shown above.
        // The only difference is that we are collecting even numbers in an Array.

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream();
        Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersArr);

        // There are plenty of other ways also to collect stream into a Set, Map or into multiple ways.
        // Just go through Collectors class and try to keep them in mind.
    }
}

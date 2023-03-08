package StreamsAPI.Guide_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lesson_01_CreatingStreams {

    /**
     * The given below ways are the most popular different ways to build streams from collections.
     */

    public static void main(String[] args) {
        Method_01_StreamOf();
        Method_02_StreamOfArray();
        Method_03_ListStream();
        Method_04_StreamGenerate_StreamIterate();
        Method_05_StreamOfStringChars_Or_Tokens();
    }

    static void Method_01_StreamOf() {
        // O1 - Stream.of()
        // In the given example, we are creating a stream of a fixed number of integers.

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(p -> System.out.println(p));
    }

    static void Method_02_StreamOfArray() {
        // 02 - Stream.of(array)
        // In the given example, we are creating a stream from the array.
        // The elements in the stream are taken from the array.

        Stream<Integer> stream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        stream.forEach(p -> System.out.println(p));
    }

    static void Method_03_ListStream() {
        // 03 - List.stream()
        // In the given example, we are creating a stream from the List.
        // The elements in the stream are taken from the List.

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream();
        stream.forEach(p -> System.out.println(p));
    }

    static void Method_04_StreamGenerate_StreamIterate() {
        // 04 - Stream.generate() or Stream.iterate()
        // In the given example, we are creating a stream from generated elements.
        // This will produce a stream of 20 random numbers.
        // We have restricted the elements count using limit() function.

        Stream<Integer> randomNumbers = Stream
                .generate(() -> (new Random()).nextInt(100));

        randomNumbers.limit(20).forEach(System.out::println);
    }

    static void Method_05_StreamOfStringChars_Or_Tokens() {
        // 05 - Stream of String chars or tokens
        // In the given example, first, we create a stream from the characters of a given string.
        // In the second part, we are creating the stream of tokens received from splitting from a string.

        IntStream stream01 = "12345_abcdefg".chars();
        stream01.forEach(p -> System.out.println(p));

        //OR

        Stream<String> stream02 = Stream.of("A$B$C".split("\\$"));
        stream02.forEach(p -> System.out.println(p));
    }
}

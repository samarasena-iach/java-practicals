package StreamsAPI.Guide;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lesson_03_StreamOperations {

    private static List<String> memberNames;

    /**
     * Stream abstraction has a long list of useful functions. Let us look at a few of them.
     * We will build our examples on this list so that it is easy to relate and understand.
     */

    public static void main(String[] args) {
        // Before moving ahead, let us build a List of strings beforehand.
        memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        StreamFilter();
        StreamMap();
        StreamSorted();

        StreamForEach();
        StreamCollect();
        StreamMatch();
        StreamCount();
        StreamReduce();
    }

    // These core methods have been divided into 2 parts given below:

    // 01. Intermediate Operations
    // Intermediate operations return the stream itself so you can chain multiple methods calls in a row.
    // Let’s learn important ones.

    static void StreamFilter() {
        // The filter() method accepts a Predicate to filter all elements of the stream.
        // This operation is intermediate, enabling us to call another stream operation (e.g. forEach()) on the result.

        memberNames
                .stream()
                .filter((s) -> s.startsWith("A"))
                .forEach(System.out::println);
    }

    static void StreamMap() {
        // The map() intermediate operation converts each element in the stream into another object via the given function.
        // The following example converts each string into an UPPERCASE string.
        // But we can use map() to transform an object into another type as well.

        memberNames
                .stream()
                .filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    static void StreamSorted() {
        // The sorted() method is an intermediate operation that returns a sorted view of the stream.
        // The elements in the stream are sorted in natural order unless we pass a custom Comparator.

        memberNames
                .stream()
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Please note that the sorted() method only creates a sorted view of the stream without
        // manipulating the ordering of the source Collection.

        // In this example, the ordering of string in the memberNames is untouched.
    }

    // 02. Terminal operations
    // Terminal operations return a result of a certain type after processing all the stream elements.
    // Once the terminal operation is invoked on a Stream, the iteration of the Stream and any of the chained streams will get started.
    // Once the iteration is done, the result of the terminal operation is returned.

    static void StreamForEach() {
        // The forEach() method helps iterate over all stream elements and perform some operation on each of them.
        // The operation to be performed is passed as the lambda expression.

        memberNames.forEach(System.out::println);
    }

    static void StreamCollect() {
        // The collect() method is used to receive elements from steam and store them in a collection.

        List<String> memNamesInUppercase = memberNames
                .stream()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.print(memNamesInUppercase);
    }

    static void StreamMatch() {
        // Various matching operations can be used to check whether a given predicate matches the stream elements.
        // All of these matching operations are terminal and return a boolean result.

        boolean matchedResult = memberNames
                .stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);     //true

        matchedResult = memberNames
                .stream()
                .allMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);     //false

        matchedResult = memberNames
                .stream()
                .noneMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);     //false
    }

    static void StreamCount() {
        // The count() is a terminal operation returning the number of elements in the stream as a long value.

        long totalMatched = memberNames
                .stream()
                .filter((s) -> s.startsWith("A"))
                .count();

        System.out.println(totalMatched);     //2
    }

    static void StreamReduce() {
        // The reduce() method performs a reduction on the elements of the stream with the given function.
        // The result is an Optional holding the reduced value.
        // In the given example, we are reducing all the strings by concatenating them using a separator #.

        Optional<String> reduced = memberNames.stream()
                .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
    }

}

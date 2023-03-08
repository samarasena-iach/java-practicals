package StreamsAPI.Guide;

import java.util.ArrayList;
import java.util.List;

public class Lesson_04_ShortCircuitOperations {

    private static List<String> memberNames;

    /**
     * Though stream operations are performed on all elements inside a collection satisfying a
     * Predicate, it is often desired to break the operation whenever a matching element is
     * encountered during iteration.
     * <p>
     * In external iteration, we will do with the if-else block.
     * In the internal iterations such as in streams, there are certain methods we can use for this purpose.
     */

    public static void main(String[] args) {
        // We'll use the same List of strings that we used in the Lesson 03
        memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        StreamAnyMatch();
        StreamFindFirst();
    }

    static void StreamAnyMatch() {
        // The anyMatch() will return true once a condition passed as predicate satisfies.
        // Once a matching value is found, no more elements will be processed in the stream.
        // In the given example, as soon as a String is found starting with the letter 'A', the
        // stream will end and the result will be returned.

        boolean matched = memberNames
                .stream()
                .anyMatch((s) -> s.startsWith("A"));

        System.out.println(matched);    //true
    }

    static void StreamFindFirst() {
        // The findFirst() method will return the first element from the stream and then it will not process
        // any more elements.

        String firstMatchedName = memberNames
                .stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst()
                .get();

        System.out.println(firstMatchedName);    //Lokesh
    }

}

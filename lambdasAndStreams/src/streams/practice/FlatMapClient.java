package streams.practice;

import java.util.Arrays;
import java.util.List;

public class FlatMapClient {
    public static void main(String[] args) {

        // ================================================================
        // flatmap

//        List<List<Integer>> numbers = List.of(
//                List.of(10, 20, 30),
//                List.of(40, 50),
//                List.of(60, 70, 80)
//        );
//
//
          // map() would produce Stream<Stream<Integer>>
          // flatMap() produces a single flattened Stream<Integer>
//
//
//
//        // print all numbers using flatMap().
//        numbers.stream()
//                .flatMap(nums -> nums.stream())
//                .forEach(System.out::println);
//
//        System.out.println("------------------------");
//
//
//
//
//        // print only numbers greater than 30.
//        numbers.stream()
//                .flatMap(x -> x.stream())
//                .filter(x -> x > 30)
//                .forEach(System.out::println);
//
//        System.out.println("------------------------");

        // ================================================================
//        List<String> sentences = List.of(
//                "Java is powerful",
//                "Streams are useful",
//                "Lambda is concise"
//        );
//
//        // we want individual strings
//        sentences.stream()
//                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
//                .forEach(System.out::println);

        // ================================================================

        List<List<Integer>> numbers = List.of(
                List.of(10, 20, 10),
                List.of(30, 20, 40),
                List.of(50, 40, 60)
        );

        System.out.println("--------------------------");



        // unique numbers sorted ascending
        numbers.stream()
                .flatMap(x -> x.stream())
                .sorted()
                .distinct()
                .forEach(System.out::println);

        System.out.println("--------------------------");
        // ================================================================
        List<String> sentences = List.of(
                "Java is powerful",
                "Java streams are powerful",
                "Lambda is concise"
        );

        // print every individual word.
        sentences.stream()
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .forEach(System.out::println);

        System.out.println("----------------------------");



        // unique words
        sentences.stream()
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .distinct()
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        // ================================================================

        // ================================================================

        // ================================================================

        // ================================================================
    }
}

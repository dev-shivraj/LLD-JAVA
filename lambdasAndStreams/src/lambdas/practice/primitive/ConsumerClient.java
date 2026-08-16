package lambdas.practice.primitive;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class ConsumerClient {
    public static void main(String[] args) {

        // =======================================================================

//        Consumer<Integer> printer = x -> System.out.println(x);
//        IntConsumer printer1 = System.out::println;
//
//        printer.accept(10);
//        printer1.accept(10);


        // =======================================================================

        IntConsumer squarePrinter = x -> System.out.println(x * x);
        squarePrinter.accept(10);


        // =======================================================================

    }
}
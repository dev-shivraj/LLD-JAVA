package lambdas.practice.primitive;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class FunctionClient {
    public static void main(String[] args) {

        // =======================================================================

        Function<Integer, String> converter = x -> "Number: " + x;
        IntFunction<String> converter1 = x -> "Number: " + x;
        IntFunction<Integer> square = x -> x * x;

        System.out.println(converter.apply(10));
        System.out.println(converter1.apply(10));
        System.out.println(square.apply(10));




        // =======================================================================


        // =======================================================================
    }
}
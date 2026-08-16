package lambdas.practice.primitive;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateClient {
    public static void main(String[] args) {

        // =======================================================================

//        Predicate<Integer> isEven = number -> number % 2 == 0;
//        IntPredicate isEvenPrimitive = number -> number % 2 == 0;
//
//        System.out.println(isEven.test(10));
//        System.out.println(isEvenPrimitive.test(10));

        // =======================================================================

        IntPredicate isEven = x -> x % 2 == 0;
        IntPredicate isOdd = x -> x % 2 != 0;
        IntPredicate isPositive = x -> x > 0;
        IntPredicate isNegative = x -> x < 0;
        IntPredicate isZero = x -> x == 0;
        IntPredicate greaterThan100 = x -> x > 100;

        System.out.println(isEven.test(10));
        System.out.println(isEven.test(11));

        System.out.println("-----------------");

        System.out.println(isOdd.test(11));
        System.out.println(isOdd.test(10));

        System.out.println("-----------------");

        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-10));

        System.out.println("-----------------");

        System.out.println(isNegative.test(-10));
        System.out.println(isNegative.test(10));

        System.out.println("-----------------");

        System.out.println(isZero.test(0));
        System.out.println(isZero.test(10));

        System.out.println("-----------------");

        System.out.println(greaterThan100.test(200));
        System.out.println(greaterThan100.test(10));

        System.out.println("-----------------");


        // =======================================================================


        // =======================================================================


        // =======================================================================
    }
}
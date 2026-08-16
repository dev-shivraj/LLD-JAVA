package lambdas.practice.primitive;

import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierClient {
    public static void main(String[] args) {

        // =======================================================================

        Supplier<Integer> supplier = () -> 10;
        IntSupplier supplier1 = () -> 10;
        IntSupplier randomNumber = () -> (int) (Math.random() * 100);

        System.out.println(supplier.get());
        System.out.println(supplier1.getAsInt());
        System.out.println(randomNumber.getAsInt());




        // =======================================================================


        // =======================================================================
    }
}
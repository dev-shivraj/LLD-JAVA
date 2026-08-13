package lambdas;

/*
    Functional Interface : interface with only one abstract method.
    It can have multiple default or static methods.
    It can be used as the assignment target for a lambda expression or method reference.

    example of functional interface:
        Runnable: having only one abstract method run()
        Callable: having only one abstract method call()
        Comparable: having only one abstract method compareTo()
        Comparator: having only one abstract method compare()

        Consumer: having only one abstract method accept()
        Supplier: having only one abstract method get()
        Function: having only one abstract method apply()
        Predicate: having only one abstract method test()
 */
/*
    here we are defining our own functional interface, which will have only one abstract method calculate,
    we need to write @FunctionalInterface annotation to tell the compiler that this is a functional interface,
    and if we try to add another abstract method to this interface, then compiler will give an error, because it will violate the rule of functional interface.

    this @FunctionalInterface annotation is optional, but it is a good practice to use it,
    because it will help us to avoid mistakes,
    and it will also help the compiler to check if the interface is a functional interface or not.
 */
@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b, int c);

    // it will give compile time error if we try to add another abstract method to this interface, because it will violate the rule of functional interface.
    // it is throwing compile time error because we have used @FunctionalInterface annotation, which tells the compiler that this is a functional interface, and it should have only one abstract method.
    /*
        int perform(int a, int b) {
            return a + b;
        }
     */
}

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
    Lambda : A single line way of defining the method of a functional interface.
        It is a block of code that can be passed around and executed later.
        It can be used to provide the implementation of the abstract method of a functional interface.
        It can be used to create anonymous classes.
        It can be used to create instances of functional interfaces with a single abstract method.
 */
public class Client {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
    }
}

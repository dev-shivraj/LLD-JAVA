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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Lambda : A single line way of defining the method of a functional interface.
        It is a block of code that can be passed around and executed later.
        It can be used to provide the implementation of the abstract method of a functional interface.
        It can be used to create anonymous classes.
        It can be used to create instances of functional interfaces with a single abstract method.
 */
public class Client {
    public static void main(String[] args) {

        /*
            Task task = new Task();
            Thread thread = new Thread(task);
            thread.start();
         */

        /*
            here printing something inside run method is not a big task,
            and we are going to use it only once or similar kind of things at certain place, so
            just creating a separate class for it is not a good idea, so
            we can use lambda expression to implement the run method of Runnable interface,
            and we can pass it to the Thread constructor, so that we don't have to create a separate class for it.

            so if the task is simple, and we feel that if we are going to use it only one or two places
            then we can use lambda expression to implement the same and avoid creating a separate class for it.
         */


        Runnable task = () -> {
            /*
                here bracket represents the body of the run method,
                and we can write the code inside it, which will be executed when the thread is started.
                and Runnable represents the Class name here.
                here function doesn't accept any parameter of run method, so we don't have to pass any parameter to it.
             */
            System.out.println("Task is running");
            // here we are not returning anything because run method doesn't return anything, so we don't have to return anything from it.
        };

        Thread thread = new Thread(task);
        thread.start();

        /*
            why lambda works on functional interface only?
            because functional interface has only one abstract method,
            so the compiler can infer the type of the lambda expression based on the context in which it is used.

            and if the interface has more than one abstract method
            then the compiler cannot be sure that which function of the interface is being implemented by the lambda expression,
            so it will throw an error, and we cannot use lambda expression to implement the interface with more than one abstract method.
         */


        /*
            where to use lambda expression?
            1. when we have a simple onetime case throwaway implementation of a functional interface with a single abstract method, we can use lambda expression to implement it.
            2. when we have to pass a block of code as an argument to a method
            3. when we have to create an anonymous class with a single abstract method.
         */


        /*
            lambda function to return anything from it,
            we can use the functional interface with a single abstract method which returns something,
            and we can use lambda expression to implement it.
         */

        List<Integer> numbers = Arrays.asList(2, 4, -3, -5, 1);
        // we want to sort this list based on square of the numbers in it
        // result : [1, 2, -3, 4, -5]

        // we can write it without lambda expression also :
        /*
            Collections.sort(numbers, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1 * o1, o2 * o2);
                }
            });
            System.out.println(numbers);
         */


        // but it would be easier to write it using lambda expression
        // here it takes lambda expression : bracket represents the compare method of Comparator interface,
        // and it takes two parameters x and y, which are the two numbers to be compared,
        // and it returns the difference of their squares.
        // it's just an implementation of compare method of Comparator interface, which is a functional interface with a single abstract method compare.
        Collections.sort(numbers, (x, y) -> {
            return x * x - y * y;
        });

        System.out.println(numbers);
    }
}

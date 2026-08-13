import java.util.Scanner;

/*
    in life there is two type of problem :
        1. Problems that can be solved with effort and persistence: that is in our control
        2. Problems that cannot be solved with effort and persistence: that is not in our control

    Similar to the above, there are two types of Things in Java :
    Exceptions and Errors:
    Exceptions : we can handle them through the code

    Errors : we cannot handle them through the code

    Exceptions :
        compile time exception and
        run time exception

    Example :
    Compile time exception : suppose if we miss any semicolon or any curly brace, the code will not compile
    Run time exception : suppose if we try to divide a number by zero, the code will compile but it will throw an error at run time

    Runtime Exceptions :
        divide by zero,
        null pointer exception,
        array index out of bounds exception,
        class cast exception,
        number format exception,
        illegal argument exception,
        illegal state exception,
        unsupported operation exception, etc.



 */
public class Client {
    public static void main(String[] args) {
        // two types of exceptions in java
        // 1. compile time exception
        // 2. run time exception


        // if we forget any curly brace or anything like that, the code will not compile and we will get an error message
        // this is called compilation time exception

        // if we try to divide a number by zero, we will get an error message
        // this is called run time exception
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        // exception in thread main java.lang.ArithmeticException: / by zero
        // this is run time exception
        System.out.println("Result: " + (x / y));


    }
}

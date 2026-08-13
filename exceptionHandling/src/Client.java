import java.io.FileReader;
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


    =========   Unchecked Exceptions and Checked Exceptions ==========

    Many people think that checked exceptions are compile time exceptions and unchecked exceptions are run time exceptions, but this is not true.



    Unchecked exceptions :
        Java doesn't enforce them.
        for example, if we try to divide a number by zero,
        java doesn't force us to handle it to put inside try catch block,
        it's our responsibility to handle it.
        JVM doesn't care about it, it will throw an error at run time.
        We need to handle it ourselves.
        and when it comes to handle it ourself, it means java doesn't force us to handle it, they don't force to put try catch block.
        it is logical errors, and programmer's responsibility to handle it.
        eg: divide by zero, null pointer exception, array index out of bounds exception, class cast exception, number format exception, illegal argument exception, illegal state exception, unsupported operation exception, etc.
        try catch block is optional for unchecked exceptions

    Checked exceptions :
        Java enforces them: mandatory to handle them.
        for example, if we try to read a file
        java forces us to handle it to put inside try catch block,
        because it may be scenario that the file is not present in the system, so java forces us to handle it.
        eg: db connections, sql queries, file handling, etc.
        try catch block is mandatory for checked exceptions

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

        System.out.print("Enter another number: ");
        int y = scanner.nextInt();

        // exception in thread main java.lang.ArithmeticException: / by zero
        // this is run time exception
        System.out.println("Result: " + (x / y));


        // it is checked exception because java forces us to handle it, if we don't handle it, we will get an error message
        // so surround it with try catch block
        try {
            FileReader fileReader = new FileReader("test.txt");
        } catch (Exception e) {
            System.out.println("File not found");
        }

    }
}

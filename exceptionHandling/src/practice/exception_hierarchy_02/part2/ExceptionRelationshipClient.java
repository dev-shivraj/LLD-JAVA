package practice.exception_hierarchy_02.part2;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionRelationshipClient {
    static void main(String[] args) {
        // ==============================================================================

//        ArithmeticException arithmeticException = new ArithmeticException();
//        NullPointerException nullPointerException = new NullPointerException();
//        IOException ioException = new IOException();
//        RuntimeException runtimeException = new RuntimeException();
//        Exception exception = new Exception();
//        Error error = new Error();

        // ==============================================================================

        Exception exception = new ArithmeticException();
        Throwable throwable = new ArithmeticException();
        RuntimeException runtimeException = new ArithmeticException();

        Exception exception1 = new IOException();
        // RuntimeException runtimeException1 = new IOException();

        Exception error = new RuntimeException();
        // Error error1 = new RuntimeException();

        // ==============================================================================


        Throwable throwable1 = new Exception();
        Throwable throwable3 = new RuntimeException();
        Throwable throwable4 = new IOException();
        Throwable throwable5 = new SQLException();
        Throwable throwable6 = new ArithmeticException();
        Throwable throwable7 = new NullPointerException();
        Throwable throwable8 = new ClassCastException();
        Throwable throwable9 = new NullPointerException();
        Throwable throwable10 = new IllegalArgumentException();
        Throwable throwable11 = new ArrayIndexOutOfBoundsException();

        Throwable throwable12 = new Error();
        Throwable throwable13 = new StackOverflowError();
        Error error1 = new Error();
        Error error2 = new StackOverflowError();
        // Error error3 = new RuntimeException();


        RuntimeException runtimeException1 = new RuntimeException();
        RuntimeException runtimeException2 = new ArithmeticException();
        RuntimeException runtimeException3 = new NullPointerException();
        RuntimeException runtimeException4 = new IllegalArgumentException();


        IOException ioException = new IOException();
        // RuntimeException runtimeException5 = new IOException();
        // RuntimeException runtimeException6 = new SQLException();

        Object object = new Exception();
        Object object1 = new Throwable();
        Object object2 = new Exception();
        Object object3 = new Error();
        Object object4 = new RuntimeException();
        Object object5 = new IOException();
        Object object6 = new SQLException();
        Object object7 = new ArithmeticException();
        Object object8 = new NullPointerException();
        Object object9 = new ClassCastException();
        Object object10 = new ArrayIndexOutOfBoundsException();

        // ==============================================================================
    }
}

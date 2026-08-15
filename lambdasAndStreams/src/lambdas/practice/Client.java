package lambdas.practice;

import lambdas.practice.impl.MyTask;
import lambdas.practice.interfaces.*;
import lambdas.practice.impl.MyCalculator;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // =====================================================

//        Task task = new MyTask();
//        task.execute();
//
//
//        // anonymous class implementation
//        Task t = new Task() {
//            @Override
//            public void execute() {
//                System.out.println("Task Executed");
//            }
//        };
//
//        t.execute();
//
//        // first lambda
//        Task task1 = () -> {
//            System.out.println("Task executed with Lambda");
//        };
//        task1.execute();
//
//        Task task2 = () -> {
//            System.out.println("Task Executed");
//        };
//        task2.execute();
//
//        task2.log();
//        Task.info();
        // =====================================================


//        Calculator calculator = new Calculator() {
//            @Override
//            public int calculate(int a, int b) {
//                return a + b;
//            }
//        };
//
//        System.out.println(calculator.calculate(4, 5));
//        System.out.println(calculator.calculate(4, 50));
//        System.out.println(calculator.calculate(40, 50));
//
//        Calculator calculator1 = new MyCalculator() {
//            @Override
//            public int calculate(int a, int b) {
//                return a + b;
//            }
//        };
//        System.out.println(calculator1.calculate(4, 5));
//
//        Calculator calculator2 = (int a, int b) -> a + b;
//        System.out.println(calculator2.calculate(4, 2));


        // =====================================================
        // lambda taking one parameter
//        Printer printer1 = new Printer() {
//            public void print(String msg) {
//                System.out.println(msg);
//            }
//        };
//
//        printer1.print("HELLO WORLD!");
//        printer1.print("HELLO WORLD AGAIN!");
//
//        Printer printer = (msg) -> {
//            System.out.println(msg);
//        };
//
//        printer.print("Hello Shivraj!");
//        printer.print("Hello Shivraj Again!");


        // =====================================================
        // lambda returning a value
//        Square square = (num) -> num * num;
//        System.out.println(square.calculate(4));
//        System.out.println(square.calculate(1));
//        System.out.println(square.calculate(5));
//
//        // multiple statement
//        Square square1 = (num) -> {
//            int res = num * num;
//            return res;
//        };
//
//        System.out.println(square1.calculate(10));
//        System.out.println(square1.calculate(20));


        // ================ practices =================
        // =====================================================
//        Greeting greeting = (msg) -> {
//            System.out.println(msg);
//        };
//
//        greeting.greet("Hello Shivraj!");
//
//        System.out.println("--------------------------------------------------");
//
//
//        // addition
//        Calculator adder = (a, b) -> a + b;
//        Calculator subtractor = (a, b) -> a - b;
//        Calculator multiplier = (a, b) -> a * b;
//        Calculator dividor = (a, b) -> a / b;
//
//        System.out.println(adder.calculate(10, 4));
//        System.out.println(subtractor.calculate(10, 4));
//        System.out.println(multiplier.calculate(10, 4));
//        System.out.println(dividor.calculate(10, 4));
//        System.out.println("--------------------------------------------------");
//
//        // without lambda, it would be more difficult
//        Calculator adder1 = new Calculator() {
//            @Override
//            public int calculate(int a, int b) {
//                return a + b;
//            }
//        };
//        Calculator subtractor1 = new Calculator() {
//            @Override
//            public int calculate(int a, int b) {
//                return a - b;
//            }
//        };
//        Calculator multiplier1 = new Calculator() {
//            @Override
//            public int calculate(int a, int b) {
//                return a * b;
//            }
//        };
//        Calculator dividor1 = new Calculator() {
//            @Override
//            public int calculate(int a, int b) {
//                return a / b;
//            }
//        };
//
//
//        System.out.println(adder1.calculate(10, 4));
//        System.out.println(subtractor1.calculate(10, 4));
//        System.out.println(multiplier1.calculate(10, 4));
//        System.out.println(dividor1.calculate(10, 4));
//
//        System.out.println("--------------------------------------------------");


        // =====================================================

//        NumberChecker isEven = (num) -> num % 2 == 0;
//        NumberChecker isOdd = (num) -> num % 2 != 0;
//        NumberChecker isPositive = (num) -> num > 0;
//        NumberChecker isNegative = (num) -> num < 0;
//        NumberChecker isZero = (num) -> num == 0;
//
//        System.out.println(isEven.check(5));
//        System.out.println(isEven.check(10));
//
//        System.out.println("--------------------------------------------------");
//
//        System.out.println(isOdd.check(5));
//        System.out.println(isOdd.check(50));
//
//        System.out.println("--------------------------------------------------");
//
//        System.out.println(isPositive.check(10));
//        System.out.println(isPositive.check(-10));
//
//        System.out.println("--------------------------------------------------");
//
//        System.out.println(isNegative.check(-5));
//        System.out.println(isNegative.check(5));
//
//        System.out.println("--------------------------------------------------");
//
//        System.out.println(isZero.check(0));
//        System.out.println(isZero.check(60));
//
//        System.out.println("--------------------------------------------------");

        // =====================================================

//        StringProcessor upppercase = (str) -> str.toUpperCase();
//        StringProcessor lowercase = (str) -> str.toLowerCase();
//        StringProcessor reverse = (str) ->  new StringBuilder(str).reverse().toString();
//        StringProcessor helloString = (str) -> "Hello " + str;
//        StringProcessor firstChar = (str) -> str.substring(0, 1);
//
//        System.out.println(upppercase.process("Shivraj"));
//        System.out.println(lowercase.process("Shivraj"));
//        System.out.println(reverse.process("Shivraj"));
//        System.out.println(helloString.process("Shivraj"));
//        System.out.println(firstChar.process("Shivraj"));


        // =====================================================


//        calculate(10, 5, (x, y) -> x + y);
//        calculate(10, 5, (x, y) -> x - y);
//        calculate(10, 5, (x, y) -> x * y);

        // =====================================================


//        int add = perform(10, 4, (a, b) -> a + b);
//        int subtract = perform(10, 4, (a, b) -> a - b);
//        int multiply = perform(10, 4, (a, b) -> a * b);
//        int divide = perform(10, 4, (a, b) -> a / b);
//        int modulo = perform(10, 4, (a, b) -> a % b);
//        int max = perform(10, 4, (a, b) -> Math.max(a,  b));
//        int min = perform(10, 4, (a, b) -> Math.min(a, b));
//        int pow = perform(10, 4, (a, b) -> (int) Math.pow(a,  b));
//
//
//        System.out.println(add);
//        System.out.println(subtract);
//        System.out.println(multiply);
//        System.out.println(divide);
//        System.out.println(modulo);
//        System.out.println(max);
//        System.out.println(min);
//        System.out.println(pow);

        // =====================================================

//        processNumber(10, num -> num % 2 == 0);
//        processNumber(11, num -> num % 2 == 0);
//
//        processNumber(10, (num) -> num >= 11);
//        processNumber(11, (num) -> num >=11);



        // =====================================================

        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 35, 40, 45, 50);

        System.out.println("Even numbers : ");
        process(numbers, number -> number % 2 == 0);

        System.out.println("Odd numbers : ");
        process(numbers, number -> number % 2 != 0);

        System.out.println("numbers greater than 20 : ");
        process(numbers, number -> number > 20);

        System.out.println("numbers divisible by 5 : ");
        process(numbers, number -> number % 5 == 0);

        // =====================================================



        // =====================================================



    }

    static void calculate(int a, int b, MathOperation operation) {
        int res = operation.operate(a, b);
        System.out.println(res);
    }

    static int perform(int a, int b, Operation operation) {
        return operation.apply(a, b);
    }

    static void processNumber(int num, NumberOperation operation) {
        if(operation.test(num)) {
            System.out.println(num + ": passed");
        } else {
            System.out.println(num + ": failed");
        }
    }

    static void process(List<Integer> numbers, NumberOperation operation) {
        for(int num : numbers) {
            if(operation.test(num))
                System.out.print(num + " ");
        }
        System.out.println();
    }
}

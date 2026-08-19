package practice.fundamentals_01.part1;

public class ExceptionFlowClient {
    public static void main(String[] args) {
        System.out.println("Step 1");

        System.out.println(10 / 0);
        ArithmeticException exception = new ArithmeticException("/ by zero");

        System.out.println("Step 2");
        System.out.println("Step 3");
    }
}

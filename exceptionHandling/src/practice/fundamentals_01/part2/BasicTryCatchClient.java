package practice.fundamentals_01.part2;

public class BasicTryCatchClient {
    public static void main(String[] args) {
        try {
            System.out.println("Start");
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Can not divide by zero");
        }

        System.out.println("End");
    }
}

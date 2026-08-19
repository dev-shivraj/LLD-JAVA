package practice.fundamentals_01.part2;

public class ExceptionInMiddleClient {
    public static void main(String[] args) {
        try {
            System.out.println("A");
            System.out.println("B");

            System.out.println(10 / 0);

            System.out.println("C");
            System.out.println("D");
            System.out.println("E");
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}

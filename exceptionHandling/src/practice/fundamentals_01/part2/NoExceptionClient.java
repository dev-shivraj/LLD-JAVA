package practice.fundamentals_01.part2;

public class NoExceptionClient {
    public static void main(String[] args) {
        try {
            System.out.println("Start");
            System.out.println(10 / 2);
        } catch (Exception e) {
            System.out.println("Exceptino occurred!");
        }

        System.out.println("End");
    }
}

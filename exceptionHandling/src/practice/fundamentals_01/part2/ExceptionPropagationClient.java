package practice.fundamentals_01.part2;

public class ExceptionPropagationClient {

    public static void main(String[] args) {
        System.out.println("main - start");
        methodA();
        System.out.println("main - end");
    }

    static void methodA() {
        System.out.println("methodA - start");
        methodB();
        System.out.println("methodA - end");
    }

    static void methodB() {
        System.out.println("methodB - start");
        int result = 10 / 0;
        System.out.println("methodB - end");
    }
}
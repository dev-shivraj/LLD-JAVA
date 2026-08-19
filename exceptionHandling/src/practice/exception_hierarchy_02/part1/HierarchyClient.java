package practice.exception_hierarchy_02.part1;

public class HierarchyClient {
    public static void main(String[] args) {
        System.out.println("Parent of ArithmeticException: " + ArithmeticException.class.getSuperclass());
        System.out.println("Parent of RuntimeException: " + RuntimeException.class.getSuperclass());
        System.out.println("Parent of Exception: " + Exception.class.getSuperclass());
        System.out.println("Parent of Error: " + Error.class.getSuperclass());
        System.out.println("Parent of Throwable: " + Throwable.class.getSuperclass());
    }
}
